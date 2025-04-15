// 1.6 Exercises
//
// 1.6.1 Aggregations
//
// 1.6.1.1 Define a function that computes a "staggered factorial" (denoted by 
// `n!!`) for positive integers as either `1*3*...*n` or as `2*4*...*n`,
// depending on whether `n` is even or odd. For example, `8!! = 384` and
// `9!! = 945`.
{
  def sfactorial(n: Int): Int = 
    val start = if n % 2 == 0 then 2 else 1
    (start to n by 2).product 
    
  println(sfactorial(9))
  println(sfactorial(8))
}

{
  def sfactorial(n: Int): Int = 
    n match 
      case n if n % 2 != 0 => (1 to n by 2).product 
      case n if n % 2 == 0 => (2 to n by 2).product 
  
  println(sfactorial(8))
  println(sfactorial(9))
}

// 1.6.1.2 Machin's formula converges to `math.Pi` faster than Example 1.4.1.5:
// `math.pi / 4 = 4 * arctan(1/5) - arctan(1/239)   ,
// arctan(1/n) = 1/n - 1/3 * 1/(pow(n, 3)) + 1/5 * 1/(pow(n, 5)) - ... = 
// {the summation as k goes to inf of (-1)^k/(2k + 1) * n^(-2k-1)}`
{
  def arctan(n: Int)(rep: Int): Double = {
    (0 to rep).map(k => math.pow(-1, k)/(2 * k + 1) * math.pow(n, (-2*k-1))).sum
  }
  println(math.Pi)
  4 * (4 * arctan(5)(14) - arctan(239)(14))
}

// 1.6.1.3 Check numerically that the sum from k to inf of 
// `(1 / math.pow(k, 2)) =  (math.pow(math.pi, 2))/ 6`. First, define a function
// of `n` that computes a partial sum of that series until `k = n`. Then compute
// the partial sum of a large value of `n` and compare with the limit value.
{
  def lhs(n: Int): Double = {
    (1 to n).map(k => math.pow(k, -2)).sum
  }
  println(lhs(math.pow(10, 5).toInt)) 
  println((math.pow(math.Pi, 2))/ 6)
}

