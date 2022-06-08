package lab1.Course

import javax.swing.SwingUtilities

fun main() {

    val rr = Contact()
    val tr = Contact()
    val atr = Contact()
    val arr = Contact()
    val tt = mutableListOf<Contact>()
    rr.changeFirstName("rr")
    rr.changeIndex(3)
    tr.changeFirstName("tr")
    tr.changeIndex(1)
    arr.changeFirstName("rr")
    atr.changeFirstName("tr")
    atr.changeIndex(2)
    arr.changeSecondName("rr")
    atr.changeSecondName("tr")
    tt.add(arr)
    tt.add(tr)
    tt.add(atr)
    tt.add(rr)
    SwingUtilities.invokeLater {
        val tableUi = TableUi(tt)
        tableUi.isVisible = true
   }
}