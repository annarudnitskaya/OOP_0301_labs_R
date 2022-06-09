package lab1.Course

import javax.swing.SwingUtilities

fun main() {

    val rr = Contact()
    val tr = Contact()
    val atr = Contact()
    val arr = Contact()
    val tt = mutableListOf<Contact>()
    rr.changeFirstName("Vlad")
    rr.changeIndex(3)
    tr.changeFirstName("Alex")
    tr.changeIndex(1)
    arr.changeFirstName("Anna")
    arr.changeDate("13.10.2001")
    arr.changePhone("89112823272")
    arr.changeAddress("Somewhere")
    arr.changeEmail("arr@gmail.com")
    atr.changeFirstName("Alina")
    atr.changeIndex(2)
    arr.changeSecondName("Rudnitskaya")
    atr.changeSecondName("Reymhen")
    tt.add(arr)
    tt.add(tr)
    tt.add(atr)
    tt.add(rr)
    SwingUtilities.invokeLater {
        val tableUi = TableUi(tt)
        tableUi.isVisible = true
   }
}