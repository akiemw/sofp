// 1.4 Examples
// 1.4.1 Aggregations

// 1.4.1.1 Improve the code for isPrime by limiting the search to k <= sqrt(n):

def isPrime(n: Int) = {
  (2 to n-1)
    .takeWhile(k => k * k <= n)
    .forall(k => n % k != 0)
}

val test = (1 to 10).foreach(isPrime)
println(test)



import math.pow 
println("Entering solution to Exercise 1.6.1.2 ...")
def approx(n: Int) = (1 to 12).map(k => (pow(-1.0, k)) * pow((2.0*k + 1), -1) * pow(n.toDouble, (-2*k-1))).sum
println(16 * approx(5) - 4 * approx(239))
println((1/4.0).toDouble)
// println(s"Pi approximate = ${(16 * approx(5)) - (4 * approx(239))}")
//
def at(n: Double, maxN: Int) = (0 to maxN)
  .map(k => 1.0 * (1 - k % 2 * 2) / (2 * k + 1) / pow(n, 2 * k + 1))
  .sum 

def p(n: Int) = 16 * at(5, n) - 4 * at(239, n)

  p(12)
math.Pi

