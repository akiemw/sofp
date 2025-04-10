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
