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
import io.crate.sql.tree.*;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;

public final class QueryUtil
{
    public static final String FIELD_REFERENCE_PREFIX = "$field_reference$";

    private QueryUtil() {}

    public static Expression nameReference(String name)
    {
        return new QualifiedNameReference(QualifiedName.of(name));
    }

    public static SelectItem unaliasedName(String name)
    {
        return new SingleColumn(nameReference(name));
    }

    public static SelectItem aliasedName(String name, String alias)
    {
        return new SingleColumn(nameReference(name), alias);
    }

    public static Select selectList(Expression... expressions)
    {
        ImmutableList.Builder<SelectItem> items = ImmutableList.builder();
        for (Expression expression : expressions) {
            items.add(new SingleColumn(expression));
        }
        return new Select(false, items.build());
    }

    public static Select selectList(SelectItem... items)
    {
        return new Select(false, ImmutableList.copyOf(items));
    }

    public static Select selectAll(List<SelectItem> items)
    {
        return new Select(false, items);
    }

    public static Table table(QualifiedName name)
    {
        return new Table(name);
    }

    public static Relation subquery(Query query)
    {
        return new TableSubquery(query);
    }

    public static SortItem ascending(String name)
    {
        return new SortItem(nameReference(name), SortItem.Ordering.ASCENDING, SortItem.NullOrdering.UNDEFINED);
    }

    public static Expression logicalAnd(Expression left, Expression right)
    {
        return new LogicalBinaryExpression(LogicalBinaryExpression.Type.AND, left, right);
    }

    public static Expression equal(Expression left, Expression right)
    {
        return new ComparisonExpression(ComparisonExpression.Type.EQUAL, left, right);
    }

    public static Expression caseWhen(Expression operand, Expression result)
    {
        return new SearchedCaseExpression(ImmutableList.of(new WhenClause(operand, result)), Optional.empty());
    }

    public static Expression functionCall(String name, Expression... arguments)
    {
        return new FunctionCall(new QualifiedName(name), ImmutableList.copyOf(arguments));
    }

    public static Values values(Row... row)
    {
        return new Values(ImmutableList.copyOf(row));
    }

    public static Row row(Expression... values)
    {
        return new Row(ImmutableList.copyOf(values));
    }

    public static Relation aliased(Relation relation, String alias, List<String> columnAliases)
    {
        return new AliasedRelation(relation, alias, columnAliases);
    }

    public static SelectItem aliasedNullToEmpty(String column, String alias)
    {
        return new SingleColumn(new CoalesceExpression(nameReference(column), new StringLiteral("")), alias);
    }

    public static SelectItem aliasedYesNoToBoolean(String column, String alias)
    {
        Expression expression = new IfExpression(
                equal(nameReference(column), new StringLiteral("YES")),
                BooleanLiteral.TRUE_LITERAL,
                BooleanLiteral.FALSE_LITERAL);
        return new SingleColumn(expression, alias);
    }

    public static List<SortItem> ordering(SortItem... items)
    {
        return ImmutableList.copyOf(items);
    }

    public static Query simpleQuery(Select select, Relation from)
    {
        return simpleQuery(select, from, Optional.empty(), ImmutableList.of());
    }

    public static Query simpleQuery(Select select, Relation from, List<SortItem> ordering)
    {
        return simpleQuery(select, from, Optional.empty(), ordering);
    }

    public static Query simpleQuery(Select select, Relation from, Expression where)
    {
        return simpleQuery(select, from, Optional.of(where), ImmutableList.of());
    }

    public static Query simpleQuery(Select select, Relation from, Expression where, List<SortItem> ordering)
    {
        return simpleQuery(select, from, Optional.of(where), ordering);
    }

    public static Query simpleQuery(Select select, Relation from, Optional<Expression> where, List<SortItem> ordering)
    {
        return simpleQuery(select, from, where, ImmutableList.of(), Optional.empty(), ordering, Optional.empty());
    }

    public static Query simpleQuery(Select select, Relation from, Optional<Expression> where, List<Expression> grouping, Optional<Expression> having, List<SortItem> ordering, Optional<String> limit)
    {
        return query(new QuerySpecification(
                select,
                Optional.of(from),
                where,
                grouping,
                having,
                ordering,
                limit));
    }

    public static Query query(QueryBody body)
    {
        return new Query(
                Optional.empty(),
                body,
                ImmutableList.of(),
                Optional.empty(),
                Optional.empty());
    }

    public static String mangleFieldReference(String fieldName)
    {
        return FIELD_REFERENCE_PREFIX + fieldName;
    }

    public static String unmangleFieldReference(String mangledName)
    {
        checkArgument(mangledName.startsWith(FIELD_REFERENCE_PREFIX), "Invalid mangled name: %s", mangledName);
        return mangledName.substring(FIELD_REFERENCE_PREFIX.length());
    }
}
