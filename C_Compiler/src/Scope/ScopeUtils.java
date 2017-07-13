/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scope;

import Symbol.AbstractSymbol;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;

public class ScopeUtils {

    public static enum CONVERSIONS_RANK {
        CHAR,
        SHORT,
        INT,
        LONG,
        LONGLONG;
    }

    public static final Map<String, CONVERSIONS_RANK> TYPES_TO_CONVERSION_RANK = new HashMap<String, CONVERSIONS_RANK>() {
        {
            put("char", CONVERSIONS_RANK.CHAR);
            put("int", CONVERSIONS_RANK.INT);
            put("float", CONVERSIONS_RANK.LONG);
            put("double", CONVERSIONS_RANK.LONGLONG);
        }
    };

    public static final Map<String, String> typeToRulesContexts = new HashMap<String, String>() {
        {
            put("int", "IntegerContext");
            put("float", "Floating_pointContext");
            put("char", "StringContext");
        }
    };

    public static final Map<String, String> rulesContextsToType = new HashMap<String, String>() {
        {
            put("IntegerContext", "int");
            put("Floating_pointContext", "float");
            put("StringContext", "char");
        }
    };

    public static Scope getCorrespondingScope(String varName, Scope currentScope, NavigableMap<Integer, Scope> symbolsTable) {
        return symbolsTable.floorEntry(currentScope.declaredAtLineNumber(varName)).getValue();
    }

    public static String getTypeFromVarName(String varName, Integer declaredAtLine, NavigableMap<Integer, Scope> symbolsTable) {
        //we get the corresponding scope
        Scope correspondingScope = symbolsTable.floorEntry(declaredAtLine).getValue();
        //and then we get the symbol by its name
        AbstractSymbol currentSymbol = correspondingScope.symbols.get(varName);
        //finally we return its type
        return currentSymbol.getType();

    }

    public static enum typesHierarchy {
        INT, LONG, FLOAT, DOUBLE, LONGDOUBLE
    }

}
