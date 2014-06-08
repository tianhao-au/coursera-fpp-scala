for {
  i <- 0 to 3
  j <- 0 to 3
  k <- 0 to 3
} yield (i, j, k)

type Occurrences = List[(Char, Int)]
def combinations(occurrences: Occurrences): List[Occurrences] =
  List() :: (for {
    (char, max) <- occurrences
    count <- 1 to max
    rest <- combinations(occurrences.filter(pair => pair._1 > char))  // List(('b', 1), ('b', 2))
  } yield List((char, count)) ++ rest)

combinations(List(('a', 1)))
combinations(List(('a', 2)))
combinations(List(('a', 2), ('b', 2)))
combinations(List(('a', 3), ('b', 3), ('c', 2)))
val abba = List(('a', 3), ('b', 3), ('c', 2))
combinations(abba)
val temp = abba.filter(pair => pair._1 > 'a')
combinations(temp)

List(('a', 2)) ++ List()