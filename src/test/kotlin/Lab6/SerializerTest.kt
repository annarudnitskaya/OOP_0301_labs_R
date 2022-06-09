package lab1.Lab6

import Lab2.Color
import lab1.Lab2.*
import lab1.Lab6.forFile
import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

internal class SerializerTest {

    @Test
    fun `serialize`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color1)
        val square = Square(4.0, color2, color2)
        val shapse = ShapeCollector(listOf(circle, triangle, square))
        val file = forFile("intest.txt", "outtest.txt")
        val work = Serializer()
        assertEquals(file.read(), work.serialization(shapse.getListFigure()))

    }

    @Test
    fun deserialization() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color1)
        val square = Square(4.0, color2, color2)
        val shapse = ShapeCollector(listOf(circle, triangle, square))
        val file = forFile("intest.txt", "outtest.txt")
        val work = Serializer()
        assertEquals(file.read(), work.serialization(shapse.getListFigure()))
    }
}