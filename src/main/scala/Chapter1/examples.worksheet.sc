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
{ val n = 12345; n * n * n + n * n}

// Example 1.1.2.1
// Define a function that takes an integer argument n and determines whether n is a prime number.
def isPrime(n: Int): Boolean = (2 to n - 1).forall(k => n % k != 0)

isPrime(12)
isPrime(13)

