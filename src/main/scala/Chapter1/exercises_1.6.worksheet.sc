// 1.6 Exercises
//
// 1.6.1 Aggregations
//
// 1.6.1.1 Define a function that computes a "staggered factorial" (denoted by 
// `n!!`) for positive integers as either `1*3*...*n` or as `2*4*...*n`,
// depending on whether `n` is even or odd. For example, `8!! = 384` and
// `9!! = 945`.
{
  def sfactorial(n: Int): Int = {
    if (n % 2 != 0) (1 to n by 2).product else (2 to n by 2).product
    }

  println(sfactorial(9))
  println(sfactorial(8))
}


// 1.6.1.2 Machin's formula converges to `math.Pi` faster than Example 1.4.1.5:
// `math.pi / 4 = 4 * arctan(1/5) - arctan(1/239)   ,
// arctan(1/n) = 1/n - 1/3 * 1/(pow(n, 3)) + 1/5 * 1/(pow(n, 5)) - ... = 
// {the summation as k goes to inf of (-1)^k/(2k + 1) * n^(-2k-1)}`
{
  def arctan(n: Int): Double = {
    (0 to 13).map(k => (math.pow(-1, k) * math.pow(n, (-2*k-1))/(2*k+1))).sum
  }
  val result: Double = 4*(4 * arctan(5) - arctan(239))
  result.toString.length
  println(s"Machin formula yields $result")
  println(s"Math.Pi yields ${math.Pi}")
  println(s"""Therefore Machin's formula is within 15 significant digits of Math.Pi
    |is ${result - math.Pi <= math.pow(10, -15)}""".stripMargin)
}

// 1.6.1.3 Check numerically that the sum from k to inf of 
// `(1 / math.pow(k, 2)) =  (math.pow(math.pi, 2))/ 6`. First, define a function
// of `n` that computes a partial sum of that series until `k = n`. Then compute
// the partial sum of a large value of `n` and compare with the limit value.
{
  def roundAt(n: Int)(value: Double): Double = {
    val scale = Math.pow(10, n)
    Math.round(value * scale) / scale
  }

  val roundedPi = roundAt(3)(3.14159) // 3.142
  def partialSum(n: Int): Double = (1 to n).map(k => math.pow(k, -2)).sum 
  val limitValue: Double = math.pow(math.Pi, 2) / 6
  var n: Int = 10
  println(s""""The partial sum for n = 10 compared to the limit value is ${roundAt(4)(partialSum(n))}
    |${if roundAt(4)(partialSum(n)) == roundAt(4)(limitValue) then "==" else "!="}
    |${roundAt(4)(limitValue)}""".stripMargin)
  n = 100
  println(s""""The partial sum for n = 100 compared to the limit value is ${roundAt(4)(partialSum(n))}
    |${if roundAt(4)(partialSum(n)) == roundAt(3)(limitValue) then "==" else "!="}
    |${roundAt(4)(limitValue)}""".stripMargin)
  n = 1000
  println(s""""The partial sum for n = 1000 compared to the limit value is ${roundAt(4)(partialSum(n))}
    |${if roundAt(4)(partialSum(n)) == roundAt(4)(limitValue) then "==" else "!="}
    |${roundAt(4)(limitValue)}""".stripMargin)
  n = 100000
  println(s""""The partial sum for n = 10000 compared to the limit value is ${roundAt(4)(partialSum(n))}
    |${if roundAt(4)(partialSum(n)) == roundAt(4)(limitValue) then "==" else "!="}
    |${roundAt(4)(limitValue)}""".stripMargin)
}

// 1.6.1.4 Using the function isPrime, check numerically the Euler product 
// formula for the Riemann's zeta function `Z(4)`. It is known that
// `Z(4) = math.pow(math.Pi, 4)/ 90`
{
  def roundAt(n: Int)(value: Double): Double = {
    val scale = Math.pow(10, n)
    Math.round(value * scale)/scale 
  }
  import Chapter1.examples.isPrime 
  def zeta(n: Int): Double = {
    (2 to 10000).filter(isPrime).map(k => 1.0 / (1 - math.pow(k, -4))).product
  }
  val lhs: Double = zeta(4)
  val rhs: Double = math.pow(math.Pi, 4) / 90

  val significantDigits: Int = (1 to 15).takeWhile(k => roundAt(k)(lhs) == roundAt(k)(rhs)).max

  println(s"The LHS = $lhs is equal to the RHS = $rhs up to $significantDigits significant digits.")
}


// 1.6.2 Transformations
//
// 1.6.2.1 Define a function `add20` of type `List[List[Int]] => List[List[Int]]`
// that adds 20 to every element of every inner list. 
{
  def add20(list: List[List[Int]]): List[List[Int]] = 
    list.map(outer => outer.map(inner => inner + 20))

  val test = List((1 to 3).toList, (2 to 10 by 2).toList)
  add20(test)
}

// 1.6.2.2 An integer `n` is called a "3-factor" if it divisible by only three 
// different integers `i, j, k` such that `1 < i < j < k < n`. Compute the set
// of all "3-factor" integers n among `n in Range(1, 10001)`. 
{
  def countFactors(n: Int): Int =
    (2 to n-1).count(k => n % k == 0)

  (1 to 1000).filter(k => countFactors(k) == 3).foreach(println)

}















































