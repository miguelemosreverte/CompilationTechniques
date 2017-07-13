/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp1_lemos;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
/**
 *
 * @author ramiro
 */
public class TP1_Lemos {
    
    public static void main(String args[]){
        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        File path = new File(dialog.getDirectory()+dialog.getFile());
        try{
            //levantamos el archivo a procesar
            FileInputStream stream=new FileInputStream(path);
            //creamos un ANTLRInputStream pasándole el stream del archivo
            ANTLRInputStream antlrStream=new ANTLRInputStream(stream);
            //Creamos un lexer
            CLexer lexer=new CLexer(antlrStream);
            //levantamos los tokens
            CommonTokenStream tokens=new CommonTokenStream(lexer);
            //Creamos el parser
            CParser parser=new CParser(tokens);
            //Instanciamos la clase que implementa el escuchas
            CBaseListener listener = new CBaseListener();
            //le pasamos al parser el listener (podríamos manejar varios escuchas).
            parser.addParseListener(listener);
            //Aramamos un árbol iniciando el proceso. para esto el generador 
            //de código crea un método dentro del parser con el nombre del símbolo 
            //inicial. Debemos invocar ese método.
            ParseTree tree =parser.prog();
            //Podríamos imprimir el árbol por consola.
            System.out.println("arbol:"+tree.toStringTree(parser));
            
            ParseTreeWalker.DEFAULT.walk(new Visitor(), tree);
        }catch(Exception e){
            //cualquier error, capturamos la exception.
            e.printStackTrace();
        }
    }
    
}
