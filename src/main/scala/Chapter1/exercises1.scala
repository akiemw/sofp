
@main()
def test() = {
  println("--" * 25 + "\n" * 5)
  ex1()
  ex2()
  ex3()
  ex4()
  println("--" * 25 + "\n" * 5)
}

def ex1(): Unit = {
  println("Entering solution to Exercise 1.6.1.1 ...")
  def fact(n: Int) = (1 to n).filter(k => if n % 2 == 0 && k % 2 == 0 then true else if n % 2 != 0 && k % 2 != 0 then true else false ).product 
  println(fact(8))
  println("\n\n")
}

def ex2(): Unit = {
  import math.pow 
  println("Entering solution to Exercise 1.6.1.2 ...")
  def arcTan(n: Double, maxN: Int): Double = (0 to maxN)
        .map(k => 1.0*(1 - k % 2 * 2) / (2 * k + 1) / pow(n, 2 * k + 1))
        .sum
  val piApprox = {(16 * arcTan(5, 12)) - (4 * arcTan(239, 12))}
  println(s"Pi approximate = ${piApprox}")
  println(s"Pi math package const = ${math.Pi}")
  val checks: Boolean = math.abs(piApprox - math.Pi) <= math.pow(10, -15) 
  println(s"Pi approx ${if checks then "checks" else "doesn't check"} with math.Pi")
  println("\n\n")
}

def ex3(): Unit = {
  println("Entering solution to Exercise 1.6.1.3 ...")
  def partialSum(n: Int): Double = (1 to n).map(k => 1/math.pow(k, 2)).sum
  val testResult: Double = math.pow(math.Pi, 2)/6
  // val testN: Int = scala.io.StdIn.readLine("Please enter a value for n: ").toInt
  val testN: Int = Int.MaxValue/1000.toInt
  val checks: Boolean = math.abs(testResult - partialSum(testN) ) <= math.pow(10, -6)
  println(s"Value of partial sum = ${partialSum(testN) }")
  println(s"Compare to pi squared / 6 = ${testResult}")
  println(s"The partial sum ${if checks == true then "checks" else "doesn't check"} with compared value up to the 5th decimal place.")
  println("\n\n")
}

def ex4(): Unit = {
  println("Entering solution to Exercise 1.6.1.4 ...")
  val testResult: Double = (2 to 10000)
    .filter(Chapter1.examples.isPrime)
    .map(k => 1 / (1 - (1/math.pow(k, 4))))
    .product
  val computedVal: Double = math.pow(math.Pi, 4)/90
  val checks: Boolean = math.abs(testResult - computedVal) <= math.pow(10, -12)
  println((2 to 100).filter(Chapter1.examples.isPrime))
  println(s"Test value = ${testResult}")
  println(s"Computed known value = ${computedVal}")
  println(s"The test value ${if checks then "checks" else "doesn't check"} with the known computed value up to the 12th decimal place.")
  println("\n\n")
}
