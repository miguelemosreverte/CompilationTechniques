/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;

import Scope.Scope;

/**
 *
 * @author Migue
 */
public class RulesChecks {

    protected static void checkVarName(String varName, String lineNumber, Scope scope) throws CErrorException {
        if (!scope.isVariableDeclared(varName)) {
            throw new CErrorException(
                    "Undeclared variable " + varName + " at line " + lineNumber);
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
