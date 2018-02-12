package IntermediateCodeGeneration

import C_ANTLR.CParser
import IntermediateCodeGeneration.MathExpressionParsers.parseMath
import java.util


import java.util
import java.util.{ArrayList, List, NavigableMap, TreeMap}

import IntermediateCodeGeneration.MathExpressionParsers.parseMath

object IntermediateCodeGenerator {

  private val globalIdentifier = 0
  private val intermediateCode_fromLinesToCode = new util.TreeMap[Integer, String]
  private var intermediateCode = ""

  def printIntermediateCode(): Unit = {
    /*intermediateCode_fromLinesToCode.forEach((lineNumber, code) -> {
               System.out.println(code);
           });*/ System.out.println(intermediateCode)
  }

  def enterF_p(ct: CParser.F_pContext): Unit = {
  }

  def enterF_d(ct: CParser.F_dContext, function: Runnable): Unit = {
  }


  def enterF_c(ct: CParser.F_cContext): Unit = {
  }

  def enterAssignation(ct: CParser.AssignationContext): Unit = {
    val lineNumber = ct.start.getLine
    val prefix = ct.ID + " := "
    val code = to_value_TAC("", ct.to_value)
    intermediateCode_fromLinesToCode.put(lineNumber, code)
    intermediateCode += code + "\n"
  }

  def enterTo_value(ct: CParser.To_valueContext): Unit = {
    /*
            Integer lineNumber = ct.start.getLine();
            String code = ct.getText();
            intermediateCode_fromLinesToCode.put(lineNumber, code);
            intermediateCode += code + "\n";
            */
  }


  def to_value_TAC(return_to: String, ct: CParser.To_valueContext): String = {
    val TAC_array = new util.ArrayList[String]
    if (ct.math_operation != null) {
      var mathTuple = new MathTuple("", 0)
      mathTuple = parseMath(mathTuple, ct.math_operation)
      TAC_array.add(mathTuple.acumulatedIntermediateCode)
    }
    if (ct.f_c != null) TAC_array.add("fc" + ct.f_c.toString)
    if (ct.digit != null) TAC_array.add("digit " + ct.getText)
    if (ct.ID != null) TAC_array.add("ID " + ct.getText)
    val lastIndex = TAC_array.size - 1
    TAC_array.set(lastIndex, return_to + TAC_array.get(lastIndex))
    String.join("\n", TAC_array)
  }

  def enterVariable_declaration(ct: CParser.Variable_declarationContext): Unit = {
    val codeList = new util.ArrayList[String]
    var i = 0
    while ( {
      i < ct.ID.size
    }) {
      val prefix = ct.ID(i) + " := "
      val code = to_value_TAC(prefix, ct.to_value(i))
      codeList.add(code)

      {
        i += 1; i - 1
      }
    }
    val lineNumber = ct.start.getLine
    intermediateCode_fromLinesToCode.put(lineNumber, String.join("\n", codeList))
    intermediateCode += String.join("\n", codeList) + "\n"
  }


}