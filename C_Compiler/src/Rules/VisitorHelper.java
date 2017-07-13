/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;

import Scope.Scope;
import Scope.ScopeUtilsDependencyInjector;
import Symbol.AbstractSymbol;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Stack;
import java.util.TreeMap;

/**
 *
 * @author Migue
 */
public class VisitorHelper {

    private final Stack<Scope> temporal_scopes = new Stack<>();
    private final NavigableMap<Integer, Scope> symbolsTable = new TreeMap<>();
    private final HashSet<AbstractSymbol> all_unusedSymbols = new HashSet<>();

    public VisitorHelper() {

        temporal_scopes.push(new Scope(null));
        symbolsTable.put(0, temporal_scopes.peek());

        EnterRules.initializeStaticVariables(temporal_scopes, symbolsTable, all_unusedSymbols);
        ScopeUtilsDependencyInjector.initializeStaticVariables(temporal_scopes, symbolsTable, all_unusedSymbols);

    }

}
