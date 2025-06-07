def isPrime(n: Int) = (2 to n - 1).forall(k => n % k != 0)
isPrime(4)


// 1.4.2.1 Given a list of lists, s: List[List[Int]], select the inner lists of size at least 3. The result must be again of type List[List[Int]]
def sol(s: List[List[Int]]): List[List[Int]] = s.filter(inner => inner.length >= 3 )

val test: List[List[Int]] = List(List(1, 2), List(1), List(4, 4, 4, 4), (1 to 10).toList)

println(test)
println(sol(test))

// 1.4.2.2 Find all integers k in domain (1 to 10) such that there are at least
// three different integers j, where 1 <= j <= k, each j satisfying the 
// condition j * j > 2 * k.
(1 to 10).filter(k => 
    (1 to k).filter(j => j * j > 2 * k).length >= 3)

// Jun 5, 2025 - Restarted SOFP from beginning of the book
