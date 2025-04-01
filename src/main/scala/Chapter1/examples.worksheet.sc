// Example 1.1.1.1
// Find the product of integers from 1 to 10 (the factorial of 10, usually denoted by 10!)
(1 to 10).product

// The code`(1 to 10).product` is a sub-expression.
100 + (1 to 10).product + 100

3628800 == (1 to 10).product

val fac10 = (1 to 10).product

// Example 1.1.1.2
// Define a function to compute the factorial of an integer argument n.
def f(n: Int) = (1 to n).product

f(10)

// f("abc")
// creates a type error

val fac = (n: Int) => (1 to n).product
fac(10)

((n: Int) => (1 to n).product)(10)

// Rarely done be none the less possible
((n: Int) => (1 to n).product)(10) == (1 to 10).product

((n: Int) => n * n * n + n * n)(12345)
// Better alternatives to this:
12345 * 12345 * 12345 + 12345 * 12345
// or
{ val n = 12345; n * n * n + n * n }

// Example 1.1.2.1
// Define a function that takes an integer argument n and determines whether n is a prime number.
def isPrime(n: Int): Boolean = (2 to n - 1).forall(k => n % k != 0)

isPrime(12)
isPrime(13)

{
  def isEven(k: Int): Int = (k % 2) match {
    case 0 => 1 // First, check if the modulous is zero
    case _ => 0 // The underscore means "otherwise".
  }
  println(s"${isEven(12)}")
  println(s"${isEven(13)}")
}

val isEven = (k: Int) => if (k % 2 == 0) 1 else 0

println(s"${isEven(12)}")
println(s"${isEven(13)}")

{
  def countEven(s: List[Int]): Int = s
    .map(isEven)
    .sum

  countEven((5 to 13).toList)
}

List(10, 20, 30).max

List(10, 20, 30).min

List(10, 20, 30).size

List(1, 2, 3, 4, 5).filter(k => k != 3)

List(1, 2, 3, 4, 5).takeWhile(k => k != 3)

List(10, 20, 30).forall(k => k > 20)

List(10, 20, 30).exists(k => k > 20)

// 1.4 Examples
// 1.4.1 Aggregations

// 1.4.1.1 Improve the code ofr isPrime by limiting the search to k <= math.sqrt(n):
def isPrime2(n: Int): Boolean = {
  (2 to n - 1)
    .takeWhile(k => k <= math.sqrt(n))
    .forall(k => n % k != 0)
}

isPrime2(1453)
isPrime2(12)


// 1.4.1.2 Compute the product of the abs value of the product from k = 1 to 10 of the abs(math.sin(k + 2)).

(1 to 10)
  .map(k => math.abs(math.sin(k + 2)))
  .product


// 1.4.1.3 Compute the sum from k in Range(1,10) and math.cos(k)>0 of math.sqrt(cos(k)) {the sum goes only over k such that cos k > 0}

(1 to 10)
  .filter(k => math.cos(k) > 0)
  .map(k => math.sqrt(math.cos(k)))
  .sum

(1 to 10).toList.filter(k => math.cos(k) > 0).map(x => math.cos(x))

// 1.4.1.4 Compute the avg of a non-empty list of type List[Double], such that, avg(s) = (1/n) * sum from i = 0 to n-1 of seq(i).

def avg(s: List[Int]): Int = {
  val n: Int = s.size 
  s.map(k => k).sum / n
}

def average(s: List[Double]): Double = s.sum / s.size

avg(List(10, 20, 30))
average(List(1.0, 2.0, 3.0))

// 1.4.1.5 Given n, compute the Wallis product truncated up to (2n)/(2n + 1):
{
  def wallis(n: Int): Double = (1 to n)
    .map(k =>  (2.0*k)/(2.0 * k -1) * (2.0 * k)/(2.0 * k + 1))
    .product 

  math.cos(wallis(10000))
}


// Example 1.4.1.6 Check numerically the following infinite product formula:
// the product from k = 1 to infinite of (1 - (pow(x, 2)/pow(k, 2))) = sin(pi * x) / (pi * x)

{
  def lhs(n: Int, x: Double) = (1 to n)
    .map(k => 1 - (math.pow(x, 2)/math.pow(k, 2)))
    .product 

  def rhs(x: Double) = (math.sin(math.Pi * x))/(math.Pi * x) 

  val lh: String = lhs(math.pow(10, 5).toInt, 0.1).toString 
  val rh: String = rhs(0.1).toString 
  println(lh)
  println(rh)
  val digits = (1 to 12)
     .takeWhile(k => lh(k) == rh(k))
     .max + 1
  println(lh.take(digits))
  println(s"The infinite product formula nd the approximation check  within ${digits - 2} digits of each other.")

}

// Example 1.4.1.7 Define a function p that takes a list of integers and a 
// function f: Int => Int, and returns the largest value of f(x) among all x in
// the list
{
  def p(list: List[Int], f: Int => Int): Int = list.map(f).max 
  val test: List[Int] = (1 to 10).toList 
  p(test, (k => 5*k + 1))
}

// 1.4.2 Transformations
// 1.4.2.1 Given a list of lists, s: List[List[Int]], select the inner lists of
// size at least 3. The result must be again of type List[List[Int]].
{
  def res(l: List[List[Int]]): List[List[Int]] = 
    l.filter(k => k.size >= 3)

  val test: List[List[Int]] = List(List(1, 2), (1 to 3).toList, List(1), List(4,4, 4, 4))
  res(test)
}


// 1.4.2.2 Find all integers k in range [1, 10] such that there are at least 
// three different integers j, where 1 <= j <= k, each j satisfying the
// condition j * j > 2 * k. 
{
  val inner, outer = (1 to 10)
  outer.filter(j => inner.exists(k => j <= k && j * j > 2 * k))
}
// Sol'n from the book
{
  (1 to 10).toList.filter(k =>
      (1 to k).filter(j => j * j > 2*k).length >= 3)
}

// My troubleshooting efforts on Apr 1, 2025
{
  (1 to 10).toList.map(k =>
      (1 to k).filter(j => j * j > 2*k))
}
