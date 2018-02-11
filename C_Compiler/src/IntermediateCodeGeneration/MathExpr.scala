package IntermediateCodeGeneration

import C_ANTLR.CParser.{FactorContext, ProductContext}
import org.antlr.v4.runtime.ParserRuleContext

sealed trait MathExpr[A <: ParserRuleContext] {
  def op1: A
  def op: String
  def op2: A
}
case class SumExpr(val op1: ProductContext
                   , val op: String
                   , val op2: ProductContext) extends MathExpr[ProductContext]
case class ProdExpr(val op1: FactorContext
                    , val op: String
                    , val op2: FactorContext) extends MathExpr[FactorContext]
