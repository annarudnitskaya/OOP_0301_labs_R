package lab1

fun main() {
    val books = "1. Отцы и дети // И.С.Тургенев // 1862\n"+
            "2. Горе от ума // А.С.Грибоедов // 1825\n"+
            "3. Война и мир // Л.Н.Толстой // 1867\n"+
            "4. Евгений Онегин // А.С.Пушкин // 1833\n".trimIndent()
    val listBooks: List<Book>? = parserBooks(books)
    if (listBooks !=null) {
        if (oldestBook(listBooks)!=null) println("The oldest book was published: ${oldestBook(listBooks)}")
        if (youngestBook(listBooks)!=null) println("The youngest book was published: ${youngestBook(listBooks)}")
        if (longestNameBook(listBooks)!=null) println("The longest name of the book is: ${longestNameBook(listBooks)}")
        if (shortestNameBook(listBooks)!=null) println("The shortest name of the book is: ${shortestNameBook(listBooks)}")
    } else {
        println("List of the books is empty")
    }
}
