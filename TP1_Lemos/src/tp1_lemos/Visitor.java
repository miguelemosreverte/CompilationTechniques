/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_lemos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Stack;
import org.antlr.v4.runtime.tree.ParseTree;
/**
 *
 * @author Migue
 */
public class Visitor extends CBaseListener {

    private final Stack<Scope> temporal_scopes;
    private final HashSet<Scope> symbolsTable;
    private final Map<String, String> rulesContextsToType;
    private final Map<String, String> dangerousTransformations;
    
    public Visitor() {
        temporal_scopes = new Stack<>();
        temporal_scopes.push(new Scope(null));
        symbolsTable = new HashSet<>();
        symbolsTable.add(temporal_scopes.peek());
        
        
        rulesContextsToType = new HashMap<>();
        rulesContextsToType.put("IntegerContext", "int");
        rulesContextsToType.put("Floating_pointContext", "float");
        rulesContextsToType.put("StringContext", "char");
        
        
        dangerousTransformations = new HashMap<>();
        dangerousTransformations.put("char", "int");
        dangerousTransformations.put("float", "int");
    } 

    @Override
    public void enterVariable_declaration(CParser.Variable_declarationContext ctx) {        
        
        Scope scope = temporal_scopes.peek();
        
        List <String> values = ctx.to_value().isEmpty()? 
                new ArrayList<>():                
                ctx.to_value().stream().map(i -> i.getText()).collect(Collectors.toList());
        
        
        //Release warnings in case of truncations or char to int initializations
        ctx.to_value().forEach  (id -> {
                                        id.children.forEach((ParseTree children) -> {
                                            String simpleClassname = children.getClass().getSimpleName();
                                            if ("DigitContext".equals(simpleClassname)){
                                                //specify the type of digit to be either float or int
                                                simpleClassname = children.getChild(0).getClass().getSimpleName();                                                
                                            }
                                            String type = ctx.VALID_C_TYPES().toString().replace("[", "").replace("]", "");
                                            String newValueType = rulesContextsToType.get(simpleClassname);
                                            if (dangerousTransformations.containsKey(newValueType)&&
                                                dangerousTransformations.get(newValueType).equals(type)){
                                                System.out.println("Warning: Converting from  " + newValueType
                                                        + " to " + type + " at line " + id.start.getLine());
                                                
                                            }
                                        });
                                    });
        
        //Then add the identificators to the scope
        ctx.ID().stream().map((ID) -> ID.getText()).forEach((varName) -> {
            scope.identificators.add(varName);            
        });
        //And finally add the complete symbol to the symbols table
        scope.symbols.add(new Symbol(ctx.ID().toString(),ctx.VALID_C_TYPES().toString(),values.toString()));
    }

    @Override
    public void enterTo_value(CParser.To_valueContext ctx) throws CErrorException {   
        try{
        checkVarName(ctx.ID().getText(), Integer.toString(ctx.start.getLine()));
        }catch (NullPointerException e){}
       
    }
    
    @Override
    public void enterAssignation(CParser.AssignationContext ctx) throws CErrorException  {
        try{
        checkVarName(ctx.ID().getText(), Integer.toString(ctx.start.getLine()));
        }catch (NullPointerException e){}
    }

    @Override
    public void enterCode_block(CParser.Code_blockContext ctx) {
        temporal_scopes.push(new Scope(temporal_scopes.peek()));
        symbolsTable.add(temporal_scopes.peek());
    }

    @Override
    public void exitCode_block(CParser.Code_blockContext ctx) {
        temporal_scopes.pop();        
    }

    private void checkVarName(String varName, String lineNumber) throws CErrorException {
        Scope scope = temporal_scopes.peek();
        if(! scope.inScope(varName)) {
            throw new CErrorException(
            "Undeclared variable " + varName  + " at line " + lineNumber);
           }
    }
    
    
}