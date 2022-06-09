package lab1.Course

import java.io.File
import java.io.FileOutputStream

class workForFile() {
    fun read(): List<Contact> {
        val file = File("phoneBook.txt").readLines()
        val listContact = mutableListOf<Contact>()
        var perem: String
        for ((cout, i) in file.withIndex()) {
            val contact = Contact()
            perem = i
            contact.changeFirstName(perem.substringBefore(';'))

            perem = perem.substringAfter(";").trim()
            contact.changeSecondName(perem.substringBefore(';'))

            perem = perem.substringAfter(";").trim()
            contact.changePhone(perem.substringBefore(';'))

            perem = perem.substringAfter(";").trim()
            contact.changeAddress(perem.substringBefore(';'))

            perem = perem.substringAfter(";").trim()
            contact.changeEmail(perem.substringBefore(';'))

            perem = perem.substringAfter(";").trim()
            contact.changeDate(perem.substringBefore(';'))

            contact.changeIndex(cout)

            listContact.add(contact)
        }
        return listContact
    }

    fun write(list: List<Contact>) {
        val file = File("phoneBook.txt")
        FileOutputStream(file)
        for (i in list.indices) {
            File("phoneBook.txt").appendText(list[i].firstName + ";" + list[i].secondName + ";" + list[i].phone + ";" + list[i].address + ";" + list[i].email + ";" + list[i].date + ";\n")
        }

    }
}