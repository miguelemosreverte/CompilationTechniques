package IntermediateCodeGeneration

class MathTuple {

  var acumulatedIntermediateCode: String = ""
  var ID: Integer = 0

  def this(acumulatedIntermediateCode: String, ID: Integer) {
    this()
    this.acumulatedIntermediateCode = acumulatedIntermediateCode
    this.ID = ID
  }


  private[IntermediateCodeGeneration] def set_acumulatedIntermediateCode(code: String) = new MathTuple(this.acumulatedIntermediateCode + code, this.ID)

  private[IntermediateCodeGeneration] def set_ID(ID: Integer) = new MathTuple(this.acumulatedIntermediateCode, ID)

}
