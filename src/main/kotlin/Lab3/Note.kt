//package Lab3
//
//import java.time.LocalDate
//
//sealed class Note(open val title: String, open val date: LocalDate, open val content: String) {
//    data class TextNote(override val title: String, override val date: LocalDate, override val content: String): Note(title, date, content) {
//        override fun toString(): String {
//            return "TextNote(title='$title', date=$date, content='$content')"
//        }
//    }
//
//    data class Task(override val title: String, override val date: LocalDate, override val content: String, var deadline: LocalDate): Note(title, date, content){
//        override fun toString(): String {
//            return "TaskNote(title='$title', date=$date, content='$content', deadline=$deadline)"
//        }
//
//    }
//
//    data class Link(override val title: String, override val date: LocalDate, override val content: String): Note(title, date, content){
//        override fun toString(): String {
//            return "UrlNote(title='$title', date=$date, url='$content')"
//        }
//
//    }
//}
//
