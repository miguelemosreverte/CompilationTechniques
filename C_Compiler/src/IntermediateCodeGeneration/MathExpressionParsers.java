/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermediateCodeGeneration;

import C_ANTLR.CParser;
import C_ANTLR.CParser.ProductContext;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author miguel
 */
public class MathExpressionParsers {
    
    
    
    
    public static MathTuple<String,Integer>  
        parseUnapplied_Low_Op(
            MathTuple<String,Integer>  tuple, 
            CParser.Unapplied_low_opContext low){
        
        tuple = parseProduct(tuple, low.product());
        return tuple;
    }
    
    
    public static MathTuple<String,Integer>  
        parseUnapplied_Medium_Op(
            MathTuple<String,Integer>  tuple, 
            CParser.Unapplied_medium_opContext medium){
        
        tuple = tuple.set_acumulatedIntermediateCode(medium.MATH_OP_MEDIUM_PRIORITY().getText());
        
        tuple = parseFactor(tuple, medium.factor());
        
    
        return tuple;
    }
    
    
    public static MathTuple<String,Integer>  
        parseUnapplied_High_Op(
            MathTuple<String,Integer>  tuple, 
            CParser.Unapplied_high_opContext high){
        
        //tuple = parseMathOperand(tuple, high.math_operand());
        
        return tuple;
    }
    
    
    public static MathTuple<String,Integer>  
        parseGroupedMath(
            MathTuple<String,Integer>  tuple, 
            CParser.GroupedContext grouped){
        return parseMath(tuple, grouped.math_operation());
    }
    
    
    public static MathTuple<String,Integer>  
        parseMathOperand(
            MathTuple<String,Integer>  tuple, 
            CParser.Math_operandContext operand){
        
        if (operand.grouped() != null){
            tuple = parseGroupedMath(tuple, operand.grouped());
        }
        else{
            tuple = tuple.set_acumulatedIntermediateCode(operand.getText());
        }
        
        return tuple;
    }
    
    
    public static MathTuple<String,Integer>  
        parseFactor(
            MathTuple<String,Integer>  tuple, 
            CParser.FactorContext factor){
            
        tuple = parseMathOperand(tuple, factor.math_operand());
        
        return tuple;
    }
    
    
    public static MathTuple<String,Integer>  
        parseProduct(
            MathTuple<String,Integer>  tuple, 
            CParser.ProductContext product){
        
       
        Integer medium_op_counter = 0;
        
        
        if (product.unapplied_medium_op().isEmpty()){
            tuple = parseFactor(tuple, product.factor());
            return tuple; // not really necessary, but helps posterior analisis
        }
        
        for (CParser.Unapplied_medium_opContext medium_op : product.unapplied_medium_op()){
            
            if (medium_op_counter == 0){
                
                if (product.factor().math_operand().grouped() == null){
                    //if it is a group we are going to be back here in a minute, 
                    //so no need to print this twice. 
                    // grouped is the only recursive math operand.
                    tuple = tuple.set_ID(tuple.ID + 1);
                    tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=");
                }
                
                tuple = parseFactor(tuple, product.factor());
                Integer givenID = tuple.ID;
        
        
                tuple = parseUnapplied_Medium_Op(tuple, medium_op);
                givenID = tuple.ID;
            }
            else{
                Integer givenID = tuple.ID;
                tuple = tuple.set_ID(tuple.ID + 1);
                tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=t" + givenID);
                tuple = parseUnapplied_Medium_Op(tuple, medium_op);
                givenID = tuple.ID;
            }        
            medium_op_counter += 1;
            
        }
        return tuple;
    }    
    
    public static boolean willRequireExtraCalculations(CParser.ProductContext product){  
       return product.factor().math_operand().grouped() != null || !product.unapplied_medium_op().isEmpty();
    } 
        
    public static MathTuple<String,Integer> 
        parseSum(
            MathTuple<String,Integer> tuple, 
            CParser.SumContext sum,
            List<CParser.Unapplied_low_opContext>shrinkableList){
        
        
            
            
            
        ProductContext operand1 = sum.product();
        
        //case 0
        // there is just a product
        if (sum.unapplied_low_op().isEmpty()){
            tuple = parseProduct(tuple, sum.product());
            return tuple;
        }
        
        //from here on we can assume there are unapplied low operations to work with
        
        //after taking what we are going to use, we remove it from the list
        //for this I needed a shrinkable list because sum.unapplied_low_op() 
        //would return a constant value.
        if (shrinkableList.isEmpty()) shrinkableList = sum.unapplied_low_op();
        
        CParser.Unapplied_low_opContext unapplied_low_op = shrinkableList.remove(0);  
        ProductContext operand2 = unapplied_low_op.product();
        String operation = unapplied_low_op.MATH_OP_LOW_PRIORITY().getText();
        
        
        
        
        
        /*
        
        Just a bit of trivia, before continuing:
        
        non-group is the same as final. Means a non-recursive math operand.
        
        This means that it is expected for that value to be processed into a single operand.
        
        A recursive math operand means that it is expected to become N extra steps.
        
        */
        
        
        
        
        //case 1 
        // there is a sum of two non-groups. 
        
        if (! willRequireExtraCalculations(operand1) &&
            ! willRequireExtraCalculations(operand2)){ 
        
            
            tuple = tuple.set_ID(tuple.ID + 1);
            tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=");
            
            tuple = parseProduct(tuple, operand1);
            Integer operand1_ID = tuple.ID;
            
            tuple = tuple.set_acumulatedIntermediateCode(operation);
            
            tuple = parseProduct(tuple, operand2);
            Integer operand2_ID = tuple.ID;
            
        
        }
        
        
        
        
        //case 2
        // there is a sum of a left group and a right final
        
        if (  willRequireExtraCalculations(operand1) &&
            ! willRequireExtraCalculations(operand2)){ 
        
            
            
            tuple = parseProduct(tuple, operand1);
            Integer operand1_ID = tuple.ID;
            
            
            tuple = tuple.set_ID(tuple.ID + 1);
            tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=" + "t" + operand1_ID);
            
            tuple = tuple.set_acumulatedIntermediateCode(operation);
            
            tuple = parseProduct(tuple, operand2);
            Integer operand2_ID = tuple.ID;
            
        
        }
        
            
        
        
        
         //case 3
        // there is a sum of a left final and a right group
        
        if (!  willRequireExtraCalculations(operand1) &&
               willRequireExtraCalculations(operand2)){ 
        
            
            
            
            tuple = parseProduct(tuple, operand2);
            Integer operand2_ID = tuple.ID;           
            
            
            tuple = tuple.set_ID(tuple.ID + 1);
            tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=");
            
            tuple = parseProduct(tuple, operand1);
            Integer operand1_ID = tuple.ID;
            
            tuple = tuple.set_acumulatedIntermediateCode(operation);
            
            tuple = tuple.set_acumulatedIntermediateCode("t" + operand2_ID);
        
        }
        
        
        
        
          
         //case 4
        // there is a sum of a left group and a right group
        
        if (  willRequireExtraCalculations(operand1) &&
              willRequireExtraCalculations(operand2)){ 
        
            
            
            
            tuple = parseProduct(tuple, operand2);
            Integer operand2_ID = tuple.ID;           
            
            
            tuple = parseProduct(tuple, operand1);
            Integer operand1_ID = tuple.ID;
            
            tuple = tuple.set_ID(tuple.ID + 1);
            tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=");
            
            tuple = tuple.set_acumulatedIntermediateCode("t" + operand1_ID);            
            
            tuple = tuple.set_acumulatedIntermediateCode(operation);
            
            tuple = tuple.set_acumulatedIntermediateCode("t" + operand2_ID);
        
        }
        
        if (!shrinkableList.isEmpty()){
            System.out.println(sum.unapplied_low_op().get(0).getText());
            tuple = parseSum(tuple, sum, shrinkableList);
        }
        
        
        return tuple;
    }
    
    
    public static MathTuple<String,Integer> 
        parseMath(
            MathTuple<String,Integer> tuple, 
            CParser.Math_operationContext math_expression){       
        
            List shrinkableList = new ArrayList<>();
        return parseSum(tuple, math_expression.sum(), shrinkableList);
    }
    
}
