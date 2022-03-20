package lab1

data class Book(val name: String, val authors: String, val yearBook: Int) {}

//parser of books
fun parserBooks(books: String): List<Book>? {
    if (books.isEmpty()) {
        return null
    }
    val splitString = books.split('\n')
    val listBooks = mutableListOf<Book>()
    var perem: String
    for (str in splitString) {
        perem = str
        perem = perem.substringAfter('.')
        val name = perem.substringBefore("//").trim()
        perem = perem.substringAfter("//")
        val author = perem.substringBeforeLast("//").trim()
        perem = perem.substringAfter("//").trim()
        val yearBook = perem.toInt()
        val fullBook = Book(name, author, yearBook)
        listBooks.add(fullBook)
    }
    return listBooks
}

//functions of processing of books
fun oldestBook(books: List<Book>): Book? = books.minByOrNull { it.yearBook }
fun youngestBook(books: List<Book>): Book? = books.maxByOrNull { it.yearBook }
fun longestNameBook(books: List<Book>): Book? = books.maxByOrNull { it.name.length }
fun shortestNameBook(books: List<Book>): Book? = books.minByOrNull { it.name.length }