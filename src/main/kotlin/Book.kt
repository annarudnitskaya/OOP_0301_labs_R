package lab1

data class Book(val number: Int, val name: String, val authors: String, val yearBook: Int) {}

fun parserBooks(books: String): List<Book>? {
    if (books.isEmpty()) { return null }
    val splitString = books.split('\n')
    val listBooks = mutableListOf<Book>()
    for (str in splitString) {
        val number = str.substringBefore('.').toInt()
        val name = str.substringBefore("//").substringAfter('.')
        val author = str.substringBeforeLast("//").substringAfter("//")
        val yearBook = str.substringAfterLast("//").toInt()
        val fullBook = Book(number, name, author, yearBook)
        listBooks.add(fullBook)
    }
    return listBooks
}

fun oldestBook(books: List<Book>): Book? = books.minByOrNull { it.yearBook }
fun youngestBook(books: List<Book>): Book? = books.maxByOrNull { it.yearBook }
fun longestNameBook(books: List<Book>): Book? = books.maxByOrNull { it.name.length }
fun shortestNameBook(books: List<Book>): Book? = books.minByOrNull { it.name.length }