package IntermediateCodeGeneration

import C_ANTLR.CParser.{FactorContext, ProductContext, SumContext}
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

import scala.collection.JavaConverters._

sealed trait MyContext
case class MyProductContext(val initialOperand: FactorContext
                            , val unappliedList: Map[String, FactorContext]) extends MyContext
case class MySumContext(val initialOperand: ProductContext
                        , val unappliedList: Map[String, ProductContext]) extends MyContext

object MyContext {
  implicit def toMyContext(context: ParserRuleContext): MyContext  = {
    if(context.isInstanceOf[SumContext]) {
      val sum = context.asInstanceOf[SumContext]
      val unappliedList: Map[String, ProductContext] = sum.unapplied_low_op.asScala.toList.map { ul =>
        val mathOperator = ul.MATH_OP_LOW_PRIORITY().getText()
        val product = ul.product()
        (mathOperator, product)
      }.toMap
      val initialOperand: ProductContext = sum.product()
      MySumContext(initialOperand, unappliedList)
    } else{
      val product = context.asInstanceOf[ProductContext]
      val unappliedList: Map[String, FactorContext] = product.unapplied_medium_op().asScala.toList.map { ul =>
        val mathOperator = ul.MATH_OP_MEDIUM_PRIORITY().getText()
        val factor = ul.factor()
        (mathOperator, factor)
      }.toMap
      val initialOperand: FactorContext = product.factor()
      MyProductContext(initialOperand, unappliedList)
    }//TODO add factorContext here
  }
}