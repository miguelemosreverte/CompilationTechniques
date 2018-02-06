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
    
    
    public static String parseUnappliedMath(CParser.Math_operandContext operand, CParser.UnappliedContext unapplied){
        String result = "";
        
        //TODO prepare for future op categories, ie.: tiny_op() 
        //low priority: That's not going to be needed in the future
        if (unapplied.low_op() != null) {
            
            
            result += math_operation_TAC(unapplied.low_op().math_operation());
            
            
            
            String operand2 = "t"+(globalIdentifier-1);
            if (unapplied.low_op().math_operation().unapplied() == null
                    && unapplied.low_op().math_operation().math_operand().grouped() == null){
                operand2 = unapplied.low_op().math_operation().math_operand().getText();
            }
            
            
            
            String operand1 = "";
            if (operand.children.get(0) instanceof CParser.DigitContext)
                operand1 = operand.getText();// + operand.children.get(0).getClass().getSimpleName();
            else operand1 = "t"+(globalIdentifier-1);
            
            
            
            result += "t" +globalIdentifier+":=" + operand1 + unapplied.low_op().MATH_OP_LOW_PRIORITY().getText() 
                    + operand2;
            
            
            
            globalIdentifier += 1;
            
            
            String splittedResult[] = result.split("\\r?\\n");
            System.out.println("low_op:\n" + splittedResult[splittedResult.length-1] + "\n");
       
        }
        
        if (unapplied.medium_op()!= null) {
            result += math_operation_TAC(unapplied.medium_op().math_operation());
            
            
            
            String operand2 = "t"+(globalIdentifier-1);
            if (unapplied.medium_op().math_operation().unapplied() == null){
                operand2 = unapplied.medium_op().math_operation().math_operand().getText();
            }
            
            
            result += "t"+globalIdentifier+":=" + operand.getText() + unapplied.medium_op().MATH_OP_MEDIUM_PRIORITY().getText() 
                    + operand2;
            globalIdentifier += 1;
            
            String splittedResult[] = result.split("\\r?\\n");
            System.out.println("medium_op:\n" + splittedResult[splittedResult.length-1] + "\n");
        }
        
        
     
        return result + "\n";
    }
    
    public static String parseGroupedMath(CParser.GroupedContext grouped){
        
        return math_operation_TAC(grouped.math_operation());
    }
    
    public static String parseMathOperand(CParser.Math_operandContext operand){
        String result = "";
        if (operand.grouped() != null){
            System.out.println("parseGroupedMath");
            result += parseGroupedMath(operand.grouped());
        }
        else{            
            //System.out.println(operand.getText() + "???");
        }
        return result;
    }
    
    public static String math_operation_TAC(CParser.Math_operationContext ct){
        String result = "";
        
        
        //result += child.getText() + child.getClass().getSimpleName() + ",";
        result += parseMathOperand(ct.math_operand());
        System.out.println("parseMathOperand was called");
        
        if (ct.unapplied() != null){
            result += parseUnappliedMath(ct.math_operand(), ct.unapplied());
            System.out.println("parseUnappliedMath was called");
        }
        return result;
    }
    
    public static String to_value_TAC(String return_to, CParser.To_valueContext ct) {
        
        List<String> TAC_array = new ArrayList <>();
        if (ct.math_operation()!= null){
            
            
            TAC_array.add(math_operation_TAC(ct.math_operation()));
        
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
