import IntermediateCodeGeneration.{Copy, Quad, SimpleStatement, Statement}

import scala.collection.mutable.ListBuffer

package object Optimization {

  def contantPropagation(tads: Seq[Statement]): Seq[Statement] = {

    val untouchables = ListBuffer[Statement]()
    var last_tad: Statement = SimpleStatement("fictional beggining");
    for (tad <- tads) {
      if (last_tad.toString == "#function return below. do not touch.")
        untouchables += tad
      last_tad = tad
    }


    val nonPropagatedconstants: Seq[Statement] =
      tads.filter(tad =>
        tad match {
          case Copy(a, b) => !(b forall Character.isDigit) && !b.contains("<") && !untouchables.contains(Copy(a, b))
          case _ => false
        })

    val constants =
      tads.filter(tad =>
        tad match {
          case Copy(_, b) => b forall Character.isDigit
          case _ => false
        })

    Console.println("nonPropagatedconstants are " + nonPropagatedconstants)
    Console.println("constants are " + constants)

    val pepe = tads.map(tad => tad match {
      case Copy(a, b) => {
        var result = Copy(a, b);
        if (nonPropagatedconstants.contains(result)) {
          for (constant <- constants) {
            val casted = constant.asInstanceOf[Copy]
            if (casted.Asignee == b) {
              if (!untouchables.contains(result))
                result = Copy(a, casted.Asignor)
            }
          }

        }
        result
      }
      case Quad(a, b, c, d) => {
        var result = Quad(a, b, c, d)
        if (nonPropagatedconstants.contains(result)) {
          for (constant <- constants) {
            val casted = constant.asInstanceOf[Copy]
            if (casted.Asignee == b) {
              if (!untouchables.contains(result))
                result = Quad(a, casted.Asignor, c, d)
            }
          }

        }
        result
      }
      case other => other
    })

    Console.println("--------------------")
    if (!nonPropagatedconstants.isEmpty)
      return contantPropagation(pepe)
    pepe
  }
}
