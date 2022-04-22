package Lab3

import java.time.LocalDate
//import java.time.LocalDateTime

sealed class Note(open val title: String, open val date: LocalDate, open val content: String) {
    class TextNote(override val title: String, override val date: LocalDate, override val content: String): Note(title, date, content) {
        override fun toString(): String {
            return "TextNote(title='$title', date=$date, content='$content')"
        }
    }

    class Task(override val title: String, override val date: LocalDate, override val content: String, var deadline: LocalDate): Note(title, date, content){
        override fun toString(): String {
            return "TaskNote(title='$title', date=$date, content='$content', deadline=$deadline)"
        }

    }

    class Url(override val title: String, override val date: LocalDate, override val content: String): Note(title, date, content){
        override fun toString(): String {
            return "UrlNote(title='$title', date=$date, url='$content')"
        }

    }

//    class Link{
//
//    }
}