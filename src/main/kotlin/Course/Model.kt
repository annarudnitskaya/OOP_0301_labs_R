package lab1.Course

class Contact {
    private var firstName: String = ""
    private var secondName:String = ""
    private var phone:String = ""
    private var email: String = ""
    private var address: String = ""
    private var ind: Int = 0
    private var date: String = ""

    fun getAllName() = firstName + " " + secondName
    fun getFirstName() = firstName
    fun getSecondName() = secondName
    fun getDate() = date
    fun getEmail() = email
    fun getPhone() = phone
    fun getAddress() = address
    fun getIndex() = ind


    fun changeFirstName(Name: String){
        firstName = Name
    }
    fun changeSecondName(Name: String){
        secondName = Name
    }
    fun changePhone(number: String){
        phone = number
    }
    fun changeEmail(mail: String){
        email = mail
    }
    fun changeAddress(new: String){
        address = new
    }

    fun changeIndex(i: Int) {
        ind = i

    }
    fun changeDate(new: String){
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
