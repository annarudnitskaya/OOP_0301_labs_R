package lab1

fun main() {
    val books = """1. Отцы и дети // И.С.Тургенев // 1862
            2. Горе от ума // А.С.Грибоедов // 1825
            3. Война и мир // Л.Н.Толстой // 1867
            4. Евгений Онегин // А.С.Пушкин // 1833""".trimIndent()
    val listBooks: List<Book>? = parserBooks(books)
if (listBooks !=null) {
    if (oldestBook(listBooks)!=null) println("The one of the oldest book was published: ${oldestBook(listBooks)}")
    if (youngestBook(listBooks)!=null) println("The one of the youngest book was published: ${youngestBook(listBooks)}")
    if (longestNameBook(listBooks)!=null) println("The one of the longest name of the book is: ${longestNameBook(listBooks)}")
    if (shortestNameBook(listBooks)!=null) println("The one of the shortest name of the book is: ${shortestNameBook(listBooks)}")
} else {
    println("List of the books is empty")
}
}
