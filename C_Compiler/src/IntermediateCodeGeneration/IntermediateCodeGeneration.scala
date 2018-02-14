package IntermediateCodeGeneration

import C_ANTLR.CParser
import IntermediateCodeGeneration.MathExpressionParsers.parseMath
import java.util
import java.util
import java.util._

import C_ANTLR.CParser.StatContext
import IntermediateCodeGeneration.MathExpressionParsers.parseMath
import Rules.Utils
import org.antlr.v4.runtime.tree.{ParseTree, TerminalNode}

import scala.collection.mutable.ListBuffer

object IntermediateCodeGenerator {

  private var globalIdentifier = 0
  private var labelIdentifier = 0
  private val functionNamesToLineNumber = new HashMap[String, Integer]
  private val lineNumberToLabelNumber = new HashMap[Integer, Integer]
  private val functionDeclarationNamesToParameters = new HashMap[String, Seq[String]]
  private val functionDeclarationNamesToFunctionDeclarations = new HashMap[String, CParser.F_dContext]
  private var intermediateCode = ""

  def printIntermediateCode(): Unit = Console.println(intermediateCode)

  def enterF_p(ct: CParser.F_pContext): Unit = {
  }

  def enterF_d(ct: CParser.F_dContext): Unit = {
    val functionName = ct.ID().getText
    import collection.JavaConverters._
    val parameterNameList: Seq[String] = Rules.Utils.getChildrenID(ct.parametersList()).asScala.toSeq
    functionDeclarationNamesToParameters.put(functionName, parameterNameList)
    functionDeclarationNamesToFunctionDeclarations.put(functionName, ct)
  }


  def enterF_c(ct: CParser.F_cContext): Unit = {
  }

  def enterProg (ctx: CParser.ProgContext) : Unit = {

    var numericalID_to_ID= scala.collection.mutable.Map[Int, String]()

    def stat_TAC(ctx: CParser.StatContext): String = {

      var code = ""


      def to_value_TAC(assignment : Int, ct: CParser.To_valueContext) : String = {
        var code = ""
        if (ct.math_operation != null) {
          var mathTuple = new MathTuple("", globalIdentifier)
          mathTuple = parseMath(mathTuple, ct.math_operation)
          code = mathTuple.acumulatedIntermediateCode
          globalIdentifier = mathTuple.ID
          //code += "math t" + globalIdentifier
        }
        val currentID = "\nvalue " +  numericalID_to_ID.getOrElse(globalIdentifier, "t" + globalIdentifier)

        if (ct.f_c != null) code = fc_TAC(assignment, ct.f_c)
        if (ct.digit != null) code = currentID + ":= digit " + ct.getText
        if (ct.ID != null) code = currentID + ":= id " + ct.getText


        code
      }


      def variable_declaration_TAC(ct: CParser.Variable_declarationContext): String = {
        val codeList = new util.ArrayList[String]
        import collection.JavaConverters._

        val ID_and_values: Seq[(TerminalNode, CParser.To_valueContext)] = ct.ID().asScala.toSeq zip ct.to_value().asScala.toSeq
        for  (zipped <- ID_and_values){
          var code = ""
          val ID = zipped._1.getText
          globalIdentifier += 1
          numericalID_to_ID += ((globalIdentifier, ID))
          val globalIdentifier_before_evaluation = globalIdentifier
          code += to_value_TAC(assignment = -1, zipped._2)
          codeList.add(code)
          if (globalIdentifier_before_evaluation < globalIdentifier)
            codeList.add(ID + ":=" + "declarated t" + globalIdentifier)
        }
        val lineNumber = ct.start.getLine
        String.join("\n", codeList)
      }

      def assignation_TAC(ct: CParser.AssignationContext): String =
      {


        globalIdentifier += 1

        val lineNumber = ct.start.getLine
        val ID = ct.ID().getText
        var code = "" // "\nassign t" + globalIdentifier + " := " + ID

        numericalID_to_ID += ((globalIdentifier, ID))
        if (ct.to_value() != null) code += to_value_TAC(assignment = globalIdentifier, ct.to_value)
        else code += ct.ID() + (if (ct.INCR_DECR().toString() == "++") "+1" else "-1")
        code + "\n"
      }

      def fc_TAC(assignment : Int, ct : CParser.F_cContext): String ={

        var code = ""

        import collection.JavaConverters._

        val functionName : String = ct.ID().getText



        def getAllParameters(input : CParser.InputParametersListContext) : Seq[CParser.To_valueContext] = {
          var parameters = new ListBuffer[CParser.To_valueContext]()

          import collection.JavaConverters._
          if (! input.inputParametersList().isEmpty)
            for (a <- input.inputParametersList().asScala.toSeq)
              parameters.++=(getAllParameters(a).toList)

          if (input.to_value() != null)
            parameters.+=(input.to_value())
          parameters
        }
        val parameters : Seq[CParser.To_valueContext] = getAllParameters(ct.inputParametersList()).toSeq
        for (parameter <- parameters){
          if (parameter.f_c() != null) {

            //code += "\nevaluating parameter "+parameter.getText+" of function " + functionName
            code += to_value_TAC(assignment = -1, parameter)
          }
          //code += to_value_TAC(parameter)

        }


        val inputParameterNames: Seq[String] =
          Rules.Utils.getChildrenID(ct.inputParametersList()).asScala.toSeq
        val parameterNamesAsStatedInFunctionDeclaration: Seq[String] =
          functionDeclarationNamesToParameters.get(functionName)

        val zippedParameters: Seq[(String, String)] = parameterNamesAsStatedInFunctionDeclaration zip inputParameterNames

        val substitutions: Predef.Map[String, String] = zippedParameters.toMap

        val functionDeclaration : CParser.F_dContext = functionDeclarationNamesToFunctionDeclarations.get(functionName)

        import collection.JavaConverters._

        for(stat <- functionDeclaration.code_block.stat().asScala.toSeq){

            var statement: String = stat_TAC(stat)
            for (substitution <- substitutions) {
              var replacement = substitution._2
              if (functionDeclarationNamesToParameters.containsKey(substitution._2))
                replacement = "t" + (globalIdentifier - 1)
              statement= statement.replace(substitution._1, replacement)
            }
            code += statement


        }
        val currentID = "\nvalue " +  numericalID_to_ID.getOrElse(assignment, "never gonna happen")

        if (assignment != -1)
        code += currentID + ":= t" + globalIdentifier
        code
      }

      def codeblock_TAC(context: CParser.Code_blockContext): String ={

        var code = ""
        import collection.JavaConverters._
        for(stat <- context.stat().asScala.toSeq){
          code += "\n" + stat_TAC(stat)
        }
        code
      }

      def fd_TAC(ct : CParser.F_dContext): String ={
        labelIdentifier += 1
        intermediateCode += "\nL" + labelIdentifier + ":\n"
        lineNumberToLabelNumber.put(ct.getStart.getLine, labelIdentifier)
        functionNamesToLineNumber.put(ct.ID().getText, ct.getStart.getLine)

        codeblock_TAC(ct.code_block())

        //val returnthing = ct.code_block().
      }

      def ret_TAC(context: CParser.RetContext) : String  = {

        to_value_TAC(assignment = -1, context.to_value())
      }

      def if_TAC(context: CParser.If_conditionContext): String ={


        //context.logic_op()
        var code = ""

        def codeblock_TAC (codeblock: CParser.Code_blockContext) : String =  {

          import collection.JavaConverters._
          val stat =  codeblock.stat().asScala.toSeq

          for (s <- stat)
            code += stat_TAC(context.stat())
          code
        }

        globalIdentifier += 1
        //TODO parse logic_op to 3 address code
        val conditionID = "condition"+globalIdentifier
        code += "\n" + conditionID+":="+context.logic_op().getText
        labelIdentifier += 1
        code += "\nifNot("+conditionID+") goto L"+labelIdentifier+"\n"
        if(context.code_block() != null){


          code += codeblock_TAC(context.code_block())


        }
        else
          code += stat_TAC(context.stat())
        code += "\nL"+labelIdentifier+":"

        if (context.else_condition() != null){
          if (context.else_condition().code_block() != null)
            code += codeblock_TAC(context.else_condition().code_block())
          else
            code += stat_TAC(context.else_condition().stat())
        }
        code
      }

      if (ctx.variable_declaration() != null) code += variable_declaration_TAC(ctx.variable_declaration())

      if (ctx.assignation() != null) code += assignation_TAC(ctx.assignation())

      if (ctx.f_c() != null) code += fc_TAC(assignment = -1, ctx.f_c())

      //if (ctx.f_d() != null) code += fd_TAC(ctx.f_d())

      if (ctx.ret() != null) code += ret_TAC(ctx.ret())


      if (ctx.if_condition() != null) code += if_TAC(ctx.if_condition())

     /*

      if (ctx.for_loop() != null) for_loop_TAC(ctx.assignation())
      if (ctx.while_loop() != null) while_TAC(ctx.assignation())
      if (ctx.if_condition() != null) if_TAC(ctx.assignation())*/

      code
    }




    import collection.JavaConverters._
    for (stat : StatContext <- ctx.stat().asScala.toSeq){
      intermediateCode += stat_TAC(stat)
    }
  }



  def enterTo_value(ct: CParser.To_valueContext): Unit = {
    /*
            Integer lineNumber = ct.start.getLine();
            String code = ct.getText();
            intermediateCode_fromLinesToCode.put(lineNumber, code);
            intermediateCode += code + "\n";
            */
  }




}