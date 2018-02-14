package IntermediateCodeGeneration

class MathTuple {

  var acumulatedIntermediateCode: String = ""
  var ID: Integer = 0
  var operand1ID: Integer = 0

  def this(acumulatedIntermediateCode: String, ID: Integer) {
    this()
    this.acumulatedIntermediateCode = acumulatedIntermediateCode
    this.ID = ID
  }


  private[IntermediateCodeGeneration] def set_acumulatedIntermediateCode(code: String) = this.acumulatedIntermediateCode += code

  private[IntermediateCodeGeneration] def set_ID(ID: Integer) = this.ID = ID

  private[IntermediateCodeGeneration] def set_operand1ID(ID: Integer) = this.operand1ID = ID

}
