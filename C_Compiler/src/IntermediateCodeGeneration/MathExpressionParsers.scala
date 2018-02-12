package IntermediateCodeGeneration

import C_ANTLR.CParser._
import IntermediateCodeGeneration.FourCases.{CASOCUATRO, CASODOS, CASOTRES, CASOUNO, workLoad}
import org.antlr.v4.runtime.ParserRuleContext




@FunctionalInterface trait parseGeneric[GenericCParser] {
  def parse(tuple: MathTuple, parser: GenericCParser): MathTuple
}


object MathExpressionParsers {


  import C_ANTLR.CParser
  import java.util



  def parseUnapplied_Low_Op(tuple: MathTuple, low: CParser.Unapplied_low_opContext): MathTuple = {
    parseProduct(tuple, low.product)
  }


  def parseUnapplied_Medium_Op(tuple: MathTuple, medium: CParser.Unapplied_medium_opContext): MathTuple = {
    tuple.set_acumulatedIntermediateCode(medium.MATH_OP_MEDIUM_PRIORITY.getText)
    parseFactor(tuple, medium.factor)
  }


  def parseUnapplied_High_Op(tuple: MathTuple, high: CParser.Unapplied_high_opContext): MathTuple = { //tuple = parseMathOperand(tuple, high.math_operand());
    tuple
  }


  def parseGroupedMath(tuple: MathTuple, grouped: CParser.GroupedContext): MathTuple
  = parseMath(tuple, grouped.math_operation)


  def parseMathOperand(tuple: MathTuple, operand: CParser.Math_operandContext): MathTuple = {
    if (operand.grouped != null) parseGroupedMath(tuple, operand.grouped)
    else {
      tuple.set_acumulatedIntermediateCode(operand.getText)
      tuple
    }
  }


  def parseFactor(tuple: MathTuple, factor: CParser.FactorContext): MathTuple = {
    parseMathOperand(tuple, factor.math_operand)
  }

  import C_ANTLR.CParser

  def parseProduct(tuple_original: MathTuple, product: ProductContext): MathTuple = {
    var tuple = tuple_original
    var medium_op_counter = 0
    if (product.unapplied_medium_op.isEmpty) {
      tuple = parseFactor(tuple, product.factor)
      return tuple // not really necessary, but helps posterior analisis

    }
    import scala.collection.JavaConversions._
    for (medium_op <- product.unapplied_medium_op) {
      if (medium_op_counter == 0) {
        if (product.factor.math_operand.grouped == null) { //if it is a group we are going to be back here in a minute,
          //so no need to print this twice.
          // grouped is the only recursive math operand.
          tuple.set_ID(tuple.ID + 1)
          tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=")
        }
        tuple = parseFactor(tuple, product.factor)
        var givenID = tuple.ID
        tuple = parseUnapplied_Medium_Op(tuple, medium_op)
        givenID = tuple.ID
      }
      else {
        var givenID = tuple.ID
        tuple.set_ID(tuple.ID + 1)
        tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=t" + givenID)
        tuple = parseUnapplied_Medium_Op(tuple, medium_op)
        givenID = tuple.ID
      }
      medium_op_counter += 1
    }
    tuple
  }





  def parseGeneric(original_tuple: MathTuple,
               context: ParserRuleContext, // context
               shrinkableList: scala.collection.immutable.List[ParserRuleContext])
  : MathTuple = {

    import MyContext._
    import Parseable._
    import Parseable.syntax._



    def exprParser[A <: ParserRuleContext](mathExpr: MathExpr[A]): MathTuple =
      mathExpr match {
        case SumExpr(op1, op, op2) =>
          if (shrinkableList.isEmpty) op1 ¬>> original_tuple
          else {
            val parsedMathTuple = workLoad(op1, op, op2, original_tuple, original_tuple.operand1ID)

            if (!shrinkableList.tail.isEmpty) {
              //parsedMathTuple.set_acumulatedIntermediateCode("\n---parseGeneric op1ID is " + parsedMathTuple.operand1ID)
              return parseGeneric(parsedMathTuple, context, shrinkableList.tail)
            }
            parsedMathTuple
          }

        /*
        case ProdExpr(op1, op, op2) =>
          if (shrinkableList.isEmpty) op1 ¬>> original_tuple
          else {
            val (parsedMathTuple, following_nextID) = workLoad(op1, op, op2, original_tuple, nextID)
            if (!shrinkableList.tail.isEmpty) {
              parsedMathTuple.set_acumulatedIntermediateCode(" PEPE \n")

              return parseGeneric(parsedMathTuple, context, shrinkableList.tail, following_nextID)
            }
            parsedMathTuple
          }*/

      }

    val pepe = toMyContext(context, shrinkableList)
    exprParser(pepe)

  }


  def parseMath(tuple: MathTuple, math_expression: CParser.Math_operationContext): MathTuple = {
    import collection.JavaConverters._
    val unappliedOps: List[Unapplied_low_opContext] = math_expression.sum().unapplied_low_op().asScala.toList
    parseGeneric(tuple, math_expression.sum, unappliedOps)
  }

}