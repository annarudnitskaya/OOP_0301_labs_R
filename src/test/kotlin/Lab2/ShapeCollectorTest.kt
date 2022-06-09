package lab1.Lab2

import Lab2.Color
import kotlin.test.Test
import kotlin.test.assertEquals

internal class ShapeCollectorTest {

    @Test
    fun `adding figure`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color1)
        val shapse = ShapeCollector(listOf())
        kotlin.test.assertEquals(0, shapse.getSizeList())
        shapse.addFigure(circle)
        kotlin.test.assertEquals(1, shapse.getSizeList())
        shapse.addFigure(triangle)
        kotlin.test.assertEquals(2, shapse.getSizeList())
    }
    @Test
    fun `max area of figure`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color1)
        val shapse = ShapeCollector(listOf(circle, triangle))
        kotlin.test.assertEquals(2, shapse.getSizeList())
        kotlin.test.assertEquals(listOf(triangle), shapse.maxAreaF())
    }
    @Test
    fun `min area of figure`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color1)
        val shapse = ShapeCollector(listOf(circle, triangle))
        kotlin.test.assertEquals(2, shapse.getSizeList())
        kotlin.test.assertEquals(listOf(circle), shapse.minAreaF())
    }
    @Test
    fun `sum of all shapes`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val triangle = Triangle(5.0, 4.0, 3.0, color2, color1)
        val square = Square(4.0, color2, color2)
        val shapse = ShapeCollector(listOf(square, triangle))
        val answer = 22.0
        kotlin.test.assertEquals(2, shapse.getSizeList())
        kotlin.test.assertEquals(answer, shapse.sumOfAreas())
    }
    @Test
    fun `find figure by border color`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color2)
        val circle2 = Circle(5.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color1)
        val shapse = ShapeCollector(listOf(circle, circle2, triangle))
        kotlin.test.assertEquals(3, shapse.getSizeList())
        kotlin.test.assertEquals(listOf(circle, circle2), shapse.findByBorderColor(color1))
    }
    @Test
    fun `find figure by fill color`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color1)
        val circle2 = Circle(5.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color2)
        val shapse = ShapeCollector(listOf(circle, circle2, triangle))
        kotlin.test.assertEquals(3, shapse.getSizeList())
        kotlin.test.assertEquals(listOf(circle2, triangle), shapse.findByFillColor(color2))
    }
    @Test
    fun `displaying the entire list of shapes`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color1)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color2)
        val shapse = ShapeCollector(listOf(circle, triangle))
        kotlin.test.assertEquals(2, shapse.getSizeList())
        kotlin.test.assertEquals(listOf(circle, triangle), shapse.getListFigure())
    }
    @Test
    fun `size of list shapes`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color1)
        val shapse = ShapeCollector(listOf())
        kotlin.test.assertEquals(0, shapse.getSizeList())
        shapse.addFigure(circle)
        kotlin.test.assertEquals(1, shapse.getSizeList())
        shapse.addFigure(triangle)
        kotlin.test.assertEquals(2, shapse.getSizeList())
    }
    @Test
    fun `grouping by border color`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color1)
        val circle2 = Circle(5.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color2)
        val shapse = ShapeCollector(listOf(circle, circle2, triangle))
        kotlin.test.assertEquals(3, shapse.getSizeList())
        kotlin.test.assertEquals(
            mapOf(color1 to listOf(circle, circle2), color2 to listOf(triangle)),
            shapse.groupedByBorderColor()
        )
    }
    @Test
    fun `grouping by fill color`() {
        val color1 = Color(255, 255, 255, 60)
        val color2 = Color(0, 0, 0, 40)
        val circle = Circle(1.0, color1, color1)
        val circle2 = Circle(5.0, color1, color2)
        val triangle = Triangle(6.0, 4.0, 9.0, color2, color1)
        val shapse = ShapeCollector(listOf(circle, circle2, triangle))
        kotlin.test.assertEquals(3, shapse.getSizeList())
        kotlin.test.assertEquals(
            mapOf(color1 to listOf(circle, triangle), color2 to listOf(circle2)),
            shapse.groupedByFillColor()
        )
    }
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
}