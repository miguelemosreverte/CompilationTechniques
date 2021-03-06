/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import C_ANTLR.CBaseListener;
import C_ANTLR.CLexer;
import C_ANTLR.CParser;
import Visitor.Visitor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

/**
 *
 * @author miguel
 */
public class Main {

    public static void main(String args[]) {
        JFileChooser fc = new JFileChooser();
        //fc.showDialog(null, "Attach");
        //File path = fc.getSelectedFile();
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
            
            
             //show AST in GUI
            JFrame frame = new JFrame("Antlr AST");
            JPanel panel = new JPanel();
            TreeViewer viewr = new TreeViewer(Arrays.asList(
                    parser.getRuleNames()),tree);
            viewr.setScale(0.8);//scale a little
            panel.add(viewr);
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800,800);
            //frame.setVisible(true);
        
        
        
            Visitor visitor = new Visitor();
            ParseTreeWalker.DEFAULT.walk(visitor, tree);
            

            visitor.printUnusedSymbols();
            visitor.printSymbolsTable();
            visitor.printIntermediateCode();
            
        } catch (IOException | RecognitionException e) {
            //cualquier error, capturamos la exception.
            System.out.println(e.toString());
        }
    }

}
