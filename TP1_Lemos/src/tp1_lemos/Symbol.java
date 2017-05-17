/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_lemos;

/**
 *
 * @author Migue
 */
class Symbol {

    private final String ID;
    private final String type;
    private final String value;
    
    
    public Symbol(String in_ID, String in_type, String in_value) {
        ID = in_ID;
        type = in_type;
        value = in_value;
    }
    
    public String getID(){
        return ID;
    }
    public String getType(){
        return type;
    }
    public String getValue(){
        return value;
    }
    public String toString(){ 
        return ID +" "+type+" "+value;  
    } 
}
