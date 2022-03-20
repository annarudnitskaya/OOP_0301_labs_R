package lab1

fun main() {
    val books = """1. Shadow and Bone // Leigh Bardugo // 2012
        2. City of Bones (Mortal Instruments) // Cassandra Clare // 2007
        3. Ninth House // Leigh Bardugo // 2019
        4. Dune // Franklin Patrick Herbert // 1965
        5. Roadside Picnic // Arcady and Boris Strugataky // 1972"""
    val listBooks: List<Book>? = parserBooks(books)
    if (oldestBook(listBooks!!) != null) println("The one of the oldest book was published: ${oldestBook(listBooks)}")
    if (youngestBook(listBooks) != null) println(
        "The one of the youngest book was published: ${
            youngestBook(
                listBooks
            )
        }"
    )
    if (longestNameBook(listBooks) != null) println(
        "The one of the longest name of the book is: ${
            longestNameBook(
                listBooks
            )
        }"
    )
    if (shortestNameBook(listBooks) != null) println(
        "The one of the shortest name of the book is: ${
            shortestNameBook(
                listBooks
            )
        }"
    )
}
