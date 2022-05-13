package lab1.Lab2

import kotlin.math.sqrt

data class Circle(private val rad: Double, override val borderColor: Color, override val fillColor: Color) : ColoredShape2d {
    override fun calcArea(): Double {
        if (rad <= 0) throw IllegalArgumentException("Radius should be positive")
        return 3.14 * rad * rad
    }
}

data class Square(private val side: Double, override val borderColor: Color, override val fillColor: Color) : ColoredShape2d {
    override fun calcArea(): Double {
        if (side <= 0) throw IllegalArgumentException("Radius can't be negative")
        return side * side
    }
}

data class Rectangle(private val side1: Double, private val side2: Double, override val borderColor: Color, override val fillColor: Color) : ColoredShape2d {
    override fun calcArea(): Double {
        if (side1 <= 0 || side2 <= 0) throw IllegalArgumentException("Sides can't be negative")
        return side1 * side2
    }
}

data class Triangle(private val side1: Double, private val side2: Double, private val side3: Double, override val borderColor: Color, override val fillColor: Color) : ColoredShape2d {
    private val halfPerimeter = side1 + side2 + side3
    override fun calcArea(): Double {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) throw IllegalArgumentException("Sides can't be negative")
        if (side1 + side2 < side3 || side1 + side3 < side2 || side3 + side2 < side1) throw IllegalArgumentException("There is no such triangle")
        return sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3))
    }
}