/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scope;

import Rules.CErrorException;
import Symbol.AbstractSymbol;
import Symbol.FunctionSymbol;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Migue
 */
public class Scope {

    public HashSet<String> identificators = new HashSet<>();

    public HashMap<String, AbstractSymbol> symbols = new HashMap<>();
    public HashSet<AbstractSymbol> unused_symbols = new HashSet<>();
    final Scope parent;

    public Scope(Scope parent) {
        this.parent = parent;
    }

    public Scope getScope(String identificator) {
        if (identificators.contains(identificator)) {
            return this;
        }
        return parent == null ? null : parent.getScope(identificator);
    }
    
    public boolean inScope(String identificator) {
        if (identificators.contains(identificator)) {
            return true;
        }
        return parent == null ? false : parent.inScope(identificator);
    }

    public boolean isVariableDeclared(String varName) {

        return inScope(varName);
    }

    public boolean isFunctionPrototyped(String functionName) {

        Scope functionScope = getScope(functionName);
        if (functionScope != null){
            return ((FunctionSymbol) functionScope.symbols.get(functionName)).isPrototyped();
        }
        return false;

    }

    public boolean isFunctionDeclared(String functionName) {

        Scope functionScope = getScope(functionName);
        if (functionScope != null){
            return ((FunctionSymbol) functionScope.symbols.get(functionName)).isDeclared();
        }
        return false;

    }

    public int declaredAtLineNumber(String varName) {
        if (identificators.contains(varName)) {
            if (!"".equals(symbols.get(varName).getLineNumber())) {
                return Integer.parseInt(symbols.get(varName).getLineNumber());
            } else {
                System.out.println(varName + " has no line number");
            }
        }
        return parent == null ? -1 : parent.declaredAtLineNumber(varName);
    }

    public HashSet<AbstractSymbol> GetAllUnusedSymbols(HashSet<AbstractSymbol> in_unusedSymbols) {
        if (unused_symbols != null) {
            in_unusedSymbols.addAll(unused_symbols);
        }

        return parent == null ? in_unusedSymbols : parent.GetAllUnusedSymbols(in_unusedSymbols);
    }

    public void addSymbol(AbstractSymbol newSymbol) {
        int declaredAtLineNumber = declaredAtLineNumber(newSymbol.getID());
        if (declaredAtLineNumber != -1) {
            throw new CErrorException(
                    "Redefinition of " + newSymbol.getID()
                    + " from line " + declaredAtLineNumber
                    + " at line " + newSymbol.getLineNumber()
            );
        } else {
            identificators.add(newSymbol.getID());
            symbols.put(newSymbol.getID(), newSymbol);
        }
    }

    @Override
    public String toString() {
        String message = "Symbols contained by this scope are:\n";
        message = symbols.entrySet().stream().map((pair) -> pair.getValue().toString() + "\n").reduce(message, String::concat);
        return message;

    }
}
