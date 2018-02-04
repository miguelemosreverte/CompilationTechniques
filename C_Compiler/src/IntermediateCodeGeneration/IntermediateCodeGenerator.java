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
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author Migue
 */
public class IntermediateCodeGenerator{

    
    
    
    /*
    
    
    mathPass(x, b*b + 2 * f(b))
    
    t4:= f(b)
    t3:= 2 * t4       
    t2:= b * b
    t1:= t2 + t3 
    x:= t0
    
    
    
    
                        
    
    
    
    
    
    
    
    */
    static private NavigableMap<Integer, String> intermediateCode_fromLinesToCode= new TreeMap<>();
    static private String intermediateCode = "";
    
    public static void printIntermediateCode(){
        
        /*intermediateCode_fromLinesToCode.forEach((lineNumber, code) -> {
            System.out.println(code);        
        });*/
        System.out.println(intermediateCode);  
        
        
    }
    
    public static void enterF_p(CParser.F_pContext ctx) {
        
                

    }

    public static void enterF_d(CParser.F_dContext ctx, Runnable function) {

    }

    
    public static void enterF_c(CParser.F_cContext ctx) {

        
    }

    public static void enterAssignation(CParser.AssignationContext ctx) {
        Integer lineNumber = ctx.start.getLine();
        String prefix = ctx.ID() + " := ";
        String code = to_value_TAC(prefix, ctx.to_value());
        intermediateCode_fromLinesToCode.put(lineNumber, code);
        intermediateCode += code + "\n";
    }

    public static void enterTo_value(CParser.To_valueContext ctx) {
        Integer lineNumber = ctx.start.getLine();
        String code = ctx.getText();
        intermediateCode_fromLinesToCode.put(lineNumber, code);
        intermediateCode += code + "\n";

    }
    
    public static String math_operation_TAC(CParser.Math_operationContext ctx){
        String result = "";
        
        result += "\n---math_operation_TAC\n";
        
       
        
        List<String> names = new ArrayList();
        names.add("operand1");
        names.add("operation");
        names.add("operand2");
        
        List<Quad> quads = new ArrayList();
        
        
        int identifier = 1;
        Quad quad = new Quad();
                        

        quad.addByIndex(0, "t_0" + ":=");        
        for (int i = 0; i < 3; i++){
            quad.addByIndex(i + 1, ctx.children.get(i).getText());
        }
        quads.add(quad);
        quad = new Quad();
                
        
        int ammountOfElementsToAddPerQuad = 2;
        for (int i = 3; i < ctx.children.size(); i++){
            
            int offset = (i-1) % ammountOfElementsToAddPerQuad;
          
            quad.addByIndex(offset + 2, ctx.children.get(i).getText());
                
            if (offset == ammountOfElementsToAddPerQuad - 1){
                quad.addByIndex(0, "t_" + identifier + ":=");
                quad.addByIndex(1, "t_" + String.valueOf(identifier - 1));
                
                
                quads.add(quad);
                quad = new Quad();
                
                identifier += 1;        
            }
            
            
        }
        
        for (Quad q : quads){
            result += q.toString() + "\n"; 
        
        }
        result += "---";
        return result;
    }
    
    public static String to_value_TAC(String return_to, CParser.To_valueContext ctx) {
        
        List<String> TAC_array = new ArrayList <>();
        if (ctx.math_operation() != null){
            
            
            TAC_array.add(math_operation_TAC(ctx.math_operation()));
        
        }
        if (ctx.f_c()!= null){
            
            
            TAC_array.add("fc" + ctx.f_c().toString());
        
        }
        if (ctx.digit() != null){
            TAC_array.add("digit " + ctx.getText());
        }
        
        if (ctx.ID()!= null){
            TAC_array.add("ID " + ctx.getText());
        }
        
        
        
        Integer lastIndex = TAC_array.size()-1;
        TAC_array.set(lastIndex, return_to +  TAC_array.get(lastIndex));
        return String.join("\n", TAC_array);
    }

    public static void enterVariable_declaration(CParser.Variable_declarationContext ctx) {
        List<String> codeList = new ArrayList<>() ;
        for (int i = 0; i < ctx.ID().size(); i++) {
            String prefix = ctx.ID(i) + " := ";
            String code = to_value_TAC(prefix, ctx.to_value(i));
            codeList.add(code);
            
        }
        
        Integer lineNumber = ctx.start.getLine();
        intermediateCode_fromLinesToCode.put(lineNumber, String.join("\n", codeList));
        intermediateCode += String.join("\n", codeList) + "\n";
        
    }


    

}
