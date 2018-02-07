/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermediateCodeGeneration;

/**
 *
 * @author miguel
 */
public class MathTuple<T0, T1> {

    public final String acumulatedIntermediateCode;
    public final Integer ID;

    public MathTuple(String acumulatedIntermediateCode, Integer ID) {
        this.acumulatedIntermediateCode = acumulatedIntermediateCode;
        this.ID = ID;
    }

    MathTuple() {
        this.acumulatedIntermediateCode = "";
        this.ID = 0;
    }
    
    MathTuple set_acumulatedIntermediateCode(String code){
        return new MathTuple(this.acumulatedIntermediateCode + code, this.ID);
    }
    
    MathTuple set_ID(Integer ID){
        return new MathTuple(this.acumulatedIntermediateCode, ID);
    }
    
}
