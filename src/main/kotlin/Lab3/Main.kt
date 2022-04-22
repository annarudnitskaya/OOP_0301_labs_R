package Lab3
import java.time.LocalDate

fun main() {
    val notes1 = Note.Task("Task Note", LocalDate.of(2022,4,24),"Do homework", LocalDate.of(2022, 5, 8))
    val notes2 = Note.TextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
    val notes3 = Note.Url("Url Note", LocalDate.of(2022,4,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")

    println(notes1)
    println(notes2)
    println(notes3)
}