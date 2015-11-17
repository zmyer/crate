/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.crate.sql.v4;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import io.crate.sql.tree.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AstBuilder
        extends SqlBaseBaseVisitor<Node>
{
    @Override
    public Node visitSingleStatement(SqlBaseParser.SingleStatementContext context)
    {
        return visit(context.statement());
    }

    @Override
    public Node visitSingleExpression(SqlBaseParser.SingleExpressionContext context)
    {
        return visit(context.expression());
    }

    // ********************** query expressions ********************

    @Override
    public Node visitQuery(SqlBaseParser.QueryContext context)
    {
        Query body = (Query) visit(context.queryNoWith());
        return new Query(
                visitIfPresent(context.with(), With.class),
                body.getQueryBody(),
                body.getOrderBy(),
                body.getLimit(),
                Optional.empty()
        );
    }

    @Override
    public Node visitWith(SqlBaseParser.WithContext context)
    {
        return new With(context.RECURSIVE() != null, visit(context.namedQuery(), WithQuery.class));
    }

    @Override
    public Node visitNamedQuery(SqlBaseParser.NamedQueryContext context)
    {
        return new WithQuery(context.name.getText(), (Query) visit(context.query()), getColumnAliases(context.columnAliases()));
    }

    @Override
    public Node visitQueryNoWith(SqlBaseParser.QueryNoWithContext context)
    {
        QueryBody term = (QueryBody) visit(context.queryTerm());

        if (term instanceof QuerySpecification) {
            // When we have a simple query specification
            // followed by order by limit, fold the order by and limit
            // clauses into the query specification (analyzer/planner
            // expects this structure to resolve references with respect
            // to columns defined in the query specification)
            QuerySpecification query = (QuerySpecification) term;

            return new Query(
                    Optional.<With>empty(),
                    new QuerySpecification(
                            query.getSelect(),
                            query.getFrom(),
                            query.getWhere(),
                            query.getGroupBy(),
                            query.getHaving(),
                            visit(context.sortItem(), SortItem.class),
                            visitIfPresent(context.limit, Expression.class),
                            visitIfPresent(context.offset, Expression.class)),
                    visit(context.sortItem(), SortItem.class),
                    visitIfPresent(context.limit, Expression.class),
                    visitIfPresent(context.offset, Expression.class)
            );
        }

        return new Query(
                Optional.<With>empty(),
                term,
                visit(context.sortItem(), SortItem.class),
                visitIfPresent(context.limit, Expression.class),
                visitIfPresent(context.offset, Expression.class)
        );
    }

    @Override
    public Node visitQuerySpecification(SqlBaseParser.QuerySpecificationContext context)
    {
        Optional<Relation> from = Optional.empty();

        List<Relation> relations = visit(context.relation(), Relation.class);
        if (!relations.isEmpty()) {
            // synthesize implicit join nodes
            Iterator<Relation> iterator = relations.iterator();
            Relation relation = iterator.next();

            while (iterator.hasNext()) {
                relation = new Join(Join.Type.INNER, relation, iterator.next(), Optional.<JoinCriteria>empty());
            }

            from = Optional.of(relation);
        }
        if (from.isPresent()) {
            relations = ImmutableList.of(from.get());
        }
        return new QuerySpecification(
                new Select(isDistinct(context.setQuantifier()), visit(context.selectItem(), SelectItem.class)),
                relations,
                visitIfPresent(context.where, Expression.class),
                visit(context.groupBy, Expression.class),
                visitIfPresent(context.having, Expression.class),
                ImmutableList.of(),
                Optional.empty(),
                Optional.empty()
        );
    }

    @Override
    public Node visitSetOperation(SqlBaseParser.SetOperationContext context)
    {
        QueryBody left = (QueryBody) visit(context.left);
        QueryBody right = (QueryBody) visit(context.right);

        boolean distinct = context.setQuantifier() == null || context.setQuantifier().DISTINCT() != null;

        switch (context.operator.getType()) {
            case SqlBaseLexer.UNION:
                return new Union(ImmutableList.of(left, right), distinct);
            case SqlBaseLexer.INTERSECT:
                return new Intersect(ImmutableList.of(left, right), distinct);
            case SqlBaseLexer.EXCEPT:
                return new Except(left, right, distinct);
        }

        throw new IllegalArgumentException("Unsupported set operation: " + context.operator.getText());
    }

    @Override
    public Node visitSelectAll(SqlBaseParser.SelectAllContext context)
    {
        if (context.qualifiedName() != null) {
            return new AllColumns(getQualifiedName(context.qualifiedName()));
        }

        return new AllColumns();
    }

    @Override
    public Node visitSelectSingle(SqlBaseParser.SelectSingleContext context)
    {
        Optional<String> alias = getTextIfPresent(context.identifier());

        return new SingleColumn((Expression) visit(context.expression()), alias);
    }

    @Override
    public Node visitTable(SqlBaseParser.TableContext context)
    {
        return new Table(getQualifiedName(context.qualifiedName()));
    }

    @Override
    public Node visitSubquery(SqlBaseParser.SubqueryContext context)
    {
        return new TableSubquery((Query) visit(context.query()));
    }

    @Override
    public Node visitExplainFormat(SqlBaseParser.ExplainFormatContext context)
    {
        switch (context.value.getType()) {
            case SqlBaseLexer.GRAPHVIZ:
                return new ExplainFormat(ExplainFormat.Type.GRAPHVIZ);
            case SqlBaseLexer.TEXT:
                return new ExplainFormat(ExplainFormat.Type.TEXT);
        }

        throw new IllegalArgumentException("Unsupported EXPLAIN format: " + context.value.getText());
    }

    @Override
    public Node visitExplainType(SqlBaseParser.ExplainTypeContext context)
    {
        switch (context.value.getType()) {
            case SqlBaseLexer.LOGICAL:
                return new ExplainType(ExplainType.Type.LOGICAL);
            case SqlBaseLexer.DISTRIBUTED:
                return new ExplainType(ExplainType.Type.DISTRIBUTED);
        }

        throw new IllegalArgumentException("Unsupported EXPLAIN type: " + context.value.getText());
    }

    // ***************** boolean expressions ******************

    @Override
    public Node visitLogicalNot(SqlBaseParser.LogicalNotContext context)
    {
        return new NotExpression((Expression) visit(context.booleanExpression()));
    }

    @Override
    public Node visitLogicalBinary(SqlBaseParser.LogicalBinaryContext context)
    {
        return new LogicalBinaryExpression(
                getLogicalBinaryOperator(context.operator),
                (Expression) visit(context.left),
                (Expression) visit(context.right));
    }

    // *************** from clause *****************

    @Override
    public Node visitJoinRelation(SqlBaseParser.JoinRelationContext context)
    {
        Relation left = (Relation) visit(context.left);
        Relation right;

        if (context.CROSS() != null) {
            right = (Relation) visit(context.right);
            return new Join(Join.Type.CROSS, left, right, Optional.<JoinCriteria>empty());
        }

        JoinCriteria criteria;
        if (context.NATURAL() != null) {
            right = (Relation) visit(context.right);
            criteria = new NaturalJoin();
        }
        else {
            right = (Relation) visit(context.rightRelation);
            if (context.joinCriteria().ON() != null) {
                criteria = new JoinOn((Expression) visit(context.joinCriteria().booleanExpression()));
            }
            else if (context.joinCriteria().USING() != null) {
                List<String> columns = context.joinCriteria()
                        .identifier().stream()
                        .map(ParseTree::getText)
                        .collect(Collectors.toList());

                criteria = new JoinUsing(columns);
            }
            else {
                throw new IllegalArgumentException("Unsupported join criteria");
            }
        }

        Join.Type joinType;
        if (context.joinType().LEFT() != null) {
            joinType = Join.Type.LEFT;
        }
        else if (context.joinType().RIGHT() != null) {
            joinType = Join.Type.RIGHT;
        }
        else if (context.joinType().FULL() != null) {
            joinType = Join.Type.FULL;
        }
        else {
            joinType = Join.Type.INNER;
        }

        return new Join(joinType, left, right, Optional.of(criteria));
    }

    @Override
    public Node visitAliasedRelation(SqlBaseParser.AliasedRelationContext context)
    {
        Relation child = (Relation) visit(context.relationPrimary());

        if (context.identifier() == null) {
            return child;
        }

        return new AliasedRelation(child, context.identifier().getText(), getColumnAliases(context.columnAliases()));
    }

    @Override
    public Node visitTableName(SqlBaseParser.TableNameContext context)
    {
        return new Table(getQualifiedName(context.qualifiedName()));
    }

    @Override
    public Node visitSubqueryRelation(SqlBaseParser.SubqueryRelationContext context)
    {
        return new TableSubquery((Query) visit(context.query()));
    }

    @Override
    public Node visitParenthesizedRelation(SqlBaseParser.ParenthesizedRelationContext context)
    {
        return visit(context.relation());
    }

    // ********************* predicates *******************

    @Override
    public Node visitPredicated(SqlBaseParser.PredicatedContext context)
    {
        if (context.predicate() != null) {
            return visit(context.predicate());
        }

        return visit(context.valueExpression);
    }

    @Override
    public Node visitComparison(SqlBaseParser.ComparisonContext context)
    {
        return new ComparisonExpression(
                getComparisonOperator(((TerminalNode) context.comparisonOperator().getChild(0)).getSymbol()),
                (Expression) visit(context.value),
                (Expression) visit(context.right));
    }

    @Override
    public Node visitDistinctFrom(SqlBaseParser.DistinctFromContext context)
    {
        Expression expression = new ComparisonExpression(
                ComparisonExpression.Type.IS_DISTINCT_FROM,
                (Expression) visit(context.value),
                (Expression) visit(context.right));

        if (context.NOT() != null) {
            expression = new NotExpression(expression);
        }

        return expression;
    }

    @Override
    public Node visitBetween(SqlBaseParser.BetweenContext context)
    {
        Expression expression = new BetweenPredicate(
                (Expression) visit(context.value),
                (Expression) visit(context.lower),
                (Expression) visit(context.upper));

        if (context.NOT() != null) {
            expression = new NotExpression(expression);
        }

        return expression;
    }

    @Override
    public Node visitNullPredicate(SqlBaseParser.NullPredicateContext context)
    {
        Expression child = (Expression) visit(context.value);

        if (context.NOT() == null) {
            return new IsNullPredicate(child);
        }

        return new IsNotNullPredicate(child);
    }

    @Override
    public Node visitLike(SqlBaseParser.LikeContext context)
    {
        Expression escape = null;
        if (context.escape != null) {
            escape = (Expression) visit(context.escape);
        }

        Expression result = new LikePredicate((Expression) visit(context.value), (Expression) visit(context.pattern), escape);

        if (context.NOT() != null) {
            result = new NotExpression(result);
        }

        return result;
    }

    @Override
    public Node visitInList(SqlBaseParser.InListContext context)
    {
        Expression result = new InPredicate(
                (Expression) visit(context.value),
                new InListExpression(visit(context.expression(), Expression.class)));

        if (context.NOT() != null) {
            result = new NotExpression(result);
        }

        return result;
    }

    @Override
    public Node visitInSubquery(SqlBaseParser.InSubqueryContext context)
    {
        Expression result = new InPredicate(
                (Expression) visit(context.value),
                new SubqueryExpression((Query) visit(context.query())));

        if (context.NOT() != null) {
            result = new NotExpression(result);
        }

        return result;
    }

    @Override
    public Node visitExists(SqlBaseParser.ExistsContext context)
    {
        return new ExistsPredicate((Query) visit(context.query()));
    }

    // ************** value expressions **************

    @Override
    public Node visitArithmeticUnary(SqlBaseParser.ArithmeticUnaryContext context)
    {
        Expression child = (Expression) visit(context.valueExpression());

        switch (context.operator.getType()) {
            case SqlBaseLexer.MINUS:
                return new NegativeExpression(child);
            case SqlBaseLexer.PLUS:
                return child;
            default:
                throw new UnsupportedOperationException("Unsupported sign: " + context.operator.getText());
        }
    }

    @Override
    public Node visitArithmeticBinary(SqlBaseParser.ArithmeticBinaryContext context)
    {
        return new ArithmeticExpression(
                getArithmeticBinaryOperator(context.operator),
                (Expression) visit(context.left),
                (Expression) visit(context.right));
    }

    @Override
    public Node visitConcatenation(SqlBaseParser.ConcatenationContext context)
    {
        return new FunctionCall(
                new QualifiedName("concat"), ImmutableList.of(
                (Expression) visit(context.left),
                (Expression) visit(context.right)));
    }

    // ********************* primary expressions **********************

    @Override
    public Node visitParenthesizedExpression(SqlBaseParser.ParenthesizedExpressionContext context)
    {
        return visit(context.expression());
    }

    @Override
    public Node visitCast(SqlBaseParser.CastContext context)
    {
        boolean isTryCast = context.TRY_CAST() != null;
        Expression expression = (Expression) visit(context.expression());
        ColumnType columnType = new ColumnType(getType(context.type()));
        if (isTryCast) {
            return new TryCast(expression, columnType);
        }
        return new Cast(expression, columnType);
    }

    @Override
    public Node visitSpecialDateTimeFunction(SqlBaseParser.SpecialDateTimeFunctionContext context)
    {
        CurrentTime.Type type = getDateTimeFunctionType(context.name);

        if (context.precision != null) {
            return new CurrentTime(type, Integer.parseInt(context.precision.getText()));
        }

        return new CurrentTime(type);
    }

    @Override
    public Node visitExtract(SqlBaseParser.ExtractContext context)
    {
        return new Extract((Expression) visit(context.valueExpression()), Extract.Field.valueOf(context.identifier().getText().toUpperCase()));
    }

    @Override
    public Node visitSubstring(SqlBaseParser.SubstringContext context)
    {
        return new FunctionCall(new QualifiedName("substr"), visit(context.valueExpression(), Expression.class));
    }

    @Override
    public Node visitPosition(SqlBaseParser.PositionContext context)
    {
        List<Expression> arguments = Lists.reverse(visit(context.valueExpression(), Expression.class));
        return new FunctionCall(new QualifiedName("strpos"), arguments);
    }

    @Override
    public Node visitSubscript(SqlBaseParser.SubscriptContext context)
    {
        return new SubscriptExpression((Expression) visit(context.value), (Expression) visit(context.index));
    }

    @Override
    public Node visitSubqueryExpression(SqlBaseParser.SubqueryExpressionContext context)
    {
        return new SubqueryExpression((Query) visit(context.query()));
    }

    @Override
    public Node visitColumnReference(SqlBaseParser.ColumnReferenceContext context)
    {
        return new QualifiedNameReference(new QualifiedName(context.getText()));
    }

    @Override
    public Node visitSimpleCase(SqlBaseParser.SimpleCaseContext context)
    {
        return new SimpleCaseExpression(
                (Expression) visit(context.valueExpression()),
                visit(context.whenClause(), WhenClause.class),
                (Expression) visit(context.elseExpression));
    }

    @Override
    public Node visitSearchedCase(SqlBaseParser.SearchedCaseContext context)
    {
        return new SearchedCaseExpression(
                visit(context.whenClause(), WhenClause.class),
                (Expression) visit(context.elseExpression));
    }

    @Override
    public Node visitWhenClause(SqlBaseParser.WhenClauseContext context)
    {
        return new WhenClause((Expression) visit(context.condition), (Expression) visit(context.result));
    }

    @Override
    public Node visitFunctionCall(SqlBaseParser.FunctionCallContext context)
    {
        QualifiedName name = getQualifiedName(context.qualifiedName());

        boolean distinct = isDistinct(context.setQuantifier());

        if (name.toString().equalsIgnoreCase("if")) {
            check(context.expression().size() == 2 || context.expression().size() == 3, "Invalid number of arguments for 'if' function", context);
            check(!distinct, "DISTINCT not valid for 'if' function", context);

            Expression elseExpression = null;
            if (context.expression().size() == 3) {
                elseExpression = (Expression) visit(context.expression(2));
            }

            return new IfExpression(
                    (Expression) visit(context.expression(0)),
                    (Expression) visit(context.expression(1)),
                    elseExpression);
        }
        else if (name.toString().equalsIgnoreCase("nullif")) {
            check(context.expression().size() == 2, "Invalid number of arguments for 'nullif' function", context);
            check(!distinct, "DISTINCT not valid for 'nullif' function", context);

            return new NullIfExpression(
                    (Expression) visit(context.expression(0)),
                    (Expression) visit(context.expression(1)));
        }
        else if (name.toString().equalsIgnoreCase("coalesce")) {
            check(!distinct, "DISTINCT not valid for 'coalesce' function", context);

            return new CoalesceExpression(visit(context.expression(), Expression.class));
        }

        return new FunctionCall(
                getQualifiedName(context.qualifiedName()),
                null,
                distinct,
                visit(context.expression(), Expression.class));
    }

    @Override
    public Node visitSortItem(SqlBaseParser.SortItemContext context)
    {
        return new SortItem(
                (Expression) visit(context.expression()),
                Optional.ofNullable(context.ordering)
                        .map(AstBuilder::getOrderingType)
                        .orElse(SortItem.Ordering.ASCENDING),
                Optional.ofNullable(context.nullOrdering)
                        .map(AstBuilder::getNullOrderingType)
                        .orElse(SortItem.NullOrdering.UNDEFINED));
    }

    // ************** literals **************

    @Override
    public Node visitNullLiteral(SqlBaseParser.NullLiteralContext context)
    {
        return new NullLiteral();
    }

    @Override
    public Node visitStringLiteral(SqlBaseParser.StringLiteralContext context)
    {
        return new StringLiteral(unquote(context.STRING().getText()));
    }

    @Override
    public Node visitIntegerLiteral(SqlBaseParser.IntegerLiteralContext context)
    {
        return new LongLiteral(context.getText());
    }

    @Override
    public Node visitDecimalLiteral(SqlBaseParser.DecimalLiteralContext context)
    {
        return new DoubleLiteral(context.getText());
    }

    @Override
    public Node visitBooleanValue(SqlBaseParser.BooleanValueContext context)
    {
        if (Boolean.parseBoolean(context.getText())) {
            return BooleanLiteral.TRUE_LITERAL;
        }
        return BooleanLiteral.FALSE_LITERAL;
    }

    // ***************** helpers *****************

    @Override
    protected Node defaultResult()
    {
        return null;
    }

    @Override
    protected Node aggregateResult(Node aggregate, Node nextResult)
    {
        if (nextResult == null) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        if (aggregate == null) {
            return nextResult;
        }

        throw new UnsupportedOperationException("not yet implemented");
    }

    private <T> Optional<T> visitIfPresent(ParserRuleContext context, Class<T> clazz)
    {
        return Optional.ofNullable(context)
                .map(this::visit)
                .map(clazz::cast);
    }

    private <T> List<T> visit(List<? extends ParserRuleContext> contexts, Class<T> clazz)
    {
        return contexts.stream()
                .map(this::visit)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    private static String unquote(String string)
    {
        return string.substring(1, string.length() - 1)
                .replace("''", "'");
    }

    private static QualifiedName getQualifiedName(SqlBaseParser.QualifiedNameContext context)
    {
        List<String> parts = context
                .identifier().stream()
                .map(ParseTree::getText)
                .collect(Collectors.toList());

        return new QualifiedName(parts);
    }

    private static boolean isDistinct(SqlBaseParser.SetQuantifierContext setQuantifier)
    {
        return setQuantifier != null && setQuantifier.DISTINCT() != null;
    }

    private static Optional<String> getTextIfPresent(ParserRuleContext context)
    {
        return Optional.ofNullable(context)
                .map(ParseTree::getText);
    }

    private static Optional<String> getTextIfPresent(Token token)
    {
        return Optional.ofNullable(token)
                .map(Token::getText);
    }

    private static List<String> getColumnAliases(SqlBaseParser.ColumnAliasesContext columnAliasesContext)
    {
        if (columnAliasesContext == null) {
            return null;
        }

        return columnAliasesContext
                .identifier().stream()
                .map(ParseTree::getText)
                .collect(Collectors.toList());
    }

    private static ArithmeticExpression.Type getArithmeticBinaryOperator(Token operator)
    {
        switch (operator.getType()) {
            case SqlBaseLexer.PLUS:
                return ArithmeticExpression.Type.ADD;
            case SqlBaseLexer.MINUS:
                return ArithmeticExpression.Type.SUBTRACT;
            case SqlBaseLexer.ASTERISK:
                return ArithmeticExpression.Type.MULTIPLY;
            case SqlBaseLexer.SLASH:
                return ArithmeticExpression.Type.DIVIDE;
            case SqlBaseLexer.PERCENT:
                return ArithmeticExpression.Type.MODULUS;
        }

        throw new UnsupportedOperationException("Unsupported operator: " + operator.getText());
    }

    private static ComparisonExpression.Type getComparisonOperator(Token symbol)
    {
        switch (symbol.getType()) {
            case SqlBaseLexer.EQ:
                return ComparisonExpression.Type.EQUAL;
            case SqlBaseLexer.NEQ:
                return ComparisonExpression.Type.NOT_EQUAL;
            case SqlBaseLexer.LT:
                return ComparisonExpression.Type.LESS_THAN;
            case SqlBaseLexer.LTE:
                return ComparisonExpression.Type.LESS_THAN_OR_EQUAL;
            case SqlBaseLexer.GT:
                return ComparisonExpression.Type.GREATER_THAN;
            case SqlBaseLexer.GTE:
                return ComparisonExpression.Type.GREATER_THAN_OR_EQUAL;
        }

        throw new IllegalArgumentException("Unsupported operator: " + symbol.getText());
    }

    private static CurrentTime.Type getDateTimeFunctionType(Token token)
    {
        switch (token.getType()) {
            case SqlBaseLexer.CURRENT_DATE:
                return CurrentTime.Type.DATE;
            case SqlBaseLexer.CURRENT_TIME:
                return CurrentTime.Type.TIME;
            case SqlBaseLexer.CURRENT_TIMESTAMP:
                return CurrentTime.Type.TIMESTAMP;
        }

        throw new IllegalArgumentException("Unsupported special function: " + token.getText());
    }

    private static LogicalBinaryExpression.Type getLogicalBinaryOperator(Token token)
    {
        switch (token.getType()) {
            case SqlBaseLexer.AND:
                return LogicalBinaryExpression.Type.AND;
            case SqlBaseLexer.OR:
                return LogicalBinaryExpression.Type.OR;
        }

        throw new IllegalArgumentException("Unsupported operator: " + token.getText());
    }

    private static SortItem.NullOrdering getNullOrderingType(Token token)
    {
        switch (token.getType()) {
            case SqlBaseLexer.FIRST:
                return SortItem.NullOrdering.FIRST;
            case SqlBaseLexer.LAST:
                return SortItem.NullOrdering.LAST;
        }

        throw new IllegalArgumentException("Unsupported ordering: " + token.getText());
    }

    private static SortItem.Ordering getOrderingType(Token token)
    {
        switch (token.getType()) {
            case SqlBaseLexer.ASC:
                return SortItem.Ordering.ASCENDING;
            case SqlBaseLexer.DESC:
                return SortItem.Ordering.DESCENDING;
        }

        throw new IllegalArgumentException("Unsupported ordering: " + token.getText());
    }

    private static String getType(SqlBaseParser.TypeContext type)
    {
        if (type.simpleType() != null) {
            return type.simpleType().getText();
        }

        if (type.ARRAY() != null) {
            return "ARRAY<" + getType(type.type(0)) + ">";
        }

        if (type.MAP() != null) {
            return "MAP<" + getType(type.type(0)) + "," + getType(type.type(1)) + ">";
        }

        throw new IllegalArgumentException("Unsupported type specification: " + type.getText());
    }

    private static void check(boolean condition, String message, ParserRuleContext context)
    {
        if (!condition) {
            throw new ParsingException(message, null, context.getStart().getLine(), context.getStart().getCharPositionInLine());
        }
    }
}
