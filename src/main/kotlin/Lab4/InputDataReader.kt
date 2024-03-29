package lab1.Lab4

import java.io.File

class InputDataReader {
    fun readFileDirectlyAsText(fileName: String): String
            = File(fileName).readText(Charsets.UTF_8)
}

fun main(args: Array<String>) {
    var fileName = "test.txt"
    val arr = InputDataReader().readFileDirectlyAsText(fileName)
    println(arr)
    println()
    for (i in arr.indices) {
        val x = arr.get(i)
        when(x) {
            '#' -> println("# + $i")
            '-' -> println("- + $i")
            'P' -> println("P + $i")
            'E' -> println("E + $i")
            else -> println("Something else")
        }
    }
}

private operator fun Int.iterator(): Iterator<Int> {
    return iterator()
}

private operator fun Unit.get(it: Int) {
    return
}

