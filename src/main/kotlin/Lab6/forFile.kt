//package lab1.Lab6
//import java.io.File
//
//class forFile (private val pathIn: String, private val pathOut: String) {
//
//    constructor(pathInputOutput: String) : this(pathInputOutput, pathInputOutput)
//
//    fun write(data: String) {
//        File(pathOut).writeText(data)
//    }
//
//    fun read(): String {
//      if (!File(pathIn).exists())
//           throw IllegalArgumentException("File doesn't exist")
//        return File(pathIn).readText()
//    }
//
//}