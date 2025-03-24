package Chapter1


object examples {

  @main
  def main(): Unit = {
    val menuOption: Int = scala.io.StdIn.readLine("""
  Welcome to SOFP Chapter 1 Examples and Exercises!
  Please select an option below to see the solutions output:

  Aggregations (Examples): 
      1. isPrime
      2. product of absolutes
      3. sum of positive cosines
      4. average of non-empty list 
      5. Wallis approximation
      6. numerical infinite product formula
      7. func that takes func and list
  """).toInt
    
    println("Here is your solution: ")
    menuOption match {
      case 1 => ex1()
      case 2 => ex2()
      case 3 => ex3()
      case 4 => ex4()
      case 5 => ex5()
      case 6 => ex6()
      case 7 => ex7()
      case _: Int => println("Not a valid option."); main()
    }

    
  }

  def isPrime(n: Int) = {
    (2 to n-1)
      .takeWhile(k => k * k <= n)
      .forall(k => n % k != 0)
  }
  def ex1(): Unit = { 
    def isPrime(n: Int) = {
      (2 to n-1)
        .takeWhile(k => k * k <= n)
        .forall(k => n % k != 0)
    }
    (1 to 10).map(isPrime).foreach(println)
  }

  def ex2(): Unit = {
    println((1 to 10).map(k => math.abs(math.sin(k + 2))).product)
  }

  def ex3(): Unit = {
    val result = (1 to 10)
                    .filter(k => math.cos(k) > 0)
                    .map(k => math.sqrt(math.cos(k)))
                    .sum
    println(result)
  }

  def ex4(): Unit = {
    def average(arr: List[Int]): Double = {
      val result = (1.0/arr.length) * arr.sum 
      result 
    }
    val testList: List[Int] = List(1, 2, 3, 4, 5)
    println(s"Your testList values = ${testList} \n Your average: ${average(testList)}")
  }

  def ex5(): Unit = {
    def wallis_frac(i: Int): Double = {
      (2.0 * i) / (2.0 * i - 1) * (2.0 * i) / (2.0 * i + 1)
    }
    def wallis(n: Int): Double = {
      (1 to n).map(wallis_frac).product 
    }
    println(s"Cos approximate using Wallis method @ 10,000 enumerations ${math.cos(wallis(10000))}")
    println(s"Cos approximate using wallis method @ 100,000 enumerations ${math.cos(wallis(100000))}")
  }

  def ex6(): Unit = {
    def check(n: Int, x: Double) = {
      val lhs = (1 to n).map(k => 1 - (math.pow(x, 2) / math.pow(k, 2))).product
      val rhs = math.sin(math.Pi * x) / (math.Pi * x)
      println(s"LHS = ${lhs} \n RHS = ${rhs}")
      val result = if (math.abs((lhs - rhs)) <= .001) then true else false
      println(s"The LHS ${if result then "checks" else "doesn't check"} with the RHS.")
    }
    check(100000, 0.1)
  }

  def ex7(): Unit = {
    def p(list: List[Int], f: Int => Int): Int = {
      list.map(f).max 
    }
    // def funcTest(k: Int) = k * k * k / 2*k 
    // println(s"The result of the test func = ${funcTest} is ${p((1 to 10).toList, funcTest)}")
    println(s"The result of your func taking func is: ${p(List(2, 3, 4, 5), x => 60 / x)}")

  }
}
