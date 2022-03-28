package lab1.Lab2

data class Color // TODO

interface Shape2d {
    fun calcArea(): Double
}

interface ColoredShape2d : Shape2d {
    val borderColor: Color
    val fillColor: Color
}
