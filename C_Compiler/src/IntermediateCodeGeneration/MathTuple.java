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
    public final Integer nextID;

    public MathTuple(String acumulatedIntermediateCode, Integer nextID) {
        this.acumulatedIntermediateCode = acumulatedIntermediateCode;
        this.nextID = nextID;
    }

    MathTuple() {
        this.acumulatedIntermediateCode = "";
        this.nextID = 0;
    }
    
    MathTuple set_acumulatedIntermediateCode(String code){
        return new MathTuple(this.acumulatedIntermediateCode + code, this.nextID);
    }
    
    MathTuple set_nextID(Integer nextID){
        return new MathTuple(this.acumulatedIntermediateCode, nextID);
    }
    
}
