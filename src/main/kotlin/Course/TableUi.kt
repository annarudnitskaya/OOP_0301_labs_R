package lab1.Course

import java.io.File
import java.awt.BorderLayout
import java.awt.Component
import java.awt.Container
import java.awt.GridLayout
import java.io.FileOutputStream
import javax.swing.*
import kotlin.system.exitProcess

private const val GAP = 10

class TableUi(list: List<Contact>) : JFrame("Phone Book") {
    private var workModel: Model = Model(list)
    private val statusLabel = JLabel("Contacts", JLabel.CENTER)
    private val buttons = mutableListOf<MutableList<JButton>>()
    private var size = list.size
    private val listContact = mutableListOf<JTextField>()

    init {
        setSize(1000, 500)
        defaultCloseOperation = EXIT_ON_CLOSE
        updateFont(statusLabel, 20.0f)
        rootPane.contentPane = startPanel()
    }

    private fun startPanel(): Container {
        val panel = JPanel(BorderLayout(GAP, GAP)).apply {
            add(statusLabel, BorderLayout.NORTH)
            add(createBoardPanel(), BorderLayout.CENTER)
            add(startButtons(), BorderLayout.SOUTH)
            border = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP)
        }
        return panel
    }

    private fun backButton(): JButton {
        val back = JButton("Back")
        back.addActionListener {
            listContact.clear()
            rootPane.contentPane = startPanel()
            revalidate()
            repaint()
        }
        updateFont(back, 20.0f)
        return back
    }

    private fun writeToVCard(ind: Int) {
        val fileName = ("vCard$ind.vcf")
        val file = File(fileName)
        FileOutputStream(file)
        val person = workModel.contacts[ind].getAllInformation()
        File(fileName).appendText("BEGIN:VCARD \nVERSION:3.0 \n${person}END:VCARD \n")
    }

    private fun saveToVCardButton(ind: Int): Component {
        val saveVCard = JButton("Save in vCard-file")
        saveVCard.addActionListener {
            writeToVCard(ind)
            listContact.clear()
            rootPane.contentPane = startPanel()
            revalidate()
            repaint()
        }
        updateFont(saveVCard, 20.0f)
        return saveVCard
    }

    private fun startButtons(): Component {
        val panel = JPanel().apply {
            add(createButton())
            add(exitButton())
        }
        return panel
    }

    private fun createButton(): Component {
        val create = JButton("Create")
        updateFont(create, 20.0f)
        create.addActionListener {
            buttons.clear()
            rootPane.contentPane = startPanel()
            rootPane.contentPane.add(changingPanel(false, 0), BorderLayout.CENTER)
            rootPane.contentPane.add(internalButtons(false, 0), BorderLayout.SOUTH)
            revalidate()
            repaint()
        }
        return create
    }

    private fun internalButtons(flag: Boolean, ind: Int): Component {
        val panel = JPanel().apply {
            if (flag) {
                add(deleteButton(ind))
            }
            add(saveButton(flag, ind))
            add(backButton())
            add(saveToVCardButton(ind))

        }
        return panel
    }

    private fun exitButton(): Component {
        val exit = JButton("Exit")
        updateFont(exit, 20.0f)
        exit.addActionListener {
            val dialogOption = JOptionPane.showConfirmDialog(
                this,
                "You sure that you want to exit? All changes will be saved.",
                "Exit",
                JOptionPane.OK_CANCEL_OPTION
            )

            if (dialogOption == JOptionPane.OK_OPTION) {
                val file = workForFile()
                val listAns = mutableListOf<Contact>()
                for (i in 0 until  size) {
                    val contact = Contact()
                    contact.changeFirstName(workModel.contacts[i].firstName)
                    contact.changeSecondName(workModel.contacts[i].secondName)
                    contact.changeDate(workModel.contacts[i].date)
                    contact.changeAddress(workModel.contacts[i].address)
                    contact.changeEmail(workModel.contacts[i].email)
                    contact.changePhone(workModel.contacts[i].phone)
                    listAns.add(contact)
                }
                file.write(listAns)
                exitProcess(0)
            }
        }
        return exit
    }

    private fun deleteButton(ind: Int): Component {
        val detele = JButton("Delete")
        updateFont(detele, 20.0f)
        detele.addActionListener {
            val dialogOption = JOptionPane.showConfirmDialog(
                this,
                "Delete the contact?",
                "Delete",
                JOptionPane.OK_CANCEL_OPTION
            )

            if (dialogOption == JOptionPane.OK_OPTION) {
                workModel.removeContact(workModel.contacts[ind])
                size--
                var i = ind
                while (i < size) {
                    workModel.contacts[i].changeIndex(i)
                    i++
                }
                listContact.clear()
                rootPane.contentPane = startPanel()
                revalidate()
                repaint()
            }
        }
        return detele
    }

    private fun saveButton(flag: Boolean, ind: Int): Component {
        val save = JButton("Save")
        updateFont(save, 20.0f)
        save.addActionListener {
            val dialogOption = JOptionPane.showConfirmDialog(
                this,
                "Save the contact?",
                "Save",
                JOptionPane.OK_CANCEL_OPTION
            )

            if (dialogOption == JOptionPane.OK_OPTION) {
                if (!flag) {
                    val cont = Contact()
                    cont.changeFirstName(listContact[0].text)
                    cont.changeSecondName(listContact[1].text)
                    cont.changePhone(listContact[2].text)
                    cont.changeAddress(listContact[3].text)
                    cont.changeEmail(listContact[4].text)
                    cont.changeDate(listContact[5].text)
                    cont.changeIndex(size)
                    workModel.createContact(cont)
                    size++
                } else {
                    workModel.contacts[ind].changeFirstName(listContact[0].text)
                    workModel.contacts[ind].changeSecondName(listContact[1].text)
                    workModel.contacts[ind].changePhone(listContact[2].text)
                    workModel.contacts[ind].changeAddress(listContact[3].text)
                    workModel.contacts[ind].changeEmail(listContact[4].text)
                    workModel.contacts[ind].changeDate(listContact[5].text)
                }
            }
        }
        return save
    }

    private fun createBoardPanel(): Component {
        val workPanel = JPanel(GridLayout(size, size, GAP, GAP))
        var j = 0
        for (i in workModel.contacts) {
            if (j < size) {
                val buttonsList = mutableListOf<JButton>()
                val cellButton = JButton(i.firstName + " " + i.secondName)
                buttonsList.add(cellButton)
                workPanel.add(cellButton)
                updateFont(cellButton, 30.0f)
                buttons.add(buttonsList)
                cellButton.addActionListener {
                    buttons.clear()
                    rootPane.contentPane = startPanel()
                    rootPane.contentPane.add(changingPanel(true, i.ind), BorderLayout.CENTER)
                    rootPane.contentPane.add(internalButtons(true, i.ind), BorderLayout.SOUTH)
                    revalidate()
                    repaint()
                }
                j++
            }
        }
        return workPanel
    }

    private fun changingPanel(flag: Boolean, int: Int): Component {
        val contact = if (flag) workModel.contacts[int]
        else Contact()
        var temp = contact.firstName
        listContact.add(JTextField(temp))
        temp = contact.secondName
        listContact.add(JTextField(temp))
        temp = contact.phone
        listContact.add(JTextField(temp))
        temp = contact.date
        listContact.add(JTextField(temp))
        temp = contact.address
        listContact.add(JTextField(temp))
        temp = contact.email
        listContact.add(JTextField(temp))
        val panel = JPanel().apply {
            add(JLabel("Name:"))
            add(listContact[0])
            add(JLabel("Surname:"))
            add(listContact[1])
            add(JLabel("Phone number:"))
            add(listContact[2])
            add(JLabel("Address:"))
            add(listContact[3])
            add(JLabel("Emails:"))
            add(listContact[4])
            add(JLabel("Date of birth:"))
            add(listContact[5])
        }
        panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
        return JScrollPane(panel)
    }

    private fun updateFont(component: JComponent, newFontSize: Float) {
        val font = component.font
        val derivedFont = font.deriveFont(newFontSize)
        component.font = derivedFont
    }
}

