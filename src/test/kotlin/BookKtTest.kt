package lab1
//import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
internal class BookKtTest {

    @Test
    fun `test correct parse fun` () {
        val testBooks = """1. Shadow and Bone // Leigh Bardugo // 2012"""
        assertEquals("Shadow and Bone", parserBooks(testBooks)!!.get(0).name)
        assertEquals("Leigh Bardugo", parserBooks(testBooks)!!.get(0).authors)
        assertEquals(2012, parserBooks(testBooks)!!.get(0).yearBook)
    }

    @Test
    fun `test correct parse fun for empty string` () {
        val testBooks = ""
        val exception = assertFailsWith<IllegalArgumentException> (
            block = { parserBooks(testBooks) }
        )
        assertEquals(exception.message, "The books string is empty")
    }

    @Test
    fun `test correct parse fun for string with name exception` () {
        val testBooks = "1. // Leigh Bardugo // 2012"
        val exception = assertFailsWith<IllegalArgumentException> (
            block = { parserBooks(testBooks) }
        )
        assertEquals(exception.message, "One book has no title")
    }

    @Test
    fun `test correct parse fun for string with author exception` () {
        val testBooks = "1. Shadow and Bone //  // 2012"
        val exception = assertFailsWith<IllegalArgumentException> (
            block = { parserBooks(testBooks) }
        )
        assertEquals(exception.message, "One book has no author")
    }

    @Test
    fun `test correct parse fun for string with year exception` () {
        val testBooks = "1. Shadow and Bone // Leigh Bardugo // "
        val exception = assertFailsWith<IllegalArgumentException> (
            block = { parserBooks(testBooks) }
        )
        assertEquals(exception.message, "One book has no year")
    }

    @Test
    fun `test correct parse fun for string with incorrect year` () {
        val testBooks = "1. Shadow and Bone // Leigh Bardugo // -2 "
        val exception = assertFailsWith<IllegalArgumentException> (
            block = { parserBooks(testBooks) }
        )
        assertEquals(exception.message, "One book has incorrect year")
    }

    @Test
    fun `test correct oldestBook fun` () {
        val testBooks = """1. Fathers and Sons // Ivan Turgenev // 1862
            2. Woe from Wit // A. S. Griboedov // 1825
            3. War and Peace // Leo Tolstoy // 1867
            4. Eugene Onegin // Alexander Pushkin // 1833"""
        val testBookList = parserBooks(testBooks)
        assertEquals("Woe from Wit", oldestBook(testBookList!!)!!.name)
        assertEquals("A. S. Griboedov", oldestBook(testBookList!!)!!.authors)
        assertEquals(1825, oldestBook(testBookList!!)!!.yearBook)
    }

    @Test
    fun `test correct youngestBook fun` () {
        val testBooks = """1. Fathers and Sons // Ivan Turgenev // 1862
            2. Woe from Wit // A. S. Griboedov // 1825
            3. War and Peace // Leo Tolstoy // 1867
            4. Eugene Onegin // Alexander Pushkin // 1833"""
        val testBookList = parserBooks(testBooks)
        assertEquals("War and Peace", youngestBook(testBookList!!)!!.name)
        assertEquals("Leo Tolstoy", youngestBook(testBookList!!)!!.authors)
        assertEquals(1867, youngestBook(testBookList!!)!!.yearBook)

    }

    @Test
    fun `test correct longestNameBook fun`() {
        val testBooks = """1. Fathers and Sons // Ivan Turgenev // 1862
            2. Woe from Wit // A. S. Griboedov // 1825
            3. War and Peace // Leo Tolstoy // 1867
            4. Eugene Onegin // Alexander Pushkin // 1833"""
        val testBookList = parserBooks(testBooks)
        assertEquals("Fathers and Sons", longestNameBook(testBookList!!)!!.name)
        assertEquals("Ivan Turgenev", longestNameBook(testBookList!!)!!.authors)
        assertEquals(1862, longestNameBook(testBookList!!)!!.yearBook)
    }

    @Test
    fun `test correct shortestNameBook fun`() {
        val testBooks = """1. Fathers and Sons // Ivan Turgenev // 1862
            2. Woe from Wit // A. S. Griboedov // 1825
            3. War and Peace // Leo Tolstoy // 1867
            4. Eugene Onegin // Alexander Pushkin // 1833"""
        val testBookList = parserBooks(testBooks)
        assertEquals("Woe from Wit", shortestNameBook(testBookList!!)!!.name)
        assertEquals("A. S. Griboedov", shortestNameBook(testBookList!!)!!.authors)
        assertEquals(1825, shortestNameBook(testBookList)!!.yearBook)
    }
}