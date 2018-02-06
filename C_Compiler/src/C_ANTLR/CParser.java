// Generated from /home/miguel/Desktop/CompilationTechniques/C_Compiler/src/C_ANTLR/C.g4 by ANTLR 4.5.3
package C_ANTLR;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, MATH_OP_MEDIUM_PRIORITY=12, MATH_OP_HIGH_PRIORITY=13, 
		MATH_OP_LOW_PRIORITY=14, ENDLINE=15, EQUAL=16, OTHER_ASSIGN_OPS=17, INCR_DECR=18, 
		COMPARACION=19, LOGIC_OP=20, VALID_C_TYPES=21, ID=22, INT=23, FLOAT=24, 
		CHAR=25;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_ret = 2, RULE_f_p = 3, RULE_for_loop = 4, 
		RULE_while_loop = 5, RULE_if_condition = 6, RULE_else_condition = 7, RULE_f_d = 8, 
		RULE_code_block = 9, RULE_assign_op = 10, RULE_string = 11, RULE_f_c = 12, 
		RULE_variable_declaration = 13, RULE_to_value = 14, RULE_comparation = 15, 
		RULE_logic_op = 16, RULE_assignation = 17, RULE_math_operation = 18, RULE_sum = 19, 
		RULE_product = 20, RULE_factor = 21, RULE_math_operand = 22, RULE_grouped = 23, 
		RULE_unapplied_low_op = 24, RULE_unapplied_medium_op = 25, RULE_unapplied_high_op = 26, 
		RULE_digit = 27, RULE_integer = 28, RULE_floating_point = 29, RULE_parametersList = 30, 
		RULE_inputParametersList = 31;
	public static final String[] ruleNames = {
		"prog", "stat", "ret", "f_p", "for_loop", "while_loop", "if_condition", 
		"else_condition", "f_d", "code_block", "assign_op", "string", "f_c", "variable_declaration", 
		"to_value", "comparation", "logic_op", "assignation", "math_operation", 
		"sum", "product", "factor", "math_operand", "grouped", "unapplied_low_op", 
		"unapplied_medium_op", "unapplied_high_op", "digit", "integer", "floating_point", 
		"parametersList", "inputParametersList"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'return'", "'('", "')'", "'for'", "'while'", "'if'", "'else'", 
		"'{'", "'}'", "','", null, "'^'", null, null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"MATH_OP_MEDIUM_PRIORITY", "MATH_OP_HIGH_PRIORITY", "MATH_OP_LOW_PRIORITY", 
		"ENDLINE", "EQUAL", "OTHER_ASSIGN_OPS", "INCR_DECR", "COMPARACION", "LOGIC_OP", 
		"VALID_C_TYPES", "ID", "INT", "FLOAT", "CHAR"
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
	public String getGrammarFileName() { return "C.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				stat();
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << VALID_C_TYPES) | (1L << ID))) != 0) );
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

	public static class StatContext extends ParserRuleContext {
		public F_dContext f_d() {
			return getRuleContext(F_dContext.class,0);
		}
		public For_loopContext for_loop() {
			return getRuleContext(For_loopContext.class,0);
		}
		public While_loopContext while_loop() {
			return getRuleContext(While_loopContext.class,0);
		}
		public If_conditionContext if_condition() {
			return getRuleContext(If_conditionContext.class,0);
		}
		public F_pContext f_p() {
			return getRuleContext(F_pContext.class,0);
		}
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public F_cContext f_c() {
			return getRuleContext(F_cContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				f_d();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				for_loop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				while_loop();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				if_condition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				f_p();
				setState(74);
				match(T__0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				variable_declaration();
				setState(77);
				match(T__0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(79);
				assignation();
				setState(80);
				match(T__0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(82);
				ret();
				setState(83);
				match(T__0);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(85);
				f_c();
				setState(86);
				match(T__0);
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

	public static class RetContext extends ParserRuleContext {
		public To_valueContext to_value() {
			return getRuleContext(To_valueContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitRet(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ret);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__1);
			setState(91);
			to_value();
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

	public static class F_pContext extends ParserRuleContext {
		public TerminalNode VALID_C_TYPES() { return getToken(CParser.VALID_C_TYPES, 0); }
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public ParametersListContext parametersList() {
			return getRuleContext(ParametersListContext.class,0);
		}
		public F_pContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_p; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterF_p(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitF_p(this);
		}
	}

	public final F_pContext f_p() throws RecognitionException {
		F_pContext _localctx = new F_pContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_f_p);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(VALID_C_TYPES);
			setState(94);
			match(ID);
			setState(95);
			match(T__2);
			setState(97);
			_la = _input.LA(1);
			if (_la==VALID_C_TYPES) {
				{
				setState(96);
				parametersList(0);
				}
			}

			setState(99);
			match(T__3);
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

	public static class For_loopContext extends ParserRuleContext {
		public ComparationContext comparation() {
			return getRuleContext(ComparationContext.class,0);
		}
		public List<AssignationContext> assignation() {
			return getRuleContexts(AssignationContext.class);
		}
		public AssignationContext assignation(int i) {
			return getRuleContext(AssignationContext.class,i);
		}
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public Code_blockContext code_block() {
			return getRuleContext(Code_blockContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public For_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterFor_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitFor_loop(this);
		}
	}

	public final For_loopContext for_loop() throws RecognitionException {
		For_loopContext _localctx = new For_loopContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_for_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__4);
			setState(102);
			match(T__2);
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(103);
				assignation();
				}
				break;
			case 2:
				{
				setState(104);
				match(ID);
				}
				break;
			}
			setState(107);
			match(T__0);
			setState(108);
			comparation();
			setState(109);
			match(T__0);
			setState(110);
			assignation();
			setState(111);
			match(T__3);
			setState(114);
			switch (_input.LA(1)) {
			case T__8:
				{
				setState(112);
				code_block();
				}
				break;
			case T__1:
			case T__4:
			case T__5:
			case T__6:
			case VALID_C_TYPES:
			case ID:
				{
				setState(113);
				stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class While_loopContext extends ParserRuleContext {
		public Logic_opContext logic_op() {
			return getRuleContext(Logic_opContext.class,0);
		}
		public Code_blockContext code_block() {
			return getRuleContext(Code_blockContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public While_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterWhile_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitWhile_loop(this);
		}
	}

	public final While_loopContext while_loop() throws RecognitionException {
		While_loopContext _localctx = new While_loopContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_while_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__5);
			setState(117);
			match(T__2);
			setState(118);
			logic_op();
			setState(119);
			match(T__3);
			setState(122);
			switch (_input.LA(1)) {
			case T__8:
				{
				setState(120);
				code_block();
				}
				break;
			case T__1:
			case T__4:
			case T__5:
			case T__6:
			case VALID_C_TYPES:
			case ID:
				{
				setState(121);
				stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class If_conditionContext extends ParserRuleContext {
		public Logic_opContext logic_op() {
			return getRuleContext(Logic_opContext.class,0);
		}
		public Code_blockContext code_block() {
			return getRuleContext(Code_blockContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Else_conditionContext else_condition() {
			return getRuleContext(Else_conditionContext.class,0);
		}
		public If_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterIf_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitIf_condition(this);
		}
	}

	public final If_conditionContext if_condition() throws RecognitionException {
		If_conditionContext _localctx = new If_conditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_if_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__6);
			setState(125);
			match(T__2);
			setState(126);
			logic_op();
			setState(127);
			match(T__3);
			setState(130);
			switch (_input.LA(1)) {
			case T__8:
				{
				setState(128);
				code_block();
				}
				break;
			case T__1:
			case T__4:
			case T__5:
			case T__6:
			case VALID_C_TYPES:
			case ID:
				{
				setState(129);
				stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(132);
				else_condition();
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

	public static class Else_conditionContext extends ParserRuleContext {
		public Code_blockContext code_block() {
			return getRuleContext(Code_blockContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Logic_opContext logic_op() {
			return getRuleContext(Logic_opContext.class,0);
		}
		public Else_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterElse_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitElse_condition(this);
		}
	}

	public final Else_conditionContext else_condition() throws RecognitionException {
		Else_conditionContext _localctx = new Else_conditionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_else_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__7);
			setState(140);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(136);
				match(T__2);
				setState(137);
				logic_op();
				setState(138);
				match(T__3);
				}
			}

			setState(144);
			switch (_input.LA(1)) {
			case T__8:
				{
				setState(142);
				code_block();
				}
				break;
			case T__1:
			case T__4:
			case T__5:
			case T__6:
			case VALID_C_TYPES:
			case ID:
				{
				setState(143);
				stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class F_dContext extends ParserRuleContext {
		public TerminalNode VALID_C_TYPES() { return getToken(CParser.VALID_C_TYPES, 0); }
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public Code_blockContext code_block() {
			return getRuleContext(Code_blockContext.class,0);
		}
		public ParametersListContext parametersList() {
			return getRuleContext(ParametersListContext.class,0);
		}
		public F_dContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_d; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterF_d(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitF_d(this);
		}
	}

	public final F_dContext f_d() throws RecognitionException {
		F_dContext _localctx = new F_dContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_f_d);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(VALID_C_TYPES);
			setState(147);
			match(ID);
			setState(148);
			match(T__2);
			setState(150);
			_la = _input.LA(1);
			if (_la==VALID_C_TYPES) {
				{
				setState(149);
				parametersList(0);
				}
			}

			setState(152);
			match(T__3);
			setState(153);
			code_block();
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

	public static class Code_blockContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public Code_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterCode_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitCode_block(this);
		}
	}

	public final Code_blockContext code_block() throws RecognitionException {
		Code_blockContext _localctx = new Code_blockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_code_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(T__8);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << VALID_C_TYPES) | (1L << ID))) != 0)) {
				{
				{
				setState(156);
				stat();
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(162);
			match(T__9);
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

	public static class Assign_opContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(CParser.EQUAL, 0); }
		public TerminalNode OTHER_ASSIGN_OPS() { return getToken(CParser.OTHER_ASSIGN_OPS, 0); }
		public Assign_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAssign_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAssign_op(this);
		}
	}

	public final Assign_opContext assign_op() throws RecognitionException {
		Assign_opContext _localctx = new Assign_opContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assign_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if ( !(_la==EQUAL || _la==OTHER_ASSIGN_OPS) ) {
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(CParser.CHAR, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(CHAR);
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

	public static class F_cContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public InputParametersListContext inputParametersList() {
			return getRuleContext(InputParametersListContext.class,0);
		}
		public F_cContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_c; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterF_c(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitF_c(this);
		}
	}

	public final F_cContext f_c() throws RecognitionException {
		F_cContext _localctx = new F_cContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_f_c);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(ID);
			setState(169);
			match(T__2);
			setState(170);
			inputParametersList(0);
			setState(171);
			match(T__3);
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

	public static class Variable_declarationContext extends ParserRuleContext {
		public List<TerminalNode> VALID_C_TYPES() { return getTokens(CParser.VALID_C_TYPES); }
		public TerminalNode VALID_C_TYPES(int i) {
			return getToken(CParser.VALID_C_TYPES, i);
		}
		public List<TerminalNode> ID() { return getTokens(CParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CParser.ID, i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(CParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(CParser.EQUAL, i);
		}
		public List<To_valueContext> to_value() {
			return getRuleContexts(To_valueContext.class);
		}
		public To_valueContext to_value(int i) {
			return getRuleContext(To_valueContext.class,i);
		}
		public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterVariable_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitVariable_declaration(this);
		}
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variable_declaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(VALID_C_TYPES);
			setState(174);
			match(ID);
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(175);
				match(EQUAL);
				setState(176);
				to_value();
				}
				break;
			}
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(179);
					match(T__10);
					setState(181);
					_la = _input.LA(1);
					if (_la==VALID_C_TYPES) {
						{
						setState(180);
						match(VALID_C_TYPES);
						}
					}

					setState(183);
					match(ID);
					setState(186);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						setState(184);
						match(EQUAL);
						setState(185);
						to_value();
						}
						break;
					}
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class To_valueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public DigitContext digit() {
			return getRuleContext(DigitContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public F_cContext f_c() {
			return getRuleContext(F_cContext.class,0);
		}
		public Math_operationContext math_operation() {
			return getRuleContext(Math_operationContext.class,0);
		}
		public To_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_to_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterTo_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitTo_value(this);
		}
	}

	public final To_valueContext to_value() throws RecognitionException {
		To_valueContext _localctx = new To_valueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_to_value);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				digit();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				string();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(196);
				f_c();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(197);
				math_operation();
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

	public static class ComparationContext extends ParserRuleContext {
		public List<To_valueContext> to_value() {
			return getRuleContexts(To_valueContext.class);
		}
		public To_valueContext to_value(int i) {
			return getRuleContext(To_valueContext.class,i);
		}
		public TerminalNode COMPARACION() { return getToken(CParser.COMPARACION, 0); }
		public ComparationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterComparation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitComparation(this);
		}
	}

	public final ComparationContext comparation() throws RecognitionException {
		ComparationContext _localctx = new ComparationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comparation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			to_value();
			setState(201);
			match(COMPARACION);
			setState(202);
			to_value();
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

	public static class Logic_opContext extends ParserRuleContext {
		public ComparationContext comparation() {
			return getRuleContext(ComparationContext.class,0);
		}
		public TerminalNode LOGIC_OP() { return getToken(CParser.LOGIC_OP, 0); }
		public Logic_opContext logic_op() {
			return getRuleContext(Logic_opContext.class,0);
		}
		public Logic_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterLogic_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitLogic_op(this);
		}
	}

	public final Logic_opContext logic_op() throws RecognitionException {
		Logic_opContext _localctx = new Logic_opContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logic_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(204);
				match(T__2);
				}
				break;
			}
			setState(207);
			comparation();
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(208);
				match(T__3);
				}
				break;
			}
			setState(213);
			_la = _input.LA(1);
			if (_la==LOGIC_OP) {
				{
				setState(211);
				match(LOGIC_OP);
				setState(212);
				logic_op();
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

	public static class AssignationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public Assign_opContext assign_op() {
			return getRuleContext(Assign_opContext.class,0);
		}
		public To_valueContext to_value() {
			return getRuleContext(To_valueContext.class,0);
		}
		public TerminalNode INCR_DECR() { return getToken(CParser.INCR_DECR, 0); }
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_assignation);
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(ID);
				{
				setState(216);
				assign_op();
				setState(217);
				to_value();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				match(ID);
				setState(220);
				match(INCR_DECR);
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

	public static class Math_operationContext extends ParserRuleContext {
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public Math_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterMath_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitMath_operation(this);
		}
	}

	public final Math_operationContext math_operation() throws RecognitionException {
		Math_operationContext _localctx = new Math_operationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_math_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			sum();
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

	public static class SumContext extends ParserRuleContext {
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public List<Unapplied_low_opContext> unapplied_low_op() {
			return getRuleContexts(Unapplied_low_opContext.class);
		}
		public Unapplied_low_opContext unapplied_low_op(int i) {
			return getRuleContext(Unapplied_low_opContext.class,i);
		}
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitSum(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		SumContext _localctx = new SumContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_sum);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			product();
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(226);
					unapplied_low_op();
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class ProductContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public List<Unapplied_medium_opContext> unapplied_medium_op() {
			return getRuleContexts(Unapplied_medium_opContext.class);
		}
		public Unapplied_medium_opContext unapplied_medium_op(int i) {
			return getRuleContext(Unapplied_medium_opContext.class,i);
		}
		public ProductContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_product; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterProduct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitProduct(this);
		}
	}

	public final ProductContext product() throws RecognitionException {
		ProductContext _localctx = new ProductContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_product);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			factor();
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(233);
					unapplied_medium_op();
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class FactorContext extends ParserRuleContext {
		public Math_operandContext math_operand() {
			return getRuleContext(Math_operandContext.class,0);
		}
		public List<Unapplied_high_opContext> unapplied_high_op() {
			return getRuleContexts(Unapplied_high_opContext.class);
		}
		public Unapplied_high_opContext unapplied_high_op(int i) {
			return getRuleContext(Unapplied_high_opContext.class,i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factor);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			math_operand();
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(240);
					unapplied_high_op();
					}
					} 
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class Math_operandContext extends ParserRuleContext {
		public DigitContext digit() {
			return getRuleContext(DigitContext.class,0);
		}
		public TerminalNode ID() { return getToken(CParser.ID, 0); }
		public F_cContext f_c() {
			return getRuleContext(F_cContext.class,0);
		}
		public GroupedContext grouped() {
			return getRuleContext(GroupedContext.class,0);
		}
		public Math_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterMath_operand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitMath_operand(this);
		}
	}

	public final Math_operandContext math_operand() throws RecognitionException {
		Math_operandContext _localctx = new Math_operandContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_math_operand);
		try {
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				digit();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				f_c();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
				grouped();
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

	public static class GroupedContext extends ParserRuleContext {
		public Math_operationContext math_operation() {
			return getRuleContext(Math_operationContext.class,0);
		}
		public GroupedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouped; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterGrouped(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitGrouped(this);
		}
	}

	public final GroupedContext grouped() throws RecognitionException {
		GroupedContext _localctx = new GroupedContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_grouped);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(T__2);
			setState(253);
			math_operation();
			setState(254);
			match(T__3);
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

	public static class Unapplied_low_opContext extends ParserRuleContext {
		public TerminalNode MATH_OP_LOW_PRIORITY() { return getToken(CParser.MATH_OP_LOW_PRIORITY, 0); }
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public Unapplied_low_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unapplied_low_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterUnapplied_low_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitUnapplied_low_op(this);
		}
	}

	public final Unapplied_low_opContext unapplied_low_op() throws RecognitionException {
		Unapplied_low_opContext _localctx = new Unapplied_low_opContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_unapplied_low_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(256);
			match(MATH_OP_LOW_PRIORITY);
			setState(257);
			product();
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

	public static class Unapplied_medium_opContext extends ParserRuleContext {
		public TerminalNode MATH_OP_MEDIUM_PRIORITY() { return getToken(CParser.MATH_OP_MEDIUM_PRIORITY, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Unapplied_medium_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unapplied_medium_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterUnapplied_medium_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitUnapplied_medium_op(this);
		}
	}

	public final Unapplied_medium_opContext unapplied_medium_op() throws RecognitionException {
		Unapplied_medium_opContext _localctx = new Unapplied_medium_opContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unapplied_medium_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(259);
			match(MATH_OP_MEDIUM_PRIORITY);
			setState(260);
			factor();
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

	public static class Unapplied_high_opContext extends ParserRuleContext {
		public TerminalNode MATH_OP_HIGH_PRIORITY() { return getToken(CParser.MATH_OP_HIGH_PRIORITY, 0); }
		public Math_operandContext math_operand() {
			return getRuleContext(Math_operandContext.class,0);
		}
		public Unapplied_high_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unapplied_high_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterUnapplied_high_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitUnapplied_high_op(this);
		}
	}

	public final Unapplied_high_opContext unapplied_high_op() throws RecognitionException {
		Unapplied_high_opContext _localctx = new Unapplied_high_opContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_unapplied_high_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(262);
			match(MATH_OP_HIGH_PRIORITY);
			setState(263);
			math_operand();
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

	public static class DigitContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public Floating_pointContext floating_point() {
			return getRuleContext(Floating_pointContext.class,0);
		}
		public DigitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDigit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDigit(this);
		}
	}

	public final DigitContext digit() throws RecognitionException {
		DigitContext _localctx = new DigitContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_digit);
		try {
			setState(267);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				integer();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				floating_point();
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CParser.INT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(INT);
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

	public static class Floating_pointContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(CParser.FLOAT, 0); }
		public Floating_pointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floating_point; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterFloating_point(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitFloating_point(this);
		}
	}

	public final Floating_pointContext floating_point() throws RecognitionException {
		Floating_pointContext _localctx = new Floating_pointContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_floating_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(FLOAT);
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

	public static class ParametersListContext extends ParserRuleContext {
		public List<TerminalNode> VALID_C_TYPES() { return getTokens(CParser.VALID_C_TYPES); }
		public TerminalNode VALID_C_TYPES(int i) {
			return getToken(CParser.VALID_C_TYPES, i);
		}
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public List<ParametersListContext> parametersList() {
			return getRuleContexts(ParametersListContext.class);
		}
		public ParametersListContext parametersList(int i) {
			return getRuleContext(ParametersListContext.class,i);
		}
		public ParametersListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterParametersList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitParametersList(this);
		}
	}

	public final ParametersListContext parametersList() throws RecognitionException {
		return parametersList(0);
	}

	private ParametersListContext parametersList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParametersListContext _localctx = new ParametersListContext(_ctx, _parentState);
		ParametersListContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_parametersList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(274);
				match(VALID_C_TYPES);
				setState(279);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(275);
						match(T__10);
						setState(276);
						match(VALID_C_TYPES);
						}
						} 
					}
					setState(281);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(282);
				variable_declaration();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(290);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParametersListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_parametersList);
					setState(285);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(286);
					match(T__10);
					setState(287);
					parametersList(2);
					}
					} 
				}
				setState(292);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class InputParametersListContext extends ParserRuleContext {
		public To_valueContext to_value() {
			return getRuleContext(To_valueContext.class,0);
		}
		public List<InputParametersListContext> inputParametersList() {
			return getRuleContexts(InputParametersListContext.class);
		}
		public InputParametersListContext inputParametersList(int i) {
			return getRuleContext(InputParametersListContext.class,i);
		}
		public InputParametersListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputParametersList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterInputParametersList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitInputParametersList(this);
		}
	}

	public final InputParametersListContext inputParametersList() throws RecognitionException {
		return inputParametersList(0);
	}

	private InputParametersListContext inputParametersList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InputParametersListContext _localctx = new InputParametersListContext(_ctx, _parentState);
		InputParametersListContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_inputParametersList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(294);
				to_value();
				}
				break;
			case 2:
				{
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(303);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InputParametersListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_inputParametersList);
					setState(298);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(299);
					match(T__10);
					setState(300);
					inputParametersList(3);
					}
					} 
				}
				setState(305);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 30:
			return parametersList_sempred((ParametersListContext)_localctx, predIndex);
		case 31:
			return inputParametersList_sempred((InputParametersListContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean parametersList_sempred(ParametersListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean inputParametersList_sempred(InputParametersListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u0135\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\6\2D\n\2\r\2\16\2E\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3[\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\5\5d\n\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6l\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\6u\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7}\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"\u0085\n\b\3\b\5\b\u0088\n\b\3\t\3\t\3\t\3\t\3\t\5\t\u008f\n\t\3\t\3\t"+
		"\5\t\u0093\n\t\3\n\3\n\3\n\3\n\5\n\u0099\n\n\3\n\3\n\3\n\3\13\3\13\7\13"+
		"\u00a0\n\13\f\13\16\13\u00a3\13\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u00b4\n\17\3\17\3\17\5\17\u00b8"+
		"\n\17\3\17\3\17\3\17\5\17\u00bd\n\17\7\17\u00bf\n\17\f\17\16\17\u00c2"+
		"\13\17\3\20\3\20\3\20\3\20\3\20\5\20\u00c9\n\20\3\21\3\21\3\21\3\21\3"+
		"\22\5\22\u00d0\n\22\3\22\3\22\5\22\u00d4\n\22\3\22\3\22\5\22\u00d8\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00e0\n\23\3\24\3\24\3\25\3\25\7\25"+
		"\u00e6\n\25\f\25\16\25\u00e9\13\25\3\26\3\26\7\26\u00ed\n\26\f\26\16\26"+
		"\u00f0\13\26\3\27\3\27\7\27\u00f4\n\27\f\27\16\27\u00f7\13\27\3\30\3\30"+
		"\3\30\3\30\5\30\u00fd\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\35\3\35\5\35\u010e\n\35\3\36\3\36\3\37\3\37\3 "+
		"\3 \3 \3 \7 \u0118\n \f \16 \u011b\13 \3 \5 \u011e\n \3 \3 \3 \7 \u0123"+
		"\n \f \16 \u0126\13 \3!\3!\3!\5!\u012b\n!\3!\3!\3!\7!\u0130\n!\f!\16!"+
		"\u0133\13!\3!\2\4>@\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,."+
		"\60\62\64\668:<>@\2\3\3\2\22\23\u013f\2C\3\2\2\2\4Z\3\2\2\2\6\\\3\2\2"+
		"\2\b_\3\2\2\2\ng\3\2\2\2\fv\3\2\2\2\16~\3\2\2\2\20\u0089\3\2\2\2\22\u0094"+
		"\3\2\2\2\24\u009d\3\2\2\2\26\u00a6\3\2\2\2\30\u00a8\3\2\2\2\32\u00aa\3"+
		"\2\2\2\34\u00af\3\2\2\2\36\u00c8\3\2\2\2 \u00ca\3\2\2\2\"\u00cf\3\2\2"+
		"\2$\u00df\3\2\2\2&\u00e1\3\2\2\2(\u00e3\3\2\2\2*\u00ea\3\2\2\2,\u00f1"+
		"\3\2\2\2.\u00fc\3\2\2\2\60\u00fe\3\2\2\2\62\u0102\3\2\2\2\64\u0105\3\2"+
		"\2\2\66\u0108\3\2\2\28\u010d\3\2\2\2:\u010f\3\2\2\2<\u0111\3\2\2\2>\u011d"+
		"\3\2\2\2@\u012a\3\2\2\2BD\5\4\3\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2"+
		"\2\2F\3\3\2\2\2G[\5\22\n\2H[\5\n\6\2I[\5\f\7\2J[\5\16\b\2KL\5\b\5\2LM"+
		"\7\3\2\2M[\3\2\2\2NO\5\34\17\2OP\7\3\2\2P[\3\2\2\2QR\5$\23\2RS\7\3\2\2"+
		"S[\3\2\2\2TU\5\6\4\2UV\7\3\2\2V[\3\2\2\2WX\5\32\16\2XY\7\3\2\2Y[\3\2\2"+
		"\2ZG\3\2\2\2ZH\3\2\2\2ZI\3\2\2\2ZJ\3\2\2\2ZK\3\2\2\2ZN\3\2\2\2ZQ\3\2\2"+
		"\2ZT\3\2\2\2ZW\3\2\2\2[\5\3\2\2\2\\]\7\4\2\2]^\5\36\20\2^\7\3\2\2\2_`"+
		"\7\27\2\2`a\7\30\2\2ac\7\5\2\2bd\5> \2cb\3\2\2\2cd\3\2\2\2de\3\2\2\2e"+
		"f\7\6\2\2f\t\3\2\2\2gh\7\7\2\2hk\7\5\2\2il\5$\23\2jl\7\30\2\2ki\3\2\2"+
		"\2kj\3\2\2\2lm\3\2\2\2mn\7\3\2\2no\5 \21\2op\7\3\2\2pq\5$\23\2qt\7\6\2"+
		"\2ru\5\24\13\2su\5\4\3\2tr\3\2\2\2ts\3\2\2\2u\13\3\2\2\2vw\7\b\2\2wx\7"+
		"\5\2\2xy\5\"\22\2y|\7\6\2\2z}\5\24\13\2{}\5\4\3\2|z\3\2\2\2|{\3\2\2\2"+
		"}\r\3\2\2\2~\177\7\t\2\2\177\u0080\7\5\2\2\u0080\u0081\5\"\22\2\u0081"+
		"\u0084\7\6\2\2\u0082\u0085\5\24\13\2\u0083\u0085\5\4\3\2\u0084\u0082\3"+
		"\2\2\2\u0084\u0083\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0088\5\20\t\2\u0087"+
		"\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\17\3\2\2\2\u0089\u008e\7\n\2"+
		"\2\u008a\u008b\7\5\2\2\u008b\u008c\5\"\22\2\u008c\u008d\7\6\2\2\u008d"+
		"\u008f\3\2\2\2\u008e\u008a\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0092\3\2"+
		"\2\2\u0090\u0093\5\24\13\2\u0091\u0093\5\4\3\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0091\3\2\2\2\u0093\21\3\2\2\2\u0094\u0095\7\27\2\2\u0095\u0096\7\30"+
		"\2\2\u0096\u0098\7\5\2\2\u0097\u0099\5> \2\u0098\u0097\3\2\2\2\u0098\u0099"+
		"\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7\6\2\2\u009b\u009c\5\24\13\2"+
		"\u009c\23\3\2\2\2\u009d\u00a1\7\13\2\2\u009e\u00a0\5\4\3\2\u009f\u009e"+
		"\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7\f\2\2\u00a5\25\3\2\2"+
		"\2\u00a6\u00a7\t\2\2\2\u00a7\27\3\2\2\2\u00a8\u00a9\7\33\2\2\u00a9\31"+
		"\3\2\2\2\u00aa\u00ab\7\30\2\2\u00ab\u00ac\7\5\2\2\u00ac\u00ad\5@!\2\u00ad"+
		"\u00ae\7\6\2\2\u00ae\33\3\2\2\2\u00af\u00b0\7\27\2\2\u00b0\u00b3\7\30"+
		"\2\2\u00b1\u00b2\7\22\2\2\u00b2\u00b4\5\36\20\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00c0\3\2\2\2\u00b5\u00b7\7\r\2\2\u00b6\u00b8\7\27"+
		"\2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00bc\7\30\2\2\u00ba\u00bb\7\22\2\2\u00bb\u00bd\5\36\20\2\u00bc\u00ba"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00b5\3\2\2\2\u00bf"+
		"\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\35\3\2\2"+
		"\2\u00c2\u00c0\3\2\2\2\u00c3\u00c9\7\30\2\2\u00c4\u00c9\58\35\2\u00c5"+
		"\u00c9\5\30\r\2\u00c6\u00c9\5\32\16\2\u00c7\u00c9\5&\24\2\u00c8\u00c3"+
		"\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c7\3\2\2\2\u00c9\37\3\2\2\2\u00ca\u00cb\5\36\20\2\u00cb\u00cc\7\25"+
		"\2\2\u00cc\u00cd\5\36\20\2\u00cd!\3\2\2\2\u00ce\u00d0\7\5\2\2\u00cf\u00ce"+
		"\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\5 \21\2\u00d2"+
		"\u00d4\7\6\2\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d7\3\2"+
		"\2\2\u00d5\u00d6\7\26\2\2\u00d6\u00d8\5\"\22\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8#\3\2\2\2\u00d9\u00da\7\30\2\2\u00da\u00db\5\26\f"+
		"\2\u00db\u00dc\5\36\20\2\u00dc\u00e0\3\2\2\2\u00dd\u00de\7\30\2\2\u00de"+
		"\u00e0\7\24\2\2\u00df\u00d9\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0%\3\2\2\2"+
		"\u00e1\u00e2\5(\25\2\u00e2\'\3\2\2\2\u00e3\u00e7\5*\26\2\u00e4\u00e6\5"+
		"\62\32\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8)\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ee\5,\27\2"+
		"\u00eb\u00ed\5\64\33\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec"+
		"\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef+\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1"+
		"\u00f5\5.\30\2\u00f2\u00f4\5\66\34\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3"+
		"\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6-\3\2\2\2\u00f7\u00f5"+
		"\3\2\2\2\u00f8\u00fd\58\35\2\u00f9\u00fd\7\30\2\2\u00fa\u00fd\5\32\16"+
		"\2\u00fb\u00fd\5\60\31\2\u00fc\u00f8\3\2\2\2\u00fc\u00f9\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd/\3\2\2\2\u00fe\u00ff\7\5\2\2"+
		"\u00ff\u0100\5&\24\2\u0100\u0101\7\6\2\2\u0101\61\3\2\2\2\u0102\u0103"+
		"\7\20\2\2\u0103\u0104\5*\26\2\u0104\63\3\2\2\2\u0105\u0106\7\16\2\2\u0106"+
		"\u0107\5,\27\2\u0107\65\3\2\2\2\u0108\u0109\7\17\2\2\u0109\u010a\5.\30"+
		"\2\u010a\67\3\2\2\2\u010b\u010e\5:\36\2\u010c\u010e\5<\37\2\u010d\u010b"+
		"\3\2\2\2\u010d\u010c\3\2\2\2\u010e9\3\2\2\2\u010f\u0110\7\31\2\2\u0110"+
		";\3\2\2\2\u0111\u0112\7\32\2\2\u0112=\3\2\2\2\u0113\u0114\b \1\2\u0114"+
		"\u0119\7\27\2\2\u0115\u0116\7\r\2\2\u0116\u0118\7\27\2\2\u0117\u0115\3"+
		"\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011e\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011e\5\34\17\2\u011d\u0113\3"+
		"\2\2\2\u011d\u011c\3\2\2\2\u011e\u0124\3\2\2\2\u011f\u0120\f\3\2\2\u0120"+
		"\u0121\7\r\2\2\u0121\u0123\5> \4\u0122\u011f\3\2\2\2\u0123\u0126\3\2\2"+
		"\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125?\3\2\2\2\u0126\u0124"+
		"\3\2\2\2\u0127\u0128\b!\1\2\u0128\u012b\5\36\20\2\u0129\u012b\3\2\2\2"+
		"\u012a\u0127\3\2\2\2\u012a\u0129\3\2\2\2\u012b\u0131\3\2\2\2\u012c\u012d"+
		"\f\4\2\2\u012d\u012e\7\r\2\2\u012e\u0130\5@!\5\u012f\u012c\3\2\2\2\u0130"+
		"\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132A\3\2\2\2"+
		"\u0133\u0131\3\2\2\2!EZckt|\u0084\u0087\u008e\u0092\u0098\u00a1\u00b3"+
		"\u00b7\u00bc\u00c0\u00c8\u00cf\u00d3\u00d7\u00df\u00e7\u00ee\u00f5\u00fc"+
		"\u010d\u0119\u011d\u0124\u012a\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}