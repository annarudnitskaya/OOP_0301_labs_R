package lab1.Course

import javax.swing.SwingUtilities

fun main() {
    val workFile = workForFile()
    val list = workFile.read()

    SwingUtilities.invokeLater {
        val tableUi = TableUi(list)
        tableUi.isVisible = true
    }

}