package IntermediateCodeGeneration

import C_ANTLR.CParser._
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
    val nextTuple : MathTuple = tuple.set_acumulatedIntermediateCode(medium.MATH_OP_MEDIUM_PRIORITY.getText)
    parseFactor(nextTuple, medium.factor)
  }


  def parseUnapplied_High_Op(tuple: MathTuple, high: CParser.Unapplied_high_opContext): MathTuple = { //tuple = parseMathOperand(tuple, high.math_operand());
    tuple
  }


  def parseGroupedMath(tuple: MathTuple, grouped: CParser.GroupedContext): MathTuple = parseMath(tuple, grouped.math_operation)


  def parseMathOperand(tuple: MathTuple, operand: CParser.Math_operandContext): MathTuple = {
    if (operand.grouped != null) parseGroupedMath(tuple, operand.grouped)
    else tuple.set_acumulatedIntermediateCode(operand.getText)
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
          tuple = tuple.set_ID(tuple.ID + 1)
          tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=")
        }
        tuple = parseFactor(tuple, product.factor)
        var givenID = tuple.ID
        tuple = parseUnapplied_Medium_Op(tuple, medium_op)
        givenID = tuple.ID
      }
      else {
        var givenID = tuple.ID
        tuple = tuple.set_ID(tuple.ID + 1)
        tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=t" + givenID)
        tuple = parseUnapplied_Medium_Op(tuple, medium_op)
        givenID = tuple.ID
      }
      medium_op_counter += 1
    }
    tuple
  }

  def willRequireExtraCalculations(context: ParserRuleContext): Boolean = {
    import MyContext._
    toMyContext(context) match {

      case MySumContext(initialOperand, map) =>
        initialOperand.factor.math_operand.grouped != null || !map.isEmpty


      case MyProductContext(initialOperand, map) =>
        initialOperand.math_operand.grouped != null || !map.isEmpty
    }

  }






  def parseGeneric(original_tuple: MathTuple,
               context: ParserRuleContext, // context
               shrinkableList: scala.collection.immutable.List[Unapplied_low_opContext],
               given_nextID : Integer)
  : MathTuple = {

    import scala.collection.JavaConverters._


    var tuple = original_tuple
    var nextID = given_nextID


    import Parseable.syntax._

    //case 1
    // there is a sum of two non-groups.
    def CASOUNO[Expr <: ParserRuleContext]
    (operand1: Expr, operation: String, operand2: Expr)
    (implicit p: Parseable[Expr]) = {

      tuple = tuple.set_ID(tuple.ID + 1)
      tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=")
      if (nextID != 0) {
        tuple = tuple.set_acumulatedIntermediateCode("t" + nextID)
        nextID = tuple.ID
      }
      else {
        tuple = operand1 ¬>> tuple
        val operand1_ID = tuple.ID
        nextID = operand1_ID
      }
      tuple = tuple.set_acumulatedIntermediateCode(operation)
      tuple = operand2 ¬>> tuple
      val operand2_ID = tuple.ID
    }


    //case 2
    // there is a sum of a left group and a right final
    def CASODOS[Expr <: ParserRuleContext]
    (operand1: Expr, operation: String, operand2: Expr)
    (implicit p: Parseable[Expr])= {
      tuple = operand1 ¬>> tuple
      val operand1_ID = tuple.ID
      tuple = tuple.set_ID(tuple.ID + 1)
      tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=" + "t" + operand1_ID)
      tuple = tuple.set_acumulatedIntermediateCode(operation)
      tuple = operand2 ¬>> tuple
      val operand2_ID = tuple.ID
    }


    //case 3
    // there is a sum of a left final and a right group

    def CASOTRES[Expr <: ParserRuleContext]
    (operand1: Expr, operation: String, operand2: Expr)
    (implicit p: Parseable[Expr])= {
      tuple = operand2 ¬>> tuple
      val operand2_ID = tuple.ID
      tuple = tuple.set_ID(tuple.ID + 1)
      tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=")
      if (nextID != 0) {
        tuple = tuple.set_acumulatedIntermediateCode("t" + nextID)
        nextID = tuple.ID
      }
      else {
        tuple = operand1 ¬>> tuple
        val operand1_ID = tuple.ID
        nextID = operand1_ID
      }
      tuple = tuple.set_acumulatedIntermediateCode(operation)
      tuple = tuple.set_acumulatedIntermediateCode("t" + operand2_ID)
    }


    //case 4
    // there is a sum of a left group and a right group

    def CASOCUATRO[Expr <: ParserRuleContext]
    (operand1: Expr, operation: String, operand2: Expr)
    (implicit p: Parseable[Expr])= {
      tuple = operand2 ¬>> tuple
      val operand2_ID = tuple.ID
      tuple = operand1 ¬>> tuple
      val operand1_ID = tuple.ID
      tuple = tuple.set_ID(tuple.ID + 1)
      tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=")
      tuple = tuple.set_acumulatedIntermediateCode("t" + operand1_ID)
      tuple = tuple.set_acumulatedIntermediateCode(operation)
      tuple = tuple.set_acumulatedIntermediateCode("t" + operand2_ID)
    }


    def workLoad[Expr <: ParserRuleContext]
        (op1: Expr, op: String, op2: Expr)
        (implicit p: Parseable[Expr])= {
      if (!willRequireExtraCalculations(op1) && !willRequireExtraCalculations(op2)) {
        CASOUNO(op1, op, op2)
      }
      if (willRequireExtraCalculations(op1) && !willRequireExtraCalculations(op2)) {
        CASODOS(op1, op, op2)
      }
      if (!willRequireExtraCalculations(op1) && willRequireExtraCalculations(op2)) {
        CASOTRES(op1, op, op2)
      }
      if (willRequireExtraCalculations(op1) && willRequireExtraCalculations(op2)) {
        CASOCUATRO(op1, op, op2)
      }
    }


    // interpret
    /*
    def exprParser[A](mathExpr: MathExpr[A]) =
      mathExpr match {
        case SumExpr(op1, op, op2) =>
          workLoad(op1, op, op2)
        case ProdExpr(op1, op, op2) =>
          workLoad(op1, op, op2)
      }
    */




    //from here on we can assume there are unapplied low operations to work with
    //after taking what we are going to use, we remove it from the list
    //for this I needed a shrinkable list because sum.unapplied_low_op()
    //would return a constant value.
    /*

            Just a bit of trivia, before continuing:

            non-group is the same as final. Means a non-recursive math operand.

            This means that it is expected for that value to be processed into a single operand.

            A recursive math operand means that it is expected to become N extra steps.

            */



    // prog
    import MyContext._
    import Parseable._
    import Parseable.syntax._
    val mathExpr = toMyContext(context) match {
      case MySumContext(initialOperand, map) =>
        //case 0
        // there is just a product
        if (map.isEmpty) {
          return initialOperand ¬>> tuple
        }
        val operand1 = initialOperand
        val (operator: String, operand2: ProductContext) = map.head

        workLoad(operand1, operator, operand2)
      case MyProductContext(initialOperand, map) =>
        if (map.isEmpty) {
          return initialOperand ¬>> tuple
        }
        val operand1: FactorContext = initialOperand
        val (operator: String, operand2: FactorContext) = map.head
        workLoad(operand1, operator, operand2)
    }

    if (!shrinkableList.isEmpty) {
      tuple = parseGeneric(tuple, context, shrinkableList.tail, nextID)
    }
    tuple

  }


  def parseMath(tuple: MathTuple, math_expression: CParser.Math_operationContext): MathTuple = {
    import collection.JavaConverters._
    val unapliedOps: List[Unapplied_low_opContext] = math_expression.sum().unapplied_low_op().asScala.toList
    parseGeneric(tuple, math_expression.sum, unapliedOps, 0)
  }

}