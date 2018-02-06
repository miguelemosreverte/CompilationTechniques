// Generated from /home/miguel/Desktop/CompilationTechniques/C_Compiler/src/C_ANTLR/C.g4 by ANTLR 4.5.3
package C_ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CParser}.
 */
public interface CListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(CParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(CParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#ret}.
	 * @param ctx the parse tree
	 */
	void enterRet(CParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#ret}.
	 * @param ctx the parse tree
	 */
	void exitRet(CParser.RetContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#f_p}.
	 * @param ctx the parse tree
	 */
	void enterF_p(CParser.F_pContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#f_p}.
	 * @param ctx the parse tree
	 */
	void exitF_p(CParser.F_pContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#for_loop}.
	 * @param ctx the parse tree
	 */
	void enterFor_loop(CParser.For_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#for_loop}.
	 * @param ctx the parse tree
	 */
	void exitFor_loop(CParser.For_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#while_loop}.
	 * @param ctx the parse tree
	 */
	void enterWhile_loop(CParser.While_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#while_loop}.
	 * @param ctx the parse tree
	 */
	void exitWhile_loop(CParser.While_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#if_condition}.
	 * @param ctx the parse tree
	 */
	void enterIf_condition(CParser.If_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#if_condition}.
	 * @param ctx the parse tree
	 */
	void exitIf_condition(CParser.If_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#else_condition}.
	 * @param ctx the parse tree
	 */
	void enterElse_condition(CParser.Else_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#else_condition}.
	 * @param ctx the parse tree
	 */
	void exitElse_condition(CParser.Else_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#f_d}.
	 * @param ctx the parse tree
	 */
	void enterF_d(CParser.F_dContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#f_d}.
	 * @param ctx the parse tree
	 */
	void exitF_d(CParser.F_dContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#code_block}.
	 * @param ctx the parse tree
	 */
	void enterCode_block(CParser.Code_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#code_block}.
	 * @param ctx the parse tree
	 */
	void exitCode_block(CParser.Code_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void enterAssign_op(CParser.Assign_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void exitAssign_op(CParser.Assign_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(CParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(CParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#f_c}.
	 * @param ctx the parse tree
	 */
	void enterF_c(CParser.F_cContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#f_c}.
	 * @param ctx the parse tree
	 */
	void exitF_c(CParser.F_cContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declaration(CParser.Variable_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declaration(CParser.Variable_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#to_value}.
	 * @param ctx the parse tree
	 */
	void enterTo_value(CParser.To_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#to_value}.
	 * @param ctx the parse tree
	 */
	void exitTo_value(CParser.To_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#comparation}.
	 * @param ctx the parse tree
	 */
	void enterComparation(CParser.ComparationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#comparation}.
	 * @param ctx the parse tree
	 */
	void exitComparation(CParser.ComparationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#logic_op}.
	 * @param ctx the parse tree
	 */
	void enterLogic_op(CParser.Logic_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#logic_op}.
	 * @param ctx the parse tree
	 */
	void exitLogic_op(CParser.Logic_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#assignation}.
	 * @param ctx the parse tree
	 */
	void enterAssignation(CParser.AssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#assignation}.
	 * @param ctx the parse tree
	 */
	void exitAssignation(CParser.AssignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#unapplied}.
	 * @param ctx the parse tree
	 */
	void enterUnapplied(CParser.UnappliedContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#unapplied}.
	 * @param ctx the parse tree
	 */
	void exitUnapplied(CParser.UnappliedContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#low_op}.
	 * @param ctx the parse tree
	 */
	void enterLow_op(CParser.Low_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#low_op}.
	 * @param ctx the parse tree
	 */
	void exitLow_op(CParser.Low_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#medium_op}.
	 * @param ctx the parse tree
	 */
	void enterMedium_op(CParser.Medium_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#medium_op}.
	 * @param ctx the parse tree
	 */
	void exitMedium_op(CParser.Medium_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#high_op}.
	 * @param ctx the parse tree
	 */
	void enterHigh_op(CParser.High_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#high_op}.
	 * @param ctx the parse tree
	 */
	void exitHigh_op(CParser.High_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#math_operation}.
	 * @param ctx the parse tree
	 */
	void enterMath_operation(CParser.Math_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#math_operation}.
	 * @param ctx the parse tree
	 */
	void exitMath_operation(CParser.Math_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#math_operand}.
	 * @param ctx the parse tree
	 */
	void enterMath_operand(CParser.Math_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#math_operand}.
	 * @param ctx the parse tree
	 */
	void exitMath_operand(CParser.Math_operandContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#grouped}.
	 * @param ctx the parse tree
	 */
	void enterGrouped(CParser.GroupedContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#grouped}.
	 * @param ctx the parse tree
	 */
	void exitGrouped(CParser.GroupedContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#digit}.
	 * @param ctx the parse tree
	 */
	void enterDigit(CParser.DigitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#digit}.
	 * @param ctx the parse tree
	 */
	void exitDigit(CParser.DigitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(CParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(CParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#floating_point}.
	 * @param ctx the parse tree
	 */
	void enterFloating_point(CParser.Floating_pointContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#floating_point}.
	 * @param ctx the parse tree
	 */
	void exitFloating_point(CParser.Floating_pointContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#parametersList}.
	 * @param ctx the parse tree
	 */
	void enterParametersList(CParser.ParametersListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#parametersList}.
	 * @param ctx the parse tree
	 */
	void exitParametersList(CParser.ParametersListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#inputParametersList}.
	 * @param ctx the parse tree
	 */
	void enterInputParametersList(CParser.InputParametersListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#inputParametersList}.
	 * @param ctx the parse tree
	 */
	void exitInputParametersList(CParser.InputParametersListContext ctx);
}