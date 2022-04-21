package Lab3
import java.time.LocalDate

fun main() {
    val notes = Note.Task("RyR", LocalDate.of(2022,4,24),"tytytyty", LocalDate.of(2022, 5, 8))

    println(notes)
}