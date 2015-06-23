val xs = Array(1, 2, 3, 44)
xs map (x => x * 2)

val s = "Hello World"
s filter (_.isUpper)
s exists (_.isUpper)
s forall (_.isUpper)

val pairs = List(1, 2, 3) zip s
pairs unzip

s flatMap (c => List('.', c))
List(1, 2, 3) flatMap (c => List(12, c))

xs.sum
xs.max

// To list all combinations of numbers x and y where x is drawn from 1..M and y is drawn from 1..N
(1 to 10) flatMap (x => (100 to 110) map (y => (x, y)))

// To compute the scalar product of two vectors
def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  (xs zip ys).map(xy => xy._1 * xy._2).sum
def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
  (xs zip ys).map{ case (x, y) => x * y}.sum
def scalarProduct3(xs: Vector[Double], ys: Vector[Double]): Double =
  (for ((x, y) <- xs zip ys) yield x * y).sum

// prime
def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
isPrime(5)
isPrime(8)

//xs flatMap f = (xs map f).flatten
//((1 until 10) map (i =>
//  (1 until i) map (j => (i, j)))).flatten
(1 until 10).flatMap(i =>
  (1 until i) map (j => (i, j)))

(1 until 10).flatMap(i =>
  (1 until i) map (j => (i, j))) filter (pair =>
    isPrime(pair._1 + pair._2))
for {
  i <- 1 until 10
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)

case class Person(name: String, age: Int)
val persons = List(Person("name1", 1), Person("name2", 2), Person("name3", 3))
for (p <- persons if p.age > 1) yield p.name
persons filter (_.age > 1) map (_.name)


case class Book(title: String, authors: List[String])
val books: Set[Book] = Set(
  Book(title = "Structure and Interpretation of Computer Programs",
    authors = List("Abelson, Harald”, ”Sussman, Gerald J.")),
  Book(title = "Introduction to Functional Programming",
    authors = List("Bird, Richard", "Wadler, Phil")),
  Book(title = "Effective Java",
    authors = List("Bloch, Joshua")),
  Book(title = "Effective Java2",
    authors = List("Bloch, Joshua")),
  Book(title = "Java Puzzlers",
    authors = List("Bloch, Joshua", "Gafter, Neal")),
  Book(title = "Programming in Scala",
    authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")))

for (b <- books; a <- b.authors if a startsWith "Bird,") yield (b.title, a)
books flatMap (b =>
  b.authors withFilter (a => a startsWith "Bird") map (y => b.title))

for (b <- books if (b.title indexOf "Program") >= 0) yield b.title
for {
  b1 <- books
  b2 <- books
  if b1.title < b2.title  // avoid twice
  a1 <- b1.authors
  a2 <- b2.authors
  if a1 == a2
} yield a1