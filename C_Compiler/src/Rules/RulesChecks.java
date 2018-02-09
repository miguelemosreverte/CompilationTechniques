/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;

import Scope.Scope;
import Symbol.VariableSymbol;
import java.util.List;

/**
 *
 * @author Migue
 */
public class RulesChecks {

    protected static void checkDangerousCastings(List<String> IDs, String lineNumber, Scope scope) throws CErrorException {

    }

    protected static void checkVarName(String varName, String lineNumber, Scope scope) throws CErrorException {
        if (!scope.isVariableDeclared(varName)) {
            throw new CErrorException(
                    "Undeclared variable " + varName + " at line " + lineNumber);
        }
    }

    protected static void checkVarInitialization(VariableSymbol currentSymbol, int declaredAtLine) {
        if (currentSymbol.getValue().isEmpty()) {
            throw new CErrorException(
                    "Use of uninitialized identifier \""
                    + currentSymbol.getID()
                    + "\" at line number "
                    + declaredAtLine
            );
        }
    }

    protected static void checkFunctionPrototype(String functionName, String lineNumber, Scope scope) throws CErrorException {

        if (!scope.isFunctionPrototyped(functionName)) {
            throw new CErrorException(
                    "Function has not been prototyped: " + functionName + " at line " + lineNumber);
        }
    }

    protected static void checkFunctionDeclaration(String functionName, String lineNumber, Scope scope) throws CErrorException {
        if (!scope.isFunctionDeclared(functionName)) {
            throw new CErrorException(
                    "Function has not been declared: " + functionName + " at line " + lineNumber);
        }
    }

    public RulesChecks() {
    }

}
