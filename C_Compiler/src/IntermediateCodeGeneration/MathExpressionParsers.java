/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermediateCodeGeneration;

import C_ANTLR.CParser;

/**
 *
 * @author miguel
 */
public class MathExpressionParsers {
    
    
    
    
    public static MathTuple<String,Integer>  
        parseUnapplied_Low_Op(
            MathTuple<String,Integer>  tuple, 
            CParser.Unapplied_low_opContext low){
        
        tuple = tuple.set_acumulatedIntermediateCode(low.MATH_OP_LOW_PRIORITY().getText());
        
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
            tuple = tuple.set_acumulatedIntermediateCode(operand.getText() + "\n");
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
        
        tuple = parseFactor(tuple, product.factor());
        
        for (CParser.Unapplied_medium_opContext medium_op : product.unapplied_medium_op()){
            
            tuple = tuple.set_nextID(tuple.nextID + 1);
            String oldID = "t" + String.valueOf(tuple.nextID - 1);
            tuple = tuple.set_acumulatedIntermediateCode("t" + tuple.nextID + ":=" + oldID);
            tuple = parseUnapplied_Medium_Op(tuple, medium_op);
        }
        
        return tuple;
    }
    
    
    public static MathTuple<String,Integer> 
        parseSum(
            MathTuple<String,Integer> tuple, 
            CParser.SumContext sum){
        
        tuple = parseProduct(tuple, sum.product());
        
        
        
        for (CParser.Unapplied_low_opContext low_op : sum.unapplied_low_op()){
            
            tuple = tuple.set_nextID(tuple.nextID + 1);
            String oldID = "t" + String.valueOf(tuple.nextID - 1);
            tuple = tuple.set_acumulatedIntermediateCode("t" + tuple.nextID + ":=" + oldID);
            tuple = parseUnapplied_Low_Op(tuple, low_op);
        }
        
        
        return tuple;
    }
    
    
    public static MathTuple<String,Integer> 
        parseMath(
            MathTuple<String,Integer> tuple, 
            CParser.Math_operationContext math_expression){       
        
        return parseSum(tuple, math_expression.sum());
    }
    
}
