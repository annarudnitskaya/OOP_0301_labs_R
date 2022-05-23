package lab1.Lab3

import Lab3.Note
import java.time.LocalDate

class NoteFun {
    private val listNotes: MutableList<Note> = mutableListOf()

        fun add(note: Note){
            listNotes.add(note)
        }

        fun getAllNotes(): List<Note>{
                if (listNotes.isEmpty()) return emptyList()
                return listNotes

        }
        fun getAllTextNotes(): List<Note.TextNote>{
            if (listNotes.isEmpty()) return emptyList()
            else {
                return listNotes.filterIsInstance(Note.TextNote::class.java)
            }
        }

    fun getAllTasks(): List<Note.Task> {
        if (listNotes.isEmpty()) return emptyList()
        else {
            return listNotes.filterIsInstance(Note.Task::class.java)
        }

    }

    fun getAllLinks(): List<Note.Link> {
        if (listNotes.isEmpty()) return emptyList()
        else {
            return listNotes.filterIsInstance(Note.Link::class.java)
        }

    }

    fun createTextNote(title: String, date: LocalDate, content: String): Note.TextNote{
        val text = Note.TextNote(title, date, content)
        listNotes.add(text)
        return text
    }

    fun createTask(title: String, date: LocalDate, content: String, deadline: LocalDate): Note.Task{
        val task = Note.Task(title, date, content, deadline)
        listNotes.add(task)
        return task
    }

    fun createLink(title: String, date: LocalDate, content: String): Note.Link{
        val link = Note.Link(title, date, content)
        listNotes.add(link)
        return link
    }

    fun findTitle(title: String): List<Note>{
        val notesByTitle: MutableList<Note> = mutableListOf()
        for (note in listNotes) {
            if (note.title == title) notesByTitle.add(note)
        }
        return notesByTitle
    }

   fun getSortedTitle():List<Note> {
       if (listNotes.isEmpty()) return emptyList()
       else return listNotes.sortedBy { it.title }
   }

    fun getSortedDate(): List<Note>{
        if (listNotes.isEmpty()) return emptyList()
        else return listNotes.sortedBy { it.date }
    }

    fun removeNote(note: Note){
        listNotes.remove(note)
    }

    fun findType(type: Class<out Note>): List<Note> {
        return listNotes.filterIsInstance(type)
    }
}
