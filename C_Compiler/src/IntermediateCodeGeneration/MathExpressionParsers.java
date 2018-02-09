/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermediateCodeGeneration;

import C_ANTLR.CParser;
import C_ANTLR.CParser.ProductContext;
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
        return product.factor().math_operand().grouped() == null || product.unapplied_medium_op().isEmpty();
    } 
        
    public static MathTuple<String,Integer> 
        parseSum(
            MathTuple<String,Integer> tuple, 
            CParser.SumContext sum){
        
        
        if (sum.unapplied_low_op().isEmpty()){
            System.out.println("Oops");
            tuple = parseProduct(tuple, sum.product());
            return tuple; //not really necessary, but helps posterior analysis
        }
        
        
        
        if (! willRequireExtraCalculations(sum.product())){               
                tuple = tuple.set_acumulatedIntermediateCode("\ntaa" + tuple.ID + ":=");
        }
        else{

            if (sum.product().factor().math_operand().grouped() == null){
                //if it is a group we are going to be back here in a minute, 
                //so no need to print this twice. 
                // grouped is the only recursive math operand.

                tuple = tuple.set_ID(tuple.ID + 1);
                tuple = tuple.set_acumulatedIntermediateCode("\ntbb" + tuple.ID + ":=");
            }
            tuple = parseProduct(tuple, sum.product());
        }
            
        TerminalNode groupLowOperand = null;
        
        
        boolean needs_prefix = willRequireExtraCalculations(sum.product());
        for (CParser.Unapplied_low_opContext low_op : sum.unapplied_low_op()){
            
            
           
          
            
            
            
            
            Integer pepe = 0;
            
            if (! willRequireExtraCalculations(low_op.product())){                
                tuple = tuple.set_acumulatedIntermediateCode("\ntd" + tuple.ID + ":=");
            }
            else{
                
                
                if (low_op.product().factor().math_operand().grouped() != null)  {
                    groupLowOperand = low_op.MATH_OP_LOW_PRIORITY();
                    tuple = parseProduct(tuple, low_op.product());
                    pepe = tuple.ID;
                }
                else{
                     if (!needs_prefix){
                        needs_prefix = true;
                    }
                    else{
                        tuple = tuple.set_ID(tuple.ID + 1);
                        tuple = tuple.set_acumulatedIntermediateCode("\ntc" + tuple.ID + ":=t" + (tuple.ID - 1));
                        // tc is waiting for a unnaplied. And that may not happen. It is waiting for a resolved product on the right.
                    }
                    tuple = tuple.set_acumulatedIntermediateCode(low_op.MATH_OP_LOW_PRIORITY().getText());
                    tuple = parseProduct(tuple, low_op.product());
                    
                }
            }
            
             
        
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
