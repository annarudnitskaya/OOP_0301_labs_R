package lab1.Course

import javax.swing.SwingUtilities

fun main() {
    val ff = forFile()
    val list = ff.read()

    SwingUtilities.invokeLater {
        val tableUi = TableUi(list)
        tableUi.isVisible = true
   }

}