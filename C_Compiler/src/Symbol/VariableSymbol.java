/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbol;

/**
 *
 * @author Migue
 */
public class VariableSymbol extends AbstractSymbol{

    private String value;
    
    
    public VariableSymbol(String in_ID, String in_type, String in_value, String in_line_number) {
        super(in_ID, in_type, in_line_number);
        value = in_value;
    }
    
    public String getValue(){
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
        
}
