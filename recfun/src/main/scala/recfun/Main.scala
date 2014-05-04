package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (r == 0 || c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def checkBalance(chars: List[Char], countOpen: Int): Boolean = {
      if (chars.isEmpty) { // finish loop
        countOpen == 0 // '(' and ')' balanced
      }
      else {
        val head = chars.head
        val index = // immutable here
        if (head == '(') // do the match
          countOpen + 1
        else if (head == ')')
          countOpen - 1
        else
          countOpen
        if (index >= 0)
          checkBalance(chars.tail, index)
        else // first one is '('
          false
      }
    }

    checkBalance(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def recCount(money: Int, coins: List[Int], count: Int): Int = {
      if (money < 0) {
        count
      }
      else if (coins.isEmpty) {
        if (money == 0)
          count + 1
        else
          count
      }
      else {
        recCount(money, coins.tail, count) + recCount(money - coins.head, coins, count)
      }
    }

    recCount(money, coins, 0)
  }
}
