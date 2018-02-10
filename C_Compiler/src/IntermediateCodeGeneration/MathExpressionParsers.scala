package IntermediateCodeGeneration

import C_ANTLR.CParser.ProductContext


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

  def parseProduct(tuple_original: MathTuple, product_original: ProductContext): MathTuple = {
    val product = product_original.asInstanceOf[CParser.ProductContext]

    var tuple = tuple_original
    var medium_op_counter = 0
    if (product.unapplied_medium_op.isEmpty) {
      tuple = parseFactor(tuple, product.factor)
      return tuple // not really necessary, but helps posterior analisis

    }
    import scala.collection.JavaConverters._
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

  def willRequireExtraCalculations(product: CParser.ProductContext): Boolean = product.factor.math_operand.grouped != null || !product.unapplied_medium_op.isEmpty

  def parseSum(original_tuple: MathTuple,
               sum: CParser.SumContext,
               shrinkableList: util.List[CParser.Unapplied_low_opContext],
               given_nextID : Integer,
              ): MathTuple = {
    val operand1 = sum.product
    var tuple = original_tuple
    var nextID = given_nextID
    //case 0
    // there is just a product
    if (sum.unapplied_low_op.isEmpty) {
      return parseProduct(tuple, sum.product)
    }
    //from here on we can assume there are unapplied low operations to work with
    //after taking what we are going to use, we remove it from the list
    //for this I needed a shrinkable list because sum.unapplied_low_op()
    //would return a constant value.
    val mod_shrinkableList = if (shrinkableList.isEmpty) sum.unapplied_low_op else shrinkableList
    val unapplied_low_op = mod_shrinkableList.remove(0)
    val operand2 = unapplied_low_op.product
    val operation = unapplied_low_op.MATH_OP_LOW_PRIORITY.getText
    /*

            Just a bit of trivia, before continuing:

            non-group is the same as final. Means a non-recursive math operand.

            This means that it is expected for that value to be processed into a single operand.

            A recursive math operand means that it is expected to become N extra steps.

            */


    //case 1
    // there is a sum of two non-groups.

    if (!willRequireExtraCalculations(operand1) && !willRequireExtraCalculations(operand2)) {
      tuple = tuple.set_ID(tuple.ID + 1)
      tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=")
      if (nextID != 0) {
        tuple = tuple.set_acumulatedIntermediateCode("t" + nextID)
        nextID = tuple.ID
      }
      else {
        tuple = parseProduct(tuple, operand1)
        val operand1_ID = tuple.ID
        nextID = operand1_ID
      }
      tuple = tuple.set_acumulatedIntermediateCode(operation)
      tuple = parseProduct(tuple, operand2)
      val operand2_ID = tuple.ID
    }




    //case 2
    // there is a sum of a left group and a right final

    if (willRequireExtraCalculations(operand1) && !willRequireExtraCalculations(operand2)) {
      tuple = parseProduct(tuple, operand1)
      val operand1_ID = tuple.ID
      tuple = tuple.set_ID(tuple.ID + 1)
      tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=" + "t" + operand1_ID)
      tuple = tuple.set_acumulatedIntermediateCode(operation)
      tuple = parseProduct(tuple, operand2)
      val operand2_ID = tuple.ID
    }





    //case 3
    // there is a sum of a left final and a right group

    if (!willRequireExtraCalculations(operand1) && willRequireExtraCalculations(operand2)) {
      tuple = parseProduct(tuple, operand2)
      val operand2_ID = tuple.ID
      tuple = tuple.set_ID(tuple.ID + 1)
      tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=")
      if (nextID != 0) {
        tuple = tuple.set_acumulatedIntermediateCode("t" + nextID)
        nextID = tuple.ID
      }
      else {
        tuple = parseProduct(tuple, operand1)
        val operand1_ID = tuple.ID
        nextID = operand1_ID
      }
      tuple = tuple.set_acumulatedIntermediateCode(operation)
      tuple = tuple.set_acumulatedIntermediateCode("t" + operand2_ID)
    }





    //case 4
    // there is a sum of a left group and a right group

    if (willRequireExtraCalculations(operand1) && willRequireExtraCalculations(operand2)) {
      tuple = parseProduct(tuple, operand2)
      val operand2_ID = tuple.ID
      tuple = parseProduct(tuple, operand1)
      val operand1_ID = tuple.ID
      tuple = tuple.set_ID(tuple.ID + 1)
      tuple = tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=")
      tuple = tuple.set_acumulatedIntermediateCode("t" + operand1_ID)
      tuple = tuple.set_acumulatedIntermediateCode(operation)
      tuple = tuple.set_acumulatedIntermediateCode("t" + operand2_ID)
    }




    if (!mod_shrinkableList.isEmpty) {
      System.out.println(mod_shrinkableList.get(0).getText)
      tuple = parseSum(tuple, sum, mod_shrinkableList, nextID)
    }
    tuple
  }


  def parseMath(tuple: MathTuple, math_expression: CParser.Math_operationContext): MathTuple = {
    val emptyList = new util.ArrayList[CParser.Unapplied_low_opContext]
    parseSum(tuple, math_expression.sum, emptyList, 0)
  }

}