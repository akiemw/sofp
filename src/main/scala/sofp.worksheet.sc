def isPrime(n: Int) = (2 to n - 1).forall(k => n % k != 0)
isPrime(4)
println("Hello World!")
