package IntermediateCodeGeneration

import C_ANTLR.CParser
import IntermediateCodeGeneration.MathExpressionParsers.parseMath
import java.util
import java.util
import java.util._

import C_ANTLR.CParser.StatContext
import IntermediateCodeGeneration.MathExpressionParsers.parseMath
import org.antlr.v4.runtime.tree.TerminalNode

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


      def to_value_TAC(ct: CParser.To_valueContext) : String = {
        var code = ""
        if (ct.math_operation != null) {
          var mathTuple = new MathTuple("", globalIdentifier)
          mathTuple = parseMath(mathTuple, ct.math_operation)
          code = mathTuple.acumulatedIntermediateCode
          globalIdentifier = mathTuple.ID
          //code += "math t" + globalIdentifier
        }
        val currentID = "\nvalue " +  numericalID_to_ID.getOrElse(globalIdentifier, "t" + globalIdentifier)

        if (ct.f_c != null) code = fc_TAC(ct.f_c) + currentID + ":= t" + globalIdentifier
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
          code += to_value_TAC(zipped._2)
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
        if (ct.to_value() != null) code += to_value_TAC(ct.to_value)
        else code += ct.ID() + (if (ct.INCR_DECR().toString() == "++") "+1" else "-1")
        code + "\n"
      }

      def fc_TAC(ct : CParser.F_cContext): String ={

        import collection.JavaConverters._

        val functionName : String = ct.ID().getText
        val inputParameterNames: Seq[String] =
          Rules.Utils.getChildrenID(ct.inputParametersList()).asScala.toSeq
        val parameterNamesAsStatedInFunctionDeclaration: Seq[String] =
          functionDeclarationNamesToParameters.get(functionName)

        val zippedParameters: Seq[(String, String)] = parameterNamesAsStatedInFunctionDeclaration zip inputParameterNames

        val substitutions: Predef.Map[String, String] = zippedParameters.toMap

        val functionDeclaration : CParser.F_dContext = functionDeclarationNamesToFunctionDeclarations.get(functionName)

        var code = ""
        import collection.JavaConverters._

        for(stat <- functionDeclaration.code_block.stat().asScala.toSeq){

            var statement: String = stat_TAC(stat)
            for (substitution <- substitutions) {
              code += statement.replace(substitution._1, substitution._2)
            }

        }
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

        to_value_TAC(context.to_value())
      }

      if (ctx.variable_declaration() != null) code += variable_declaration_TAC(ctx.variable_declaration())

      if (ctx.assignation() != null) code += assignation_TAC(ctx.assignation())

      if (ctx.f_c() != null) code += fc_TAC(ctx.f_c())

      //if (ctx.f_d() != null) code += fd_TAC(ctx.f_d())

      if (ctx.ret() != null) code += ret_TAC(ctx.ret())

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





  def enterIf_condition(ctx: CParser.If_conditionContext): Unit = {
    val codeList = new util.ArrayList[String]

    globalIdentifier += 1
    //TODO parse logic_op to 3 address code
    val conditionID = "condition"+globalIdentifier
    intermediateCode += "\n" + conditionID+":="+ctx.logic_op().getText
    labelIdentifier += 1
    intermediateCode += "\nifNot("+conditionID+") goto L"+labelIdentifier+"\n"
    if(ctx.code_block() != null){

      import collection.JavaConverters._
      val stat =  ctx.code_block().stat().asScala.toSeq

      //for (s <- stat)
        //stat_TAC(s)

    }
    else
      codeList.add(ctx.stat().toString)
    intermediateCode += "\nL"+labelIdentifier+":"


  }

}