/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermediateCodeGeneration;

import C_ANTLR.CParser;
import Scope.Scope;
import Symbol.AbstractSymbol;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableMap;
import java.util.Stack;
import java.util.TreeMap;

/**
 *
 * @author Migue
 */
public class IntermediateCodeGenerator{

    static private NavigableMap<Integer, String> intermediateCode= new TreeMap<>();
    
    public static void printIntermediateCode(){
        
        intermediateCode.forEach((lineNumber, code) -> {
            System.out.println(code);        
        });
        
        
        
    }
    
    public static void enterF_p(CParser.F_pContext ctx) {
        
                

    }

    public static void enterF_d(CParser.F_dContext ctx, Runnable function) {

    }

    
    public static void enterF_c(CParser.F_cContext ctx) {

        
    }

    public static void enterAssignation(CParser.AssignationContext ctx) {
        Integer lineNumber = ctx.start.getLine();
        String code = ctx.ID() + " := " + ctx.to_value().getText();
        intermediateCode.put(lineNumber, code);
    }

    public static void enterTo_value(CParser.To_valueContext ctx) {


    }

    public static void enterVariable_declaration(CParser.Variable_declarationContext ctx) {
        List<String> codeList = new ArrayList<>() ;
        for (int i = 0; i < ctx.ID().size(); i++) {
            String code = ctx.ID(i) + " := " + ctx.to_value(i).getText();
            codeList.add(code);
            
        }
        
        Integer lineNumber = ctx.start.getLine();
        intermediateCode.put(lineNumber, String.join("\n", codeList));
        
    }


    

}
