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
  private val functionDeclarationNamesToParameters = new HashMap[String, Seq[String]]
  private val functionDeclarationNamesToFunctionDeclarations = new HashMap[String, CParser.F_dContext]
  private var intermediateCode = ""
  import scala.collection.mutable.ListBuffer
  private var TADs = new ListBuffer[Statement]

  def printIntermediateCode(): Unit = {
    val optimizedTADs = Optimization.contantPropagation(TADs)

    def cleanOfAnnotations(tads : Seq[Statement]) = optimizedTADs.filter(tad => !tad.toString.contains("#"))

    val cleaned = cleanOfAnnotations(optimizedTADs)
    //Console.println(intermediateCode)
    for (tad: Statement <- cleaned)
      Console.println(tad)

  }

  def enterF_p(ct: CParser.F_pContext): Unit = {
  }

  def enterF_d(ct: CParser.F_dContext): Unit = {
    val functionName = ct.ID().getText
    import collection.JavaConverters._
    val parameterNameList: Seq[String] = Rules.Utils.getChildrenID(ct.parametersList()).asScala.toSeq
    functionDeclarationNamesToParameters.put(functionName, parameterNameList)
    functionDeclarationNamesToFunctionDeclarations.put(functionName, ct)
  }


  def enterProg (ctx: CParser.ProgContext) : Unit = {

    var numericalID_to_ID= scala.collection.mutable.Map[Int, String]()

    def stat_TAC(ctx: CParser.StatContext): Seq[Statement] = {

      var code : Seq[Statement] = Seq[Statement]()


      def to_value_TAC(assignment : Int, ct: CParser.To_valueContext) : Seq[Statement] = {
        var code = ListBuffer[Statement]()
        if (ct.math_operation != null) {
          var mathTuple = new MathTuple("", globalIdentifier)
          mathTuple = parseMath(mathTuple, ct.math_operation)
          code.append(SimpleStatement(mathTuple.acumulatedIntermediateCode))
          globalIdentifier = mathTuple.ID
          //code += "math t" + globalIdentifier
        }

        val currentID = numericalID_to_ID.getOrElse(globalIdentifier, "t" + globalIdentifier)

        if (ct.f_c != null) code.++=(fc_TAC(assignment, ct.f_c))
        if (ct.digit != null) {
          code += Copy(Asignee = currentID, Asignor = ct.getText)
        }
        if (ct.ID != null) {
          code += Copy(Asignee = currentID, Asignor = ct.getText)
        }


        code
      }


      def variable_declaration_TAC(ct: CParser.Variable_declarationContext): Seq[Statement] = {
        val code = ListBuffer[Statement]()
        import collection.JavaConverters._

        val ID_and_values: Seq[(TerminalNode, CParser.To_valueContext)] = ct.ID().asScala.toSeq zip ct.to_value().asScala.toSeq
        for  (zipped <- ID_and_values){
          val ID = zipped._1.getText
          globalIdentifier += 1
          numericalID_to_ID += ((globalIdentifier, ID))
          val globalIdentifier_before_evaluation = globalIdentifier
          code.++=(to_value_TAC(assignment = -1, zipped._2))
          if (globalIdentifier_before_evaluation < globalIdentifier) {

            code.append(Copy(Asignee = ID, Asignor = "declarated t" + globalIdentifier))
          }
        }
        code
      }

      def assignation_TAC(ct: CParser.AssignationContext): Seq[Statement] =
      {


        globalIdentifier += 1

        val lineNumber = ct.start.getLine
        val ID = ct.ID().getText
        var code = ListBuffer[Statement]()

        numericalID_to_ID += ((globalIdentifier, ID))
        if (ct.to_value() != null) code ++= to_value_TAC(assignment = globalIdentifier, ct.to_value)
        else code += SimpleStatement(ct.ID() + (if (ct.INCR_DECR().toString() == "++") "+1" else "-1"))
        code
      }

      def fc_TAC(assignment : Int, ct : CParser.F_cContext): Seq[Statement] ={

        var code = ListBuffer[Statement]()

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

            //code += "evaluating parameter "+parameter.getText+" of function " + functionName
            code.++=(to_value_TAC(assignment = -1, parameter))
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

            val statements: Seq[Statement] = stat_TAC(stat)

            def substitute(stat : Statement) : Statement = {
              var acumulatedReplacements = stat
              for (substitution <- substitutions) {
                var replacement = substitution._2
                if (functionDeclarationNamesToParameters.containsKey(substitution._2))
                  replacement = "t" + (globalIdentifier - 1)
                def r(a : String ):String = a.replace(substitution._1, replacement)

                acumulatedReplacements = acumulatedReplacements match {
                  case SimpleStatement(s) => SimpleStatement(r(s))
                  case Copy(a,b) => Copy(r(a), r(b))
                  case Quad(a,b,c,d) => Quad(r(a), r(b), r(c), r(d))
                }
              }
              acumulatedReplacements
            }
            val subtituted = statements.map( statement => substitute(statement))

            code ++= subtituted



        }
        val currentID = numericalID_to_ID.getOrElse(assignment, "never gonna happen")

        if (assignment != -1) {
          code += SimpleStatement("#function return below. do not touch.")
          code += Copy(Asignee = currentID, Asignor = "t" + globalIdentifier)
        }
        code
      }

      def codeblock_TAC(context: CParser.Code_blockContext): Seq[Statement] ={

        var code = ListBuffer[Statement]()
        import collection.JavaConverters._
        for(stat <- context.stat().asScala.toSeq){
          code ++= stat_TAC(stat)
        }
        code
      }

      def ret_TAC(context: CParser.RetContext) : Seq[Statement]  = {

        to_value_TAC(assignment = -1, context.to_value())
      }

      def if_TAC(context: CParser.If_conditionContext): Seq[Statement] ={


        //context.logic_op()
        var code = ListBuffer[Statement]()

        def codeblock_TAC (codeblock: CParser.Code_blockContext) : Seq[Statement] =  {

          import collection.JavaConverters._
          val stat =  codeblock.stat().asScala.toSeq

          for (s <- stat)
            code ++= stat_TAC(context.stat())
          code
        }

        globalIdentifier += 1
        //TODO parse logic_op to 3 address code
        val conditionID = "condition"+globalIdentifier
        code += Copy(Asignee = ""+conditionID, Asignor = context.logic_op().getText)


        labelIdentifier += 1
        code += SimpleStatement(statement = "ifNot("+conditionID+") goto L" + labelIdentifier+"")
        if(context.code_block() != null){


          code ++= codeblock_TAC(context.code_block())


        }
        else
          code ++= stat_TAC(context.stat())
        code += SimpleStatement(statement = "L"+labelIdentifier+":")


        if (context.else_condition() != null){
          if (context.else_condition().code_block() != null)
            code ++= codeblock_TAC(context.else_condition().code_block())
          else
            code ++= stat_TAC(context.else_condition().stat())
        }
        code
      }

      if (ctx.variable_declaration() != null) code ++= variable_declaration_TAC(ctx.variable_declaration())

      if (ctx.assignation() != null) code ++= assignation_TAC(ctx.assignation())

      if (ctx.f_c() != null) code ++= fc_TAC(assignment = -1, ctx.f_c())

      //if (ctx.f_d() != null) code += fd_TAC(ctx.f_d())

      if (ctx.ret() != null) code ++= ret_TAC(ctx.ret())


      if (ctx.if_condition() != null) code ++= if_TAC(ctx.if_condition())

     /*

      if (ctx.for_loop() != null) for_loop_TAC(ctx.assignation())
      if (ctx.while_loop() != null) while_TAC(ctx.assignation())*/
      code
    }




    import collection.JavaConverters._
    for (stat : StatContext <- ctx.stat().asScala.toSeq){
      //intermediateCode += stat_TAC(stat)
      TADs.++=(stat_TAC(stat))
    }
  }






}