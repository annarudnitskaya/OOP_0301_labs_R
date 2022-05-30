package lab1.Lab2

import kotlin.math.sqrt

data class Circle(var rad: Double, override val borderColor: Color, override val fillColor: Color) : ColoredShape2d {
    init {
        if (rad <= 0) { throw IllegalArgumentException("Radius should be positive") }
        this.rad = rad
    }
    override fun calcArea(): Double {
        return 3.14 * rad * rad
    }
}

data class Square(var side: Double, override val borderColor: Color, override val fillColor: Color) : ColoredShape2d {
    init {
        if (side <= 0) { throw IllegalArgumentException("Side can't be negative") }
        this.side = side
    }
    override fun calcArea(): Double {
        return side * side
    }
}

data class Rectangle(var side1: Double, private var side2: Double, override val borderColor: Color, override val fillColor: Color) : ColoredShape2d {
    init {
        if (side1 <= 0 || side2 <= 0) { throw IllegalArgumentException("Sides can't be negative") }
        this.side1 = side1
        this.side2 = side2
    }
    override fun calcArea(): Double {
        return side1 * side2
    }
}

data class Triangle(var side1: Double, private var side2: Double, private var side3: Double, override val borderColor: Color, override val fillColor: Color) : ColoredShape2d {
    init {
        if (side1 + side2 + side3 - 2 * maxOf(side1, side2, side3) <= 0) {
            throw IllegalArgumentException("Triangle with entered sides doesn't exist")
        }
        this.side1 = side1
        this.side2 = side2
        this.side3 = side3
    }
    private val halfPerimeter = (side1 + side2 + side3)/2
    override fun calcArea(): Double {
        return sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3))
    }
}