package IntermediateCodeGeneration

import C_ANTLR.CParser._
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

import scala.collection.JavaConverters._

sealed trait MyContext
case class MyProductContext(val initialOperand: FactorContext
                            , val unappliedList: Map[String, FactorContext]) extends MyContext
case class MySumContext(val initialOperand: ProductContext
                        , val unappliedList: Map[String, ProductContext]) extends MyContext

object MyContext {
  implicit def toMyContext
  (context: ParserRuleContext,
   shrinkableList: scala.collection.immutable.List[ParserRuleContext],
  ): MathExpr[_ >: ProductContext with FactorContext <: ParserRuleContext] = {


    if(context.isInstanceOf[SumContext]) {
      val specificContext = context.asInstanceOf[SumContext]
      val operand1 = specificContext.product()
      val unappliedOp = shrinkableList.head.asInstanceOf[Unapplied_low_opContext]
      val operation = unappliedOp.MATH_OP_LOW_PRIORITY().getText
      val operand2 = unappliedOp.product()
      SumExpr(operand1, operation, operand2)


    } else{
      val specificContext = context.asInstanceOf[ProductContext]
      val operand1 = specificContext.factor()
      val unappliedOp = shrinkableList.head.asInstanceOf[Unapplied_medium_opContext]
      val operation = unappliedOp.MATH_OP_MEDIUM_PRIORITY().getText
      val operand2 = unappliedOp.factor()
      ProdExpr(operand1, operation, operand2)
    }//TODO add factorContext here
  }
}