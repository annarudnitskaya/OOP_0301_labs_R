//package Lab3
//
//import lab1.Lab3.NoteFun
//import java.time.LocalDate
//
//fun main() {
//    val notes = NoteFun()
//    notes.createTask("Task Note", LocalDate.of(2022,4,24),"Do homework", LocalDate.of(2022, 5, 8))
//    notes.createTextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
//    notes.createLink("Link Note", LocalDate.of(2022,3,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")
//    notes.createTextNote("Text Note", LocalDate.of(2022,4,24),"Just a text")
//
//
//
//    println("AllNotes: $notes.getAllNotes()")
//    println("All Notes: ${notes.getAllNotes()}")
//    println("All TextNotes: ${notes.getAllTextNotes()}")
//    println("All Links: ${notes.getAllLinks()}")
//    println("All Tasks: ${notes.getAllTasks()}")
//    println("Sorted by date: ${notes.getSortedDate()}")
//    println("Sorted by title: ${notes.getSortedTitle()}")
//    println("Delete TextNotes: ${notes.removeNote(notes.getAllNotes()[1])}")
//    println("Find of tipe link: ${notes.findType(Note.Link::class.java)}")
//
//}