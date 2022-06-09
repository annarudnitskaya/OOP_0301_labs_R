package lab1.Course

import java.io.File
import java.awt.BorderLayout
import java.awt.Component
import java.awt.Container
import java.awt.GridLayout
import java.io.FileOutputStream
import javax.swing.*

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
        rootPane.contentPane = resubscribe() as Container?
    }

    private fun resubscribe(): Component {
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
            rootPane.contentPane = resubscribe() as Container?
            revalidate()
            repaint()
        }
        updateFont(back, 20.0f)
        return back
    }

    fun writeToVCard(ind:Int) {
        val fileName = ("vCard"+ind+".vcf")
        val file = File(fileName)
        FileOutputStream(file)
        val person= workModel.contacts[ind].getAllInformation()
        File(fileName).appendText("BEGIN:VCARD \nVERSION:3.0 \n${person}END:VCARD \n")
    }

    private fun saveToVCardButton(ind:Int): Component{
        val saveVCard = JButton("Save in vCard-file")
        saveVCard.addActionListener{
            writeToVCard(ind)
            listContact.clear()
            rootPane.contentPane = resubscribe() as Container?
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
            rootPane.contentPane = resubscribe() as Container?
            rootPane.contentPane.add(changingPanel(false, 0), BorderLayout.CENTER)
            rootPane.contentPane.add(internalButtons(false, 0), BorderLayout.SOUTH)
            revalidate()
            repaint()
        }
        return create
    }

    private fun internalButtons(flag: Boolean, ind:Int): Component {
        val panel = JPanel().apply {
            if (flag) {add(deleteButton(ind)) }
            add(saveButton(flag, ind))
            add(backButton())
            add(saveToVCardButton(ind))

        }
        return panel
    }

    private fun exitButton(): Component{
        val exit = JButton("Exit")
        updateFont(exit, 20.0f)
        exit.addActionListener{
            val dialogOption = JOptionPane.showConfirmDialog(
                this,
                "You sure that you want to exit? All changes will be saved.",
                "Exit",
                JOptionPane.OK_CANCEL_OPTION
            )

            if (dialogOption == JOptionPane.OK_OPTION) {
            val file = forFile()
            val listAns = mutableListOf<Contact>()
            var i =0
            while(i < size){
                val contact = Contact()
                contact.changeFirstName(workModel.contacts[i].getFirstName())
                contact.changeSecondName(workModel.contacts[i].getSecondName())
                contact.changeDate(workModel.contacts[i].getDate())
                contact.changeAddress(workModel.contacts[i].getAddress())
                contact.changeEmail(workModel.contacts[i].getEmail())
                contact.changePhone(workModel.contacts[i].getPhone())
                listAns.add(contact)
                i++
            }
            val list = file.write(listAns)
                System.exit(0)
            }
        }
        return exit
    }

    private fun deleteButton(ind:Int): Component{
        val detele = JButton("Delete")
        updateFont(detele, 20.0f)
        detele.addActionListener{
            val dialogOption = JOptionPane.showConfirmDialog(
                this,
                "Delete the contact?",
                "Delete",
                JOptionPane.OK_CANCEL_OPTION
            )

            if (dialogOption == JOptionPane.OK_OPTION) {
            workModel.removeContact(workModel.contacts[ind])
            size--
            var i = 0
            while ( i < ind){
                i++
            }
            while (i < size){
                workModel.contacts[i].changeIndex(i)
                i++
            }
            listContact.clear()
            rootPane.contentPane = resubscribe() as Container?
            revalidate()
            repaint()
        }
        }
        return detele
    }

    private fun saveButton(flag:Boolean, ind:Int): Component{
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
//            listContact.clear()
//            rootPane.contentPane = resubscribe() as Container?
//            revalidate()
//            repaint()
            }
        }
        return save
    }

private fun createBoardPanel(): Component {
            val workPanel = JPanel(GridLayout(size, size, GAP, GAP))
            var j = 0
            for (i  in workModel.contacts) {
               if( j < size) {
                    val buttonsList = mutableListOf<JButton>()
                    val cellButton = JButton(i.getAllName())
                   buttonsList.add(cellButton)
                   workPanel.add(cellButton)
                   updateFont(cellButton, 30.0f)
                   buttons.add(buttonsList)
                    cellButton.addActionListener {
                        buttons.clear()
                        rootPane.contentPane = resubscribe() as Container?
                        rootPane.contentPane.add(changingPanel(true, i.getIndex()), BorderLayout.CENTER)
                        rootPane.contentPane.add(internalButtons(true, i.getIndex()), BorderLayout.SOUTH)
                        revalidate()
                        repaint()
                    }
                    j++
                }
            }
            return workPanel
        }

    private fun changingPanel(flag:Boolean, int: Int): Component {
        val contact =  if (flag)  workModel.contacts[int]
            else Contact()
        var temp = contact.getFirstName()
        listContact.add(JTextField(temp))
        temp = contact.getSecondName()
        listContact.add(JTextField(temp))
        temp = contact.getPhone()
        listContact.add(JTextField(temp))
        temp = contact.getDate()
        listContact.add(JTextField(temp))
        temp = contact.getAddress()
        listContact.add(JTextField(temp))
        temp = contact.getEmail()
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

