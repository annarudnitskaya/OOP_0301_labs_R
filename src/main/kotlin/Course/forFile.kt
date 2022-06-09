package lab1.Course

import java.io.File
import java.io.FileOutputStream

class forFile() {
    fun read(): List<Contact>{
        val file = File("phoneBook.txt").readLines()
        var listContact = mutableListOf<Contact>()
        var perem: String
        var cout = 0
        for (i in file){
            var contact = Contact()
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
            cout++

            listContact.add(contact)
        }
        return listContact
    }
    fun write(list: List<Contact>){
        var file = File("phoneBook.txt")
        FileOutputStream(file)
        for (i in list.indices){
            File("phoneBook.txt").appendText(list[i].getFirstName() + ";" + list[i].getSecondName() +";" + list[i].getPhone() +";" + list[i].getAddress()+";" + list[i].getEmail() +";" + list[i].getDate()+";\n")
        }

    }
}