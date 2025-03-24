package Chapter1 


@main()
def test() = {
  ex1()
  ex2()
}

def ex1(): Unit = {
  println("Entering solution to Exercise 1.6.1.1 ...")
  def fact(n: Int) = (1 to n).filter(k => if n % 2 == 0 && k % 2 == 0 then true else if n % 2 != 0 && k % 2 != 0 then true else false ).product 
  println(fact(8))
}

def ex2(): Unit = {
  import math.pow 
  println("Entering solution to Exercise 1.6.1.2 ...")
  def arcTan(n: Double, maxN: Int): Double = (0 to maxN)
        .map(k => 1.0*(1 - k % 2 * 2) / (2 * k + 1) / pow(n, 2 * k + 1))
        .sum
  println(s"Pi approximate = ${(16 * arcTan(5, 12)) - (4 * arcTan(239, 12))}")
  println(s"Pi approx2 = ${math.Pi}")
}
