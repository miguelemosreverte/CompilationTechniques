/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;

import C_ANTLR.CBaseListener;
import C_ANTLR.CParser;

/**
 *
 * @author Migue
 */
public class Visitor extends CBaseListener {

    VisitorHelper VisitorHelperInstance = new VisitorHelper();

    public Visitor() {
    }

    @Override
    public void enterVariable_declaration(CParser.Variable_declarationContext ctx) {

        EnterRules.enterVariable_declaration(ctx);

    }

    @Override
    public void enterF_p(CParser.F_pContext ctx) {

        EnterRules.enterF_p(ctx);

    }

    @Override
    public void enterF_c(CParser.F_cContext ctx) {

        EnterRules.enterF_c(ctx);

    }

    @Override
    public void enterTo_value(CParser.To_valueContext ctx) throws CErrorException {

        EnterRules.enterTo_value(ctx);

    }

    @Override
    public void enterAssignation(CParser.AssignationContext ctx) throws CErrorException {

        EnterRules.enterAssignation(ctx);

    }

    @Override
    public void enterF_d(CParser.F_dContext ctx) {
        EnterRules.enterF_d(ctx);
        enterScope(ctx);
    }

    @Override
    public void enterIf_condition(CParser.If_conditionContext ctx) {
        enterScope(ctx);
    }

    @Override
    public void enterElse_condition(CParser.Else_conditionContext ctx) {
        enterScope(ctx);
    }

    @Override
    public void enterWhile_loop(CParser.While_loopContext ctx) {
        enterScope(ctx);
    }

    @Override
    public void enterFor_loop(CParser.For_loopContext ctx) {
        enterScope(ctx);
    }

    @Override
    public void exitCode_block(CParser.Code_blockContext ctx) {
        EnterRules.leaveScope(ctx);
    }

    private void enterScope(CParser.For_loopContext ctx) {
        if (ctx.code_block() != null) {
            EnterRules.enterScopeAtLineNumber(ctx.start.getLine());
        }
    }

    private void enterScope(CParser.While_loopContext ctx) {
        if (ctx.code_block() != null) {
            EnterRules.enterScopeAtLineNumber(ctx.start.getLine());
        }
    }

    private void enterScope(CParser.If_conditionContext ctx) {
        if (ctx.code_block() != null) {
            EnterRules.enterScopeAtLineNumber(ctx.start.getLine());
        }
    }

    private void enterScope(CParser.Else_conditionContext ctx) {
        if (ctx.code_block() != null) {
            EnterRules.enterScopeAtLineNumber(ctx.start.getLine());
        }
    }

    private void enterScope(CParser.F_dContext ctx) {
        if (ctx.code_block() != null) {
            EnterRules.enterScopeAtLineNumber(ctx.start.getLine());
        }
    }

    public void printUnusedSymbols() {
        if (!EnterRules.all_unusedSymbols.isEmpty()) {
            System.out.println("Warning: Unused symbols \n   "
                    + EnterRules.all_unusedSymbols.toString().replace(", ", "\n   ").replace("[", "").replace("]", ""));
        }
    }

}
