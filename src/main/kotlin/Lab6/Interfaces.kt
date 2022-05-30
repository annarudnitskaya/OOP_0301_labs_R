package lab1.Lab6


interface Shape2d {
    fun calcArea(): Double
}

interface ColoredShape2d : Shape2d {
    val borderColor: Color
    val fillColor: Color
}