/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbol;

import java.util.List;

/**
 *
 * @author Migue
 */
public class FunctionSymbol extends AbstractSymbol{

    private List<String> parameters;
    private boolean prototyped;
    private boolean declared;
    
    
    public FunctionSymbol(String in_ID, String in_type, List<String> in_parameters, String in_line_number) {
        super(in_ID, in_type, in_line_number);
        parameters = in_parameters;
    }
    
    
    public FunctionSymbol(String in_ID, String in_type, List<String> in_parameters, String in_line_number, boolean in_prototyped) {
        super(in_ID, in_type, in_line_number);
        parameters = in_parameters;
        prototyped = in_prototyped;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public boolean isPrototyped() {
        return prototyped;
    }

    public void setPrototyped(boolean isPrototyped) {
        this.prototyped = isPrototyped;
    }

    public boolean isDeclared() {
        return declared;
    }

    public void setDeclared(boolean isDeclared) {
        this.declared = isDeclared;
    }

    
    
        
}
