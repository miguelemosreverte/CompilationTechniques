package IntermediateCodeGeneration

trait Statement {
  def State : String
}
trait Assignment extends Statement{
  def Asignee: String
  def Asignor: String
  def State = toString
  override def toString = Asignee + " := " + Asignor
}
case class Copy(Asignee:String, Asignor:String) extends Assignment
case class Quad(Asignee:String, Asignor:String, Operation: String, Operand2 : String ) extends Assignment {
  override def toString = super[Assignment].toString + Operation + Operand2
}
case class SimpleStatement(statement: String ) extends Statement {
  override def State = super[Statement].toString
  override def toString = statement
}