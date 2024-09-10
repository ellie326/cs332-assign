package recfun
import common._

object Main {
  def main(args: Array[String]) {
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    // c = column index ?
    // r = row index?
  def pascal(c: Int, r: Int): Int = {
    // edge case:
    if (c == 0 || c == r) 1
    // recursive case:
    else {pascal(c - 1, r - 1) + pascal (c, r - 1)}
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def counting(chars: List[Char], count: Int): Boolean = {
      // when there exists more closing parenthesis than opening parenthesis
      if (count < 0) false
      // if empty, check whether there are same number of opening and closing parenthesis
      else if (chars.isEmpty) count == 0
      else {
        val headChar = chars.head
        val tailChar = chars.tail
        counting(tailChar,
          if (headChar == '(') count + 1
          else if (headChar == ')') count - 1
          else count
        )
      }
    }
    counting(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    // if 0 money, then only one way -- using no coin
    if (money == 0) 1
    // if no coin exists and money less than 0, no way to make change
    else if (money < 0 || coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
