package Chapter1

object transformations {
  @main
  def transforms(): Unit = {
    println("\n" * 2 + "--" * 40 + "\n" * 4)

    ex1()
    ex2() 
    println("\n" * 2 + "--" * 40 + "\n" * 4)

  }

  def ex1(): Unit = {
    def add20(input: List[List[Int]]): List[List[Int]] = {
      input.map(outer => outer.map(inner => inner + 20))
    }

    val test: List[List[Int]] = List(List(1, 2, 3), (1 to 5).toList, (10 to 30 by 10).toList)
    val testFromBook = List(List(1), List(2, 3))
    val results = add20(test)

    println("Entering exercise 1.6.2.1 ... \n")
    println(s"Your test values: ${test}")
    println(s"Your result values: $results")
    println(s"Your test values: ${testFromBook}")
    println(s"Your result values: ${add20(testFromBook)}")
  }

  def ex2(): Unit = {
    // An integer n is called a "3-factor" if it is divisible by only three 
    // different inegers i, j, k such that 1 < i < j < k < n. Compute the set
    // of all "3-factor" integers n among n in range(1, 1000).
    val testRange = (1 to 1000).toList
    def threeFactorNum(testRange: List[Int]): List[Int] =
      testRange.filter(numOfDivisors(_) == 5)
    def numOfDivisors(n: Int): Int =
      (1 to n).count(n % _ == 0)
    println("\n\nEntereing exercise 1.6.2.2 ...\n")
    println("Given a range(1, 1000) the following is the set of all")
    println("'3-factor' integers such that 1 < i < j < k < n.")
    println(threeFactorNum(testRange).mkString(", "))
  }

  def ex3(): Unit = {
    // Given a function f: Int => Boolean, an integer n is called a "3-f"
    // if there are only three different integers 1 < i < j < k < n such that
    // f(i), f(j), and f(k) are all true. Define a function that takes f as an
    // argument and returns a sequence of all "3-f" integers among n in 
    // range(1, 1000). What is the type of that function? Implement Exercise
    // 1.6.2.2 using that function
  
  }
  
}
