/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_lemos;

import java.util.HashSet;

/**
 *
 * @author Migue
 */
class Scope {
    HashSet<String> identificators;
    HashSet<Symbol> symbols;
    final Scope parent;

    public Scope(Scope parent) {
        this.parent = parent;
        identificators = new HashSet<>();
        symbols = new HashSet<>();
    }

    boolean inScope(String varName) {
        if(identificators.contains(varName)) {
            return true;
        }
        return parent == null ? false : parent.inScope(varName);
    }
}