package lab1.Lab3

import Lab3.Note
import lab1.Lab3.NoteFun
import kotlin.test.Test
import kotlin.test.assertEquals
import java.time.LocalDate

internal class NoteFunTest {

    @Test
   fun `getting all note`() {
        val listTest = NoteFun()
        val note = Note.TextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        listTest.createTextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        assertEquals(mutableListOf(note),listTest.getAllNotes())
   }
    @Test
    fun getAllTextNotes() {
        val listTest = NoteFun()
        val note = Note.TextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        listTest.createTask("Task Note", LocalDate.of(2022,4,24),"Do homework", LocalDate.of(2022, 5, 8))
        listTest.createLink("Link Note", LocalDate.of(2022,4,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")
        listTest.createTextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        assertEquals(mutableListOf(note),listTest.getAllTextNotes())
    }
    @Test
    fun getAllTasks() {
        val listTest = NoteFun()
        val note = Note.Task("Task Note", LocalDate.of(2022,4,24),"Do homework", LocalDate.of(2022, 5, 8))
        listTest.createTask("Task Note", LocalDate.of(2022,4,24),"Do homework", LocalDate.of(2022, 5, 8))
        listTest.createLink("Link Note", LocalDate.of(2022,4,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")
        listTest.createTextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        assertEquals(mutableListOf(note),listTest.getAllTasks())
    }
    @Test
    fun getAllLinks() {
        val listTest = NoteFun()
        val note = Note.Link("Link Note", LocalDate.of(2022,4,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")
        listTest.createTask("Task Note", LocalDate.of(2022,4,24),"Do homework", LocalDate.of(2022, 5, 8))
        listTest.createLink("Link Note", LocalDate.of(2022,4,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")
        listTest.createTextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        assertEquals(mutableListOf(note),listTest.getAllLinks())
    }
    @Test
    fun createTextNote() {
        val listTest = NoteFun()
        val note = Note.TextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        listTest.createTextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        assertEquals(mutableListOf(note),listTest.getAllTextNotes())
    }
    @Test
    fun createTask() {
        val listTest = NoteFun()
        val note = Note.Task("Task Note", LocalDate.of(2022,4,24),"Do homework", LocalDate.of(2022, 5, 8))
        listTest.createTask("Task Note", LocalDate.of(2022,4,24),"Do homework", LocalDate.of(2022, 5, 8))
        assertEquals(mutableListOf(note),listTest.getAllTasks())
    }
    @Test
    fun createLink() {
        val listTest = NoteFun()
        val note = Note.Link("Link Note", LocalDate.of(2022,4,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")
        listTest.createLink("Link Note", LocalDate.of(2022,4,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")
        assertEquals(mutableListOf(note),listTest.getAllLinks())
    }
    @Test
    fun findTitle() {
        val listTest = NoteFun()
        val note = Note.TextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        listTest.createTextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        listTest.createTextNote("Text Note2", LocalDate.of(2022,4,24),"I want to be here")
        assertEquals(mutableListOf(note),listTest.findTitle("Text Note"))

    }
    @Test
    fun getSortedTitle() {
        val listTest = NoteFun()
        val note = Note.Task("Task Note", LocalDate.of(2022,2,24),"Do homework", LocalDate.of(2022, 5, 8))
        val note2 = Note.Link("Link Note", LocalDate.of(2022,5,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")
        val note3 = Note.TextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        listTest.createTask("Task Note", LocalDate.of(2022,2,24),"Do homework", LocalDate.of(2022, 5, 8))
        listTest.createLink("Link Note", LocalDate.of(2022,5,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")
        listTest.createTextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        assertEquals(mutableListOf(note2, note, note3),listTest.getSortedTitle())
    }
    @Test
    fun getSortedDate() {
        val listTest = NoteFun()
        val note = Note.Task("Task Note", LocalDate.of(2022,2,24),"Do homework", LocalDate.of(2022, 5, 8))
        val note2 = Note.Link("Link Note", LocalDate.of(2022,5,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")
        val note3 = Note.TextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        listTest.createTask("Task Note", LocalDate.of(2022,2,24),"Do homework", LocalDate.of(2022, 5, 8))
        listTest.createLink("Link Note", LocalDate.of(2022,5,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")
        listTest.createTextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        assertEquals(mutableListOf(note, note3, note2),listTest.getSortedDate())
    }
    @Test
    fun removeNote() {
        val listTest = NoteFun()
        val note = Note.TextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        val note2 = Note.TextNote("Text Note2", LocalDate.of(2022,4,24),"Just a text")
        listTest.createTextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        listTest.createTextNote("Text Note2", LocalDate.of(2022,4,24),"Just a text")
        assertEquals(mutableListOf(note, note2),listTest.findType(Note.TextNote::class.java))
        listTest.removeNote(listTest.getAllNotes()[1])
        assertEquals(mutableListOf(note),listTest.getAllTextNotes())
    }
    @Test
    fun findType() {
        val listTest = NoteFun()
        val note = Note.TextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        val note2 = Note.TextNote("Text Note", LocalDate.of(2022,4,24),"Just a text")
        listTest.createTask("Task Note", LocalDate.of(2022,4,24),"Do homework", LocalDate.of(2022, 5, 8))
        listTest.createLink("Link Note", LocalDate.of(2022,4,24),"https://github.com/annarudnitskaya/OOP_0301_labs_R")
        listTest.createTextNote("Text Note", LocalDate.of(2022,4,24),"I want to be here")
        listTest.createTextNote("Text Note", LocalDate.of(2022,4,24),"Just a text")
        assertEquals(mutableListOf(note, note2),listTest.findType(Note.TextNote::class.java))
    }
}