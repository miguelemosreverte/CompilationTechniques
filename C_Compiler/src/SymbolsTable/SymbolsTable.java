/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SymbolsTable;

import Scope.Scope;
import Symbol.AbstractSymbol;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Stack;
import java.util.TreeMap;

/**
 *
 * @author miguel
 */
public enum SymbolsTable {    
    INSTANCE;
    public final Stack<Scope> temporal_scopes = new Stack<>();
    public final NavigableMap<Integer, Scope> symbolsTable = new TreeMap<>();
    public final HashSet<AbstractSymbol> all_unusedSymbols = new HashSet<>();
    
}
