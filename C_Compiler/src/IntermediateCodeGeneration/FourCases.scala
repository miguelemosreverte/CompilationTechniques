package IntermediateCodeGeneration
import C_ANTLR.CParser.{FactorContext, ProductContext, SumContext}
import org.antlr.v4.runtime.ParserRuleContext

object FourCases {

  def willRequireExtraCalculations(context: ParserRuleContext): Boolean = {

    if(context.isInstanceOf[SumContext]) {
      val sum = context.asInstanceOf[SumContext]
      sum.product.factor.math_operand.grouped != null || !sum.product.unapplied_medium_op.isEmpty
    }

    else if(context.isInstanceOf[ProductContext]) {
      val product = context.asInstanceOf[ProductContext]
      product.factor.math_operand.grouped != null || !product.unapplied_medium_op.isEmpty
    }

    else {//if(context.isInstanceOf[FactorContext]) {
      val factor = context.asInstanceOf[FactorContext]
      factor.math_operand.grouped != null || !factor.unapplied_high_op().isEmpty
    }
  }




  def workLoad[Expr <: ParserRuleContext]
  (op1: Expr, op: String, op2: Expr, tuple : MathTuple, nextID : Integer)
  (implicit p: Parseable[Expr]) : MathTuple = {
    if (!willRequireExtraCalculations(op1) && !willRequireExtraCalculations(op2)) {
      //tuple.set_acumulatedIntermediateCode("\nCASO1-"+ tuple.operand1ID)
      CASOUNO(op1, op, op2, tuple, nextID)
    }
    else if (willRequireExtraCalculations(op1) && !willRequireExtraCalculations(op2)) {
      //tuple.set_acumulatedIntermediateCode("\nCASO2-"+ tuple.operand1ID)
      CASODOS(op1, op, op2, tuple, nextID)
    }
    else if (!willRequireExtraCalculations(op1) && willRequireExtraCalculations(op2)) {
      //tuple.set_acumulatedIntermediateCode("\nCASO3-"+ tuple.operand1ID)
      CASOTRES(op1, op, op2, tuple, nextID)
    }
    else{ //if (willRequireExtraCalculations(op1) && willRequireExtraCalculations(op2)) {
      //tuple.set_acumulatedIntermediateCode("\nCASO4-"+ tuple.operand1ID)
      CASOCUATRO(op1, op, op2, tuple, nextID)
    }
  }

  import Parseable.syntax._

  //case 1
  // there is a sum of two non-groups.
  def CASOUNO[Expr <: ParserRuleContext]
  (operand1: Expr, operation: String, operand2: Expr, tuple: MathTuple, givenNextID : Integer)
  (implicit p: Parseable[Expr]): MathTuple = {

    tuple.set_ID(tuple.ID + 1)
    tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=")
    if (tuple.operand1ID != 0) {
      tuple.set_acumulatedIntermediateCode("t" + tuple.operand1ID)
      tuple.operand1ID = tuple.ID
    }
    else {
      operand1 ¬>> tuple
    }
    tuple.set_acumulatedIntermediateCode(operation)
    operand2 ¬>> tuple
    tuple
  }


  //case 2
  // there is a sum of a left group and a right final
  def CASODOS[Expr <: ParserRuleContext]
  (operand1: Expr, operation: String, operand2: Expr, tuple: MathTuple, givenNextID : Integer)
  (implicit p: Parseable[Expr]): MathTuple = {

    if (tuple.operand1ID != 0) {
      //tuple.set_acumulatedIntermediateCode("t" + tuple.operand1ID)
    }
    else {
      operand1 ¬>> tuple
    }
    tuple.operand1ID = tuple.ID

    tuple.set_ID(tuple.ID + 1)
    tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=" + "t" + tuple.operand1ID)
    tuple.set_acumulatedIntermediateCode(operation)
    operand2 ¬>> tuple
    tuple
  }


  //case 3
  // there is a sum of a left final and a right group

  def CASOTRES[Expr <: ParserRuleContext]
  (operand1: Expr, operation: String, operand2: Expr, tuple: MathTuple, givenNextID : Integer)
  (implicit p: Parseable[Expr]): MathTuple = {




    val pepe = tuple.operand1ID
    tuple.operand1ID = 0
    operand2 ¬>> tuple
    val operand2_ID = tuple.ID

    tuple.set_ID(tuple.ID + 1)
    tuple.set_acumulatedIntermediateCode("\nt" + tuple.ID + ":=")
    tuple.set_acumulatedIntermediateCode("")


    if (pepe != 0) {
      tuple.set_acumulatedIntermediateCode("t" + pepe)
    }
    else {
      operand1 ¬>> tuple
    }
    val operand1ID = tuple.ID


    tuple.set_acumulatedIntermediateCode(operation)
    tuple.set_acumulatedIntermediateCode("t" + operand2_ID)

    tuple.operand1ID = operand1ID
    tuple
  }


  //case 4
  // there is a sum of a left group and a right group

  def CASOCUATRO[Expr <: ParserRuleContext]
  (operand1: Expr, operation: String, operand2: Expr, tuple: MathTuple, givenNextID : Integer)
  (implicit p: Parseable[Expr]): MathTuple = {


    if (tuple.operand1ID != 0) {
      //tuple.set_acumulatedIntermediateCode("t" + tuple.operand1ID)
    }
    else {
      operand1 ¬>> tuple
    }
    val operand1ID = tuple.ID


    tuple.operand1ID = 0
    operand2 ¬>> tuple
    val operand2_ID = tuple.ID

    tuple.set_ID(tuple.ID + 1)
    tuple.set_acumulatedIntermediateCode("\nt4" + tuple.ID + ":=")
    tuple.set_acumulatedIntermediateCode("t" + operand1ID)
    tuple.set_acumulatedIntermediateCode(operation)
    tuple.set_acumulatedIntermediateCode("t" + operand2_ID)

    tuple.operand1ID = operand1ID
    tuple
  }

}
