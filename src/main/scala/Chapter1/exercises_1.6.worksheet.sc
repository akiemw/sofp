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
// Sol'n to 1.6.1.2 needs reworking completed it before going to attempt again tomorrow.
  // def arctan(n: Int): Double = {
  //   (0 to 10000).map(k => (math.pow(-1, k) * math.pow(n, (-2*k-1))/(2*k+1))).sum
  // }
  // 4 * arctan(5) - arctan(239)

}
