package lab1
//import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class BookKtTest {

    @Test
    fun `test correct parse fun`() {
        val testBooks = """1. Shadow and Bone // Leigh Bardugo // 2012"""
        val actual = parserBooks(testBooks)

        assertEquals(
            listOf(Book("Shadow and Bone", "Leigh Bardugo", 2012)),
            actual
        )

    }
    @Test
    fun `test correct parse fun for empty string`() {
        val testBooks = ""
        val testBookList: List<Book>?= parserBooks(testBooks)
        assertEquals(null,testBookList)
    }
    @Test
    fun `test correct parse fun for string with name exception`() {
        val testBooks = "1. // Leigh Bardugo // 2012"
        val exception = assertFailsWith<IllegalArgumentException>(
            block = { parserBooks(testBooks) }
        )
        assertEquals(exception.message, "One book has no title")
    }
    @Test
    fun `test correct parse fun for string with author exception`() {
        val testBooks = "1. Shadow and Bone //  // 2012"
        val exception = assertFailsWith<IllegalArgumentException>(
            block = { parserBooks(testBooks) }
        )
        assertEquals(exception.message, "One book has no author")
    }
    @Test
    fun `test correct parse fun for string with year exception`() {
        val testBooks = "1. Shadow and Bone // Leigh Bardugo // "
        val exception = assertFailsWith<IllegalArgumentException>(
            block = { parserBooks(testBooks) }
        )
        assertEquals(exception.message, "One book has no year")
    }
    @Test
    fun `test correct parse fun for string with incorrect year`() {
        val testBooks = "1. Shadow and Bone // Leigh Bardugo // -2 "
        val exception = assertFailsWith<IllegalArgumentException>(
            block = { parserBooks(testBooks) }
        )
        assertEquals(exception.message, "One book has incorrect year")
    }
    @Test
    fun `test correct oldestBook fun`() {
        val testBooks = """1. Fathers and Sons // Ivan Turgenev // 1862
            2. Woe from Wit // A. S. Griboedov // 1825
            3. War and Peace // Leo Tolstoy // 1867
            4. Eugene Onegin // Alexander Pushkin // 1833"""
        val testBookList: List<Book>?= parserBooks(testBooks)
        assertEquals(
            Book("Woe from Wit", "A. S. Griboedov", 1825),
            oldestBook(testBookList!!)
        )
    }
    @Test
    fun `test correct youngestBook fun`() {
        val testBooks = """1. Fathers and Sons // Ivan Turgenev // 1862
            2. Woe from Wit // A. S. Griboedov // 1825
            3. War and Peace // Leo Tolstoy // 1867
            4. Eugene Onegin // Alexander Pushkin // 1833"""
        val testBookList = parserBooks(testBooks)
        assertEquals(
            Book("War and Peace", "Leo Tolstoy", 1867),
            youngestBook(testBookList!!)
        )
    }
    @Test
    fun `test correct longestNameBook fun`() {
        val testBooks = """1. Fathers and Sons // Ivan Turgenev // 1862
            2. Woe from Wit // A. S. Griboedov // 1825
            3. War and Peace // Leo Tolstoy // 1867
            4. Eugene Onegin // Alexander Pushkin // 1833"""
        val testBookList = parserBooks(testBooks)
        assertEquals(
            Book("Fathers and Sons", "Ivan Turgenev", 1862),
            longestNameBook(testBookList!!)
        )
    }
    @Test
    fun `test correct shortestNameBook fun`() {
        val testBooks = """1. Fathers and Sons // Ivan Turgenev // 1862
            2. Woe from Wit // A. S. Griboedov // 1825
            3. War and Peace // Leo Tolstoy // 1867
            4. Eugene Onegin // Alexander Pushkin // 1833"""
        val testBookList = parserBooks(testBooks)
        assertEquals(
            Book("Woe from Wit", "A. S. Griboedov", 1825),
            shortestNameBook(testBookList!!)
        )
    }
}