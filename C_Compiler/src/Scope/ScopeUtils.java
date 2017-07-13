/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scope;

import C_ANTLR.CParser;
import Symbol.AbstractSymbol;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;


public class ScopeUtils {

 
    public static final Map<String, String> dangerousTransformations = new HashMap<String, String>(){
        {
            put("char", "int");
            put("float", "int");
        }
    };
    
    
    public static final Map<String, String> typeToRulesContexts = new HashMap<String, String>(){
        {
            put("int","IntegerContext");
            put("float","Floating_pointContext");
            put("char","StringContext");
        }
    };
    
    
    
    public static final Map<String, String> rulesContextsToType = new HashMap<String, String>(){
        {
            put("IntegerContext", "int");
            put("Floating_pointContext", "float");
            put("StringContext", "char");
        }
    };
    
    
    
    
    public static boolean hasDifferentTypes(String originalType, CParser.To_valueContext toValue,NavigableMap<Integer, Scope> symbolsTable){


        return false;
    }
    
    public static Scope getCorrespondingScope(String varName, Scope currentScope, NavigableMap<Integer, Scope> symbolsTable){
        
        return symbolsTable.floorEntry(currentScope.declaredAtLineNumber(varName)).getValue();
    }

    public static String getTypeFromVarName(String varName, Integer declaredAtLine, NavigableMap<Integer, Scope> symbolsTable){
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
