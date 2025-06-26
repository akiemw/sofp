// Jun 5, 2025 - Restarted SOFP from beginning of the book
// Chapter 1 Mathematical formulas as code.
// I. Nameless functions
// 1.1 Translating mathematics into code
// 1.1.1 First examples
(1 to 10).product
100 + (1 to 10).product + 100
3628800 == (1 to 10).product

val fac10 = (1 to 10).product

def f(n: Int) = (1 to n).product
f(10)
// f("abc")

// 1.1.2 Nameless functions
val fac = (n: Int) => (1 to n).product
fac(10)

((n: Int) => (1 to n).product)(10)

def isEven(k: Int): Int = (k % 2) match {
  case 0 => 1
  case _ => 0
}

isEven(12)
isEven(13)

def isPrime(n: Int): Boolean = {
  (2 to n -1)
    .takeWhile(k => k * k <= )
}
