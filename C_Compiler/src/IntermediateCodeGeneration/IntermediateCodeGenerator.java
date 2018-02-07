/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermediateCodeGeneration;

import C_ANTLR.CParser;
import static IntermediateCodeGeneration.MathExpressionParsers.parseMath;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 *
 * @author Migue
 */
public class IntermediateCodeGenerator{

    
    
    
   
    
    static private Integer globalIdentifier = 0;
    static private NavigableMap<Integer, String> intermediateCode_fromLinesToCode= new TreeMap<>();
    static private String intermediateCode = "";
    
    public static void printIntermediateCode(){
        
        /*intermediateCode_fromLinesToCode.forEach((lineNumber, code) -> {
            System.out.println(code);        
        });*/
        System.out.println(intermediateCode);  
        
        
    }
    
    public static void enterF_p(CParser.F_pContext ct) {
        
                

    }

    public static void enterF_d(CParser.F_dContext ct, Runnable function) {

    }

    
    public static void enterF_c(CParser.F_cContext ct) {

        
    }

    public static void enterAssignation(CParser.AssignationContext ct) {
        Integer lineNumber = ct.start.getLine();
        String prefix = ct.ID() + " := ";
        String code = to_value_TAC("", ct.to_value());
        intermediateCode_fromLinesToCode.put(lineNumber, code);
        intermediateCode += code + "\n";
        
    }

    public static void enterTo_value(CParser.To_valueContext ct) {
        /*
        Integer lineNumber = ct.start.getLine();
        String code = ct.getText();
        intermediateCode_fromLinesToCode.put(lineNumber, code);
        intermediateCode += code + "\n";
        */

    }
    
    
    public static String to_value_TAC(String return_to, CParser.To_valueContext ct) {
        
        List<String> TAC_array = new ArrayList <>();
        if (ct.math_operation()!= null){
            
            MathTuple<String,Integer> mathTuple = new MathTuple("", 0);
            mathTuple = parseMath(mathTuple, ct.math_operation());
            TAC_array.add(mathTuple.acumulatedIntermediateCode);
        
        }
        if (ct.f_c()!= null){
            
            
            TAC_array.add("fc" + ct.f_c().toString());
        
        }
        if (ct.digit() != null){
            TAC_array.add("digit " + ct.getText());
        }
        
        if (ct.ID()!= null){
            TAC_array.add("ID " + ct.getText());
        }
        
        
        
        Integer lastIndex = TAC_array.size()-1;
        TAC_array.set(lastIndex, return_to +  TAC_array.get(lastIndex));
        return String.join("\n", TAC_array);
    }

    public static void enterVariable_declaration(CParser.Variable_declarationContext ct) {
        List<String> codeList = new ArrayList<>() ;
        for (int i = 0; i < ct.ID().size(); i++) {
            String prefix = ct.ID(i) + " := ";
            String code = to_value_TAC(prefix, ct.to_value(i));
            codeList.add(code);
            
        }
        
        Integer lineNumber = ct.start.getLine();
        intermediateCode_fromLinesToCode.put(lineNumber, String.join("\n", codeList));
        intermediateCode += String.join("\n", codeList) + "\n";
        
    }


    

}
