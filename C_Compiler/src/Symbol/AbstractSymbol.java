/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbol;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Migue
 */
public class AbstractSymbol {
    
    private final String ID;
    private final String type;
    private final String line_number;
    
    
    public AbstractSymbol(String in_ID, String in_type, String in_line_number) {
        ID = in_ID;
        type = in_type;
        line_number = in_line_number;
    }
    
    public String getID(){
        return ID;
    }
    public String getType(){
        return type;
    }
    public String getLineNumber(){
        return line_number;
    }
    
        
    @Override
    public String toString(){ 
        
        Field[] fields = this.getClass().getDeclaredFields();//REFLECTION AT LAST!
        String message= type + " " + ID;
        
        for (Field field : fields){            
            field.setAccessible(true);
            try {
                Object value = field.get(this);

                if (!value.toString().isEmpty()) {
                    message += "; " + field.getName() + " " + value.toString();
                }
            
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(AbstractSymbol.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        return message + "; declared at line " + line_number;  
    } 
    
    
    
}
