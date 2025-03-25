
def isPrime(n: Int): Boolean = {
  (2 to n-1)
    .takeWhile(k => k * k <= n)
    .forall(k => n % k != 0)
}


// val orig: List[Int] = (1 to 1000).toList 
// val divisors = orig
//                 .filter(k => k * (k+1) * (k + 2) <= 1000)
//
// val results = orig.filter(k => divisors.exists(divisors => k % divisors == 0) )
//
//
// val test: List[Int] = (2 to 50).toList.filter(k => 
//                           (2 to k).filter(j => k % j == 0 ).size >= 2)
//
// (1 to 50).filter(k => 
//       (1 to 50).tail.filter(j => k % j == 0 || j * j * j == k).size == 3)
//
// (1 to 1000).filter(k =>
//   (2 to 1000).tail.filter(j => 
//     (3 to 1000).tail.filter( i => (k % j % i == 0 && (i != j || j != k || k != i))).size > 1).size == 4)


// object TwoFactorFunctional {
//
//   val range = 1 to 50
//
//   val twoFactors = range.filter(isTwoFactor)
//
//   println("2-factor numbeers between 1 and 50:")
//   println(twoFactors.mkString(", "))
// }
//
// def isTwoFactor(n: Int): Boolean = 
//   countDivisors(n) == 5
//
// def divisors(n: Int): Seq[Int] =
//   (1 to n).filter(n % _ == 0)
//
// def countDivisors(n: Int): Int =
//   divisors(n).size
//
// (1 to 1000).filter(isTwoFactor)

object ThreeFactorFinder {
  def main(): Unit = {
  val threeFactors = (1 to 1000).filter(isThreeFactor)
  println("3-factor numbers between 1 and 1000:")
  println(threeFactors.mkString(", "))
  }

  def isThreeFactor(n: Int): Boolean = 
    countDivisors(n) == 5
  
  def divisors(n: Int): Seq[Int] =
    (1 to n).filter(n % _ == 0)

  def countDivisors(n: Int): Int = 
    divisors(n).size
}

ThreeFactorFinder.main()
