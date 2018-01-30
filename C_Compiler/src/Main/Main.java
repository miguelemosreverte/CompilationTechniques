/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import C_ANTLR.CBaseListener;
import C_ANTLR.CLexer;
import C_ANTLR.CParser;
import Rules.Visitor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author ramiro
 */
public class Main {

    public static void main(String args[]) {
        JFileChooser fc = new JFileChooser();
        //fc.showDialog(null, "Attach");
        File path = new File("/home/miguel/Desktop/CompilationTechniques/code examples/test.c");//fc.getSelectedFile();

        
        try {
            //levantamos el archivo a procesar
            FileInputStream stream = new FileInputStream(path);
            //creamos un ANTLRInputStream pasándole el stream del archivo
            ANTLRInputStream antlrStream = new ANTLRInputStream(stream);
            //Creamos un lexer
            CLexer lexer = new CLexer(antlrStream);
            //levantamos los tokens
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            //Creamos el parser
            CParser parser = new CParser(tokens);
            //Instanciamos la clase que implementa el escuchas
            CBaseListener listener = new CBaseListener();
            //le pasamos al parser el listener (podríamos manejar varios escuchas).
            parser.addParseListener(listener);
            //Aramamos un árbol iniciando el proceso. para esto el generador
            //de código crea un método dentro del parser con el nombre del símbolo
            //inicial. Debemos invocar ese método.
            ParseTree tree = parser.prog();
            //Podríamos imprimir el árbol por consola.
            System.out.println("arbol:" + tree.toStringTree(parser));
            Visitor visitor = new Visitor();
            ParseTreeWalker.DEFAULT.walk(visitor, tree);

            visitor.printUnusedSymbols();

        } catch (IOException | RecognitionException e) {
            //cualquier error, capturamos la exception.
        }
    }

}
