// Generated from SqlBase.g4 by ANTLR 4.5
package io.crate.sql.v4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlBaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, SELECT=7, FROM=8, AS=9, 
		ALL=10, SOME=11, ANY=12, DISTINCT=13, WHERE=14, GROUP=15, BY=16, ORDER=17, 
		HAVING=18, LIMIT=19, APPROXIMATE=20, AT=21, CONFIDENCE=22, OR=23, AND=24, 
		IN=25, NOT=26, EXISTS=27, BETWEEN=28, LIKE=29, IS=30, NULL=31, TRUE=32, 
		FALSE=33, NULLS=34, FIRST=35, LAST=36, ESCAPE=37, ASC=38, DESC=39, SUBSTRING=40, 
		POSITION=41, FOR=42, DATE=43, TIME=44, TIMESTAMP=45, INTERVAL=46, YEAR=47, 
		MONTH=48, DAY=49, HOUR=50, MINUTE=51, SECOND=52, ZONE=53, CURRENT_DATE=54, 
		CURRENT_TIME=55, CURRENT_TIMESTAMP=56, LOCALTIME=57, LOCALTIMESTAMP=58, 
		EXTRACT=59, CASE=60, WHEN=61, THEN=62, ELSE=63, END=64, JOIN=65, CROSS=66, 
		OUTER=67, INNER=68, LEFT=69, RIGHT=70, FULL=71, NATURAL=72, USING=73, 
		ON=74, OVER=75, PARTITION=76, RANGE=77, ROWS=78, UNBOUNDED=79, PRECEDING=80, 
		FOLLOWING=81, CURRENT=82, ROW=83, WITH=84, RECURSIVE=85, VALUES=86, CREATE=87, 
		PRIMARY_KEY=88, CLUSTERED=89, SHARDS=90, PARTITIONED=91, TABLE=92, VIEW=93, 
		REPLACE=94, INSERT=95, DELETE=96, INTO=97, CONSTRAINT=98, DESCRIBE=99, 
		EXPLAIN=100, FORMAT=101, TYPE=102, TEXT=103, GRAPHVIZ=104, JSON=105, LOGICAL=106, 
		DISTRIBUTED=107, CAST=108, TRY_CAST=109, SHOW=110, TABLES=111, SCHEMAS=112, 
		CATALOGS=113, COLUMNS=114, COLUMN=115, USE=116, PARTITIONS=117, FUNCTIONS=118, 
		DROP=119, UNION=120, EXCEPT=121, INTERSECT=122, TO=123, SYSTEM=124, BERNOULLI=125, 
		POISSONIZED=126, TABLESAMPLE=127, RESCALED=128, STRATIFY=129, ALTER=130, 
		RENAME=131, UNNEST=132, ORDINALITY=133, ARRAY=134, MAP=135, SET=136, RESET=137, 
		SESSION=138, NORMALIZE=139, NFD=140, NFC=141, NFKD=142, NFKC=143, IF=144, 
		NULLIF=145, COALESCE=146, EQ=147, NEQ=148, LT=149, LTE=150, GT=151, GTE=152, 
		PLUS=153, MINUS=154, ASTERISK=155, SLASH=156, PERCENT=157, CONCAT=158, 
		STRING=159, INTEGER_VALUE=160, DECIMAL_VALUE=161, IDENTIFIER=162, DIGIT_IDENTIFIER=163, 
		QUOTED_IDENTIFIER=164, BACKQUOTED_IDENTIFIER=165, TIME_WITH_TIME_ZONE=166, 
		TIMESTAMP_WITH_TIME_ZONE=167, SIMPLE_COMMENT=168, BRACKETED_COMMENT=169, 
		WS=170, UNRECOGNIZED=171, DELIMITER=172;
	public static final int
		RULE_singleStatement = 0, RULE_singleExpression = 1, RULE_statement = 2, 
		RULE_valuesList = 3, RULE_values = 4, RULE_query = 5, RULE_with = 6, RULE_tableElement = 7, 
		RULE_columnConstraint = 8, RULE_clusteredBy = 9, RULE_partitionedBy = 10, 
		RULE_tableProperties = 11, RULE_tableProperty = 12, RULE_queryNoWith = 13, 
		RULE_queryTerm = 14, RULE_queryPrimary = 15, RULE_sortItem = 16, RULE_querySpecification = 17, 
		RULE_namedQuery = 18, RULE_setQuantifier = 19, RULE_selectItem = 20, RULE_relation = 21, 
		RULE_joinType = 22, RULE_joinCriteria = 23, RULE_sampledRelation = 24, 
		RULE_sampleType = 25, RULE_aliasedRelation = 26, RULE_columnAliases = 27, 
		RULE_relationPrimary = 28, RULE_expression = 29, RULE_booleanExpression = 30, 
		RULE_predicated = 31, RULE_predicate = 32, RULE_valueExpression = 33, 
		RULE_primaryExpression = 34, RULE_timeZoneSpecifier = 35, RULE_comparisonOperator = 36, 
		RULE_booleanValue = 37, RULE_interval = 38, RULE_intervalField = 39, RULE_type = 40, 
		RULE_simpleType = 41, RULE_whenClause = 42, RULE_over = 43, RULE_windowFrame = 44, 
		RULE_frameBound = 45, RULE_explainOption = 46, RULE_qualifiedName = 47, 
		RULE_identifier = 48, RULE_quotedIdentifier = 49, RULE_number = 50, RULE_nonReserved = 51, 
		RULE_normalForm = 52;
	public static final String[] ruleNames = {
		"singleStatement", "singleExpression", "statement", "valuesList", "values", 
		"query", "with", "tableElement", "columnConstraint", "clusteredBy", "partitionedBy", 
		"tableProperties", "tableProperty", "queryNoWith", "queryTerm", "queryPrimary", 
		"sortItem", "querySpecification", "namedQuery", "setQuantifier", "selectItem", 
		"relation", "joinType", "joinCriteria", "sampledRelation", "sampleType", 
		"aliasedRelation", "columnAliases", "relationPrimary", "expression", "booleanExpression", 
		"predicated", "predicate", "valueExpression", "primaryExpression", "timeZoneSpecifier", 
		"comparisonOperator", "booleanValue", "interval", "intervalField", "type", 
		"simpleType", "whenClause", "over", "windowFrame", "frameBound", "explainOption", 
		"qualifiedName", "identifier", "quotedIdentifier", "number", "nonReserved", 
		"normalForm"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'.'", "'['", "']'", "'SELECT'", "'FROM'", 
		"'AS'", "'ALL'", "'SOME'", "'ANY'", "'DISTINCT'", "'WHERE'", "'GROUP'", 
		"'BY'", "'ORDER'", "'HAVING'", "'LIMIT'", "'APPROXIMATE'", "'AT'", "'CONFIDENCE'", 
		"'OR'", "'AND'", "'IN'", "'NOT'", "'EXISTS'", "'BETWEEN'", "'LIKE'", "'IS'", 
		"'NULL'", "'TRUE'", "'FALSE'", "'NULLS'", "'FIRST'", "'LAST'", "'ESCAPE'", 
		"'ASC'", "'DESC'", "'SUBSTRING'", "'POSITION'", "'FOR'", "'DATE'", "'TIME'", 
		"'TIMESTAMP'", "'INTERVAL'", "'YEAR'", "'MONTH'", "'DAY'", "'HOUR'", "'MINUTE'", 
		"'SECOND'", "'ZONE'", "'CURRENT_DATE'", "'CURRENT_TIME'", "'CURRENT_TIMESTAMP'", 
		"'LOCALTIME'", "'LOCALTIMESTAMP'", "'EXTRACT'", "'CASE'", "'WHEN'", "'THEN'", 
		"'ELSE'", "'END'", "'JOIN'", "'CROSS'", "'OUTER'", "'INNER'", "'LEFT'", 
		"'RIGHT'", "'FULL'", "'NATURAL'", "'USING'", "'ON'", "'OVER'", "'PARTITION'", 
		"'RANGE'", "'ROWS'", "'UNBOUNDED'", "'PRECEDING'", "'FOLLOWING'", "'CURRENT'", 
		"'ROW'", "'WITH'", "'RECURSIVE'", "'VALUES'", "'CREATE'", "'PRIMARY KEY'", 
		"'CLUSTERED'", "'SHARDS'", "'PARTITIONED'", "'TABLE'", "'VIEW'", "'REPLACE'", 
		"'INSERT'", "'DELETE'", "'INTO'", "'CONSTRAINT'", "'DESCRIBE'", "'EXPLAIN'", 
		"'FORMAT'", "'TYPE'", "'TEXT'", "'GRAPHVIZ'", "'JSON'", "'LOGICAL'", "'DISTRIBUTED'", 
		"'CAST'", "'TRY_CAST'", "'SHOW'", "'TABLES'", "'SCHEMAS'", "'CATALOGS'", 
		"'COLUMNS'", "'COLUMN'", "'USE'", "'PARTITIONS'", "'FUNCTIONS'", "'DROP'", 
		"'UNION'", "'EXCEPT'", "'INTERSECT'", "'TO'", "'SYSTEM'", "'BERNOULLI'", 
		"'POISSONIZED'", "'TABLESAMPLE'", "'RESCALED'", "'STRATIFY'", "'ALTER'", 
		"'RENAME'", "'UNNEST'", "'ORDINALITY'", "'ARRAY'", "'MAP'", "'SET'", "'RESET'", 
		"'SESSION'", "'NORMALIZE'", "'NFD'", "'NFC'", "'NFKD'", "'NFKC'", "'IF'", 
		"'NULLIF'", "'COALESCE'", "'='", null, "'<'", "'<='", "'>'", "'>='", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "SELECT", "FROM", "AS", "ALL", 
		"SOME", "ANY", "DISTINCT", "WHERE", "GROUP", "BY", "ORDER", "HAVING", 
		"LIMIT", "APPROXIMATE", "AT", "CONFIDENCE", "OR", "AND", "IN", "NOT", 
		"EXISTS", "BETWEEN", "LIKE", "IS", "NULL", "TRUE", "FALSE", "NULLS", "FIRST", 
		"LAST", "ESCAPE", "ASC", "DESC", "SUBSTRING", "POSITION", "FOR", "DATE", 
		"TIME", "TIMESTAMP", "INTERVAL", "YEAR", "MONTH", "DAY", "HOUR", "MINUTE", 
		"SECOND", "ZONE", "CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP", 
		"LOCALTIME", "LOCALTIMESTAMP", "EXTRACT", "CASE", "WHEN", "THEN", "ELSE", 
		"END", "JOIN", "CROSS", "OUTER", "INNER", "LEFT", "RIGHT", "FULL", "NATURAL", 
		"USING", "ON", "OVER", "PARTITION", "RANGE", "ROWS", "UNBOUNDED", "PRECEDING", 
		"FOLLOWING", "CURRENT", "ROW", "WITH", "RECURSIVE", "VALUES", "CREATE", 
		"PRIMARY_KEY", "CLUSTERED", "SHARDS", "PARTITIONED", "TABLE", "VIEW", 
		"REPLACE", "INSERT", "DELETE", "INTO", "CONSTRAINT", "DESCRIBE", "EXPLAIN", 
		"FORMAT", "TYPE", "TEXT", "GRAPHVIZ", "JSON", "LOGICAL", "DISTRIBUTED", 
		"CAST", "TRY_CAST", "SHOW", "TABLES", "SCHEMAS", "CATALOGS", "COLUMNS", 
		"COLUMN", "USE", "PARTITIONS", "FUNCTIONS", "DROP", "UNION", "EXCEPT", 
		"INTERSECT", "TO", "SYSTEM", "BERNOULLI", "POISSONIZED", "TABLESAMPLE", 
		"RESCALED", "STRATIFY", "ALTER", "RENAME", "UNNEST", "ORDINALITY", "ARRAY", 
		"MAP", "SET", "RESET", "SESSION", "NORMALIZE", "NFD", "NFC", "NFKD", "NFKC", 
		"IF", "NULLIF", "COALESCE", "EQ", "NEQ", "LT", "LTE", "GT", "GTE", "PLUS", 
		"MINUS", "ASTERISK", "SLASH", "PERCENT", "CONCAT", "STRING", "INTEGER_VALUE", 
		"DECIMAL_VALUE", "IDENTIFIER", "DIGIT_IDENTIFIER", "QUOTED_IDENTIFIER", 
		"BACKQUOTED_IDENTIFIER", "TIME_WITH_TIME_ZONE", "TIMESTAMP_WITH_TIME_ZONE", 
		"SIMPLE_COMMENT", "BRACKETED_COMMENT", "WS", "UNRECOGNIZED", "DELIMITER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SqlBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlBaseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SingleStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_singleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			statement();
			setState(107);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public SingleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSingleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSingleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSingleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleExpressionContext singleExpression() throws RecognitionException {
		SingleExpressionContext _localctx = new SingleExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_singleExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			expression();
			setState(110);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExplainContext extends StatementContext {
		public TerminalNode EXPLAIN() { return getToken(SqlBaseParser.EXPLAIN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExplainOptionContext> explainOption() {
			return getRuleContexts(ExplainOptionContext.class);
		}
		public ExplainOptionContext explainOption(int i) {
			return getRuleContext(ExplainOptionContext.class,i);
		}
		public ExplainContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterExplain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitExplain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitExplain(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateTableContext extends StatementContext {
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public List<TableElementContext> tableElement() {
			return getRuleContexts(TableElementContext.class);
		}
		public TableElementContext tableElement(int i) {
			return getRuleContext(TableElementContext.class,i);
		}
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public ClusteredByContext clusteredBy() {
			return getRuleContext(ClusteredByContext.class,0);
		}
		public PartitionedByContext partitionedBy() {
			return getRuleContext(PartitionedByContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public TablePropertiesContext tableProperties() {
			return getRuleContext(TablePropertiesContext.class,0);
		}
		public CreateTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterCreateTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitCreateTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitCreateTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ResetSessionContext extends StatementContext {
		public TerminalNode RESET() { return getToken(SqlBaseParser.RESET, 0); }
		public TerminalNode SESSION() { return getToken(SqlBaseParser.SESSION, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ResetSessionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterResetSession(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitResetSession(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitResetSession(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateTableAsSelectContext extends StatementContext {
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public TablePropertiesContext tableProperties() {
			return getRuleContext(TablePropertiesContext.class,0);
		}
		public CreateTableAsSelectContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterCreateTableAsSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitCreateTableAsSelect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitCreateTableAsSelect(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsertIntoContext extends StatementContext {
		public TerminalNode INSERT() { return getToken(SqlBaseParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(SqlBaseParser.INTO, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ValuesListContext valuesList() {
			return getRuleContext(ValuesListContext.class,0);
		}
		public ColumnAliasesContext columnAliases() {
			return getRuleContext(ColumnAliasesContext.class,0);
		}
		public InsertIntoContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterInsertInto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitInsertInto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitInsertInto(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RenameTableContext extends StatementContext {
		public QualifiedNameContext from;
		public QualifiedNameContext to;
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TerminalNode RENAME() { return getToken(SqlBaseParser.RENAME, 0); }
		public TerminalNode TO() { return getToken(SqlBaseParser.TO, 0); }
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public RenameTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterRenameTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitRenameTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitRenameTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowSessionContext extends StatementContext {
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode SESSION() { return getToken(SqlBaseParser.SESSION, 0); }
		public ShowSessionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterShowSession(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitShowSession(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitShowSession(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeleteContext extends StatementContext {
		public TerminalNode DELETE() { return getToken(SqlBaseParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SqlBaseParser.WHERE, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public DeleteContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDelete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDelete(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowTablesContext extends StatementContext {
		public Token pattern;
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode TABLES() { return getToken(SqlBaseParser.TABLES, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(SqlBaseParser.LIKE, 0); }
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public ShowTablesContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterShowTables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitShowTables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitShowTables(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowCatalogsContext extends StatementContext {
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode CATALOGS() { return getToken(SqlBaseParser.CATALOGS, 0); }
		public ShowCatalogsContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterShowCatalogs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitShowCatalogs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitShowCatalogs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementDefaultContext extends StatementContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public StatementDefaultContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterStatementDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitStatementDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitStatementDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RenameColumnContext extends StatementContext {
		public QualifiedNameContext tableName;
		public IdentifierContext from;
		public IdentifierContext to;
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TerminalNode RENAME() { return getToken(SqlBaseParser.RENAME, 0); }
		public TerminalNode COLUMN() { return getToken(SqlBaseParser.COLUMN, 0); }
		public TerminalNode TO() { return getToken(SqlBaseParser.TO, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public RenameColumnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterRenameColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitRenameColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitRenameColumn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowFunctionsContext extends StatementContext {
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode FUNCTIONS() { return getToken(SqlBaseParser.FUNCTIONS, 0); }
		public ShowFunctionsContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterShowFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitShowFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitShowFunctions(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetSessionContext extends StatementContext {
		public TerminalNode SET() { return getToken(SqlBaseParser.SET, 0); }
		public TerminalNode SESSION() { return getToken(SqlBaseParser.SESSION, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SqlBaseParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SetSessionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSetSession(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSetSession(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSetSession(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowSchemasContext extends StatementContext {
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode SCHEMAS() { return getToken(SqlBaseParser.SCHEMAS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public ShowSchemasContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterShowSchemas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitShowSchemas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitShowSchemas(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropTableContext extends StatementContext {
		public TerminalNode DROP() { return getToken(SqlBaseParser.DROP, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public DropTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDropTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDropTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDropTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowColumnsContext extends StatementContext {
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlBaseParser.COLUMNS, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public TerminalNode DESCRIBE() { return getToken(SqlBaseParser.DESCRIBE, 0); }
		public TerminalNode DESC() { return getToken(SqlBaseParser.DESC, 0); }
		public ShowColumnsContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterShowColumns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitShowColumns(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitShowColumns(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(245);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new StatementDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				query();
				}
				break;
			case 2:
				_localctx = new CreateTableAsSelectContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				match(CREATE);
				setState(114);
				match(TABLE);
				setState(115);
				qualifiedName();
				setState(118);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(116);
					match(WITH);
					setState(117);
					tableProperties();
					}
				}

				setState(120);
				match(AS);
				setState(121);
				query();
				}
				break;
			case 3:
				_localctx = new CreateTableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				match(CREATE);
				setState(124);
				match(TABLE);
				setState(128);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(125);
					match(IF);
					setState(126);
					match(NOT);
					setState(127);
					match(EXISTS);
					}
					break;
				}
				setState(130);
				qualifiedName();
				setState(131);
				match(T__0);
				setState(132);
				tableElement();
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(133);
					match(T__1);
					setState(134);
					tableElement();
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(140);
				match(T__2);
				setState(142);
				_la = _input.LA(1);
				if (_la==CLUSTERED) {
					{
					setState(141);
					clusteredBy();
					}
				}

				setState(145);
				_la = _input.LA(1);
				if (_la==PARTITIONED) {
					{
					setState(144);
					partitionedBy();
					}
				}

				setState(149);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(147);
					match(WITH);
					setState(148);
					tableProperties();
					}
				}

				}
				break;
			case 4:
				_localctx = new DropTableContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
				match(DROP);
				setState(152);
				match(TABLE);
				setState(155);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(153);
					match(IF);
					setState(154);
					match(EXISTS);
					}
					break;
				}
				setState(157);
				qualifiedName();
				}
				break;
			case 5:
				_localctx = new InsertIntoContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(158);
				match(INSERT);
				setState(159);
				match(INTO);
				setState(160);
				qualifiedName();
				setState(162);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(161);
					columnAliases();
					}
					break;
				}
				setState(166);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(164);
					query();
					}
					break;
				case 2:
					{
					setState(165);
					valuesList();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new DeleteContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(168);
				match(DELETE);
				setState(169);
				match(FROM);
				setState(170);
				qualifiedName();
				setState(173);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(171);
					match(WHERE);
					setState(172);
					booleanExpression(0);
					}
				}

				}
				break;
			case 7:
				_localctx = new RenameTableContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(175);
				match(ALTER);
				setState(176);
				match(TABLE);
				setState(177);
				((RenameTableContext)_localctx).from = qualifiedName();
				setState(178);
				match(RENAME);
				setState(179);
				match(TO);
				setState(180);
				((RenameTableContext)_localctx).to = qualifiedName();
				}
				break;
			case 8:
				_localctx = new RenameColumnContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(182);
				match(ALTER);
				setState(183);
				match(TABLE);
				setState(184);
				((RenameColumnContext)_localctx).tableName = qualifiedName();
				setState(185);
				match(RENAME);
				setState(186);
				match(COLUMN);
				setState(187);
				((RenameColumnContext)_localctx).from = identifier();
				setState(188);
				match(TO);
				setState(189);
				((RenameColumnContext)_localctx).to = identifier();
				}
				break;
			case 9:
				_localctx = new ExplainContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(191);
				match(EXPLAIN);
				setState(203);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(192);
					match(T__0);
					setState(193);
					explainOption();
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(194);
						match(T__1);
						setState(195);
						explainOption();
						}
						}
						setState(200);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(201);
					match(T__2);
					}
					break;
				}
				setState(205);
				statement();
				}
				break;
			case 10:
				_localctx = new ShowTablesContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(206);
				match(SHOW);
				setState(207);
				match(TABLES);
				setState(210);
				_la = _input.LA(1);
				if (_la==FROM || _la==IN) {
					{
					setState(208);
					_la = _input.LA(1);
					if ( !(_la==FROM || _la==IN) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(209);
					qualifiedName();
					}
				}

				setState(214);
				_la = _input.LA(1);
				if (_la==LIKE) {
					{
					setState(212);
					match(LIKE);
					setState(213);
					((ShowTablesContext)_localctx).pattern = match(STRING);
					}
				}

				}
				break;
			case 11:
				_localctx = new ShowSchemasContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(216);
				match(SHOW);
				setState(217);
				match(SCHEMAS);
				setState(220);
				_la = _input.LA(1);
				if (_la==FROM || _la==IN) {
					{
					setState(218);
					_la = _input.LA(1);
					if ( !(_la==FROM || _la==IN) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(219);
					identifier();
					}
				}

				}
				break;
			case 12:
				_localctx = new ShowCatalogsContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(222);
				match(SHOW);
				setState(223);
				match(CATALOGS);
				}
				break;
			case 13:
				_localctx = new ShowColumnsContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(224);
				match(SHOW);
				setState(225);
				match(COLUMNS);
				setState(226);
				_la = _input.LA(1);
				if ( !(_la==FROM || _la==IN) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(227);
				qualifiedName();
				}
				break;
			case 14:
				_localctx = new ShowColumnsContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(228);
				match(DESCRIBE);
				setState(229);
				qualifiedName();
				}
				break;
			case 15:
				_localctx = new ShowColumnsContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(230);
				match(DESC);
				setState(231);
				qualifiedName();
				}
				break;
			case 16:
				_localctx = new ShowFunctionsContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(232);
				match(SHOW);
				setState(233);
				match(FUNCTIONS);
				}
				break;
			case 17:
				_localctx = new ShowSessionContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(234);
				match(SHOW);
				setState(235);
				match(SESSION);
				}
				break;
			case 18:
				_localctx = new SetSessionContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(236);
				match(SET);
				setState(237);
				match(SESSION);
				setState(238);
				qualifiedName();
				setState(239);
				match(EQ);
				setState(240);
				expression();
				}
				break;
			case 19:
				_localctx = new ResetSessionContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(242);
				match(RESET);
				setState(243);
				match(SESSION);
				setState(244);
				qualifiedName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValuesListContext extends ParserRuleContext {
		public TerminalNode VALUES() { return getToken(SqlBaseParser.VALUES, 0); }
		public List<ValuesContext> values() {
			return getRuleContexts(ValuesContext.class);
		}
		public ValuesContext values(int i) {
			return getRuleContext(ValuesContext.class,i);
		}
		public ValuesListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuesList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterValuesList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitValuesList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitValuesList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesListContext valuesList() throws RecognitionException {
		ValuesListContext _localctx = new ValuesListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_valuesList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(VALUES);
			setState(248);
			values();
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(249);
				match(T__1);
				setState(250);
				values();
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValuesContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(T__0);
			setState(257);
			expression();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(258);
				match(T__1);
				setState(259);
				expression();
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public WithContext with() {
			return getRuleContext(WithContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(267);
				with();
				}
			}

			setState(270);
			queryNoWith();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public List<NamedQueryContext> namedQuery() {
			return getRuleContexts(NamedQueryContext.class);
		}
		public NamedQueryContext namedQuery(int i) {
			return getRuleContext(NamedQueryContext.class,i);
		}
		public TerminalNode RECURSIVE() { return getToken(SqlBaseParser.RECURSIVE, 0); }
		public WithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterWith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitWith(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitWith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithContext with() throws RecognitionException {
		WithContext _localctx = new WithContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_with);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(WITH);
			setState(274);
			_la = _input.LA(1);
			if (_la==RECURSIVE) {
				{
				setState(273);
				match(RECURSIVE);
				}
			}

			setState(276);
			namedQuery();
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(277);
				match(T__1);
				setState(278);
				namedQuery();
				}
				}
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableElementContext extends ParserRuleContext {
		public TableElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableElement; }
	 
		public TableElementContext() { }
		public void copyFrom(TableElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ColumnDefinitionContext extends TableElementContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ColumnConstraintContext> columnConstraint() {
			return getRuleContexts(ColumnConstraintContext.class);
		}
		public ColumnConstraintContext columnConstraint(int i) {
			return getRuleContext(ColumnConstraintContext.class,i);
		}
		public ColumnDefinitionContext(TableElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterColumnDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitColumnDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitColumnDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableElementContext tableElement() throws RecognitionException {
		TableElementContext _localctx = new TableElementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tableElement);
		int _la;
		try {
			_localctx = new ColumnDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			identifier();
			setState(285);
			type(0);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PRIMARY_KEY) {
				{
				{
				setState(286);
				columnConstraint();
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnConstraintContext extends ParserRuleContext {
		public TerminalNode PRIMARY_KEY() { return getToken(SqlBaseParser.PRIMARY_KEY, 0); }
		public ColumnConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterColumnConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitColumnConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitColumnConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnConstraintContext columnConstraint() throws RecognitionException {
		ColumnConstraintContext _localctx = new ColumnConstraintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_columnConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(PRIMARY_KEY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClusteredByContext extends ParserRuleContext {
		public ExpressionContext by;
		public ExpressionContext into;
		public TerminalNode CLUSTERED() { return getToken(SqlBaseParser.CLUSTERED, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public TerminalNode INTO() { return getToken(SqlBaseParser.INTO, 0); }
		public TerminalNode SHARDS() { return getToken(SqlBaseParser.SHARDS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ClusteredByContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clusteredBy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterClusteredBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitClusteredBy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitClusteredBy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClusteredByContext clusteredBy() throws RecognitionException {
		ClusteredByContext _localctx = new ClusteredByContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_clusteredBy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(CLUSTERED);
			setState(300);
			_la = _input.LA(1);
			if (_la==BY) {
				{
				setState(295);
				match(BY);
				setState(296);
				match(T__0);
				setState(297);
				((ClusteredByContext)_localctx).by = expression();
				setState(298);
				match(T__2);
				}
			}

			setState(306);
			_la = _input.LA(1);
			if (_la==INTO) {
				{
				setState(302);
				match(INTO);
				setState(303);
				((ClusteredByContext)_localctx).into = expression();
				setState(304);
				match(SHARDS);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionedByContext extends ParserRuleContext {
		public TerminalNode PARTITIONED() { return getToken(SqlBaseParser.PARTITIONED, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public PartitionedByContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionedBy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterPartitionedBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitPartitionedBy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitPartitionedBy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionedByContext partitionedBy() throws RecognitionException {
		PartitionedByContext _localctx = new PartitionedByContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_partitionedBy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(PARTITIONED);
			setState(309);
			match(BY);
			setState(310);
			match(T__0);
			setState(311);
			identifier();
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(312);
				match(T__1);
				setState(313);
				identifier();
				}
				}
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(319);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertiesContext extends ParserRuleContext {
		public List<TablePropertyContext> tableProperty() {
			return getRuleContexts(TablePropertyContext.class);
		}
		public TablePropertyContext tableProperty(int i) {
			return getRuleContext(TablePropertyContext.class,i);
		}
		public TablePropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableProperties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTableProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTableProperties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTableProperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePropertiesContext tableProperties() throws RecognitionException {
		TablePropertiesContext _localctx = new TablePropertiesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(T__0);
			setState(322);
			tableProperty();
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(323);
				match(T__1);
				setState(324);
				tableProperty();
				}
				}
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(330);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SqlBaseParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TablePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTableProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTableProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTableProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePropertyContext tableProperty() throws RecognitionException {
		TablePropertyContext _localctx = new TablePropertyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tableProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			identifier();
			setState(333);
			match(EQ);
			setState(334);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryNoWithContext extends ParserRuleContext {
		public Token limit;
		public NumberContext confidence;
		public QueryTermContext queryTerm() {
			return getRuleContext(QueryTermContext.class,0);
		}
		public TerminalNode ORDER() { return getToken(SqlBaseParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public List<SortItemContext> sortItem() {
			return getRuleContexts(SortItemContext.class);
		}
		public SortItemContext sortItem(int i) {
			return getRuleContext(SortItemContext.class,i);
		}
		public TerminalNode LIMIT() { return getToken(SqlBaseParser.LIMIT, 0); }
		public TerminalNode APPROXIMATE() { return getToken(SqlBaseParser.APPROXIMATE, 0); }
		public TerminalNode AT() { return getToken(SqlBaseParser.AT, 0); }
		public TerminalNode CONFIDENCE() { return getToken(SqlBaseParser.CONFIDENCE, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode ALL() { return getToken(SqlBaseParser.ALL, 0); }
		public QueryNoWithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryNoWith; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQueryNoWith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQueryNoWith(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQueryNoWith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryNoWithContext queryNoWith() throws RecognitionException {
		QueryNoWithContext _localctx = new QueryNoWithContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_queryNoWith);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			queryTerm(0);
			setState(347);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(337);
				match(ORDER);
				setState(338);
				match(BY);
				setState(339);
				sortItem();
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(340);
					match(T__1);
					setState(341);
					sortItem();
					}
					}
					setState(346);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(351);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(349);
				match(LIMIT);
				setState(350);
				((QueryNoWithContext)_localctx).limit = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ALL || _la==INTEGER_VALUE) ) {
					((QueryNoWithContext)_localctx).limit = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(358);
			_la = _input.LA(1);
			if (_la==APPROXIMATE) {
				{
				setState(353);
				match(APPROXIMATE);
				setState(354);
				match(AT);
				setState(355);
				((QueryNoWithContext)_localctx).confidence = number();
				setState(356);
				match(CONFIDENCE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryTermContext extends ParserRuleContext {
		public QueryTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryTerm; }
	 
		public QueryTermContext() { }
		public void copyFrom(QueryTermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QueryTermDefaultContext extends QueryTermContext {
		public QueryPrimaryContext queryPrimary() {
			return getRuleContext(QueryPrimaryContext.class,0);
		}
		public QueryTermDefaultContext(QueryTermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQueryTermDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQueryTermDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQueryTermDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetOperationContext extends QueryTermContext {
		public QueryTermContext left;
		public Token operator;
		public QueryTermContext right;
		public List<QueryTermContext> queryTerm() {
			return getRuleContexts(QueryTermContext.class);
		}
		public QueryTermContext queryTerm(int i) {
			return getRuleContext(QueryTermContext.class,i);
		}
		public TerminalNode INTERSECT() { return getToken(SqlBaseParser.INTERSECT, 0); }
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public TerminalNode UNION() { return getToken(SqlBaseParser.UNION, 0); }
		public TerminalNode EXCEPT() { return getToken(SqlBaseParser.EXCEPT, 0); }
		public SetOperationContext(QueryTermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSetOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSetOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSetOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryTermContext queryTerm() throws RecognitionException {
		return queryTerm(0);
	}

	private QueryTermContext queryTerm(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		QueryTermContext _localctx = new QueryTermContext(_ctx, _parentState);
		QueryTermContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_queryTerm, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new QueryTermDefaultContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(361);
			queryPrimary();
			}
			_ctx.stop = _input.LT(-1);
			setState(377);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(375);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new SetOperationContext(new QueryTermContext(_parentctx, _parentState));
						((SetOperationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_queryTerm);
						setState(363);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(364);
						((SetOperationContext)_localctx).operator = match(INTERSECT);
						setState(366);
						_la = _input.LA(1);
						if (_la==ALL || _la==DISTINCT) {
							{
							setState(365);
							setQuantifier();
							}
						}

						setState(368);
						((SetOperationContext)_localctx).right = queryTerm(3);
						}
						break;
					case 2:
						{
						_localctx = new SetOperationContext(new QueryTermContext(_parentctx, _parentState));
						((SetOperationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_queryTerm);
						setState(369);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(370);
						((SetOperationContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==UNION || _la==EXCEPT) ) {
							((SetOperationContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(372);
						_la = _input.LA(1);
						if (_la==ALL || _la==DISTINCT) {
							{
							setState(371);
							setQuantifier();
							}
						}

						setState(374);
						((SetOperationContext)_localctx).right = queryTerm(2);
						}
						break;
					}
					} 
				}
				setState(379);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class QueryPrimaryContext extends ParserRuleContext {
		public QueryPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryPrimary; }
	 
		public QueryPrimaryContext() { }
		public void copyFrom(QueryPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubqueryContext extends QueryPrimaryContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public SubqueryContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSubquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSubquery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QueryPrimaryDefaultContext extends QueryPrimaryContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public QueryPrimaryDefaultContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQueryPrimaryDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQueryPrimaryDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQueryPrimaryDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TableContext extends QueryPrimaryContext {
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TableContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InlineTableContext extends QueryPrimaryContext {
		public TerminalNode VALUES() { return getToken(SqlBaseParser.VALUES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InlineTableContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterInlineTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitInlineTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitInlineTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryPrimaryContext queryPrimary() throws RecognitionException {
		QueryPrimaryContext _localctx = new QueryPrimaryContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_queryPrimary);
		try {
			int _alt;
			setState(396);
			switch (_input.LA(1)) {
			case SELECT:
				_localctx = new QueryPrimaryDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(380);
				querySpecification();
				}
				break;
			case TABLE:
				_localctx = new TableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(381);
				match(TABLE);
				setState(382);
				qualifiedName();
				}
				break;
			case VALUES:
				_localctx = new InlineTableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(383);
				match(VALUES);
				setState(384);
				expression();
				setState(389);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(385);
						match(T__1);
						setState(386);
						expression();
						}
						} 
					}
					setState(391);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				}
				}
				break;
			case T__0:
				_localctx = new SubqueryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(392);
				match(T__0);
				setState(393);
				queryNoWith();
				setState(394);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SortItemContext extends ParserRuleContext {
		public Token ordering;
		public Token nullOrdering;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NULLS() { return getToken(SqlBaseParser.NULLS, 0); }
		public TerminalNode ASC() { return getToken(SqlBaseParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SqlBaseParser.DESC, 0); }
		public TerminalNode FIRST() { return getToken(SqlBaseParser.FIRST, 0); }
		public TerminalNode LAST() { return getToken(SqlBaseParser.LAST, 0); }
		public SortItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSortItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSortItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSortItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortItemContext sortItem() throws RecognitionException {
		SortItemContext _localctx = new SortItemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sortItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			expression();
			setState(400);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(399);
				((SortItemContext)_localctx).ordering = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((SortItemContext)_localctx).ordering = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(404);
			_la = _input.LA(1);
			if (_la==NULLS) {
				{
				setState(402);
				match(NULLS);
				setState(403);
				((SortItemContext)_localctx).nullOrdering = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==FIRST || _la==LAST) ) {
					((SortItemContext)_localctx).nullOrdering = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuerySpecificationContext extends ParserRuleContext {
		public BooleanExpressionContext where;
		public ExpressionContext expression;
		public List<ExpressionContext> groupBy = new ArrayList<ExpressionContext>();
		public BooleanExpressionContext having;
		public TerminalNode SELECT() { return getToken(SqlBaseParser.SELECT, 0); }
		public List<SelectItemContext> selectItem() {
			return getRuleContexts(SelectItemContext.class);
		}
		public SelectItemContext selectItem(int i) {
			return getRuleContext(SelectItemContext.class,i);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode WHERE() { return getToken(SqlBaseParser.WHERE, 0); }
		public TerminalNode GROUP() { return getToken(SqlBaseParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public TerminalNode HAVING() { return getToken(SqlBaseParser.HAVING, 0); }
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public QuerySpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQuerySpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQuerySpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQuerySpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_querySpecification);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(SELECT);
			setState(408);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(407);
				setQuantifier();
				}
			}

			setState(410);
			selectItem();
			setState(415);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(411);
					match(T__1);
					setState(412);
					selectItem();
					}
					} 
				}
				setState(417);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(427);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(418);
				match(FROM);
				setState(419);
				relation(0);
				setState(424);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(420);
						match(T__1);
						setState(421);
						relation(0);
						}
						} 
					}
					setState(426);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				}
				}
				break;
			}
			setState(431);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(429);
				match(WHERE);
				setState(430);
				((QuerySpecificationContext)_localctx).where = booleanExpression(0);
				}
				break;
			}
			setState(443);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(433);
				match(GROUP);
				setState(434);
				match(BY);
				setState(435);
				((QuerySpecificationContext)_localctx).expression = expression();
				((QuerySpecificationContext)_localctx).groupBy.add(((QuerySpecificationContext)_localctx).expression);
				setState(440);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(436);
						match(T__1);
						setState(437);
						((QuerySpecificationContext)_localctx).expression = expression();
						((QuerySpecificationContext)_localctx).groupBy.add(((QuerySpecificationContext)_localctx).expression);
						}
						} 
					}
					setState(442);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				}
				}
				break;
			}
			setState(447);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(445);
				match(HAVING);
				setState(446);
				((QuerySpecificationContext)_localctx).having = booleanExpression(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedQueryContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColumnAliasesContext columnAliases() {
			return getRuleContext(ColumnAliasesContext.class,0);
		}
		public NamedQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNamedQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNamedQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNamedQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedQueryContext namedQuery() throws RecognitionException {
		NamedQueryContext _localctx = new NamedQueryContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_namedQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			((NamedQueryContext)_localctx).name = identifier();
			setState(451);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(450);
				columnAliases();
				}
			}

			setState(453);
			match(AS);
			setState(454);
			match(T__0);
			setState(455);
			query();
			setState(456);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetQuantifierContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(SqlBaseParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(SqlBaseParser.ALL, 0); }
		public SetQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setQuantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSetQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSetQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSetQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetQuantifierContext setQuantifier() throws RecognitionException {
		SetQuantifierContext _localctx = new SetQuantifierContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_setQuantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectItemContext extends ParserRuleContext {
		public SelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectItem; }
	 
		public SelectItemContext() { }
		public void copyFrom(SelectItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectAllContext extends SelectItemContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode ASTERISK() { return getToken(SqlBaseParser.ASTERISK, 0); }
		public SelectAllContext(SelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSelectAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSelectAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSelectAll(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectSingleContext extends SelectItemContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public SelectSingleContext(SelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSelectSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSelectSingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSelectSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectItemContext selectItem() throws RecognitionException {
		SelectItemContext _localctx = new SelectItemContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_selectItem);
		int _la;
		try {
			setState(472);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				_localctx = new SelectSingleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(460);
				expression();
				setState(465);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(462);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(461);
						match(AS);
						}
					}

					setState(464);
					identifier();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new SelectAllContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(467);
				qualifiedName();
				setState(468);
				match(T__3);
				setState(469);
				match(ASTERISK);
				}
				break;
			case 3:
				_localctx = new SelectAllContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(471);
				match(ASTERISK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	 
		public RelationContext() { }
		public void copyFrom(RelationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelationDefaultContext extends RelationContext {
		public SampledRelationContext sampledRelation() {
			return getRuleContext(SampledRelationContext.class,0);
		}
		public RelationDefaultContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterRelationDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitRelationDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitRelationDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JoinRelationContext extends RelationContext {
		public RelationContext left;
		public SampledRelationContext right;
		public RelationContext rightRelation;
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode CROSS() { return getToken(SqlBaseParser.CROSS, 0); }
		public TerminalNode JOIN() { return getToken(SqlBaseParser.JOIN, 0); }
		public JoinTypeContext joinType() {
			return getRuleContext(JoinTypeContext.class,0);
		}
		public JoinCriteriaContext joinCriteria() {
			return getRuleContext(JoinCriteriaContext.class,0);
		}
		public TerminalNode NATURAL() { return getToken(SqlBaseParser.NATURAL, 0); }
		public SampledRelationContext sampledRelation() {
			return getRuleContext(SampledRelationContext.class,0);
		}
		public JoinRelationContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterJoinRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitJoinRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitJoinRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		return relation(0);
	}

	private RelationContext relation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationContext _localctx = new RelationContext(_ctx, _parentState);
		RelationContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_relation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new RelationDefaultContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(475);
			sampledRelation();
			}
			_ctx.stop = _input.LT(-1);
			setState(495);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new JoinRelationContext(new RelationContext(_parentctx, _parentState));
					((JoinRelationContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_relation);
					setState(477);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(491);
					switch (_input.LA(1)) {
					case CROSS:
						{
						setState(478);
						match(CROSS);
						setState(479);
						match(JOIN);
						setState(480);
						((JoinRelationContext)_localctx).right = sampledRelation();
						}
						break;
					case JOIN:
					case INNER:
					case LEFT:
					case RIGHT:
					case FULL:
						{
						setState(481);
						joinType();
						setState(482);
						match(JOIN);
						setState(483);
						((JoinRelationContext)_localctx).rightRelation = relation(0);
						setState(484);
						joinCriteria();
						}
						break;
					case NATURAL:
						{
						setState(486);
						match(NATURAL);
						setState(487);
						joinType();
						setState(488);
						match(JOIN);
						setState(489);
						((JoinRelationContext)_localctx).right = sampledRelation();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(497);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class JoinTypeContext extends ParserRuleContext {
		public TerminalNode INNER() { return getToken(SqlBaseParser.INNER, 0); }
		public TerminalNode LEFT() { return getToken(SqlBaseParser.LEFT, 0); }
		public TerminalNode OUTER() { return getToken(SqlBaseParser.OUTER, 0); }
		public TerminalNode RIGHT() { return getToken(SqlBaseParser.RIGHT, 0); }
		public TerminalNode FULL() { return getToken(SqlBaseParser.FULL, 0); }
		public JoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitJoinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitJoinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinTypeContext joinType() throws RecognitionException {
		JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_joinType);
		int _la;
		try {
			setState(513);
			switch (_input.LA(1)) {
			case JOIN:
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				_la = _input.LA(1);
				if (_la==INNER) {
					{
					setState(498);
					match(INNER);
					}
				}

				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 2);
				{
				setState(501);
				match(LEFT);
				setState(503);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(502);
					match(OUTER);
					}
				}

				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 3);
				{
				setState(505);
				match(RIGHT);
				setState(507);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(506);
					match(OUTER);
					}
				}

				}
				break;
			case FULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(509);
				match(FULL);
				setState(511);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(510);
					match(OUTER);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinCriteriaContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode USING() { return getToken(SqlBaseParser.USING, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public JoinCriteriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinCriteria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterJoinCriteria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitJoinCriteria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitJoinCriteria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinCriteriaContext joinCriteria() throws RecognitionException {
		JoinCriteriaContext _localctx = new JoinCriteriaContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_joinCriteria);
		int _la;
		try {
			setState(529);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(515);
				match(ON);
				setState(516);
				booleanExpression(0);
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
				match(USING);
				setState(518);
				match(T__0);
				setState(519);
				identifier();
				setState(524);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(520);
					match(T__1);
					setState(521);
					identifier();
					}
					}
					setState(526);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(527);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SampledRelationContext extends ParserRuleContext {
		public ExpressionContext percentage;
		public ExpressionContext expression;
		public List<ExpressionContext> stratify = new ArrayList<ExpressionContext>();
		public AliasedRelationContext aliasedRelation() {
			return getRuleContext(AliasedRelationContext.class,0);
		}
		public TerminalNode TABLESAMPLE() { return getToken(SqlBaseParser.TABLESAMPLE, 0); }
		public SampleTypeContext sampleType() {
			return getRuleContext(SampleTypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RESCALED() { return getToken(SqlBaseParser.RESCALED, 0); }
		public TerminalNode STRATIFY() { return getToken(SqlBaseParser.STRATIFY, 0); }
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public SampledRelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sampledRelation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSampledRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSampledRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSampledRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SampledRelationContext sampledRelation() throws RecognitionException {
		SampledRelationContext _localctx = new SampledRelationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_sampledRelation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			aliasedRelation();
			setState(555);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(532);
				match(TABLESAMPLE);
				setState(533);
				sampleType();
				setState(534);
				match(T__0);
				setState(535);
				((SampledRelationContext)_localctx).percentage = expression();
				setState(536);
				match(T__2);
				setState(538);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(537);
					match(RESCALED);
					}
					break;
				}
				setState(553);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(540);
					match(STRATIFY);
					setState(541);
					match(ON);
					setState(542);
					match(T__0);
					setState(543);
					((SampledRelationContext)_localctx).expression = expression();
					((SampledRelationContext)_localctx).stratify.add(((SampledRelationContext)_localctx).expression);
					setState(548);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(544);
						match(T__1);
						setState(545);
						((SampledRelationContext)_localctx).expression = expression();
						((SampledRelationContext)_localctx).stratify.add(((SampledRelationContext)_localctx).expression);
						}
						}
						setState(550);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(551);
					match(T__2);
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SampleTypeContext extends ParserRuleContext {
		public TerminalNode BERNOULLI() { return getToken(SqlBaseParser.BERNOULLI, 0); }
		public TerminalNode SYSTEM() { return getToken(SqlBaseParser.SYSTEM, 0); }
		public TerminalNode POISSONIZED() { return getToken(SqlBaseParser.POISSONIZED, 0); }
		public SampleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sampleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSampleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSampleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSampleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SampleTypeContext sampleType() throws RecognitionException {
		SampleTypeContext _localctx = new SampleTypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_sampleType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			_la = _input.LA(1);
			if ( !(((((_la - 124)) & ~0x3f) == 0 && ((1L << (_la - 124)) & ((1L << (SYSTEM - 124)) | (1L << (BERNOULLI - 124)) | (1L << (POISSONIZED - 124)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasedRelationContext extends ParserRuleContext {
		public RelationPrimaryContext relationPrimary() {
			return getRuleContext(RelationPrimaryContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public ColumnAliasesContext columnAliases() {
			return getRuleContext(ColumnAliasesContext.class,0);
		}
		public AliasedRelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasedRelation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterAliasedRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitAliasedRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitAliasedRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliasedRelationContext aliasedRelation() throws RecognitionException {
		AliasedRelationContext _localctx = new AliasedRelationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_aliasedRelation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			relationPrimary();
			setState(567);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(561);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(560);
					match(AS);
					}
				}

				setState(563);
				identifier();
				setState(565);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(564);
					columnAliases();
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnAliasesContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ColumnAliasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnAliases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterColumnAliases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitColumnAliases(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitColumnAliases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnAliasesContext columnAliases() throws RecognitionException {
		ColumnAliasesContext _localctx = new ColumnAliasesContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_columnAliases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
			match(T__0);
			setState(570);
			identifier();
			setState(575);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(571);
				match(T__1);
				setState(572);
				identifier();
				}
				}
				setState(577);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(578);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationPrimaryContext extends ParserRuleContext {
		public RelationPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationPrimary; }
	 
		public RelationPrimaryContext() { }
		public void copyFrom(RelationPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubqueryRelationContext extends RelationPrimaryContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public SubqueryRelationContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSubqueryRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSubqueryRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSubqueryRelation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedRelationContext extends RelationPrimaryContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public ParenthesizedRelationContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterParenthesizedRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitParenthesizedRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitParenthesizedRelation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnnestContext extends RelationPrimaryContext {
		public TerminalNode UNNEST() { return getToken(SqlBaseParser.UNNEST, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public TerminalNode ORDINALITY() { return getToken(SqlBaseParser.ORDINALITY, 0); }
		public UnnestContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterUnnest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitUnnest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitUnnest(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TableNameContext extends RelationPrimaryContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TableNameContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationPrimaryContext relationPrimary() throws RecognitionException {
		RelationPrimaryContext _localctx = new RelationPrimaryContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_relationPrimary);
		int _la;
		try {
			setState(604);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				_localctx = new TableNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(580);
				qualifiedName();
				}
				break;
			case 2:
				_localctx = new SubqueryRelationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(581);
				match(T__0);
				setState(582);
				query();
				setState(583);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new UnnestContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(585);
				match(UNNEST);
				setState(586);
				match(T__0);
				setState(587);
				expression();
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(588);
					match(T__1);
					setState(589);
					expression();
					}
					}
					setState(594);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(595);
				match(T__2);
				setState(598);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(596);
					match(WITH);
					setState(597);
					match(ORDINALITY);
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ParenthesizedRelationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(600);
				match(T__0);
				setState(601);
				relation(0);
				setState(602);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
			booleanExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
	 
		public BooleanExpressionContext() { }
		public void copyFrom(BooleanExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalNotContext extends BooleanExpressionContext {
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public LogicalNotContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterLogicalNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitLogicalNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitLogicalNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanDefaultContext extends BooleanExpressionContext {
		public PredicatedContext predicated() {
			return getRuleContext(PredicatedContext.class,0);
		}
		public BooleanDefaultContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBooleanDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBooleanDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBooleanDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExistsContext extends BooleanExpressionContext {
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ExistsContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterExists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitExists(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitExists(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalBinaryContext extends BooleanExpressionContext {
		public BooleanExpressionContext left;
		public Token operator;
		public BooleanExpressionContext right;
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(SqlBaseParser.AND, 0); }
		public TerminalNode OR() { return getToken(SqlBaseParser.OR, 0); }
		public LogicalBinaryContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterLogicalBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitLogicalBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitLogicalBinary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		return booleanExpression(0);
	}

	private BooleanExpressionContext booleanExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, _parentState);
		BooleanExpressionContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_booleanExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new LogicalNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(609);
				match(NOT);
				setState(610);
				booleanExpression(4);
				}
				break;
			case T__0:
			case APPROXIMATE:
			case AT:
			case CONFIDENCE:
			case NULL:
			case TRUE:
			case FALSE:
			case SUBSTRING:
			case POSITION:
			case DATE:
			case TIME:
			case TIMESTAMP:
			case INTERVAL:
			case YEAR:
			case MONTH:
			case DAY:
			case HOUR:
			case MINUTE:
			case SECOND:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case LOCALTIME:
			case LOCALTIMESTAMP:
			case EXTRACT:
			case CASE:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case ROW:
			case VIEW:
			case REPLACE:
			case EXPLAIN:
			case FORMAT:
			case TYPE:
			case TEXT:
			case GRAPHVIZ:
			case JSON:
			case LOGICAL:
			case DISTRIBUTED:
			case CAST:
			case TRY_CAST:
			case SHOW:
			case TABLES:
			case SCHEMAS:
			case CATALOGS:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case TO:
			case SYSTEM:
			case BERNOULLI:
			case POISSONIZED:
			case TABLESAMPLE:
			case RESCALED:
			case ARRAY:
			case MAP:
			case SET:
			case RESET:
			case SESSION:
			case NORMALIZE:
			case NFD:
			case NFC:
			case NFKD:
			case NFKC:
			case IF:
			case NULLIF:
			case COALESCE:
			case PLUS:
			case MINUS:
			case STRING:
			case INTEGER_VALUE:
			case DECIMAL_VALUE:
			case IDENTIFIER:
			case DIGIT_IDENTIFIER:
			case QUOTED_IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				{
				_localctx = new BooleanDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(611);
				predicated();
				}
				break;
			case EXISTS:
				{
				_localctx = new ExistsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(612);
				match(EXISTS);
				setState(613);
				match(T__0);
				setState(614);
				query();
				setState(615);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(627);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(625);
					switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
						((LogicalBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(619);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(620);
						((LogicalBinaryContext)_localctx).operator = match(AND);
						setState(621);
						((LogicalBinaryContext)_localctx).right = booleanExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
						((LogicalBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(622);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(623);
						((LogicalBinaryContext)_localctx).operator = match(OR);
						setState(624);
						((LogicalBinaryContext)_localctx).right = booleanExpression(3);
						}
						break;
					}
					} 
				}
				setState(629);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PredicatedContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression;
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicatedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicated; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterPredicated(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitPredicated(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitPredicated(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatedContext predicated() throws RecognitionException {
		PredicatedContext _localctx = new PredicatedContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_predicated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			((PredicatedContext)_localctx).valueExpression = valueExpression(0);
			setState(632);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(631);
				predicate(((PredicatedContext)_localctx).valueExpression);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public ParserRuleContext value;
		public PredicateContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PredicateContext(ParserRuleContext parent, int invokingState, ParserRuleContext value) {
			super(parent, invokingState);
			this.value = value;
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	 
		public PredicateContext() { }
		public void copyFrom(PredicateContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
		}
	}
	public static class ComparisonContext extends PredicateContext {
		public ValueExpressionContext right;
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public ComparisonContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LikeContext extends PredicateContext {
		public ValueExpressionContext pattern;
		public ValueExpressionContext escape;
		public TerminalNode LIKE() { return getToken(SqlBaseParser.LIKE, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public TerminalNode ESCAPE() { return getToken(SqlBaseParser.ESCAPE, 0); }
		public LikeContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterLike(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitLike(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitLike(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InSubqueryContext extends PredicateContext {
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public InSubqueryContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterInSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitInSubquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitInSubquery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DistinctFromContext extends PredicateContext {
		public ValueExpressionContext right;
		public TerminalNode IS() { return getToken(SqlBaseParser.IS, 0); }
		public TerminalNode DISTINCT() { return getToken(SqlBaseParser.DISTINCT, 0); }
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public DistinctFromContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDistinctFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDistinctFrom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDistinctFrom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InListContext extends PredicateContext {
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public InListContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterInList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitInList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitInList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullPredicateContext extends PredicateContext {
		public TerminalNode IS() { return getToken(SqlBaseParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SqlBaseParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public NullPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNullPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNullPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNullPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenContext extends PredicateContext {
		public ValueExpressionContext lower;
		public ValueExpressionContext upper;
		public TerminalNode BETWEEN() { return getToken(SqlBaseParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(SqlBaseParser.AND, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public BetweenContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBetween(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBetween(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBetween(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate(ParserRuleContext value) throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState(), value);
		enterRule(_localctx, 64, RULE_predicate);
		int _la;
		try {
			setState(689);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				_localctx = new ComparisonContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(634);
				comparisonOperator();
				setState(635);
				((ComparisonContext)_localctx).right = valueExpression(0);
				}
				break;
			case 2:
				_localctx = new BetweenContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(638);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(637);
					match(NOT);
					}
				}

				setState(640);
				match(BETWEEN);
				setState(641);
				((BetweenContext)_localctx).lower = valueExpression(0);
				setState(642);
				match(AND);
				setState(643);
				((BetweenContext)_localctx).upper = valueExpression(0);
				}
				break;
			case 3:
				_localctx = new InListContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(646);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(645);
					match(NOT);
					}
				}

				setState(648);
				match(IN);
				setState(649);
				match(T__0);
				setState(650);
				expression();
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(651);
					match(T__1);
					setState(652);
					expression();
					}
					}
					setState(657);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(658);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new InSubqueryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(661);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(660);
					match(NOT);
					}
				}

				setState(663);
				match(IN);
				setState(664);
				match(T__0);
				setState(665);
				query();
				setState(666);
				match(T__2);
				}
				break;
			case 5:
				_localctx = new LikeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(669);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(668);
					match(NOT);
					}
				}

				setState(671);
				match(LIKE);
				setState(672);
				((LikeContext)_localctx).pattern = valueExpression(0);
				setState(675);
				switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
				case 1:
					{
					setState(673);
					match(ESCAPE);
					setState(674);
					((LikeContext)_localctx).escape = valueExpression(0);
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new NullPredicateContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(677);
				match(IS);
				setState(679);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(678);
					match(NOT);
					}
				}

				setState(681);
				match(NULL);
				}
				break;
			case 7:
				_localctx = new DistinctFromContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(682);
				match(IS);
				setState(684);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(683);
					match(NOT);
					}
				}

				setState(686);
				match(DISTINCT);
				setState(687);
				match(FROM);
				setState(688);
				((DistinctFromContext)_localctx).right = valueExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueExpressionContext extends ParserRuleContext {
		public ValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueExpression; }
	 
		public ValueExpressionContext() { }
		public void copyFrom(ValueExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueExpressionDefaultContext extends ValueExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ValueExpressionDefaultContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterValueExpressionDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitValueExpressionDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitValueExpressionDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConcatenationContext extends ValueExpressionContext {
		public ValueExpressionContext left;
		public ValueExpressionContext right;
		public TerminalNode CONCAT() { return getToken(SqlBaseParser.CONCAT, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public ConcatenationContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterConcatenation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitConcatenation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitConcatenation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticBinaryContext extends ValueExpressionContext {
		public ValueExpressionContext left;
		public Token operator;
		public ValueExpressionContext right;
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode ASTERISK() { return getToken(SqlBaseParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(SqlBaseParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(SqlBaseParser.PERCENT, 0); }
		public TerminalNode PLUS() { return getToken(SqlBaseParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public ArithmeticBinaryContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterArithmeticBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitArithmeticBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitArithmeticBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticUnaryContext extends ValueExpressionContext {
		public Token operator;
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SqlBaseParser.PLUS, 0); }
		public ArithmeticUnaryContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterArithmeticUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitArithmeticUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitArithmeticUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtTimeZoneContext extends ValueExpressionContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode AT() { return getToken(SqlBaseParser.AT, 0); }
		public TimeZoneSpecifierContext timeZoneSpecifier() {
			return getRuleContext(TimeZoneSpecifierContext.class,0);
		}
		public AtTimeZoneContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterAtTimeZone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitAtTimeZone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitAtTimeZone(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueExpressionContext valueExpression() throws RecognitionException {
		return valueExpression(0);
	}

	private ValueExpressionContext valueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueExpressionContext _localctx = new ValueExpressionContext(_ctx, _parentState);
		ValueExpressionContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_valueExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(695);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
				{
				_localctx = new ArithmeticUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(692);
				((ArithmeticUnaryContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((ArithmeticUnaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(693);
				valueExpression(4);
				}
				break;
			case T__0:
			case APPROXIMATE:
			case AT:
			case CONFIDENCE:
			case NULL:
			case TRUE:
			case FALSE:
			case SUBSTRING:
			case POSITION:
			case DATE:
			case TIME:
			case TIMESTAMP:
			case INTERVAL:
			case YEAR:
			case MONTH:
			case DAY:
			case HOUR:
			case MINUTE:
			case SECOND:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case LOCALTIME:
			case LOCALTIMESTAMP:
			case EXTRACT:
			case CASE:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case ROW:
			case VIEW:
			case REPLACE:
			case EXPLAIN:
			case FORMAT:
			case TYPE:
			case TEXT:
			case GRAPHVIZ:
			case JSON:
			case LOGICAL:
			case DISTRIBUTED:
			case CAST:
			case TRY_CAST:
			case SHOW:
			case TABLES:
			case SCHEMAS:
			case CATALOGS:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case TO:
			case SYSTEM:
			case BERNOULLI:
			case POISSONIZED:
			case TABLESAMPLE:
			case RESCALED:
			case ARRAY:
			case MAP:
			case SET:
			case RESET:
			case SESSION:
			case NORMALIZE:
			case NFD:
			case NFC:
			case NFKD:
			case NFKC:
			case IF:
			case NULLIF:
			case COALESCE:
			case STRING:
			case INTEGER_VALUE:
			case DECIMAL_VALUE:
			case IDENTIFIER:
			case DIGIT_IDENTIFIER:
			case QUOTED_IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				{
				_localctx = new ValueExpressionDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(694);
				primaryExpression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(711);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(709);
					switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(697);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(698);
						((ArithmeticBinaryContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 155)) & ~0x3f) == 0 && ((1L << (_la - 155)) & ((1L << (ASTERISK - 155)) | (1L << (SLASH - 155)) | (1L << (PERCENT - 155)))) != 0)) ) {
							((ArithmeticBinaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(699);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(700);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(701);
						((ArithmeticBinaryContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ArithmeticBinaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(702);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(3);
						}
						break;
					case 3:
						{
						_localctx = new ConcatenationContext(new ValueExpressionContext(_parentctx, _parentState));
						((ConcatenationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(703);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(704);
						match(CONCAT);
						setState(705);
						((ConcatenationContext)_localctx).right = valueExpression(2);
						}
						break;
					case 4:
						{
						_localctx = new AtTimeZoneContext(new ValueExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(706);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(707);
						match(AT);
						setState(708);
						timeZoneSpecifier();
						}
						break;
					}
					} 
				}
				setState(713);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	 
		public PrimaryExpressionContext() { }
		public void copyFrom(PrimaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleCaseContext extends PrimaryExpressionContext {
		public ExpressionContext elseExpression;
		public TerminalNode CASE() { return getToken(SqlBaseParser.CASE, 0); }
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode END() { return getToken(SqlBaseParser.END, 0); }
		public List<WhenClauseContext> whenClause() {
			return getRuleContexts(WhenClauseContext.class);
		}
		public WhenClauseContext whenClause(int i) {
			return getRuleContext(WhenClauseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SqlBaseParser.ELSE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SimpleCaseContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSimpleCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSimpleCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSimpleCase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColumnReferenceContext extends PrimaryExpressionContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ColumnReferenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterColumnReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitColumnReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitColumnReference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullLiteralContext extends PrimaryExpressionContext {
		public TerminalNode NULL() { return getToken(SqlBaseParser.NULL, 0); }
		public NullLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNullLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowConstructorContext extends PrimaryExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ROW() { return getToken(SqlBaseParser.ROW, 0); }
		public RowConstructorContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterRowConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitRowConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitRowConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubscriptContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext value;
		public ValueExpressionContext index;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public SubscriptContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSubscript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSubscript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSubscript(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeConstructorContext extends PrimaryExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TypeConstructorContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTypeConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTypeConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTypeConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SpecialDateTimeFunctionContext extends PrimaryExpressionContext {
		public Token name;
		public Token precision;
		public TerminalNode CURRENT_DATE() { return getToken(SqlBaseParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIME() { return getToken(SqlBaseParser.CURRENT_TIME, 0); }
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SqlBaseParser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode LOCALTIME() { return getToken(SqlBaseParser.LOCALTIME, 0); }
		public TerminalNode LOCALTIMESTAMP() { return getToken(SqlBaseParser.LOCALTIMESTAMP, 0); }
		public SpecialDateTimeFunctionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSpecialDateTimeFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSpecialDateTimeFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSpecialDateTimeFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubqueryExpressionContext extends PrimaryExpressionContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public SubqueryExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSubqueryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSubqueryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSubqueryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubstringContext extends PrimaryExpressionContext {
		public TerminalNode SUBSTRING() { return getToken(SqlBaseParser.SUBSTRING, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public TerminalNode FOR() { return getToken(SqlBaseParser.FOR, 0); }
		public SubstringContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSubstring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSubstring(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSubstring(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastContext extends PrimaryExpressionContext {
		public TerminalNode CAST() { return getToken(SqlBaseParser.CAST, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TRY_CAST() { return getToken(SqlBaseParser.TRY_CAST, 0); }
		public CastContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitCast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitCast(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExtractContext extends PrimaryExpressionContext {
		public TerminalNode EXTRACT() { return getToken(SqlBaseParser.EXTRACT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public ExtractContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterExtract(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitExtract(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitExtract(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedExpressionContext extends PrimaryExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesizedExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterParenthesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitParenthesizedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitParenthesizedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends PrimaryExpressionContext {
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public StringLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayConstructorContext extends PrimaryExpressionContext {
		public TerminalNode ARRAY() { return getToken(SqlBaseParser.ARRAY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayConstructorContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterArrayConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitArrayConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitArrayConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends PrimaryExpressionContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode ASTERISK() { return getToken(SqlBaseParser.ASTERISK, 0); }
		public OverContext over() {
			return getRuleContext(OverContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public FunctionCallContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NormalizeContext extends PrimaryExpressionContext {
		public TerminalNode NORMALIZE() { return getToken(SqlBaseParser.NORMALIZE, 0); }
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public NormalFormContext normalForm() {
			return getRuleContext(NormalFormContext.class,0);
		}
		public NormalizeContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNormalize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNormalize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNormalize(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldReferenceContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext value;
		public IdentifierContext fieldName;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FieldReferenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterFieldReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitFieldReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitFieldReference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SearchedCaseContext extends PrimaryExpressionContext {
		public ExpressionContext elseExpression;
		public TerminalNode CASE() { return getToken(SqlBaseParser.CASE, 0); }
		public TerminalNode END() { return getToken(SqlBaseParser.END, 0); }
		public List<WhenClauseContext> whenClause() {
			return getRuleContexts(WhenClauseContext.class);
		}
		public WhenClauseContext whenClause(int i) {
			return getRuleContext(WhenClauseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SqlBaseParser.ELSE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SearchedCaseContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSearchedCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSearchedCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSearchedCase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PositionContext extends PrimaryExpressionContext {
		public TerminalNode POSITION() { return getToken(SqlBaseParser.POSITION, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public PositionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitPosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitPosition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntervalLiteralContext extends PrimaryExpressionContext {
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public IntervalLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterIntervalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitIntervalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitIntervalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericLiteralContext extends PrimaryExpressionContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumericLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNumericLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNumericLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends PrimaryExpressionContext {
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public BooleanLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		return primaryExpression(0);
	}

	private PrimaryExpressionContext primaryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, _parentState);
		PrimaryExpressionContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_primaryExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(891);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				{
				_localctx = new NullLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(715);
				match(NULL);
				}
				break;
			case 2:
				{
				_localctx = new IntervalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(716);
				interval();
				}
				break;
			case 3:
				{
				_localctx = new TypeConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(717);
				identifier();
				setState(718);
				match(STRING);
				}
				break;
			case 4:
				{
				_localctx = new NumericLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(720);
				number();
				}
				break;
			case 5:
				{
				_localctx = new BooleanLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(721);
				booleanValue();
				}
				break;
			case 6:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(722);
				match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new RowConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(723);
				match(T__0);
				setState(724);
				expression();
				setState(727); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(725);
					match(T__1);
					setState(726);
					expression();
					}
					}
					setState(729); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 );
				setState(731);
				match(T__2);
				}
				break;
			case 8:
				{
				_localctx = new RowConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(733);
				match(ROW);
				setState(734);
				match(T__0);
				setState(735);
				expression();
				setState(740);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(736);
					match(T__1);
					setState(737);
					expression();
					}
					}
					setState(742);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(743);
				match(T__2);
				}
				break;
			case 9:
				{
				_localctx = new ColumnReferenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(745);
				qualifiedName();
				}
				break;
			case 10:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(746);
				qualifiedName();
				setState(747);
				match(T__0);
				setState(748);
				match(ASTERISK);
				setState(749);
				match(T__2);
				setState(751);
				switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
				case 1:
					{
					setState(750);
					over();
					}
					break;
				}
				}
				break;
			case 11:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(753);
				qualifiedName();
				setState(754);
				match(T__0);
				setState(766);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << ALL) | (1L << DISTINCT) | (1L << APPROXIMATE) | (1L << AT) | (1L << CONFIDENCE) | (1L << NOT) | (1L << EXISTS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << SUBSTRING) | (1L << POSITION) | (1L << DATE) | (1L << TIME) | (1L << TIMESTAMP) | (1L << INTERVAL) | (1L << YEAR) | (1L << MONTH) | (1L << DAY) | (1L << HOUR) | (1L << MINUTE) | (1L << SECOND) | (1L << CURRENT_DATE) | (1L << CURRENT_TIME) | (1L << CURRENT_TIMESTAMP) | (1L << LOCALTIME) | (1L << LOCALTIMESTAMP) | (1L << EXTRACT) | (1L << CASE))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (OVER - 75)) | (1L << (PARTITION - 75)) | (1L << (RANGE - 75)) | (1L << (ROWS - 75)) | (1L << (PRECEDING - 75)) | (1L << (FOLLOWING - 75)) | (1L << (CURRENT - 75)) | (1L << (ROW - 75)) | (1L << (VIEW - 75)) | (1L << (REPLACE - 75)) | (1L << (EXPLAIN - 75)) | (1L << (FORMAT - 75)) | (1L << (TYPE - 75)) | (1L << (TEXT - 75)) | (1L << (GRAPHVIZ - 75)) | (1L << (JSON - 75)) | (1L << (LOGICAL - 75)) | (1L << (DISTRIBUTED - 75)) | (1L << (CAST - 75)) | (1L << (TRY_CAST - 75)) | (1L << (SHOW - 75)) | (1L << (TABLES - 75)) | (1L << (SCHEMAS - 75)) | (1L << (CATALOGS - 75)) | (1L << (COLUMNS - 75)) | (1L << (COLUMN - 75)) | (1L << (USE - 75)) | (1L << (PARTITIONS - 75)) | (1L << (FUNCTIONS - 75)) | (1L << (TO - 75)) | (1L << (SYSTEM - 75)) | (1L << (BERNOULLI - 75)) | (1L << (POISSONIZED - 75)) | (1L << (TABLESAMPLE - 75)) | (1L << (RESCALED - 75)) | (1L << (ARRAY - 75)) | (1L << (MAP - 75)) | (1L << (SET - 75)) | (1L << (RESET - 75)) | (1L << (SESSION - 75)))) != 0) || ((((_la - 139)) & ~0x3f) == 0 && ((1L << (_la - 139)) & ((1L << (NORMALIZE - 139)) | (1L << (NFD - 139)) | (1L << (NFC - 139)) | (1L << (NFKD - 139)) | (1L << (NFKC - 139)) | (1L << (IF - 139)) | (1L << (NULLIF - 139)) | (1L << (COALESCE - 139)) | (1L << (PLUS - 139)) | (1L << (MINUS - 139)) | (1L << (STRING - 139)) | (1L << (INTEGER_VALUE - 139)) | (1L << (DECIMAL_VALUE - 139)) | (1L << (IDENTIFIER - 139)) | (1L << (DIGIT_IDENTIFIER - 139)) | (1L << (QUOTED_IDENTIFIER - 139)) | (1L << (BACKQUOTED_IDENTIFIER - 139)))) != 0)) {
					{
					setState(756);
					_la = _input.LA(1);
					if (_la==ALL || _la==DISTINCT) {
						{
						setState(755);
						setQuantifier();
						}
					}

					setState(758);
					expression();
					setState(763);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(759);
						match(T__1);
						setState(760);
						expression();
						}
						}
						setState(765);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(768);
				match(T__2);
				setState(770);
				switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
				case 1:
					{
					setState(769);
					over();
					}
					break;
				}
				}
				break;
			case 12:
				{
				_localctx = new SubqueryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(772);
				match(T__0);
				setState(773);
				query();
				setState(774);
				match(T__2);
				}
				break;
			case 13:
				{
				_localctx = new SimpleCaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(776);
				match(CASE);
				setState(777);
				valueExpression(0);
				setState(779); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(778);
					whenClause();
					}
					}
					setState(781); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(785);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(783);
					match(ELSE);
					setState(784);
					((SimpleCaseContext)_localctx).elseExpression = expression();
					}
				}

				setState(787);
				match(END);
				}
				break;
			case 14:
				{
				_localctx = new SearchedCaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(789);
				match(CASE);
				setState(791); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(790);
					whenClause();
					}
					}
					setState(793); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(797);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(795);
					match(ELSE);
					setState(796);
					((SearchedCaseContext)_localctx).elseExpression = expression();
					}
				}

				setState(799);
				match(END);
				}
				break;
			case 15:
				{
				_localctx = new CastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(801);
				match(CAST);
				setState(802);
				match(T__0);
				setState(803);
				expression();
				setState(804);
				match(AS);
				setState(805);
				type(0);
				setState(806);
				match(T__2);
				}
				break;
			case 16:
				{
				_localctx = new CastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(808);
				match(TRY_CAST);
				setState(809);
				match(T__0);
				setState(810);
				expression();
				setState(811);
				match(AS);
				setState(812);
				type(0);
				setState(813);
				match(T__2);
				}
				break;
			case 17:
				{
				_localctx = new ArrayConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(815);
				match(ARRAY);
				setState(816);
				match(T__4);
				setState(825);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << APPROXIMATE) | (1L << AT) | (1L << CONFIDENCE) | (1L << NOT) | (1L << EXISTS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << SUBSTRING) | (1L << POSITION) | (1L << DATE) | (1L << TIME) | (1L << TIMESTAMP) | (1L << INTERVAL) | (1L << YEAR) | (1L << MONTH) | (1L << DAY) | (1L << HOUR) | (1L << MINUTE) | (1L << SECOND) | (1L << CURRENT_DATE) | (1L << CURRENT_TIME) | (1L << CURRENT_TIMESTAMP) | (1L << LOCALTIME) | (1L << LOCALTIMESTAMP) | (1L << EXTRACT) | (1L << CASE))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (OVER - 75)) | (1L << (PARTITION - 75)) | (1L << (RANGE - 75)) | (1L << (ROWS - 75)) | (1L << (PRECEDING - 75)) | (1L << (FOLLOWING - 75)) | (1L << (CURRENT - 75)) | (1L << (ROW - 75)) | (1L << (VIEW - 75)) | (1L << (REPLACE - 75)) | (1L << (EXPLAIN - 75)) | (1L << (FORMAT - 75)) | (1L << (TYPE - 75)) | (1L << (TEXT - 75)) | (1L << (GRAPHVIZ - 75)) | (1L << (JSON - 75)) | (1L << (LOGICAL - 75)) | (1L << (DISTRIBUTED - 75)) | (1L << (CAST - 75)) | (1L << (TRY_CAST - 75)) | (1L << (SHOW - 75)) | (1L << (TABLES - 75)) | (1L << (SCHEMAS - 75)) | (1L << (CATALOGS - 75)) | (1L << (COLUMNS - 75)) | (1L << (COLUMN - 75)) | (1L << (USE - 75)) | (1L << (PARTITIONS - 75)) | (1L << (FUNCTIONS - 75)) | (1L << (TO - 75)) | (1L << (SYSTEM - 75)) | (1L << (BERNOULLI - 75)) | (1L << (POISSONIZED - 75)) | (1L << (TABLESAMPLE - 75)) | (1L << (RESCALED - 75)) | (1L << (ARRAY - 75)) | (1L << (MAP - 75)) | (1L << (SET - 75)) | (1L << (RESET - 75)) | (1L << (SESSION - 75)))) != 0) || ((((_la - 139)) & ~0x3f) == 0 && ((1L << (_la - 139)) & ((1L << (NORMALIZE - 139)) | (1L << (NFD - 139)) | (1L << (NFC - 139)) | (1L << (NFKD - 139)) | (1L << (NFKC - 139)) | (1L << (IF - 139)) | (1L << (NULLIF - 139)) | (1L << (COALESCE - 139)) | (1L << (PLUS - 139)) | (1L << (MINUS - 139)) | (1L << (STRING - 139)) | (1L << (INTEGER_VALUE - 139)) | (1L << (DECIMAL_VALUE - 139)) | (1L << (IDENTIFIER - 139)) | (1L << (DIGIT_IDENTIFIER - 139)) | (1L << (QUOTED_IDENTIFIER - 139)) | (1L << (BACKQUOTED_IDENTIFIER - 139)))) != 0)) {
					{
					setState(817);
					expression();
					setState(822);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(818);
						match(T__1);
						setState(819);
						expression();
						}
						}
						setState(824);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(827);
				match(T__5);
				}
				break;
			case 18:
				{
				_localctx = new SpecialDateTimeFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(828);
				((SpecialDateTimeFunctionContext)_localctx).name = match(CURRENT_DATE);
				}
				break;
			case 19:
				{
				_localctx = new SpecialDateTimeFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(829);
				((SpecialDateTimeFunctionContext)_localctx).name = match(CURRENT_TIME);
				setState(833);
				switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
				case 1:
					{
					setState(830);
					match(T__0);
					setState(831);
					((SpecialDateTimeFunctionContext)_localctx).precision = match(INTEGER_VALUE);
					setState(832);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 20:
				{
				_localctx = new SpecialDateTimeFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(835);
				((SpecialDateTimeFunctionContext)_localctx).name = match(CURRENT_TIMESTAMP);
				setState(839);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(836);
					match(T__0);
					setState(837);
					((SpecialDateTimeFunctionContext)_localctx).precision = match(INTEGER_VALUE);
					setState(838);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 21:
				{
				_localctx = new SpecialDateTimeFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(841);
				((SpecialDateTimeFunctionContext)_localctx).name = match(LOCALTIME);
				setState(845);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(842);
					match(T__0);
					setState(843);
					((SpecialDateTimeFunctionContext)_localctx).precision = match(INTEGER_VALUE);
					setState(844);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 22:
				{
				_localctx = new SpecialDateTimeFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(847);
				((SpecialDateTimeFunctionContext)_localctx).name = match(LOCALTIMESTAMP);
				setState(851);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(848);
					match(T__0);
					setState(849);
					((SpecialDateTimeFunctionContext)_localctx).precision = match(INTEGER_VALUE);
					setState(850);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 23:
				{
				_localctx = new SubstringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(853);
				match(SUBSTRING);
				setState(854);
				match(T__0);
				setState(855);
				valueExpression(0);
				setState(856);
				match(FROM);
				setState(857);
				valueExpression(0);
				setState(860);
				_la = _input.LA(1);
				if (_la==FOR) {
					{
					setState(858);
					match(FOR);
					setState(859);
					valueExpression(0);
					}
				}

				setState(862);
				match(T__2);
				}
				break;
			case 24:
				{
				_localctx = new NormalizeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(864);
				match(NORMALIZE);
				setState(865);
				match(T__0);
				setState(866);
				valueExpression(0);
				setState(869);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(867);
					match(T__1);
					setState(868);
					normalForm();
					}
				}

				setState(871);
				match(T__2);
				}
				break;
			case 25:
				{
				_localctx = new ExtractContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(873);
				match(EXTRACT);
				setState(874);
				match(T__0);
				setState(875);
				identifier();
				setState(876);
				match(FROM);
				setState(877);
				valueExpression(0);
				setState(878);
				match(T__2);
				}
				break;
			case 26:
				{
				_localctx = new PositionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(880);
				match(POSITION);
				setState(881);
				match(T__0);
				setState(882);
				valueExpression(0);
				setState(883);
				match(IN);
				setState(884);
				valueExpression(0);
				setState(885);
				match(T__2);
				}
				break;
			case 27:
				{
				_localctx = new ParenthesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(887);
				match(T__0);
				setState(888);
				expression();
				setState(889);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(903);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(901);
					switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
					case 1:
						{
						_localctx = new SubscriptContext(new PrimaryExpressionContext(_parentctx, _parentState));
						((SubscriptContext)_localctx).value = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(893);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(894);
						match(T__4);
						setState(895);
						((SubscriptContext)_localctx).index = valueExpression(0);
						setState(896);
						match(T__5);
						}
						break;
					case 2:
						{
						_localctx = new FieldReferenceContext(new PrimaryExpressionContext(_parentctx, _parentState));
						((FieldReferenceContext)_localctx).value = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(898);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(899);
						match(T__3);
						setState(900);
						((FieldReferenceContext)_localctx).fieldName = identifier();
						}
						break;
					}
					} 
				}
				setState(905);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TimeZoneSpecifierContext extends ParserRuleContext {
		public TimeZoneSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeZoneSpecifier; }
	 
		public TimeZoneSpecifierContext() { }
		public void copyFrom(TimeZoneSpecifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TimeZoneIntervalContext extends TimeZoneSpecifierContext {
		public TerminalNode TIME() { return getToken(SqlBaseParser.TIME, 0); }
		public TerminalNode ZONE() { return getToken(SqlBaseParser.ZONE, 0); }
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public TimeZoneIntervalContext(TimeZoneSpecifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTimeZoneInterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTimeZoneInterval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTimeZoneInterval(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TimeZoneStringContext extends TimeZoneSpecifierContext {
		public TerminalNode TIME() { return getToken(SqlBaseParser.TIME, 0); }
		public TerminalNode ZONE() { return getToken(SqlBaseParser.ZONE, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TimeZoneStringContext(TimeZoneSpecifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTimeZoneString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTimeZoneString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTimeZoneString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeZoneSpecifierContext timeZoneSpecifier() throws RecognitionException {
		TimeZoneSpecifierContext _localctx = new TimeZoneSpecifierContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_timeZoneSpecifier);
		try {
			setState(912);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				_localctx = new TimeZoneIntervalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(906);
				match(TIME);
				setState(907);
				match(ZONE);
				setState(908);
				interval();
				}
				break;
			case 2:
				_localctx = new TimeZoneStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(909);
				match(TIME);
				setState(910);
				match(ZONE);
				setState(911);
				match(STRING);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SqlBaseParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(SqlBaseParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(SqlBaseParser.LT, 0); }
		public TerminalNode LTE() { return getToken(SqlBaseParser.LTE, 0); }
		public TerminalNode GT() { return getToken(SqlBaseParser.GT, 0); }
		public TerminalNode GTE() { return getToken(SqlBaseParser.GTE, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			_la = _input.LA(1);
			if ( !(((((_la - 147)) & ~0x3f) == 0 && ((1L << (_la - 147)) & ((1L << (EQ - 147)) | (1L << (NEQ - 147)) | (1L << (LT - 147)) | (1L << (LTE - 147)) | (1L << (GT - 147)) | (1L << (GTE - 147)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanValueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SqlBaseParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SqlBaseParser.FALSE, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBooleanValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_booleanValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(916);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalContext extends ParserRuleContext {
		public Token sign;
		public IntervalFieldContext from;
		public IntervalFieldContext to;
		public TerminalNode INTERVAL() { return getToken(SqlBaseParser.INTERVAL, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public List<IntervalFieldContext> intervalField() {
			return getRuleContexts(IntervalFieldContext.class);
		}
		public IntervalFieldContext intervalField(int i) {
			return getRuleContext(IntervalFieldContext.class,i);
		}
		public TerminalNode TO() { return getToken(SqlBaseParser.TO, 0); }
		public TerminalNode PLUS() { return getToken(SqlBaseParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public IntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterInterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitInterval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalContext interval() throws RecognitionException {
		IntervalContext _localctx = new IntervalContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_interval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(918);
			match(INTERVAL);
			setState(920);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(919);
				((IntervalContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((IntervalContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(922);
			match(STRING);
			setState(923);
			((IntervalContext)_localctx).from = intervalField();
			setState(926);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				{
				setState(924);
				match(TO);
				setState(925);
				((IntervalContext)_localctx).to = intervalField();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalFieldContext extends ParserRuleContext {
		public TerminalNode YEAR() { return getToken(SqlBaseParser.YEAR, 0); }
		public TerminalNode MONTH() { return getToken(SqlBaseParser.MONTH, 0); }
		public TerminalNode DAY() { return getToken(SqlBaseParser.DAY, 0); }
		public TerminalNode HOUR() { return getToken(SqlBaseParser.HOUR, 0); }
		public TerminalNode MINUTE() { return getToken(SqlBaseParser.MINUTE, 0); }
		public TerminalNode SECOND() { return getToken(SqlBaseParser.SECOND, 0); }
		public IntervalFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterIntervalField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitIntervalField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitIntervalField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalFieldContext intervalField() throws RecognitionException {
		IntervalFieldContext _localctx = new IntervalFieldContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_intervalField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(928);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << YEAR) | (1L << MONTH) | (1L << DAY) | (1L << HOUR) | (1L << MINUTE) | (1L << SECOND))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(SqlBaseParser.ARRAY, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode MAP() { return getToken(SqlBaseParser.MAP, 0); }
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(944);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				{
				setState(931);
				match(ARRAY);
				setState(932);
				match(LT);
				setState(933);
				type(0);
				setState(934);
				match(GT);
				}
				break;
			case 2:
				{
				setState(936);
				match(MAP);
				setState(937);
				match(LT);
				setState(938);
				type(0);
				setState(939);
				match(T__1);
				setState(940);
				type(0);
				setState(941);
				match(GT);
				}
				break;
			case 3:
				{
				setState(943);
				simpleType();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(950);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(946);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(947);
					match(ARRAY);
					}
					} 
				}
				setState(952);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SimpleTypeContext extends ParserRuleContext {
		public TerminalNode TIME_WITH_TIME_ZONE() { return getToken(SqlBaseParser.TIME_WITH_TIME_ZONE, 0); }
		public TerminalNode TIMESTAMP_WITH_TIME_ZONE() { return getToken(SqlBaseParser.TIMESTAMP_WITH_TIME_ZONE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SimpleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSimpleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSimpleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSimpleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleTypeContext simpleType() throws RecognitionException {
		SimpleTypeContext _localctx = new SimpleTypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_simpleType);
		try {
			setState(956);
			switch (_input.LA(1)) {
			case TIME_WITH_TIME_ZONE:
				enterOuterAlt(_localctx, 1);
				{
				setState(953);
				match(TIME_WITH_TIME_ZONE);
				}
				break;
			case TIMESTAMP_WITH_TIME_ZONE:
				enterOuterAlt(_localctx, 2);
				{
				setState(954);
				match(TIMESTAMP_WITH_TIME_ZONE);
				}
				break;
			case APPROXIMATE:
			case AT:
			case CONFIDENCE:
			case POSITION:
			case DATE:
			case TIME:
			case TIMESTAMP:
			case INTERVAL:
			case YEAR:
			case MONTH:
			case DAY:
			case HOUR:
			case MINUTE:
			case SECOND:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case ROW:
			case VIEW:
			case REPLACE:
			case EXPLAIN:
			case FORMAT:
			case TYPE:
			case TEXT:
			case GRAPHVIZ:
			case JSON:
			case LOGICAL:
			case DISTRIBUTED:
			case SHOW:
			case TABLES:
			case SCHEMAS:
			case CATALOGS:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case TO:
			case SYSTEM:
			case BERNOULLI:
			case POISSONIZED:
			case TABLESAMPLE:
			case RESCALED:
			case MAP:
			case SET:
			case RESET:
			case SESSION:
			case NFD:
			case NFC:
			case NFKD:
			case NFKC:
			case IF:
			case NULLIF:
			case COALESCE:
			case IDENTIFIER:
			case DIGIT_IDENTIFIER:
			case QUOTED_IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(955);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenClauseContext extends ParserRuleContext {
		public ExpressionContext condition;
		public ExpressionContext result;
		public TerminalNode WHEN() { return getToken(SqlBaseParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(SqlBaseParser.THEN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public WhenClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterWhenClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitWhenClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitWhenClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenClauseContext whenClause() throws RecognitionException {
		WhenClauseContext _localctx = new WhenClauseContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_whenClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(958);
			match(WHEN);
			setState(959);
			((WhenClauseContext)_localctx).condition = expression();
			setState(960);
			match(THEN);
			setState(961);
			((WhenClauseContext)_localctx).result = expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OverContext extends ParserRuleContext {
		public ExpressionContext expression;
		public List<ExpressionContext> partition = new ArrayList<ExpressionContext>();
		public TerminalNode OVER() { return getToken(SqlBaseParser.OVER, 0); }
		public TerminalNode PARTITION() { return getToken(SqlBaseParser.PARTITION, 0); }
		public List<TerminalNode> BY() { return getTokens(SqlBaseParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SqlBaseParser.BY, i);
		}
		public TerminalNode ORDER() { return getToken(SqlBaseParser.ORDER, 0); }
		public List<SortItemContext> sortItem() {
			return getRuleContexts(SortItemContext.class);
		}
		public SortItemContext sortItem(int i) {
			return getRuleContext(SortItemContext.class,i);
		}
		public WindowFrameContext windowFrame() {
			return getRuleContext(WindowFrameContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_over; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterOver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitOver(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitOver(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OverContext over() throws RecognitionException {
		OverContext _localctx = new OverContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_over);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(963);
			match(OVER);
			setState(964);
			match(T__0);
			setState(975);
			_la = _input.LA(1);
			if (_la==PARTITION) {
				{
				setState(965);
				match(PARTITION);
				setState(966);
				match(BY);
				setState(967);
				((OverContext)_localctx).expression = expression();
				((OverContext)_localctx).partition.add(((OverContext)_localctx).expression);
				setState(972);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(968);
					match(T__1);
					setState(969);
					((OverContext)_localctx).expression = expression();
					((OverContext)_localctx).partition.add(((OverContext)_localctx).expression);
					}
					}
					setState(974);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(987);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(977);
				match(ORDER);
				setState(978);
				match(BY);
				setState(979);
				sortItem();
				setState(984);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(980);
					match(T__1);
					setState(981);
					sortItem();
					}
					}
					setState(986);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(990);
			_la = _input.LA(1);
			if (_la==RANGE || _la==ROWS) {
				{
				setState(989);
				windowFrame();
				}
			}

			setState(992);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameContext extends ParserRuleContext {
		public Token frameType;
		public FrameBoundContext start;
		public FrameBoundContext end;
		public TerminalNode RANGE() { return getToken(SqlBaseParser.RANGE, 0); }
		public List<FrameBoundContext> frameBound() {
			return getRuleContexts(FrameBoundContext.class);
		}
		public FrameBoundContext frameBound(int i) {
			return getRuleContext(FrameBoundContext.class,i);
		}
		public TerminalNode ROWS() { return getToken(SqlBaseParser.ROWS, 0); }
		public TerminalNode BETWEEN() { return getToken(SqlBaseParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(SqlBaseParser.AND, 0); }
		public WindowFrameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrame; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterWindowFrame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitWindowFrame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitWindowFrame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFrameContext windowFrame() throws RecognitionException {
		WindowFrameContext _localctx = new WindowFrameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_windowFrame);
		try {
			setState(1010);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(994);
				((WindowFrameContext)_localctx).frameType = match(RANGE);
				setState(995);
				((WindowFrameContext)_localctx).start = frameBound();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(996);
				((WindowFrameContext)_localctx).frameType = match(ROWS);
				setState(997);
				((WindowFrameContext)_localctx).start = frameBound();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(998);
				((WindowFrameContext)_localctx).frameType = match(RANGE);
				setState(999);
				match(BETWEEN);
				setState(1000);
				((WindowFrameContext)_localctx).start = frameBound();
				setState(1001);
				match(AND);
				setState(1002);
				((WindowFrameContext)_localctx).end = frameBound();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1004);
				((WindowFrameContext)_localctx).frameType = match(ROWS);
				setState(1005);
				match(BETWEEN);
				setState(1006);
				((WindowFrameContext)_localctx).start = frameBound();
				setState(1007);
				match(AND);
				setState(1008);
				((WindowFrameContext)_localctx).end = frameBound();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FrameBoundContext extends ParserRuleContext {
		public FrameBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frameBound; }
	 
		public FrameBoundContext() { }
		public void copyFrom(FrameBoundContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoundedFrameContext extends FrameBoundContext {
		public Token boundType;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PRECEDING() { return getToken(SqlBaseParser.PRECEDING, 0); }
		public TerminalNode FOLLOWING() { return getToken(SqlBaseParser.FOLLOWING, 0); }
		public BoundedFrameContext(FrameBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBoundedFrame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBoundedFrame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBoundedFrame(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnboundedFrameContext extends FrameBoundContext {
		public Token boundType;
		public TerminalNode UNBOUNDED() { return getToken(SqlBaseParser.UNBOUNDED, 0); }
		public TerminalNode PRECEDING() { return getToken(SqlBaseParser.PRECEDING, 0); }
		public TerminalNode FOLLOWING() { return getToken(SqlBaseParser.FOLLOWING, 0); }
		public UnboundedFrameContext(FrameBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterUnboundedFrame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitUnboundedFrame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitUnboundedFrame(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CurrentRowBoundContext extends FrameBoundContext {
		public TerminalNode CURRENT() { return getToken(SqlBaseParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SqlBaseParser.ROW, 0); }
		public CurrentRowBoundContext(FrameBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterCurrentRowBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitCurrentRowBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitCurrentRowBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameBoundContext frameBound() throws RecognitionException {
		FrameBoundContext _localctx = new FrameBoundContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_frameBound);
		int _la;
		try {
			setState(1021);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				_localctx = new UnboundedFrameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1012);
				match(UNBOUNDED);
				setState(1013);
				((UnboundedFrameContext)_localctx).boundType = match(PRECEDING);
				}
				break;
			case 2:
				_localctx = new UnboundedFrameContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1014);
				match(UNBOUNDED);
				setState(1015);
				((UnboundedFrameContext)_localctx).boundType = match(FOLLOWING);
				}
				break;
			case 3:
				_localctx = new CurrentRowBoundContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1016);
				match(CURRENT);
				setState(1017);
				match(ROW);
				}
				break;
			case 4:
				_localctx = new BoundedFrameContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1018);
				expression();
				setState(1019);
				((BoundedFrameContext)_localctx).boundType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PRECEDING || _la==FOLLOWING) ) {
					((BoundedFrameContext)_localctx).boundType = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplainOptionContext extends ParserRuleContext {
		public ExplainOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explainOption; }
	 
		public ExplainOptionContext() { }
		public void copyFrom(ExplainOptionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExplainFormatContext extends ExplainOptionContext {
		public Token value;
		public TerminalNode FORMAT() { return getToken(SqlBaseParser.FORMAT, 0); }
		public TerminalNode TEXT() { return getToken(SqlBaseParser.TEXT, 0); }
		public TerminalNode GRAPHVIZ() { return getToken(SqlBaseParser.GRAPHVIZ, 0); }
		public TerminalNode JSON() { return getToken(SqlBaseParser.JSON, 0); }
		public ExplainFormatContext(ExplainOptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterExplainFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitExplainFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitExplainFormat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExplainTypeContext extends ExplainOptionContext {
		public Token value;
		public TerminalNode TYPE() { return getToken(SqlBaseParser.TYPE, 0); }
		public TerminalNode LOGICAL() { return getToken(SqlBaseParser.LOGICAL, 0); }
		public TerminalNode DISTRIBUTED() { return getToken(SqlBaseParser.DISTRIBUTED, 0); }
		public ExplainTypeContext(ExplainOptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterExplainType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitExplainType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitExplainType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplainOptionContext explainOption() throws RecognitionException {
		ExplainOptionContext _localctx = new ExplainOptionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_explainOption);
		int _la;
		try {
			setState(1027);
			switch (_input.LA(1)) {
			case FORMAT:
				_localctx = new ExplainFormatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1023);
				match(FORMAT);
				setState(1024);
				((ExplainFormatContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (TEXT - 103)) | (1L << (GRAPHVIZ - 103)) | (1L << (JSON - 103)))) != 0)) ) {
					((ExplainFormatContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case TYPE:
				_localctx = new ExplainTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1025);
				match(TYPE);
				setState(1026);
				((ExplainTypeContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==LOGICAL || _la==DISTRIBUTED) ) {
					((ExplainTypeContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1029);
			identifier();
			setState(1034);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1030);
					match(T__3);
					setState(1031);
					identifier();
					}
					} 
				}
				setState(1036);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	 
		public IdentifierContext() { }
		public void copyFrom(IdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BackQuotedIdentifierContext extends IdentifierContext {
		public TerminalNode BACKQUOTED_IDENTIFIER() { return getToken(SqlBaseParser.BACKQUOTED_IDENTIFIER, 0); }
		public BackQuotedIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBackQuotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBackQuotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBackQuotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuotedIdentifierAlternativeContext extends IdentifierContext {
		public QuotedIdentifierContext quotedIdentifier() {
			return getRuleContext(QuotedIdentifierContext.class,0);
		}
		public QuotedIdentifierAlternativeContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQuotedIdentifierAlternative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQuotedIdentifierAlternative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQuotedIdentifierAlternative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DigitIdentifierContext extends IdentifierContext {
		public TerminalNode DIGIT_IDENTIFIER() { return getToken(SqlBaseParser.DIGIT_IDENTIFIER, 0); }
		public DigitIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDigitIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDigitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDigitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnquotedIdentifierContext extends IdentifierContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlBaseParser.IDENTIFIER, 0); }
		public NonReservedContext nonReserved() {
			return getRuleContext(NonReservedContext.class,0);
		}
		public UnquotedIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterUnquotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitUnquotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitUnquotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_identifier);
		try {
			setState(1042);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1037);
				match(IDENTIFIER);
				}
				break;
			case QUOTED_IDENTIFIER:
				_localctx = new QuotedIdentifierAlternativeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1038);
				quotedIdentifier();
				}
				break;
			case APPROXIMATE:
			case AT:
			case CONFIDENCE:
			case POSITION:
			case DATE:
			case TIME:
			case TIMESTAMP:
			case INTERVAL:
			case YEAR:
			case MONTH:
			case DAY:
			case HOUR:
			case MINUTE:
			case SECOND:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case ROW:
			case VIEW:
			case REPLACE:
			case EXPLAIN:
			case FORMAT:
			case TYPE:
			case TEXT:
			case GRAPHVIZ:
			case JSON:
			case LOGICAL:
			case DISTRIBUTED:
			case SHOW:
			case TABLES:
			case SCHEMAS:
			case CATALOGS:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case TO:
			case SYSTEM:
			case BERNOULLI:
			case POISSONIZED:
			case TABLESAMPLE:
			case RESCALED:
			case MAP:
			case SET:
			case RESET:
			case SESSION:
			case NFD:
			case NFC:
			case NFKD:
			case NFKC:
			case IF:
			case NULLIF:
			case COALESCE:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1039);
				nonReserved();
				}
				break;
			case BACKQUOTED_IDENTIFIER:
				_localctx = new BackQuotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1040);
				match(BACKQUOTED_IDENTIFIER);
				}
				break;
			case DIGIT_IDENTIFIER:
				_localctx = new DigitIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1041);
				match(DIGIT_IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuotedIdentifierContext extends ParserRuleContext {
		public TerminalNode QUOTED_IDENTIFIER() { return getToken(SqlBaseParser.QUOTED_IDENTIFIER, 0); }
		public QuotedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQuotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQuotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQuotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuotedIdentifierContext quotedIdentifier() throws RecognitionException {
		QuotedIdentifierContext _localctx = new QuotedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_quotedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1044);
			match(QUOTED_IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecimalLiteralContext extends NumberContext {
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlBaseParser.DECIMAL_VALUE, 0); }
		public DecimalLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDecimalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralContext extends NumberContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public IntegerLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_number);
		try {
			setState(1048);
			switch (_input.LA(1)) {
			case DECIMAL_VALUE:
				_localctx = new DecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1046);
				match(DECIMAL_VALUE);
				}
				break;
			case INTEGER_VALUE:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1047);
				match(INTEGER_VALUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonReservedContext extends ParserRuleContext {
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode TABLES() { return getToken(SqlBaseParser.TABLES, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlBaseParser.COLUMNS, 0); }
		public TerminalNode COLUMN() { return getToken(SqlBaseParser.COLUMN, 0); }
		public TerminalNode PARTITIONS() { return getToken(SqlBaseParser.PARTITIONS, 0); }
		public TerminalNode FUNCTIONS() { return getToken(SqlBaseParser.FUNCTIONS, 0); }
		public TerminalNode SCHEMAS() { return getToken(SqlBaseParser.SCHEMAS, 0); }
		public TerminalNode CATALOGS() { return getToken(SqlBaseParser.CATALOGS, 0); }
		public TerminalNode SESSION() { return getToken(SqlBaseParser.SESSION, 0); }
		public TerminalNode OVER() { return getToken(SqlBaseParser.OVER, 0); }
		public TerminalNode PARTITION() { return getToken(SqlBaseParser.PARTITION, 0); }
		public TerminalNode RANGE() { return getToken(SqlBaseParser.RANGE, 0); }
		public TerminalNode ROWS() { return getToken(SqlBaseParser.ROWS, 0); }
		public TerminalNode PRECEDING() { return getToken(SqlBaseParser.PRECEDING, 0); }
		public TerminalNode FOLLOWING() { return getToken(SqlBaseParser.FOLLOWING, 0); }
		public TerminalNode CURRENT() { return getToken(SqlBaseParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SqlBaseParser.ROW, 0); }
		public TerminalNode MAP() { return getToken(SqlBaseParser.MAP, 0); }
		public TerminalNode DATE() { return getToken(SqlBaseParser.DATE, 0); }
		public TerminalNode TIME() { return getToken(SqlBaseParser.TIME, 0); }
		public TerminalNode TIMESTAMP() { return getToken(SqlBaseParser.TIMESTAMP, 0); }
		public TerminalNode INTERVAL() { return getToken(SqlBaseParser.INTERVAL, 0); }
		public TerminalNode YEAR() { return getToken(SqlBaseParser.YEAR, 0); }
		public TerminalNode MONTH() { return getToken(SqlBaseParser.MONTH, 0); }
		public TerminalNode DAY() { return getToken(SqlBaseParser.DAY, 0); }
		public TerminalNode HOUR() { return getToken(SqlBaseParser.HOUR, 0); }
		public TerminalNode MINUTE() { return getToken(SqlBaseParser.MINUTE, 0); }
		public TerminalNode SECOND() { return getToken(SqlBaseParser.SECOND, 0); }
		public TerminalNode EXPLAIN() { return getToken(SqlBaseParser.EXPLAIN, 0); }
		public TerminalNode FORMAT() { return getToken(SqlBaseParser.FORMAT, 0); }
		public TerminalNode TYPE() { return getToken(SqlBaseParser.TYPE, 0); }
		public TerminalNode TEXT() { return getToken(SqlBaseParser.TEXT, 0); }
		public TerminalNode GRAPHVIZ() { return getToken(SqlBaseParser.GRAPHVIZ, 0); }
		public TerminalNode LOGICAL() { return getToken(SqlBaseParser.LOGICAL, 0); }
		public TerminalNode DISTRIBUTED() { return getToken(SqlBaseParser.DISTRIBUTED, 0); }
		public TerminalNode TABLESAMPLE() { return getToken(SqlBaseParser.TABLESAMPLE, 0); }
		public TerminalNode SYSTEM() { return getToken(SqlBaseParser.SYSTEM, 0); }
		public TerminalNode BERNOULLI() { return getToken(SqlBaseParser.BERNOULLI, 0); }
		public TerminalNode POISSONIZED() { return getToken(SqlBaseParser.POISSONIZED, 0); }
		public TerminalNode USE() { return getToken(SqlBaseParser.USE, 0); }
		public TerminalNode JSON() { return getToken(SqlBaseParser.JSON, 0); }
		public TerminalNode TO() { return getToken(SqlBaseParser.TO, 0); }
		public TerminalNode RESCALED() { return getToken(SqlBaseParser.RESCALED, 0); }
		public TerminalNode APPROXIMATE() { return getToken(SqlBaseParser.APPROXIMATE, 0); }
		public TerminalNode AT() { return getToken(SqlBaseParser.AT, 0); }
		public TerminalNode CONFIDENCE() { return getToken(SqlBaseParser.CONFIDENCE, 0); }
		public TerminalNode SET() { return getToken(SqlBaseParser.SET, 0); }
		public TerminalNode RESET() { return getToken(SqlBaseParser.RESET, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public TerminalNode REPLACE() { return getToken(SqlBaseParser.REPLACE, 0); }
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode NULLIF() { return getToken(SqlBaseParser.NULLIF, 0); }
		public TerminalNode COALESCE() { return getToken(SqlBaseParser.COALESCE, 0); }
		public NormalFormContext normalForm() {
			return getRuleContext(NormalFormContext.class,0);
		}
		public TerminalNode POSITION() { return getToken(SqlBaseParser.POSITION, 0); }
		public NonReservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonReserved; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNonReserved(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNonReserved(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNonReserved(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonReservedContext nonReserved() throws RecognitionException {
		NonReservedContext _localctx = new NonReservedContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_nonReserved);
		try {
			setState(1105);
			switch (_input.LA(1)) {
			case SHOW:
				enterOuterAlt(_localctx, 1);
				{
				setState(1050);
				match(SHOW);
				}
				break;
			case TABLES:
				enterOuterAlt(_localctx, 2);
				{
				setState(1051);
				match(TABLES);
				}
				break;
			case COLUMNS:
				enterOuterAlt(_localctx, 3);
				{
				setState(1052);
				match(COLUMNS);
				}
				break;
			case COLUMN:
				enterOuterAlt(_localctx, 4);
				{
				setState(1053);
				match(COLUMN);
				}
				break;
			case PARTITIONS:
				enterOuterAlt(_localctx, 5);
				{
				setState(1054);
				match(PARTITIONS);
				}
				break;
			case FUNCTIONS:
				enterOuterAlt(_localctx, 6);
				{
				setState(1055);
				match(FUNCTIONS);
				}
				break;
			case SCHEMAS:
				enterOuterAlt(_localctx, 7);
				{
				setState(1056);
				match(SCHEMAS);
				}
				break;
			case CATALOGS:
				enterOuterAlt(_localctx, 8);
				{
				setState(1057);
				match(CATALOGS);
				}
				break;
			case SESSION:
				enterOuterAlt(_localctx, 9);
				{
				setState(1058);
				match(SESSION);
				}
				break;
			case OVER:
				enterOuterAlt(_localctx, 10);
				{
				setState(1059);
				match(OVER);
				}
				break;
			case PARTITION:
				enterOuterAlt(_localctx, 11);
				{
				setState(1060);
				match(PARTITION);
				}
				break;
			case RANGE:
				enterOuterAlt(_localctx, 12);
				{
				setState(1061);
				match(RANGE);
				}
				break;
			case ROWS:
				enterOuterAlt(_localctx, 13);
				{
				setState(1062);
				match(ROWS);
				}
				break;
			case PRECEDING:
				enterOuterAlt(_localctx, 14);
				{
				setState(1063);
				match(PRECEDING);
				}
				break;
			case FOLLOWING:
				enterOuterAlt(_localctx, 15);
				{
				setState(1064);
				match(FOLLOWING);
				}
				break;
			case CURRENT:
				enterOuterAlt(_localctx, 16);
				{
				setState(1065);
				match(CURRENT);
				}
				break;
			case ROW:
				enterOuterAlt(_localctx, 17);
				{
				setState(1066);
				match(ROW);
				}
				break;
			case MAP:
				enterOuterAlt(_localctx, 18);
				{
				setState(1067);
				match(MAP);
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 19);
				{
				setState(1068);
				match(DATE);
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 20);
				{
				setState(1069);
				match(TIME);
				}
				break;
			case TIMESTAMP:
				enterOuterAlt(_localctx, 21);
				{
				setState(1070);
				match(TIMESTAMP);
				}
				break;
			case INTERVAL:
				enterOuterAlt(_localctx, 22);
				{
				setState(1071);
				match(INTERVAL);
				}
				break;
			case YEAR:
				enterOuterAlt(_localctx, 23);
				{
				setState(1072);
				match(YEAR);
				}
				break;
			case MONTH:
				enterOuterAlt(_localctx, 24);
				{
				setState(1073);
				match(MONTH);
				}
				break;
			case DAY:
				enterOuterAlt(_localctx, 25);
				{
				setState(1074);
				match(DAY);
				}
				break;
			case HOUR:
				enterOuterAlt(_localctx, 26);
				{
				setState(1075);
				match(HOUR);
				}
				break;
			case MINUTE:
				enterOuterAlt(_localctx, 27);
				{
				setState(1076);
				match(MINUTE);
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 28);
				{
				setState(1077);
				match(SECOND);
				}
				break;
			case EXPLAIN:
				enterOuterAlt(_localctx, 29);
				{
				setState(1078);
				match(EXPLAIN);
				}
				break;
			case FORMAT:
				enterOuterAlt(_localctx, 30);
				{
				setState(1079);
				match(FORMAT);
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 31);
				{
				setState(1080);
				match(TYPE);
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 32);
				{
				setState(1081);
				match(TEXT);
				}
				break;
			case GRAPHVIZ:
				enterOuterAlt(_localctx, 33);
				{
				setState(1082);
				match(GRAPHVIZ);
				}
				break;
			case LOGICAL:
				enterOuterAlt(_localctx, 34);
				{
				setState(1083);
				match(LOGICAL);
				}
				break;
			case DISTRIBUTED:
				enterOuterAlt(_localctx, 35);
				{
				setState(1084);
				match(DISTRIBUTED);
				}
				break;
			case TABLESAMPLE:
				enterOuterAlt(_localctx, 36);
				{
				setState(1085);
				match(TABLESAMPLE);
				}
				break;
			case SYSTEM:
				enterOuterAlt(_localctx, 37);
				{
				setState(1086);
				match(SYSTEM);
				}
				break;
			case BERNOULLI:
				enterOuterAlt(_localctx, 38);
				{
				setState(1087);
				match(BERNOULLI);
				}
				break;
			case POISSONIZED:
				enterOuterAlt(_localctx, 39);
				{
				setState(1088);
				match(POISSONIZED);
				}
				break;
			case USE:
				enterOuterAlt(_localctx, 40);
				{
				setState(1089);
				match(USE);
				}
				break;
			case JSON:
				enterOuterAlt(_localctx, 41);
				{
				setState(1090);
				match(JSON);
				}
				break;
			case TO:
				enterOuterAlt(_localctx, 42);
				{
				setState(1091);
				match(TO);
				}
				break;
			case RESCALED:
				enterOuterAlt(_localctx, 43);
				{
				setState(1092);
				match(RESCALED);
				}
				break;
			case APPROXIMATE:
				enterOuterAlt(_localctx, 44);
				{
				setState(1093);
				match(APPROXIMATE);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 45);
				{
				setState(1094);
				match(AT);
				}
				break;
			case CONFIDENCE:
				enterOuterAlt(_localctx, 46);
				{
				setState(1095);
				match(CONFIDENCE);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 47);
				{
				setState(1096);
				match(SET);
				}
				break;
			case RESET:
				enterOuterAlt(_localctx, 48);
				{
				setState(1097);
				match(RESET);
				}
				break;
			case VIEW:
				enterOuterAlt(_localctx, 49);
				{
				setState(1098);
				match(VIEW);
				}
				break;
			case REPLACE:
				enterOuterAlt(_localctx, 50);
				{
				setState(1099);
				match(REPLACE);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 51);
				{
				setState(1100);
				match(IF);
				}
				break;
			case NULLIF:
				enterOuterAlt(_localctx, 52);
				{
				setState(1101);
				match(NULLIF);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 53);
				{
				setState(1102);
				match(COALESCE);
				}
				break;
			case NFD:
			case NFC:
			case NFKD:
			case NFKC:
				enterOuterAlt(_localctx, 54);
				{
				setState(1103);
				normalForm();
				}
				break;
			case POSITION:
				enterOuterAlt(_localctx, 55);
				{
				setState(1104);
				match(POSITION);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormalFormContext extends ParserRuleContext {
		public TerminalNode NFD() { return getToken(SqlBaseParser.NFD, 0); }
		public TerminalNode NFC() { return getToken(SqlBaseParser.NFC, 0); }
		public TerminalNode NFKD() { return getToken(SqlBaseParser.NFKD, 0); }
		public TerminalNode NFKC() { return getToken(SqlBaseParser.NFKC, 0); }
		public NormalFormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalForm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNormalForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNormalForm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNormalForm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalFormContext normalForm() throws RecognitionException {
		NormalFormContext _localctx = new NormalFormContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_normalForm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1107);
			_la = _input.LA(1);
			if ( !(((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (NFD - 140)) | (1L << (NFC - 140)) | (1L << (NFKD - 140)) | (1L << (NFKC - 140)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return queryTerm_sempred((QueryTermContext)_localctx, predIndex);
		case 21:
			return relation_sempred((RelationContext)_localctx, predIndex);
		case 30:
			return booleanExpression_sempred((BooleanExpressionContext)_localctx, predIndex);
		case 33:
			return valueExpression_sempred((ValueExpressionContext)_localctx, predIndex);
		case 34:
			return primaryExpression_sempred((PrimaryExpressionContext)_localctx, predIndex);
		case 40:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean queryTerm_sempred(QueryTermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relation_sempred(RelationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean booleanExpression_sempred(BooleanExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean valueExpression_sempred(ValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean primaryExpression_sempred(PrimaryExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 12);
		case 10:
			return precpred(_ctx, 11);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00ae\u0458\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4y\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0083\n\4\3\4\3\4\3\4"+
		"\3\4\3\4\7\4\u008a\n\4\f\4\16\4\u008d\13\4\3\4\3\4\5\4\u0091\n\4\3\4\5"+
		"\4\u0094\n\4\3\4\3\4\5\4\u0098\n\4\3\4\3\4\3\4\3\4\5\4\u009e\n\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4\u00a5\n\4\3\4\3\4\5\4\u00a9\n\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4\u00b0\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u00c7\n\4\f\4\16\4\u00ca\13\4\3\4\3\4"+
		"\5\4\u00ce\n\4\3\4\3\4\3\4\3\4\3\4\5\4\u00d5\n\4\3\4\3\4\5\4\u00d9\n\4"+
		"\3\4\3\4\3\4\3\4\5\4\u00df\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00f8\n\4\3\5"+
		"\3\5\3\5\3\5\7\5\u00fe\n\5\f\5\16\5\u0101\13\5\3\6\3\6\3\6\3\6\7\6\u0107"+
		"\n\6\f\6\16\6\u010a\13\6\3\6\3\6\3\7\5\7\u010f\n\7\3\7\3\7\3\b\3\b\5\b"+
		"\u0115\n\b\3\b\3\b\3\b\7\b\u011a\n\b\f\b\16\b\u011d\13\b\3\t\3\t\3\t\7"+
		"\t\u0122\n\t\f\t\16\t\u0125\13\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u012f\n\13\3\13\3\13\3\13\3\13\5\13\u0135\n\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\7\f\u013d\n\f\f\f\16\f\u0140\13\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u0148"+
		"\n\r\f\r\16\r\u014b\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\7\17\u0159\n\17\f\17\16\17\u015c\13\17\5\17\u015e\n\17\3"+
		"\17\3\17\5\17\u0162\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u0169\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u0171\n\20\3\20\3\20\3\20\3\20\5\20\u0177"+
		"\n\20\3\20\7\20\u017a\n\20\f\20\16\20\u017d\13\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u0186\n\21\f\21\16\21\u0189\13\21\3\21\3\21\3\21"+
		"\3\21\5\21\u018f\n\21\3\22\3\22\5\22\u0193\n\22\3\22\3\22\5\22\u0197\n"+
		"\22\3\23\3\23\5\23\u019b\n\23\3\23\3\23\3\23\7\23\u01a0\n\23\f\23\16\23"+
		"\u01a3\13\23\3\23\3\23\3\23\3\23\7\23\u01a9\n\23\f\23\16\23\u01ac\13\23"+
		"\5\23\u01ae\n\23\3\23\3\23\5\23\u01b2\n\23\3\23\3\23\3\23\3\23\3\23\7"+
		"\23\u01b9\n\23\f\23\16\23\u01bc\13\23\5\23\u01be\n\23\3\23\3\23\5\23\u01c2"+
		"\n\23\3\24\3\24\5\24\u01c6\n\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\5\26\u01d1\n\26\3\26\5\26\u01d4\n\26\3\26\3\26\3\26\3\26\3\26\5"+
		"\26\u01db\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u01ee\n\27\7\27\u01f0\n\27\f\27\16"+
		"\27\u01f3\13\27\3\30\5\30\u01f6\n\30\3\30\3\30\5\30\u01fa\n\30\3\30\3"+
		"\30\5\30\u01fe\n\30\3\30\3\30\5\30\u0202\n\30\5\30\u0204\n\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\7\31\u020d\n\31\f\31\16\31\u0210\13\31\3\31"+
		"\3\31\5\31\u0214\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u021d\n"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0225\n\32\f\32\16\32\u0228\13"+
		"\32\3\32\3\32\5\32\u022c\n\32\5\32\u022e\n\32\3\33\3\33\3\34\3\34\5\34"+
		"\u0234\n\34\3\34\3\34\5\34\u0238\n\34\5\34\u023a\n\34\3\35\3\35\3\35\3"+
		"\35\7\35\u0240\n\35\f\35\16\35\u0243\13\35\3\35\3\35\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0251\n\36\f\36\16\36\u0254\13"+
		"\36\3\36\3\36\3\36\5\36\u0259\n\36\3\36\3\36\3\36\3\36\5\36\u025f\n\36"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u026c\n \3 \3 \3 \3 \3 \3 \7"+
		" \u0274\n \f \16 \u0277\13 \3!\3!\5!\u027b\n!\3\"\3\"\3\"\3\"\5\"\u0281"+
		"\n\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0289\n\"\3\"\3\"\3\"\3\"\3\"\7\"\u0290"+
		"\n\"\f\"\16\"\u0293\13\"\3\"\3\"\3\"\5\"\u0298\n\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\5\"\u02a0\n\"\3\"\3\"\3\"\3\"\5\"\u02a6\n\"\3\"\3\"\5\"\u02aa\n\""+
		"\3\"\3\"\3\"\5\"\u02af\n\"\3\"\3\"\3\"\5\"\u02b4\n\"\3#\3#\3#\3#\5#\u02ba"+
		"\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u02c8\n#\f#\16#\u02cb\13#\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\6$\u02da\n$\r$\16$\u02db\3$\3$\3"+
		"$\3$\3$\3$\3$\7$\u02e5\n$\f$\16$\u02e8\13$\3$\3$\3$\3$\3$\3$\3$\3$\5$"+
		"\u02f2\n$\3$\3$\3$\5$\u02f7\n$\3$\3$\3$\7$\u02fc\n$\f$\16$\u02ff\13$\5"+
		"$\u0301\n$\3$\3$\5$\u0305\n$\3$\3$\3$\3$\3$\3$\3$\6$\u030e\n$\r$\16$\u030f"+
		"\3$\3$\5$\u0314\n$\3$\3$\3$\3$\6$\u031a\n$\r$\16$\u031b\3$\3$\5$\u0320"+
		"\n$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\7$"+
		"\u0337\n$\f$\16$\u033a\13$\5$\u033c\n$\3$\3$\3$\3$\3$\3$\5$\u0344\n$\3"+
		"$\3$\3$\3$\5$\u034a\n$\3$\3$\3$\3$\5$\u0350\n$\3$\3$\3$\3$\5$\u0356\n"+
		"$\3$\3$\3$\3$\3$\3$\3$\5$\u035f\n$\3$\3$\3$\3$\3$\3$\3$\5$\u0368\n$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u037e\n"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\7$\u0388\n$\f$\16$\u038b\13$\3%\3%\3%\3%\3%"+
		"\3%\5%\u0393\n%\3&\3&\3\'\3\'\3(\3(\5(\u039b\n(\3(\3(\3(\3(\5(\u03a1\n"+
		"(\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u03b3\n*\3*\3*\7"+
		"*\u03b7\n*\f*\16*\u03ba\13*\3+\3+\3+\5+\u03bf\n+\3,\3,\3,\3,\3,\3-\3-"+
		"\3-\3-\3-\3-\3-\7-\u03cd\n-\f-\16-\u03d0\13-\5-\u03d2\n-\3-\3-\3-\3-\3"+
		"-\7-\u03d9\n-\f-\16-\u03dc\13-\5-\u03de\n-\3-\5-\u03e1\n-\3-\3-\3.\3."+
		"\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u03f5\n.\3/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\5/\u0400\n/\3\60\3\60\3\60\3\60\5\60\u0406\n\60\3\61\3\61"+
		"\3\61\7\61\u040b\n\61\f\61\16\61\u040e\13\61\3\62\3\62\3\62\3\62\3\62"+
		"\5\62\u0415\n\62\3\63\3\63\3\64\3\64\5\64\u041b\n\64\3\65\3\65\3\65\3"+
		"\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3"+
		"\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3"+
		"\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3"+
		"\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u0454\n\65\3\66"+
		"\3\66\3\66\2\b\36,>DFR\67\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhj\2\22\4\2\n\n\33\33\4\2\f\f"+
		"\u00a2\u00a2\3\2z{\3\2()\3\2%&\4\2\f\f\17\17\3\2~\u0080\3\2\u009b\u009c"+
		"\3\2\u009d\u009f\3\2\u0095\u009a\3\2\"#\3\2\61\66\3\2RS\3\2ik\3\2lm\3"+
		"\2\u008e\u0091\u0518\2l\3\2\2\2\4o\3\2\2\2\6\u00f7\3\2\2\2\b\u00f9\3\2"+
		"\2\2\n\u0102\3\2\2\2\f\u010e\3\2\2\2\16\u0112\3\2\2\2\20\u011e\3\2\2\2"+
		"\22\u0126\3\2\2\2\24\u0128\3\2\2\2\26\u0136\3\2\2\2\30\u0143\3\2\2\2\32"+
		"\u014e\3\2\2\2\34\u0152\3\2\2\2\36\u016a\3\2\2\2 \u018e\3\2\2\2\"\u0190"+
		"\3\2\2\2$\u0198\3\2\2\2&\u01c3\3\2\2\2(\u01cc\3\2\2\2*\u01da\3\2\2\2,"+
		"\u01dc\3\2\2\2.\u0203\3\2\2\2\60\u0213\3\2\2\2\62\u0215\3\2\2\2\64\u022f"+
		"\3\2\2\2\66\u0231\3\2\2\28\u023b\3\2\2\2:\u025e\3\2\2\2<\u0260\3\2\2\2"+
		">\u026b\3\2\2\2@\u0278\3\2\2\2B\u02b3\3\2\2\2D\u02b9\3\2\2\2F\u037d\3"+
		"\2\2\2H\u0392\3\2\2\2J\u0394\3\2\2\2L\u0396\3\2\2\2N\u0398\3\2\2\2P\u03a2"+
		"\3\2\2\2R\u03b2\3\2\2\2T\u03be\3\2\2\2V\u03c0\3\2\2\2X\u03c5\3\2\2\2Z"+
		"\u03f4\3\2\2\2\\\u03ff\3\2\2\2^\u0405\3\2\2\2`\u0407\3\2\2\2b\u0414\3"+
		"\2\2\2d\u0416\3\2\2\2f\u041a\3\2\2\2h\u0453\3\2\2\2j\u0455\3\2\2\2lm\5"+
		"\6\4\2mn\7\2\2\3n\3\3\2\2\2op\5<\37\2pq\7\2\2\3q\5\3\2\2\2r\u00f8\5\f"+
		"\7\2st\7Y\2\2tu\7^\2\2ux\5`\61\2vw\7V\2\2wy\5\30\r\2xv\3\2\2\2xy\3\2\2"+
		"\2yz\3\2\2\2z{\7\13\2\2{|\5\f\7\2|\u00f8\3\2\2\2}~\7Y\2\2~\u0082\7^\2"+
		"\2\177\u0080\7\u0092\2\2\u0080\u0081\7\34\2\2\u0081\u0083\7\35\2\2\u0082"+
		"\177\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\5`\61"+
		"\2\u0085\u0086\7\3\2\2\u0086\u008b\5\20\t\2\u0087\u0088\7\4\2\2\u0088"+
		"\u008a\5\20\t\2\u0089\u0087\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3"+
		"\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e"+
		"\u0090\7\5\2\2\u008f\u0091\5\24\13\2\u0090\u008f\3\2\2\2\u0090\u0091\3"+
		"\2\2\2\u0091\u0093\3\2\2\2\u0092\u0094\5\26\f\2\u0093\u0092\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0096\7V\2\2\u0096\u0098\5\30"+
		"\r\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u00f8\3\2\2\2\u0099"+
		"\u009a\7y\2\2\u009a\u009d\7^\2\2\u009b\u009c\7\u0092\2\2\u009c\u009e\7"+
		"\35\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00f8\5`\61\2\u00a0\u00a1\7a\2\2\u00a1\u00a2\7c\2\2\u00a2\u00a4\5`\61"+
		"\2\u00a3\u00a5\58\35\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a8"+
		"\3\2\2\2\u00a6\u00a9\5\f\7\2\u00a7\u00a9\5\b\5\2\u00a8\u00a6\3\2\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00f8\3\2\2\2\u00aa\u00ab\7b\2\2\u00ab\u00ac\7\n"+
		"\2\2\u00ac\u00af\5`\61\2\u00ad\u00ae\7\20\2\2\u00ae\u00b0\5> \2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00f8\3\2\2\2\u00b1\u00b2\7\u0084"+
		"\2\2\u00b2\u00b3\7^\2\2\u00b3\u00b4\5`\61\2\u00b4\u00b5\7\u0085\2\2\u00b5"+
		"\u00b6\7}\2\2\u00b6\u00b7\5`\61\2\u00b7\u00f8\3\2\2\2\u00b8\u00b9\7\u0084"+
		"\2\2\u00b9\u00ba\7^\2\2\u00ba\u00bb\5`\61\2\u00bb\u00bc\7\u0085\2\2\u00bc"+
		"\u00bd\7u\2\2\u00bd\u00be\5b\62\2\u00be\u00bf\7}\2\2\u00bf\u00c0\5b\62"+
		"\2\u00c0\u00f8\3\2\2\2\u00c1\u00cd\7f\2\2\u00c2\u00c3\7\3\2\2\u00c3\u00c8"+
		"\5^\60\2\u00c4\u00c5\7\4\2\2\u00c5\u00c7\5^\60\2\u00c6\u00c4\3\2\2\2\u00c7"+
		"\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\7\5\2\2\u00cc\u00ce\3\2\2\2\u00cd"+
		"\u00c2\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00f8\5\6"+
		"\4\2\u00d0\u00d1\7p\2\2\u00d1\u00d4\7q\2\2\u00d2\u00d3\t\2\2\2\u00d3\u00d5"+
		"\5`\61\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6"+
		"\u00d7\7\37\2\2\u00d7\u00d9\7\u00a1\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00f8\3\2\2\2\u00da\u00db\7p\2\2\u00db\u00de\7r\2\2\u00dc"+
		"\u00dd\t\2\2\2\u00dd\u00df\5b\62\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00f8\3\2\2\2\u00e0\u00e1\7p\2\2\u00e1\u00f8\7s\2\2\u00e2\u00e3"+
		"\7p\2\2\u00e3\u00e4\7t\2\2\u00e4\u00e5\t\2\2\2\u00e5\u00f8\5`\61\2\u00e6"+
		"\u00e7\7e\2\2\u00e7\u00f8\5`\61\2\u00e8\u00e9\7)\2\2\u00e9\u00f8\5`\61"+
		"\2\u00ea\u00eb\7p\2\2\u00eb\u00f8\7x\2\2\u00ec\u00ed\7p\2\2\u00ed\u00f8"+
		"\7\u008c\2\2\u00ee\u00ef\7\u008a\2\2\u00ef\u00f0\7\u008c\2\2\u00f0\u00f1"+
		"\5`\61\2\u00f1\u00f2\7\u0095\2\2\u00f2\u00f3\5<\37\2\u00f3\u00f8\3\2\2"+
		"\2\u00f4\u00f5\7\u008b\2\2\u00f5\u00f6\7\u008c\2\2\u00f6\u00f8\5`\61\2"+
		"\u00f7r\3\2\2\2\u00f7s\3\2\2\2\u00f7}\3\2\2\2\u00f7\u0099\3\2\2\2\u00f7"+
		"\u00a0\3\2\2\2\u00f7\u00aa\3\2\2\2\u00f7\u00b1\3\2\2\2\u00f7\u00b8\3\2"+
		"\2\2\u00f7\u00c1\3\2\2\2\u00f7\u00d0\3\2\2\2\u00f7\u00da\3\2\2\2\u00f7"+
		"\u00e0\3\2\2\2\u00f7\u00e2\3\2\2\2\u00f7\u00e6\3\2\2\2\u00f7\u00e8\3\2"+
		"\2\2\u00f7\u00ea\3\2\2\2\u00f7\u00ec\3\2\2\2\u00f7\u00ee\3\2\2\2\u00f7"+
		"\u00f4\3\2\2\2\u00f8\7\3\2\2\2\u00f9\u00fa\7X\2\2\u00fa\u00ff\5\n\6\2"+
		"\u00fb\u00fc\7\4\2\2\u00fc\u00fe\5\n\6\2\u00fd\u00fb\3\2\2\2\u00fe\u0101"+
		"\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\t\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0102\u0103\7\3\2\2\u0103\u0108\5<\37\2\u0104\u0105\7\4"+
		"\2\2\u0105\u0107\5<\37\2\u0106\u0104\3\2\2\2\u0107\u010a\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2"+
		"\2\2\u010b\u010c\7\5\2\2\u010c\13\3\2\2\2\u010d\u010f\5\16\b\2\u010e\u010d"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\5\34\17\2"+
		"\u0111\r\3\2\2\2\u0112\u0114\7V\2\2\u0113\u0115\7W\2\2\u0114\u0113\3\2"+
		"\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u011b\5&\24\2\u0117"+
		"\u0118\7\4\2\2\u0118\u011a\5&\24\2\u0119\u0117\3\2\2\2\u011a\u011d\3\2"+
		"\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\17\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011e\u011f\5b\62\2\u011f\u0123\5R*\2\u0120\u0122\5\22\n\2\u0121"+
		"\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\21\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\7Z\2\2\u0127\23"+
		"\3\2\2\2\u0128\u012e\7[\2\2\u0129\u012a\7\22\2\2\u012a\u012b\7\3\2\2\u012b"+
		"\u012c\5<\37\2\u012c\u012d\7\5\2\2\u012d\u012f\3\2\2\2\u012e\u0129\3\2"+
		"\2\2\u012e\u012f\3\2\2\2\u012f\u0134\3\2\2\2\u0130\u0131\7c\2\2\u0131"+
		"\u0132\5<\37\2\u0132\u0133\7\\\2\2\u0133\u0135\3\2\2\2\u0134\u0130\3\2"+
		"\2\2\u0134\u0135\3\2\2\2\u0135\25\3\2\2\2\u0136\u0137\7]\2\2\u0137\u0138"+
		"\7\22\2\2\u0138\u0139\7\3\2\2\u0139\u013e\5b\62\2\u013a\u013b\7\4\2\2"+
		"\u013b\u013d\5b\62\2\u013c\u013a\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c"+
		"\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0141\3\2\2\2\u0140\u013e\3\2\2\2\u0141"+
		"\u0142\7\5\2\2\u0142\27\3\2\2\2\u0143\u0144\7\3\2\2\u0144\u0149\5\32\16"+
		"\2\u0145\u0146\7\4\2\2\u0146\u0148\5\32\16\2\u0147\u0145\3\2\2\2\u0148"+
		"\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\3\2"+
		"\2\2\u014b\u0149\3\2\2\2\u014c\u014d\7\5\2\2\u014d\31\3\2\2\2\u014e\u014f"+
		"\5b\62\2\u014f\u0150\7\u0095\2\2\u0150\u0151\5<\37\2\u0151\33\3\2\2\2"+
		"\u0152\u015d\5\36\20\2\u0153\u0154\7\23\2\2\u0154\u0155\7\22\2\2\u0155"+
		"\u015a\5\"\22\2\u0156\u0157\7\4\2\2\u0157\u0159\5\"\22\2\u0158\u0156\3"+
		"\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b"+
		"\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u0153\3\2\2\2\u015d\u015e\3\2"+
		"\2\2\u015e\u0161\3\2\2\2\u015f\u0160\7\25\2\2\u0160\u0162\t\3\2\2\u0161"+
		"\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0168\3\2\2\2\u0163\u0164\7\26"+
		"\2\2\u0164\u0165\7\27\2\2\u0165\u0166\5f\64\2\u0166\u0167\7\30\2\2\u0167"+
		"\u0169\3\2\2\2\u0168\u0163\3\2\2\2\u0168\u0169\3\2\2\2\u0169\35\3\2\2"+
		"\2\u016a\u016b\b\20\1\2\u016b\u016c\5 \21\2\u016c\u017b\3\2\2\2\u016d"+
		"\u016e\f\4\2\2\u016e\u0170\7|\2\2\u016f\u0171\5(\25\2\u0170\u016f\3\2"+
		"\2\2\u0170\u0171\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u017a\5\36\20\5\u0173"+
		"\u0174\f\3\2\2\u0174\u0176\t\4\2\2\u0175\u0177\5(\25\2\u0176\u0175\3\2"+
		"\2\2\u0176\u0177\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017a\5\36\20\4\u0179"+
		"\u016d\3\2\2\2\u0179\u0173\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2"+
		"\2\2\u017b\u017c\3\2\2\2\u017c\37\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u018f"+
		"\5$\23\2\u017f\u0180\7^\2\2\u0180\u018f\5`\61\2\u0181\u0182\7X\2\2\u0182"+
		"\u0187\5<\37\2\u0183\u0184\7\4\2\2\u0184\u0186\5<\37\2\u0185\u0183\3\2"+
		"\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188"+
		"\u018f\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018b\7\3\2\2\u018b\u018c\5\34"+
		"\17\2\u018c\u018d\7\5\2\2\u018d\u018f\3\2\2\2\u018e\u017e\3\2\2\2\u018e"+
		"\u017f\3\2\2\2\u018e\u0181\3\2\2\2\u018e\u018a\3\2\2\2\u018f!\3\2\2\2"+
		"\u0190\u0192\5<\37\2\u0191\u0193\t\5\2\2\u0192\u0191\3\2\2\2\u0192\u0193"+
		"\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0195\7$\2\2\u0195\u0197\t\6\2\2\u0196"+
		"\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197#\3\2\2\2\u0198\u019a\7\t\2\2"+
		"\u0199\u019b\5(\25\2\u019a\u0199\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c"+
		"\3\2\2\2\u019c\u01a1\5*\26\2\u019d\u019e\7\4\2\2\u019e\u01a0\5*\26\2\u019f"+
		"\u019d\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a2\3\2"+
		"\2\2\u01a2\u01ad\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u01a5\7\n\2\2\u01a5"+
		"\u01aa\5,\27\2\u01a6\u01a7\7\4\2\2\u01a7\u01a9\5,\27\2\u01a8\u01a6\3\2"+
		"\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab"+
		"\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01a4\3\2\2\2\u01ad\u01ae\3\2"+
		"\2\2\u01ae\u01b1\3\2\2\2\u01af\u01b0\7\20\2\2\u01b0\u01b2\5> \2\u01b1"+
		"\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01bd\3\2\2\2\u01b3\u01b4\7\21"+
		"\2\2\u01b4\u01b5\7\22\2\2\u01b5\u01ba\5<\37\2\u01b6\u01b7\7\4\2\2\u01b7"+
		"\u01b9\5<\37\2\u01b8\u01b6\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2"+
		"\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01be\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd"+
		"\u01b3\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01c0\7\24"+
		"\2\2\u01c0\u01c2\5> \2\u01c1\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2%"+
		"\3\2\2\2\u01c3\u01c5\5b\62\2\u01c4\u01c6\58\35\2\u01c5\u01c4\3\2\2\2\u01c5"+
		"\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8\7\13\2\2\u01c8\u01c9\7"+
		"\3\2\2\u01c9\u01ca\5\f\7\2\u01ca\u01cb\7\5\2\2\u01cb\'\3\2\2\2\u01cc\u01cd"+
		"\t\7\2\2\u01cd)\3\2\2\2\u01ce\u01d3\5<\37\2\u01cf\u01d1\7\13\2\2\u01d0"+
		"\u01cf\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d4\5b"+
		"\62\2\u01d3\u01d0\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01db\3\2\2\2\u01d5"+
		"\u01d6\5`\61\2\u01d6\u01d7\7\6\2\2\u01d7\u01d8\7\u009d\2\2\u01d8\u01db"+
		"\3\2\2\2\u01d9\u01db\7\u009d\2\2\u01da\u01ce\3\2\2\2\u01da\u01d5\3\2\2"+
		"\2\u01da\u01d9\3\2\2\2\u01db+\3\2\2\2\u01dc\u01dd\b\27\1\2\u01dd\u01de"+
		"\5\62\32\2\u01de\u01f1\3\2\2\2\u01df\u01ed\f\4\2\2\u01e0\u01e1\7D\2\2"+
		"\u01e1\u01e2\7C\2\2\u01e2\u01ee\5\62\32\2\u01e3\u01e4\5.\30\2\u01e4\u01e5"+
		"\7C\2\2\u01e5\u01e6\5,\27\2\u01e6\u01e7\5\60\31\2\u01e7\u01ee\3\2\2\2"+
		"\u01e8\u01e9\7J\2\2\u01e9\u01ea\5.\30\2\u01ea\u01eb\7C\2\2\u01eb\u01ec"+
		"\5\62\32\2\u01ec\u01ee\3\2\2\2\u01ed\u01e0\3\2\2\2\u01ed\u01e3\3\2\2\2"+
		"\u01ed\u01e8\3\2\2\2\u01ee\u01f0\3\2\2\2\u01ef\u01df\3\2\2\2\u01f0\u01f3"+
		"\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2-\3\2\2\2\u01f3"+
		"\u01f1\3\2\2\2\u01f4\u01f6\7F\2\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2"+
		"\2\2\u01f6\u0204\3\2\2\2\u01f7\u01f9\7G\2\2\u01f8\u01fa\7E\2\2\u01f9\u01f8"+
		"\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u0204\3\2\2\2\u01fb\u01fd\7H\2\2\u01fc"+
		"\u01fe\7E\2\2\u01fd\u01fc\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0204\3\2"+
		"\2\2\u01ff\u0201\7I\2\2\u0200\u0202\7E\2\2\u0201\u0200\3\2\2\2\u0201\u0202"+
		"\3\2\2\2\u0202\u0204\3\2\2\2\u0203\u01f5\3\2\2\2\u0203\u01f7\3\2\2\2\u0203"+
		"\u01fb\3\2\2\2\u0203\u01ff\3\2\2\2\u0204/\3\2\2\2\u0205\u0206\7L\2\2\u0206"+
		"\u0214\5> \2\u0207\u0208\7K\2\2\u0208\u0209\7\3\2\2\u0209\u020e\5b\62"+
		"\2\u020a\u020b\7\4\2\2\u020b\u020d\5b\62\2\u020c\u020a\3\2\2\2\u020d\u0210"+
		"\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0211\3\2\2\2\u0210"+
		"\u020e\3\2\2\2\u0211\u0212\7\5\2\2\u0212\u0214\3\2\2\2\u0213\u0205\3\2"+
		"\2\2\u0213\u0207\3\2\2\2\u0214\61\3\2\2\2\u0215\u022d\5\66\34\2\u0216"+
		"\u0217\7\u0081\2\2\u0217\u0218\5\64\33\2\u0218\u0219\7\3\2\2\u0219\u021a"+
		"\5<\37\2\u021a\u021c\7\5\2\2\u021b\u021d\7\u0082\2\2\u021c\u021b\3\2\2"+
		"\2\u021c\u021d\3\2\2\2\u021d\u022b\3\2\2\2\u021e\u021f\7\u0083\2\2\u021f"+
		"\u0220\7L\2\2\u0220\u0221\7\3\2\2\u0221\u0226\5<\37\2\u0222\u0223\7\4"+
		"\2\2\u0223\u0225\5<\37\2\u0224\u0222\3\2\2\2\u0225\u0228\3\2\2\2\u0226"+
		"\u0224\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0229\3\2\2\2\u0228\u0226\3\2"+
		"\2\2\u0229\u022a\7\5\2\2\u022a\u022c\3\2\2\2\u022b\u021e\3\2\2\2\u022b"+
		"\u022c\3\2\2\2\u022c\u022e\3\2\2\2\u022d\u0216\3\2\2\2\u022d\u022e\3\2"+
		"\2\2\u022e\63\3\2\2\2\u022f\u0230\t\b\2\2\u0230\65\3\2\2\2\u0231\u0239"+
		"\5:\36\2\u0232\u0234\7\13\2\2\u0233\u0232\3\2\2\2\u0233\u0234\3\2\2\2"+
		"\u0234\u0235\3\2\2\2\u0235\u0237\5b\62\2\u0236\u0238\58\35\2\u0237\u0236"+
		"\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u023a\3\2\2\2\u0239\u0233\3\2\2\2\u0239"+
		"\u023a\3\2\2\2\u023a\67\3\2\2\2\u023b\u023c\7\3\2\2\u023c\u0241\5b\62"+
		"\2\u023d\u023e\7\4\2\2\u023e\u0240\5b\62\2\u023f\u023d\3\2\2\2\u0240\u0243"+
		"\3\2\2\2\u0241\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0244\3\2\2\2\u0243"+
		"\u0241\3\2\2\2\u0244\u0245\7\5\2\2\u02459\3\2\2\2\u0246\u025f\5`\61\2"+
		"\u0247\u0248\7\3\2\2\u0248\u0249\5\f\7\2\u0249\u024a\7\5\2\2\u024a\u025f"+
		"\3\2\2\2\u024b\u024c\7\u0086\2\2\u024c\u024d\7\3\2\2\u024d\u0252\5<\37"+
		"\2\u024e\u024f\7\4\2\2\u024f\u0251\5<\37\2\u0250\u024e\3\2\2\2\u0251\u0254"+
		"\3\2\2\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0255\3\2\2\2\u0254"+
		"\u0252\3\2\2\2\u0255\u0258\7\5\2\2\u0256\u0257\7V\2\2\u0257\u0259\7\u0087"+
		"\2\2\u0258\u0256\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025f\3\2\2\2\u025a"+
		"\u025b\7\3\2\2\u025b\u025c\5,\27\2\u025c\u025d\7\5\2\2\u025d\u025f\3\2"+
		"\2\2\u025e\u0246\3\2\2\2\u025e\u0247\3\2\2\2\u025e\u024b\3\2\2\2\u025e"+
		"\u025a\3\2\2\2\u025f;\3\2\2\2\u0260\u0261\5> \2\u0261=\3\2\2\2\u0262\u0263"+
		"\b \1\2\u0263\u0264\7\34\2\2\u0264\u026c\5> \6\u0265\u026c\5@!\2\u0266"+
		"\u0267\7\35\2\2\u0267\u0268\7\3\2\2\u0268\u0269\5\f\7\2\u0269\u026a\7"+
		"\5\2\2\u026a\u026c\3\2\2\2\u026b\u0262\3\2\2\2\u026b\u0265\3\2\2\2\u026b"+
		"\u0266\3\2\2\2\u026c\u0275\3\2\2\2\u026d\u026e\f\5\2\2\u026e\u026f\7\32"+
		"\2\2\u026f\u0274\5> \6\u0270\u0271\f\4\2\2\u0271\u0272\7\31\2\2\u0272"+
		"\u0274\5> \5\u0273\u026d\3\2\2\2\u0273\u0270\3\2\2\2\u0274\u0277\3\2\2"+
		"\2\u0275\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276?\3\2\2\2\u0277\u0275"+
		"\3\2\2\2\u0278\u027a\5D#\2\u0279\u027b\5B\"\2\u027a\u0279\3\2\2\2\u027a"+
		"\u027b\3\2\2\2\u027bA\3\2\2\2\u027c\u027d\5J&\2\u027d\u027e\5D#\2\u027e"+
		"\u02b4\3\2\2\2\u027f\u0281\7\34\2\2\u0280\u027f\3\2\2\2\u0280\u0281\3"+
		"\2\2\2\u0281\u0282\3\2\2\2\u0282\u0283\7\36\2\2\u0283\u0284\5D#\2\u0284"+
		"\u0285\7\32\2\2\u0285\u0286\5D#\2\u0286\u02b4\3\2\2\2\u0287\u0289\7\34"+
		"\2\2\u0288\u0287\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028a\3\2\2\2\u028a"+
		"\u028b\7\33\2\2\u028b\u028c\7\3\2\2\u028c\u0291\5<\37\2\u028d\u028e\7"+
		"\4\2\2\u028e\u0290\5<\37\2\u028f\u028d\3\2\2\2\u0290\u0293\3\2\2\2\u0291"+
		"\u028f\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0294\3\2\2\2\u0293\u0291\3\2"+
		"\2\2\u0294\u0295\7\5\2\2\u0295\u02b4\3\2\2\2\u0296\u0298\7\34\2\2\u0297"+
		"\u0296\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029a\7\33"+
		"\2\2\u029a\u029b\7\3\2\2\u029b\u029c\5\f\7\2\u029c\u029d\7\5\2\2\u029d"+
		"\u02b4\3\2\2\2\u029e\u02a0\7\34\2\2\u029f\u029e\3\2\2\2\u029f\u02a0\3"+
		"\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a2\7\37\2\2\u02a2\u02a5\5D#\2\u02a3"+
		"\u02a4\7\'\2\2\u02a4\u02a6\5D#\2\u02a5\u02a3\3\2\2\2\u02a5\u02a6\3\2\2"+
		"\2\u02a6\u02b4\3\2\2\2\u02a7\u02a9\7 \2\2\u02a8\u02aa\7\34\2\2\u02a9\u02a8"+
		"\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02b4\7!\2\2\u02ac"+
		"\u02ae\7 \2\2\u02ad\u02af\7\34\2\2\u02ae\u02ad\3\2\2\2\u02ae\u02af\3\2"+
		"\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b1\7\17\2\2\u02b1\u02b2\7\n\2\2\u02b2"+
		"\u02b4\5D#\2\u02b3\u027c\3\2\2\2\u02b3\u0280\3\2\2\2\u02b3\u0288\3\2\2"+
		"\2\u02b3\u0297\3\2\2\2\u02b3\u029f\3\2\2\2\u02b3\u02a7\3\2\2\2\u02b3\u02ac"+
		"\3\2\2\2\u02b4C\3\2\2\2\u02b5\u02b6\b#\1\2\u02b6\u02b7\t\t\2\2\u02b7\u02ba"+
		"\5D#\6\u02b8\u02ba\5F$\2\u02b9\u02b5\3\2\2\2\u02b9\u02b8\3\2\2\2\u02ba"+
		"\u02c9\3\2\2\2\u02bb\u02bc\f\5\2\2\u02bc\u02bd\t\n\2\2\u02bd\u02c8\5D"+
		"#\6\u02be\u02bf\f\4\2\2\u02bf\u02c0\t\t\2\2\u02c0\u02c8\5D#\5\u02c1\u02c2"+
		"\f\3\2\2\u02c2\u02c3\7\u00a0\2\2\u02c3\u02c8\5D#\4\u02c4\u02c5\f\7\2\2"+
		"\u02c5\u02c6\7\27\2\2\u02c6\u02c8\5H%\2\u02c7\u02bb\3\2\2\2\u02c7\u02be"+
		"\3\2\2\2\u02c7\u02c1\3\2\2\2\u02c7\u02c4\3\2\2\2\u02c8\u02cb\3\2\2\2\u02c9"+
		"\u02c7\3\2\2\2\u02c9\u02ca\3\2\2\2\u02caE\3\2\2\2\u02cb\u02c9\3\2\2\2"+
		"\u02cc\u02cd\b$\1\2\u02cd\u037e\7!\2\2\u02ce\u037e\5N(\2\u02cf\u02d0\5"+
		"b\62\2\u02d0\u02d1\7\u00a1\2\2\u02d1\u037e\3\2\2\2\u02d2\u037e\5f\64\2"+
		"\u02d3\u037e\5L\'\2\u02d4\u037e\7\u00a1\2\2\u02d5\u02d6\7\3\2\2\u02d6"+
		"\u02d9\5<\37\2\u02d7\u02d8\7\4\2\2\u02d8\u02da\5<\37\2\u02d9\u02d7\3\2"+
		"\2\2\u02da\u02db\3\2\2\2\u02db\u02d9\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc"+
		"\u02dd\3\2\2\2\u02dd\u02de\7\5\2\2\u02de\u037e\3\2\2\2\u02df\u02e0\7U"+
		"\2\2\u02e0\u02e1\7\3\2\2\u02e1\u02e6\5<\37\2\u02e2\u02e3\7\4\2\2\u02e3"+
		"\u02e5\5<\37\2\u02e4\u02e2\3\2\2\2\u02e5\u02e8\3\2\2\2\u02e6\u02e4\3\2"+
		"\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e9\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e9"+
		"\u02ea\7\5\2\2\u02ea\u037e\3\2\2\2\u02eb\u037e\5`\61\2\u02ec\u02ed\5`"+
		"\61\2\u02ed\u02ee\7\3\2\2\u02ee\u02ef\7\u009d\2\2\u02ef\u02f1\7\5\2\2"+
		"\u02f0\u02f2\5X-\2\u02f1\u02f0\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2\u037e"+
		"\3\2\2\2\u02f3\u02f4\5`\61\2\u02f4\u0300\7\3\2\2\u02f5\u02f7\5(\25\2\u02f6"+
		"\u02f5\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02fd\5<"+
		"\37\2\u02f9\u02fa\7\4\2\2\u02fa\u02fc\5<\37\2\u02fb\u02f9\3\2\2\2\u02fc"+
		"\u02ff\3\2\2\2\u02fd\u02fb\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u0301\3\2"+
		"\2\2\u02ff\u02fd\3\2\2\2\u0300\u02f6\3\2\2\2\u0300\u0301\3\2\2\2\u0301"+
		"\u0302\3\2\2\2\u0302\u0304\7\5\2\2\u0303\u0305\5X-\2\u0304\u0303\3\2\2"+
		"\2\u0304\u0305\3\2\2\2\u0305\u037e\3\2\2\2\u0306\u0307\7\3\2\2\u0307\u0308"+
		"\5\f\7\2\u0308\u0309\7\5\2\2\u0309\u037e\3\2\2\2\u030a\u030b\7>\2\2\u030b"+
		"\u030d\5D#\2\u030c\u030e\5V,\2\u030d\u030c\3\2\2\2\u030e\u030f\3\2\2\2"+
		"\u030f\u030d\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u0313\3\2\2\2\u0311\u0312"+
		"\7A\2\2\u0312\u0314\5<\37\2\u0313\u0311\3\2\2\2\u0313\u0314\3\2\2\2\u0314"+
		"\u0315\3\2\2\2\u0315\u0316\7B\2\2\u0316\u037e\3\2\2\2\u0317\u0319\7>\2"+
		"\2\u0318\u031a\5V,\2\u0319\u0318\3\2\2\2\u031a\u031b\3\2\2\2\u031b\u0319"+
		"\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u031f\3\2\2\2\u031d\u031e\7A\2\2\u031e"+
		"\u0320\5<\37\2\u031f\u031d\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0321\3\2"+
		"\2\2\u0321\u0322\7B\2\2\u0322\u037e\3\2\2\2\u0323\u0324\7n\2\2\u0324\u0325"+
		"\7\3\2\2\u0325\u0326\5<\37\2\u0326\u0327\7\13\2\2\u0327\u0328\5R*\2\u0328"+
		"\u0329\7\5\2\2\u0329\u037e\3\2\2\2\u032a\u032b\7o\2\2\u032b\u032c\7\3"+
		"\2\2\u032c\u032d\5<\37\2\u032d\u032e\7\13\2\2\u032e\u032f\5R*\2\u032f"+
		"\u0330\7\5\2\2\u0330\u037e\3\2\2\2\u0331\u0332\7\u0088\2\2\u0332\u033b"+
		"\7\7\2\2\u0333\u0338\5<\37\2\u0334\u0335\7\4\2\2\u0335\u0337\5<\37\2\u0336"+
		"\u0334\3\2\2\2\u0337\u033a\3\2\2\2\u0338\u0336\3\2\2\2\u0338\u0339\3\2"+
		"\2\2\u0339\u033c\3\2\2\2\u033a\u0338\3\2\2\2\u033b\u0333\3\2\2\2\u033b"+
		"\u033c\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u037e\7\b\2\2\u033e\u037e\78"+
		"\2\2\u033f\u0343\79\2\2\u0340\u0341\7\3\2\2\u0341\u0342\7\u00a2\2\2\u0342"+
		"\u0344\7\5\2\2\u0343\u0340\3\2\2\2\u0343\u0344\3\2\2\2\u0344\u037e\3\2"+
		"\2\2\u0345\u0349\7:\2\2\u0346\u0347\7\3\2\2\u0347\u0348\7\u00a2\2\2\u0348"+
		"\u034a\7\5\2\2\u0349\u0346\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u037e\3\2"+
		"\2\2\u034b\u034f\7;\2\2\u034c\u034d\7\3\2\2\u034d\u034e\7\u00a2\2\2\u034e"+
		"\u0350\7\5\2\2\u034f\u034c\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u037e\3\2"+
		"\2\2\u0351\u0355\7<\2\2\u0352\u0353\7\3\2\2\u0353\u0354\7\u00a2\2\2\u0354"+
		"\u0356\7\5\2\2\u0355\u0352\3\2\2\2\u0355\u0356\3\2\2\2\u0356\u037e\3\2"+
		"\2\2\u0357\u0358\7*\2\2\u0358\u0359\7\3\2\2\u0359\u035a\5D#\2\u035a\u035b"+
		"\7\n\2\2\u035b\u035e\5D#\2\u035c\u035d\7,\2\2\u035d\u035f\5D#\2\u035e"+
		"\u035c\3\2\2\2\u035e\u035f\3\2\2\2\u035f\u0360\3\2\2\2\u0360\u0361\7\5"+
		"\2\2\u0361\u037e\3\2\2\2\u0362\u0363\7\u008d\2\2\u0363\u0364\7\3\2\2\u0364"+
		"\u0367\5D#\2\u0365\u0366\7\4\2\2\u0366\u0368\5j\66\2\u0367\u0365\3\2\2"+
		"\2\u0367\u0368\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u036a\7\5\2\2\u036a\u037e"+
		"\3\2\2\2\u036b\u036c\7=\2\2\u036c\u036d\7\3\2\2\u036d\u036e\5b\62\2\u036e"+
		"\u036f\7\n\2\2\u036f\u0370\5D#\2\u0370\u0371\7\5\2\2\u0371\u037e\3\2\2"+
		"\2\u0372\u0373\7+\2\2\u0373\u0374\7\3\2\2\u0374\u0375\5D#\2\u0375\u0376"+
		"\7\33\2\2\u0376\u0377\5D#\2\u0377\u0378\7\5\2\2\u0378\u037e\3\2\2\2\u0379"+
		"\u037a\7\3\2\2\u037a\u037b\5<\37\2\u037b\u037c\7\5\2\2\u037c\u037e\3\2"+
		"\2\2\u037d\u02cc\3\2\2\2\u037d\u02ce\3\2\2\2\u037d\u02cf\3\2\2\2\u037d"+
		"\u02d2\3\2\2\2\u037d\u02d3\3\2\2\2\u037d\u02d4\3\2\2\2\u037d\u02d5\3\2"+
		"\2\2\u037d\u02df\3\2\2\2\u037d\u02eb\3\2\2\2\u037d\u02ec\3\2\2\2\u037d"+
		"\u02f3\3\2\2\2\u037d\u0306\3\2\2\2\u037d\u030a\3\2\2\2\u037d\u0317\3\2"+
		"\2\2\u037d\u0323\3\2\2\2\u037d\u032a\3\2\2\2\u037d\u0331\3\2\2\2\u037d"+
		"\u033e\3\2\2\2\u037d\u033f\3\2\2\2\u037d\u0345\3\2\2\2\u037d\u034b\3\2"+
		"\2\2\u037d\u0351\3\2\2\2\u037d\u0357\3\2\2\2\u037d\u0362\3\2\2\2\u037d"+
		"\u036b\3\2\2\2\u037d\u0372\3\2\2\2\u037d\u0379\3\2\2\2\u037e\u0389\3\2"+
		"\2\2\u037f\u0380\f\16\2\2\u0380\u0381\7\7\2\2\u0381\u0382\5D#\2\u0382"+
		"\u0383\7\b\2\2\u0383\u0388\3\2\2\2\u0384\u0385\f\r\2\2\u0385\u0386\7\6"+
		"\2\2\u0386\u0388\5b\62\2\u0387\u037f\3\2\2\2\u0387\u0384\3\2\2\2\u0388"+
		"\u038b\3\2\2\2\u0389\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038aG\3\2\2\2"+
		"\u038b\u0389\3\2\2\2\u038c\u038d\7.\2\2\u038d\u038e\7\67\2\2\u038e\u0393"+
		"\5N(\2\u038f\u0390\7.\2\2\u0390\u0391\7\67\2\2\u0391\u0393\7\u00a1\2\2"+
		"\u0392\u038c\3\2\2\2\u0392\u038f\3\2\2\2\u0393I\3\2\2\2\u0394\u0395\t"+
		"\13\2\2\u0395K\3\2\2\2\u0396\u0397\t\f\2\2\u0397M\3\2\2\2\u0398\u039a"+
		"\7\60\2\2\u0399\u039b\t\t\2\2\u039a\u0399\3\2\2\2\u039a\u039b\3\2\2\2"+
		"\u039b\u039c\3\2\2\2\u039c\u039d\7\u00a1\2\2\u039d\u03a0\5P)\2\u039e\u039f"+
		"\7}\2\2\u039f\u03a1\5P)\2\u03a0\u039e\3\2\2\2\u03a0\u03a1\3\2\2\2\u03a1"+
		"O\3\2\2\2\u03a2\u03a3\t\r\2\2\u03a3Q\3\2\2\2\u03a4\u03a5\b*\1\2\u03a5"+
		"\u03a6\7\u0088\2\2\u03a6\u03a7\7\u0097\2\2\u03a7\u03a8\5R*\2\u03a8\u03a9"+
		"\7\u0099\2\2\u03a9\u03b3\3\2\2\2\u03aa\u03ab\7\u0089\2\2\u03ab\u03ac\7"+
		"\u0097\2\2\u03ac\u03ad\5R*\2\u03ad\u03ae\7\4\2\2\u03ae\u03af\5R*\2\u03af"+
		"\u03b0\7\u0099\2\2\u03b0\u03b3\3\2\2\2\u03b1\u03b3\5T+\2\u03b2\u03a4\3"+
		"\2\2\2\u03b2\u03aa\3\2\2\2\u03b2\u03b1\3\2\2\2\u03b3\u03b8\3\2\2\2\u03b4"+
		"\u03b5\f\6\2\2\u03b5\u03b7\7\u0088\2\2\u03b6\u03b4\3\2\2\2\u03b7\u03ba"+
		"\3\2\2\2\u03b8\u03b6\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9S\3\2\2\2\u03ba"+
		"\u03b8\3\2\2\2\u03bb\u03bf\7\u00a8\2\2\u03bc\u03bf\7\u00a9\2\2\u03bd\u03bf"+
		"\5b\62\2\u03be\u03bb\3\2\2\2\u03be\u03bc\3\2\2\2\u03be\u03bd\3\2\2\2\u03bf"+
		"U\3\2\2\2\u03c0\u03c1\7?\2\2\u03c1\u03c2\5<\37\2\u03c2\u03c3\7@\2\2\u03c3"+
		"\u03c4\5<\37\2\u03c4W\3\2\2\2\u03c5\u03c6\7M\2\2\u03c6\u03d1\7\3\2\2\u03c7"+
		"\u03c8\7N\2\2\u03c8\u03c9\7\22\2\2\u03c9\u03ce\5<\37\2\u03ca\u03cb\7\4"+
		"\2\2\u03cb\u03cd\5<\37\2\u03cc\u03ca\3\2\2\2\u03cd\u03d0\3\2\2\2\u03ce"+
		"\u03cc\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf\u03d2\3\2\2\2\u03d0\u03ce\3\2"+
		"\2\2\u03d1\u03c7\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03dd\3\2\2\2\u03d3"+
		"\u03d4\7\23\2\2\u03d4\u03d5\7\22\2\2\u03d5\u03da\5\"\22\2\u03d6\u03d7"+
		"\7\4\2\2\u03d7\u03d9\5\"\22\2\u03d8\u03d6\3\2\2\2\u03d9\u03dc\3\2\2\2"+
		"\u03da\u03d8\3\2\2\2\u03da\u03db\3\2\2\2\u03db\u03de\3\2\2\2\u03dc\u03da"+
		"\3\2\2\2\u03dd\u03d3\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\u03e0\3\2\2\2\u03df"+
		"\u03e1\5Z.\2\u03e0\u03df\3\2\2\2\u03e0\u03e1\3\2\2\2\u03e1\u03e2\3\2\2"+
		"\2\u03e2\u03e3\7\5\2\2\u03e3Y\3\2\2\2\u03e4\u03e5\7O\2\2\u03e5\u03f5\5"+
		"\\/\2\u03e6\u03e7\7P\2\2\u03e7\u03f5\5\\/\2\u03e8\u03e9\7O\2\2\u03e9\u03ea"+
		"\7\36\2\2\u03ea\u03eb\5\\/\2\u03eb\u03ec\7\32\2\2\u03ec\u03ed\5\\/\2\u03ed"+
		"\u03f5\3\2\2\2\u03ee\u03ef\7P\2\2\u03ef\u03f0\7\36\2\2\u03f0\u03f1\5\\"+
		"/\2\u03f1\u03f2\7\32\2\2\u03f2\u03f3\5\\/\2\u03f3\u03f5\3\2\2\2\u03f4"+
		"\u03e4\3\2\2\2\u03f4\u03e6\3\2\2\2\u03f4\u03e8\3\2\2\2\u03f4\u03ee\3\2"+
		"\2\2\u03f5[\3\2\2\2\u03f6\u03f7\7Q\2\2\u03f7\u0400\7R\2\2\u03f8\u03f9"+
		"\7Q\2\2\u03f9\u0400\7S\2\2\u03fa\u03fb\7T\2\2\u03fb\u0400\7U\2\2\u03fc"+
		"\u03fd\5<\37\2\u03fd\u03fe\t\16\2\2\u03fe\u0400\3\2\2\2\u03ff\u03f6\3"+
		"\2\2\2\u03ff\u03f8\3\2\2\2\u03ff\u03fa\3\2\2\2\u03ff\u03fc\3\2\2\2\u0400"+
		"]\3\2\2\2\u0401\u0402\7g\2\2\u0402\u0406\t\17\2\2\u0403\u0404\7h\2\2\u0404"+
		"\u0406\t\20\2\2\u0405\u0401\3\2\2\2\u0405\u0403\3\2\2\2\u0406_\3\2\2\2"+
		"\u0407\u040c\5b\62\2\u0408\u0409\7\6\2\2\u0409\u040b\5b\62\2\u040a\u0408"+
		"\3\2\2\2\u040b\u040e\3\2\2\2\u040c\u040a\3\2\2\2\u040c\u040d\3\2\2\2\u040d"+
		"a\3\2\2\2\u040e\u040c\3\2\2\2\u040f\u0415\7\u00a4\2\2\u0410\u0415\5d\63"+
		"\2\u0411\u0415\5h\65\2\u0412\u0415\7\u00a7\2\2\u0413\u0415\7\u00a5\2\2"+
		"\u0414\u040f\3\2\2\2\u0414\u0410\3\2\2\2\u0414\u0411\3\2\2\2\u0414\u0412"+
		"\3\2\2\2\u0414\u0413\3\2\2\2\u0415c\3\2\2\2\u0416\u0417\7\u00a6\2\2\u0417"+
		"e\3\2\2\2\u0418\u041b\7\u00a3\2\2\u0419\u041b\7\u00a2\2\2\u041a\u0418"+
		"\3\2\2\2\u041a\u0419\3\2\2\2\u041bg\3\2\2\2\u041c\u0454\7p\2\2\u041d\u0454"+
		"\7q\2\2\u041e\u0454\7t\2\2\u041f\u0454\7u\2\2\u0420\u0454\7w\2\2\u0421"+
		"\u0454\7x\2\2\u0422\u0454\7r\2\2\u0423\u0454\7s\2\2\u0424\u0454\7\u008c"+
		"\2\2\u0425\u0454\7M\2\2\u0426\u0454\7N\2\2\u0427\u0454\7O\2\2\u0428\u0454"+
		"\7P\2\2\u0429\u0454\7R\2\2\u042a\u0454\7S\2\2\u042b\u0454\7T\2\2\u042c"+
		"\u0454\7U\2\2\u042d\u0454\7\u0089\2\2\u042e\u0454\7-\2\2\u042f\u0454\7"+
		".\2\2\u0430\u0454\7/\2\2\u0431\u0454\7\60\2\2\u0432\u0454\7\61\2\2\u0433"+
		"\u0454\7\62\2\2\u0434\u0454\7\63\2\2\u0435\u0454\7\64\2\2\u0436\u0454"+
		"\7\65\2\2\u0437\u0454\7\66\2\2\u0438\u0454\7f\2\2\u0439\u0454\7g\2\2\u043a"+
		"\u0454\7h\2\2\u043b\u0454\7i\2\2\u043c\u0454\7j\2\2\u043d\u0454\7l\2\2"+
		"\u043e\u0454\7m\2\2\u043f\u0454\7\u0081\2\2\u0440\u0454\7~\2\2\u0441\u0454"+
		"\7\177\2\2\u0442\u0454\7\u0080\2\2\u0443\u0454\7v\2\2\u0444\u0454\7k\2"+
		"\2\u0445\u0454\7}\2\2\u0446\u0454\7\u0082\2\2\u0447\u0454\7\26\2\2\u0448"+
		"\u0454\7\27\2\2\u0449\u0454\7\30\2\2\u044a\u0454\7\u008a\2\2\u044b\u0454"+
		"\7\u008b\2\2\u044c\u0454\7_\2\2\u044d\u0454\7`\2\2\u044e\u0454\7\u0092"+
		"\2\2\u044f\u0454\7\u0093\2\2\u0450\u0454\7\u0094\2\2\u0451\u0454\5j\66"+
		"\2\u0452\u0454\7+\2\2\u0453\u041c\3\2\2\2\u0453\u041d\3\2\2\2\u0453\u041e"+
		"\3\2\2\2\u0453\u041f\3\2\2\2\u0453\u0420\3\2\2\2\u0453\u0421\3\2\2\2\u0453"+
		"\u0422\3\2\2\2\u0453\u0423\3\2\2\2\u0453\u0424\3\2\2\2\u0453\u0425\3\2"+
		"\2\2\u0453\u0426\3\2\2\2\u0453\u0427\3\2\2\2\u0453\u0428\3\2\2\2\u0453"+
		"\u0429\3\2\2\2\u0453\u042a\3\2\2\2\u0453\u042b\3\2\2\2\u0453\u042c\3\2"+
		"\2\2\u0453\u042d\3\2\2\2\u0453\u042e\3\2\2\2\u0453\u042f\3\2\2\2\u0453"+
		"\u0430\3\2\2\2\u0453\u0431\3\2\2\2\u0453\u0432\3\2\2\2\u0453\u0433\3\2"+
		"\2\2\u0453\u0434\3\2\2\2\u0453\u0435\3\2\2\2\u0453\u0436\3\2\2\2\u0453"+
		"\u0437\3\2\2\2\u0453\u0438\3\2\2\2\u0453\u0439\3\2\2\2\u0453\u043a\3\2"+
		"\2\2\u0453\u043b\3\2\2\2\u0453\u043c\3\2\2\2\u0453\u043d\3\2\2\2\u0453"+
		"\u043e\3\2\2\2\u0453\u043f\3\2\2\2\u0453\u0440\3\2\2\2\u0453\u0441\3\2"+
		"\2\2\u0453\u0442\3\2\2\2\u0453\u0443\3\2\2\2\u0453\u0444\3\2\2\2\u0453"+
		"\u0445\3\2\2\2\u0453\u0446\3\2\2\2\u0453\u0447\3\2\2\2\u0453\u0448\3\2"+
		"\2\2\u0453\u0449\3\2\2\2\u0453\u044a\3\2\2\2\u0453\u044b\3\2\2\2\u0453"+
		"\u044c\3\2\2\2\u0453\u044d\3\2\2\2\u0453\u044e\3\2\2\2\u0453\u044f\3\2"+
		"\2\2\u0453\u0450\3\2\2\2\u0453\u0451\3\2\2\2\u0453\u0452\3\2\2\2\u0454"+
		"i\3\2\2\2\u0455\u0456\t\21\2\2\u0456k\3\2\2\2\u0080x\u0082\u008b\u0090"+
		"\u0093\u0097\u009d\u00a4\u00a8\u00af\u00c8\u00cd\u00d4\u00d8\u00de\u00f7"+
		"\u00ff\u0108\u010e\u0114\u011b\u0123\u012e\u0134\u013e\u0149\u015a\u015d"+
		"\u0161\u0168\u0170\u0176\u0179\u017b\u0187\u018e\u0192\u0196\u019a\u01a1"+
		"\u01aa\u01ad\u01b1\u01ba\u01bd\u01c1\u01c5\u01d0\u01d3\u01da\u01ed\u01f1"+
		"\u01f5\u01f9\u01fd\u0201\u0203\u020e\u0213\u021c\u0226\u022b\u022d\u0233"+
		"\u0237\u0239\u0241\u0252\u0258\u025e\u026b\u0273\u0275\u027a\u0280\u0288"+
		"\u0291\u0297\u029f\u02a5\u02a9\u02ae\u02b3\u02b9\u02c7\u02c9\u02db\u02e6"+
		"\u02f1\u02f6\u02fd\u0300\u0304\u030f\u0313\u031b\u031f\u0338\u033b\u0343"+
		"\u0349\u034f\u0355\u035e\u0367\u037d\u0387\u0389\u0392\u039a\u03a0\u03b2"+
		"\u03b8\u03be\u03ce\u03d1\u03da\u03dd\u03e0\u03f4\u03ff\u0405\u040c\u0414"+
		"\u041a\u0453";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}