package lab1.Lab2

fun main() {

    val color1 = Color(255, 255, 255, 60)
    val color2 = Color(0, 0, 0, 40)

    //Creating shapes
    val circle = Circle(6.0, color1, color2)
    val triangle = Triangle(8.0, 4.0, 7.0, color2, color1)
    val rectangle = Rectangle(2.3, 4.5, color1, color1)
    val square = Square(6.0, color2, color2)
    val square2 = Square(7.0, color2, color2)


    val allShapes = ShapeCollector(listOf())
    allShapes.addFigure(circle)
    allShapes.addFigure(triangle)
    allShapes.addFigure(rectangle)
    allShapes.addFigure(square)
    allShapes.addFigure(square2)


    //Methods of working with the class
    println("ShapeCollection = ${allShapes.getListFigure()}") //List output
    println("Min area = ${allShapes.minAreaF()}")
    println("Max area = ${allShapes.maxAreaF()}")
    println("Area of all figures = ${allShapes.sumOfAreas()}")
    println("Count of figures = ${allShapes.getSizeList()}")
    println("Shapes with color1 in border color = ${allShapes.findByBorderColor(color1)}")
    println("Shapes with color2 in fill color = ${allShapes.findByFillColor(color2)}")
    println("Shapes grouped by border color = ${allShapes.groupedByBorderColor()}")
    println("Shapes grouped by fill color = ${allShapes.groupedByFillColor()}")
    println("Shapes of a certain type = ${allShapes.shapesByType(Circle::class.java)}")
}