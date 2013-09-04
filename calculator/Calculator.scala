object Calculator extends Arith {
  def main(args: Array[String]) {
    println("input: " + args(0))
    println("result: " + parseAll(expr, args(0)).get)
  }
}
