/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;

import C_ANTLR.CLexer;
import C_ANTLR.CParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author Migue
 */
public class Utils {

    public static Stream<String> flattenParameters(ParseTree parameterListParseTree) {
        Stream<String> stringStream = null;
        try {
            //this filters children from ruleF_pContext like the parentheses
            CParser.ParametersListContext parameterList = ((CParser.ParametersListContext) parameterListParseTree);

            stringStream = Stream.concat(Stream.of(
                    //At this point we can safely assume we are visiting every parameterList

                    //but because ParameterLists contain ParameterList
                    //we only want to work with the terminals, the ones that don't contain ParameterLists

                    ((!parameterList.parametersList().isEmpty()) ? ""
                            : //and now we safely cast between the two remaining options:
                            //is it just a list of TOKENS?
                            parameterList.children.get(0) instanceof org.antlr.v4.runtime.tree.TerminalNodeImpl
                            ? parameterList.getText()
                            : //or is it a variable declaration rule?
                            parameterList.children.get(0) instanceof CParser.Variable_declarationContext
                            ? ((CParser.Variable_declarationContext) parameterList.children.get(0)).VALID_C_TYPES().stream()
                            .map(n -> n.getText()
                            )
                            .collect(Collectors.joining(","))
                            : "")
            ),
                    parameterList.children.stream().flatMap((parameterListParameterList) -> Utils.flattenParameters(parameterListParameterList))); // recursion here

        } catch (java.lang.ClassCastException e) {
        }

        return stringStream;
    }

    public static List<String> getParametersTypesList(List<ParseTree> ctx) {
        List<String> flattenedParametersTypes = ctx.stream()
                .flatMap(Utils::flattenParameters)
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());

        flattenedParametersTypes = Arrays.asList(flattenedParametersTypes.toString().split(","));

        return flattenedParametersTypes;
    }

    public static String getLexerRule(ParseTree child) {

        return CLexer.VOCABULARY.getSymbolicName(((org.antlr.v4.runtime.tree.TerminalNodeImpl) child).getSymbol().getType());

    }

    public static String getParentFromParameterList(CParser.ParametersListContext parameterList) {

        RuleContext parentCtx = parameterList.parent;
        //go up until the context is no longer ParametersListContext
        while ("ParametersListContext".equals(parentCtx.getClass().getSimpleName())) {
            parentCtx = parentCtx.parent;
        }
        return parentCtx.getClass().getSimpleName();
    }

    public static List<String> getChildrensID_from_ParseTree(ParseTree ctx) {

        List<String> ToValueChildren = new ArrayList<>();

        for (int index = 0; index < ctx.getChildCount(); index++) {
            try {
                ParseTree child = ctx.getChild(index);
                ToValueChildren.addAll(getChildrensID_from_ParseTree(child));
                if ("ID".equals(getLexerRule(child))) {
                    String varName = ((org.antlr.v4.runtime.tree.TerminalNodeImpl) child).getSymbol().getText();

                    ToValueChildren.add(varName);
                }
            } catch (java.lang.ClassCastException e) {
            }
        }

        return ToValueChildren;
    }

}
