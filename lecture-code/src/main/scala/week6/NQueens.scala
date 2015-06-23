package week6

object NQueens {

  def isSafe(queens: List[Int], col: Int): Boolean = {
    val row = queens.length
    val queensWithRow = (row - 1 to 0 by - 1) zip queens
    queensWithRow forall {
      case (r, c) => col != c && math.abs(col - c) != row - r
    }
  }

  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List()) // actually there is a solution
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(queens, col)
        } yield col :: queens
    }
    placeQueens(n)
  }

  def show(queens: List[Int]) = {
    val lines =
      for (col <- queens.reverse)
        yield Vector.fill(queens.length)("* ").updated(col, "@ ").mkString
    "\n" + (lines mkString "\n")
  }

//  (queens(4) take 3 map show) mkString "\n"
}
