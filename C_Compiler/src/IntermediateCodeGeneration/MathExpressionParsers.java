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
        }
        
        for (CParser.Unapplied_medium_opContext medium_op : product.unapplied_medium_op()){
            
            if (medium_op_counter == 0){
                tuple = tuple.set_ID(tuple.ID + 1);
                tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=");
                

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
    
        
    public static MathTuple<String,Integer> 
        parseSum(
            MathTuple<String,Integer> tuple, 
            CParser.SumContext sum){
        
        
        //unlike parseProduct, I dont have to worry here about having an empty sum.unapplied_low_op()
        //so I do not need to make that case. 
        //HOLD ON... A number without sums operators around it is not a math op???
        
        if (sum.unapplied_low_op().isEmpty()){
            tuple = parseProduct(tuple, sum.product());
        }
        
        
        Integer low_op_counter = 0;
        for (CParser.Unapplied_low_opContext low_op : sum.unapplied_low_op()){
            
            Integer beforeID = tuple.ID;
            tuple = parseUnapplied_Low_Op(tuple, low_op);
            Integer givenID = tuple.ID;
                
            if (low_op_counter == 0){
                
                    Integer beforeID2 = tuple.ID;
                    tuple = parseProduct(tuple, sum.product());
                    tuple = tuple.set_ID(tuple.ID + 1);
                    tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=t" + (tuple.ID - 1));
                    String TAD = low_op.MATH_OP_LOW_PRIORITY().getText() + "t"+beforeID2;
                    tuple = tuple.set_acumulatedIntermediateCode(TAD);
                
                
                
                
            }
            else{
                
                tuple = tuple.set_ID(tuple.ID + 1);
                tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=t" + beforeID);
                String TAD = low_op.MATH_OP_LOW_PRIORITY().getText() + "t"+givenID;
                tuple = tuple.set_acumulatedIntermediateCode(TAD);
                
            }
            low_op_counter += 1;
        
        }
        
        //tuple = parseProduct(tuple, sum.product());  
        return tuple;
    }
    
    
    public static MathTuple<String,Integer> 
        parseMath(
            MathTuple<String,Integer> tuple, 
            CParser.Math_operationContext math_expression){       
        
        return parseSum(tuple, math_expression.sum());
    }
    
}
