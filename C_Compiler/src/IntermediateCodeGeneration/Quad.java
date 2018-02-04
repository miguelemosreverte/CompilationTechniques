/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermediateCodeGeneration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author miguel
 */
public class Quad {
    String result = "";
    String operation = "";
    String operand1 = "";
    String operand2 = "";
    
    private List<String> elements = new ArrayList<>();
    private HashMap <Integer, String> elementsByIndex = new HashMap<>();

    public Quad() {
        this.elementsByIndex.put(0, result);
        this.elementsByIndex.put(1, operand1);
        this.elementsByIndex.put(2, operation);
        this.elementsByIndex.put(3, operand2);
        
        this.elements.add(result);
        this.elements.add(operand1);
        this.elements.add(operation);
        this.elements.add(operand2);
    }
    

   
  
    public void addByIndex(Integer index, String value){
        this.elementsByIndex.put(index, value);
    }
    
    
    @Override
    public String toString(){         
        return String.join(" ", elementsByIndex.values());
    }
    
    public boolean isComplete(){
        return this.elements.size() == 3;
    }
}
