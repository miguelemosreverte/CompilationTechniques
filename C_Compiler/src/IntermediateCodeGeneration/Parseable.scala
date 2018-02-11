package IntermediateCodeGeneration

import C_ANTLR.CParser.{FactorContext, ProductContext}
import IntermediateCodeGeneration.MathExpressionParsers.{parseFactor, parseProduct}
import org.antlr.v4.runtime.ParserRuleContext

trait Parseable[A <: ParserRuleContext] {
  def parse(tuple: MathTuple, a: A): MathTuple
}

object Parseable {

  def apply[A <: ParserRuleContext](implicit p: Parseable[A]): Parseable[A] = p

  def from[A <: ParserRuleContext](f: (MathTuple, A)=> MathTuple): Parseable[A] = new Parseable[A] {
    def parse(tuple: MathTuple, a: A): MathTuple = f(tuple, a)
  }

  def parse[A <: ParserRuleContext](tuple: MathTuple, a: A)
                                   (implicit p: Parseable[A]): MathTuple =
    p.parse(tuple, a)

  object syntax {
    implicit class ParseableOps[A <: ParserRuleContext](target: A)
                                  (implicit p: Parseable[A]){
      def ¬>>(tuple: MathTuple): MathTuple =
        p.parse(tuple, target)
    }
  }

  // type class instances
  implicit val productParseable: Parseable[ProductContext] =
    from[ProductContext](parseProduct)

  implicit val factorParseable: Parseable[FactorContext] =
    from[FactorContext](parseFactor)

}




