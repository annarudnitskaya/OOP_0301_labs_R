package lab1.Course


class Contact {
    var firstName: String = ""
    var secondName: String = ""
    var phone: String = ""
    var email: String = ""
    var address: String = ""
    var ind: Int = 0
    var date: String = ""

    fun getAllInformation() =
        "N:" + firstName + " " + secondName + "\n" + "BDAY:" + date + "\n" + "TEL;HOME:" + phone + "\n" + "EMAIL;HOME:" + email + "\n" + "ADR;TYPE=home:" + address + "\n"


    fun changeFirstName(Name: String) {
        firstName = Name
    }

    fun changeSecondName(Name: String) {
        secondName = Name
    }

    fun changePhone(number: String) {
        phone = number
    }

    fun changeEmail(mail: String) {
        email = mail
    }

    fun changeAddress(new: String) {
        address = new
    }

    fun changeIndex(i: Int) {
        ind = i

    }

    fun changeDate(new: String) {
        date = new
    }
}

class Model(list: List<Contact>) {
    private val _contact: MutableList<Contact> = list.toMutableList()
    val contacts: List<Contact>
        get() = _contact

    fun createContact(contact: Contact) {
        _contact.add(contact)
    }

    fun removeContact(contact: Contact) {
        _contact.remove(contact)
    }
}

