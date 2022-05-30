package lab1.Lab2
import kotlinx.serialization.*

@Serializable
data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val transparency: Int
) {
    init {
        if (red < 0 || red > 255) error("Incorrect value of red color")
        if (green < 0 || green > 255) error("Incorrect value of green color")
        if (blue < 0 || blue > 255) error("Incorrect value of blue color")
        if (transparency < 0 || transparency > 100) error("Incorrect value of transparency")
    }
}