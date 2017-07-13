/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;

import C_ANTLR.CParser;
import Scope.Scope;
import Scope.ScopeUtils;
import Scope.ScopeUtilsDependencyInjector;
import Symbol.AbstractSymbol;
import Symbol.FunctionSymbol;
import Symbol.Symbol;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableMap;
import java.util.Stack;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

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

    public static void enterF_d(CParser.F_dContext ctx) {

        Scope currentScope = temporal_scopes.peek();
        String functionName = ctx.ID().getText();

        checkFunctionPrototype(functionName, Integer.toString(ctx.start.getLine()), currentScope);

        Scope correspondingScope = ScopeUtilsDependencyInjector.getCorrespondingScope(functionName);
        FunctionSymbol functionSymbol = ((FunctionSymbol) correspondingScope.symbols.get(functionName));
        correspondingScope.symbols.get(functionName).toString();

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

    }

    public static void enterAssignation(CParser.AssignationContext ctx) {

        Scope currentScope = symbolsTable.floorEntry(ctx.start.getLine()).getValue();
        try {
            ((Symbol) currentScope.symbols.get(ctx.ID().getText())).setValue("initialized");

            checkVarName(ctx.ID().getText(), Integer.toString(ctx.start.getLine()), currentScope);
        } catch (NullPointerException e) {
        }

    }

    public static void enterTo_value(CParser.To_valueContext ctx) throws CErrorException {

        //first we get the current scope
        Scope currentScope = symbolsTable.floorEntry(ctx.start.getLine()).getValue();

        List<String> childrensID = Utils.getChildrensID_from_ToValue(ctx);
        childrensID.forEach(ID
                -> {
            Integer declaredAtLine = currentScope.declaredAtLineNumber(ID);

            checkVarName(ID, Integer.toString(ctx.start.getLine()), currentScope);
            Scope correspondingScope = symbolsTable.floorEntry(declaredAtLine).getValue();
            AbstractSymbol currentSymbol = correspondingScope.symbols.get(ID);

            correspondingScope.unused_symbols.remove(currentSymbol);

            if (((Symbol) currentSymbol).getValue().isEmpty()) {
                throw new CErrorException(
                        "Use of uninitialized identifier \""
                        + currentSymbol.getID()
                        + "\" at line number "
                        + declaredAtLine
                );
            }
        });

    }

    public static void enterVariable_declaration(CParser.Variable_declarationContext ctx) {

        Scope currentScope = symbolsTable.floorEntry(ctx.start.getLine()).getValue();
        List<String> values = ctx.to_value().isEmpty()
                ? new ArrayList<>()
                : ctx.to_value().stream().map(i -> i.getText()).collect(Collectors.toList());

        List<String> valuesTypes = ctx.to_value().isEmpty()
                ? new ArrayList<>()
                : ctx.to_value().stream().map(i -> i.getClass().getName())
                .collect(Collectors.toList());

        //check for each of the values used that their returned type matches the one
        //used in the variable declaration
        boolean allValuesHaveCorrectType = true;
        for (CParser.To_valueContext toValue : ctx.to_value()) {
            allValuesHaveCorrectType = allValuesHaveCorrectType && ScopeUtilsDependencyInjector.hasDifferentTypes(ctx.VALID_C_TYPES(0).getText(), toValue);
            if (!allValuesHaveCorrectType) {
                break;
            }
        }

        //Release warnings in case of truncations or char to int initializations
        ctx.to_value().forEach(id -> {
            id.children.forEach((ParseTree children) -> {
                String simpleClassname = children.getClass().getSimpleName();
                if ("DigitContext".equals(simpleClassname)) {
                    //specify the type of digit to be either float or int
                    simpleClassname = children.getChild(0).getClass().getSimpleName();
                }
                String type = ctx.VALID_C_TYPES().toString().replace("[", "").replace("]", "");
                String newValueType = ScopeUtils.rulesContextsToType.get(simpleClassname);

                if (ScopeUtils.dangerousTransformations.containsKey(newValueType)
                        && ScopeUtils.dangerousTransformations.get(newValueType).equals(type)) {
                    System.out.println("Warning: Converting from  " + newValueType
                            + " to " + type + " at line " + id.start.getLine());

                }
            });
        });

        for (int i = 0; i < ctx.ID().size(); i++) {
            //And finally add the complete symbol to the symbols table
            Symbol newSymbol = new Symbol(ctx.ID(i).getText(),
                    (ctx.VALID_C_TYPES(i) != null) ? ctx.VALID_C_TYPES(i).toString() : "",
                    (ctx.to_value(i) != null) ? values.get(i) : "",
                    Integer.toString(ctx.start.getLine())
            );

            RuleContext parentCtx = ctx.parent;
            //go up until the context is no longer ParametersListContext
            while ("ParametersListContext".equals(parentCtx.getClass().getSimpleName())) {
                parentCtx = parentCtx.parent;
            }

            if (!"F_pContext".equals(parentCtx.getClass().getSimpleName())) {
                currentScope.addSymbol(newSymbol);
            }

            if (!"ParametersListContext".equals(ctx.parent.getClass().getSimpleName())) {
                currentScope.unused_symbols.add(newSymbol);
            }
        }
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
