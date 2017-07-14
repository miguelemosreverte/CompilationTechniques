/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;

import C_ANTLR.CParser;
import static Rules.Utils.getParentFromParameterList;
import Scope.Scope;
import Scope.ScopeUtilsDependencyInjector;
import Symbol.AbstractSymbol;
import Symbol.FunctionSymbol;
import Symbol.VariableSymbol;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableMap;
import java.util.Stack;

/**
 *
 * @author Migue
 */
public class EnterRules extends RulesChecks {

    static private Stack<Scope> temporal_scopes;
    static private NavigableMap<Integer, Scope> symbolsTable;
    static public HashSet<AbstractSymbol> all_unusedSymbols;

    public static void enterF_p(CParser.F_pContext ctx) {

        Scope currentScope = temporal_scopes.peek();
        String functionName = ctx.ID().getText();

        List<String> flattenedParametersTypes = Utils.getParametersTypesList(ctx.parametersList().children);

        FunctionSymbol newSymbol = new FunctionSymbol(ctx.ID().getText(),
                ctx.VALID_C_TYPES().toString(),
                flattenedParametersTypes,
                Integer.toString(ctx.start.getLine()),
                true
        );
        currentScope.addSymbol(newSymbol);

    }

    public static void enterF_d(CParser.F_dContext ctx, Runnable function) {

        Scope currentScope = temporal_scopes.peek();
        function.run();
        String functionName = ctx.ID().getText();

        checkFunctionPrototype(functionName, Integer.toString(ctx.start.getLine()), currentScope);

        Scope correspondingScope = ScopeUtilsDependencyInjector.getCorrespondingScope(functionName);
        FunctionSymbol functionSymbol = ((FunctionSymbol) currentScope.symbols.get(functionName));

        if (!Utils.getParametersTypesList(ctx.parametersList().children).equals(functionSymbol.getParameters())) {
            throw new CErrorException(
                    "The parameters from the function declaration \""
                    + functionName
                    + "\" at line number "
                    + ctx.start.getLine()
                    + "are not the same as the function prototype declared at line number "
                    + functionSymbol.getLineNumber()
            );
        } else {
            functionSymbol.setDeclared(true);
        }
    }

    /**
     *
     * @param ctx Checks that the used functions had been previously prototyped
     * and declared
     */
    public static void enterF_c(CParser.F_cContext ctx) {

        checkFunctionPrototype(ctx.ID().getText(), Integer.toString(ctx.start.getLine()), temporal_scopes.peek());
        checkFunctionDeclaration(ctx.ID().getText(), Integer.toString(ctx.start.getLine()), temporal_scopes.peek());

        List<String> inputParametersType = Utils.getChildrensType(ctx);
        System.out.println(inputParametersType);

    }

    public static void enterAssignation(CParser.AssignationContext ctx) {

        Scope currentScope = symbolsTable.floorEntry(ctx.start.getLine()).getValue();
        try {
            ((VariableSymbol) currentScope.symbols.get(ctx.ID().getText())).setValue("initialized");

            checkVarName(ctx.ID().getText(), Integer.toString(ctx.start.getLine()), currentScope);
        } catch (NullPointerException e) {
        }

    }

    public static void enterTo_value(CParser.To_valueContext ctx) throws CErrorException {

        //first we get the current scope
        Scope currentScope = symbolsTable.floorEntry(ctx.start.getLine()).getValue();

        List<String> childrensID = Utils.getChildrensID(ctx);

        childrensID.forEach(ID
                -> {
            Integer declaredAtLine = currentScope.declaredAtLineNumber(ID);

            checkVarName(ID, Integer.toString(ctx.start.getLine()), currentScope);
            Scope correspondingScope = symbolsTable.floorEntry(declaredAtLine).getValue();
            AbstractSymbol currentSymbol = correspondingScope.symbols.get(ID);

            correspondingScope.unused_symbols.remove(currentSymbol);

            if (currentSymbol instanceof VariableSymbol) {
                checkVarInitialization((VariableSymbol) currentSymbol, declaredAtLine);
            }

        });

    }

    public static void enterVariable_declaration(CParser.Variable_declarationContext ctx) {

        Scope currentScope = temporal_scopes.peek();

        for (int i = 0; i < ctx.ID().size(); i++) {
            //add the complete symbol to the symbols table
            VariableSymbol newSymbol = new VariableSymbol(ctx.ID(i).getText(),
                    (ctx.VALID_C_TYPES(i) != null) ? ctx.VALID_C_TYPES(i).toString() : "",
                    (ctx.to_value(i) != null) ? ctx.to_value(i).getText() : "",
                    Integer.toString(ctx.start.getLine())
            );

            if (ctx.parent instanceof CParser.ParametersListContext) {
                newSymbol.setValue("MaybeWasParametrized");
                CParser.ParametersListContext parent = (CParser.ParametersListContext) ctx.parent;
                if (!"F_pContext".equals(getParentFromParameterList(parent))) {
                    currentScope.addSymbol(newSymbol);
                } else {

                    currentScope.addSymbol(newSymbol);
                }
            } else {
                currentScope.addSymbol(newSymbol);
            }
            if (!"ParametersListContext".equals(ctx.parent.getClass().getSimpleName())) {
                currentScope.unused_symbols.add(newSymbol);
            }
        }

        List<String> childrensID = Utils.getChildrensID(ctx);
        //Release warnings in case of truncations or char to int initializations
        /*if (ScopeUtils.TYPES_TO_CONVERSION_RANK.get(newValueType).compareTo(ScopeUtils.TYPES_TO_CONVERSION_RANK.get(type))
                        < 0) {
                    System.out.println("Warning: Converting from  " + newValueType
                            + " to " + type + " at line " + id.start.getLine());

                }*/
    }

    static public void enterScopeAtLineNumber(Integer lineNumber) {
        temporal_scopes.push(new Scope(temporal_scopes.peek()));
        symbolsTable.put(lineNumber, temporal_scopes.peek());
    }

    static public void leaveScope(CParser.Code_blockContext ctx) {
        Scope pop = temporal_scopes.pop();
        HashSet<AbstractSymbol> in_unusedSymbols = new HashSet<>();
        pop.GetAllUnusedSymbols(in_unusedSymbols);
        all_unusedSymbols.addAll(in_unusedSymbols);
    }

    public static void initializeStaticVariables(Stack<Scope> temporal_scopes, NavigableMap<Integer, Scope> symbolsTable, HashSet<AbstractSymbol> all_unusedSymbols) {
        EnterRules.symbolsTable = symbolsTable;
        EnterRules.all_unusedSymbols = all_unusedSymbols;
        EnterRules.temporal_scopes = temporal_scopes;

    }

}
