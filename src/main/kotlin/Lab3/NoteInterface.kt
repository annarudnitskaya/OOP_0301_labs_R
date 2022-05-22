package lab1.Lab3

import Lab3.Note
import java.time.LocalDate

interface InterfaceFunctions {
    val noteList: List<Note>

    fun add(note: Note)

    fun getAllNotes(): List<Note>
    fun getAllTextNotes(): List<Note.TextNote>
    fun getAllTasks(): List<Note.Task>
    fun getAllLinks(): List<Note.Link>

    fun createTextNote(title: String, date: LocalDate, content: String): Note.TextNote

    fun createTask(title: String, date: LocalDate, content: String, deadline: LocalDate): Note.Task

    fun createLink(title: String, date: LocalDate, content: String): Note.Link

    //fun removeNote(note: Note)

    //fun findType(type: Class<Any>): List<Note>
    fun findTitle(title: String): List<Note>

    fun getSortedTitle(): List<Note>
    fun getSortedDate(): List<Note>


}