package lab1.Lab5

import Lab2.Color
import kotlin.test.Test
import kotlin.test.assertEquals
import lab1.Lab2.Circle
import lab1.Lab2.Triangle
import lab1.Lab2.Rectangle
import lab1.Lab2.Square
import lab1.Lab2.ShapeCollector

internal class ShapeCollectorTest {
    @Test
    fun `shapes of a specific type`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color2)
        val circle2 = Circle(5.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color1)
        val shapse = ShapeCollector(listOf(circle, circle2, triangle))
        kotlin.test.assertEquals(3, shapse.getSizeList())
        kotlin.test.assertEquals(listOf(circle, circle2), shapse.shapesByType(Circle::class.java))
    }

    @Test
    fun `adding all figure`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color1)
        val square = Square(4.0, color2, color2)
        val shapse = ShapeCollector(listOf(circle, triangle, square))
        kotlin.test.assertEquals(3, shapse.getSizeList())
    }

    @Test
    fun `get sorted figure`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color2)
        val circle2 = Circle(5.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color1)
        val square = Square(4.0, color2, color2)
        val shapse = ShapeCollector(listOf(circle, circle2, triangle, square))
        kotlin.test.assertEquals(listOf(circle, triangle, square, circle2), shapse.getSorted(AreaComparator()))
    }
}