
import lab1.Lab6.*
import java.io.File

fun main() {
    val color1 = Color(255, 255, 255, 60)
    val color2 = Color(0, 0, 0, 40)


//    val file = forFile("src/main/kotlin/lab1/Lab6/input.txt", "src/main/kotlin/lab1/Lab6/output.txt")
    println(File("input.txt").readText())
//    val workSerializer = Serializer()
//    println("\nObjects list from file:")
//    val workList = workSerializer.deserialization(file.read()).toMutableList()
//    println(workList)
//    println("\nAdd objects:")
//    workList.add(Circle(6.0, color1, color2))
//    workList.add(Rectangle(2.3, 4.5, color1, color1))
//    workList.add(Triangle(8.0, 4.0, 7.0, color2, color1))
//    workList.add(Square(6.0, color2, color2))
//    println(workList)
//    println("\nAdd it to file")
//    file.write(workSerializer.serialization(workList))
}