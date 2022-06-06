//package lab1.Course
//
//import lab1.Course.StateCells.*
//import java.awt.BorderLayout
//import java.awt.Color
//import java.awt.Component
//import java.awt.GridLayout
//import javax.swing.*
//
//
//private const val GAP = 10
//class TableUi : JFrame("Table") {
//        private var workModel: Model = Model()
//        private val statusLabel = JLabel("Status", JLabel.CENTER)
//        private val buttons = mutableListOf<MutableList<JButton>>()
//    init {
//        setSize(1500, 800)
//        defaultCloseOperation = EXIT_ON_CLOSE
//        val statusLabel = JLabel("РАСПИСАНИЕ")
//        updateFont(statusLabel, 20.0f)
//
//        rootPane.contentPane = JPanel(BorderLayout(100, 50)).apply {
//                  add(statusLabel, BorderLayout.NORTH)
//                  add(createBoardPanel(), BorderLayout.CENTER)
//                  add(createSaveButton(), BorderLayout.SOUTH)
//            border = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP)
//        }
//        resubscribe()
//    }
//
//private fun createBoardPanel(): Component {
//            val workPanel = JPanel(GridLayout(BOARD_SIZE, BOARD_SIZE, GAP, GAP))
//            for (i in 0 until BOARD_SIZE) {
//                val buttonsRow = mutableListOf<JButton>()
//                for (j in 0 until BOARD_SIZE) {
//                    val cellButton = JButton("")
//                    cellButton.addActionListener {
//                        //workModel.doMove(j, i)
//                    }
//                    buttonsRow.add(cellButton)
//                    workPanel.add(cellButton)
//                    updateFont(cellButton, 30.0f)
//                }
//                buttons.add(buttonsRow)
//            }
//
//            return workPanel
//        }
//
//
//private fun createSaveButton(): Component {
//            val restartButton = JButton("Save")
//            updateFont(restartButton, 20.0f)
//            restartButton.addActionListener {
//                if (workModel.MOVE in WORK_NOT_FINISHED) {
//                    val dialogOption = JOptionPane.showConfirmDialog(
//                        this,
//                        "No changes have been saved, are you sure?",
//                        "Save",
//                        JOptionPane.OK_CANCEL_OPTION
//                    )
//
//                    if (dialogOption == JOptionPane.OK_OPTION) {
//                        resubscribe()
//                    }
//                } else {
//                    resubscribe()
//                }
//            }
//
//            return restartButton
//        }
//
//        private fun resubscribe() {
//            workModel.removeModelChangeListener(this)
//            workModel = Model()
//            workModel.addModelChangeListener(this)
//            updateWorkUI()
//
//        }
//
//
//        private fun updateFont(component: JComponent, newFontSize: Float) {
//            val font = component.font
//            val derivedFont = font.deriveFont(newFontSize)
//            component.font = derivedFont
//        }
//
//        fun onModelChanged() {
//            updateWorkUI()
//        }
//
//        private fun updateWorkUI() {
//            val state = workModel.MOVE
//            statusLabel.text = state.textValue
//
//            for ((i, buttonRow) in buttons.withIndex()) {
//                for ((j, button) in buttonRow.withIndex()) {
//                    val cell = workModel.board[i][j]
//                    button.text = cell.toString()
//
//                    button.isEnabled = cell.state == EMPTY && state in WORK_NOT_FINISHED
//                    button.foreground = when (cell.state) {
//                        FREE -> Color.GREEN
//                        BUSY -> Color.RED
//                        EMPTY -> Color.GREEN
//                    }
//                }
//            }
//        }
//}
