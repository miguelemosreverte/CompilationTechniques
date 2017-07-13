/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scope;

import C_ANTLR.CParser;
import Symbol.AbstractSymbol;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Stack;

/**
 *
 * @author Migue
 */
public class ScopeUtilsDependencyInjector {

    private static Stack<Scope> temporal_scopes;
    private static NavigableMap<Integer, Scope> symbolsTable;
    private static HashSet<AbstractSymbol> all_unusedSymbols;

    public static boolean hasDifferentTypes(String originalType, CParser.To_valueContext toValue) {

        return ScopeUtils.hasDifferentTypes(originalType, toValue, symbolsTable);

    }

    public static Scope getCorrespondingScope(String varName) {

        return ScopeUtils.getCorrespondingScope(varName, temporal_scopes.peek(), symbolsTable);

    }

    public static void initializeStaticVariables(Stack<Scope> temporal_scopes, NavigableMap<Integer, Scope> symbolsTable, HashSet<AbstractSymbol> all_unusedSymbols) {
        ScopeUtilsDependencyInjector.symbolsTable = symbolsTable;
        ScopeUtilsDependencyInjector.all_unusedSymbols = all_unusedSymbols;
        ScopeUtilsDependencyInjector.temporal_scopes = temporal_scopes;
    }

    public String getTypeFromVarName(String varName, Integer declaredAtLine) {

        return ScopeUtils.getTypeFromVarName(varName, declaredAtLine, symbolsTable);

    }

}
