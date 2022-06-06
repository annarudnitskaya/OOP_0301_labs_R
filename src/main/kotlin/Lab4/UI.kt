package lab1.Lab4

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import javax.swing.*
import java.awt.event.KeyAdapter

class LabyrinthUI : JFrame("Labyrinth"), ModelChangeListener {

    private var gameModel: Model = Model()
    private val statusLabel = JLabel("Status", JLabel.CENTER)
    private val buttons = mutableListOf<MutableList<JButton>>()

    private val closeAction: Action = object : AbstractAction() {
        override fun actionPerformed(e: ActionEvent?) {
            dispose()
        }
    }

    private fun createMenuBar() {

        val menubar = JMenuBar()

        val DropList = JMenu("Settings")
        DropList.mnemonic = KeyEvent.VK_F

        val Restart = JMenuItem("Restart")
        Restart.mnemonic = KeyEvent.VK_E
        Restart.toolTipText = "Exit application"
        Restart.addActionListener { _: ActionEvent -> resubscribe() }

        val Exit = JMenuItem("Exit")
        Exit.mnemonic = KeyEvent.VK_E
        Exit.toolTipText = "Exit application"
        Exit.addActionListener { _: ActionEvent -> System.exit(0) }

        DropList.add(Restart)
        DropList.add(Exit)
        menubar.add(DropList)

        jMenuBar = menubar
    }

    init {
        setSize(1024, 768)
        defaultCloseOperation = EXIT_ON_CLOSE

        updateFont(statusLabel, 20.0f)

        rootPane.contentPane = JPanel(BorderLayout()).apply {
            add(statusLabel, BorderLayout.NORTH)
            add(createBoardPanel(), BorderLayout.CENTER)
            border = BorderFactory.createEmptyBorder()
        }

        val esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0)
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(esc, "closex")
        getRootPane().actionMap.put("closex", closeAction)

        createMenuBar()
        setSize(width, height)
        setTitle(title)

        resubscribe()
    }


    private fun resubscribe() {
        gameModel.removeModelChangeListener(this)
        gameModel = Model()
        gameModel.addModelChangeListener(this)
        updateGameUI()
    }

    private fun createBoardPanel(): Component {
        val gamePanel = JPanel(GridLayout(gameModel.getBoardRow(), gameModel.getBoardCol()))
        for (i in 0 until gameModel.getBoardRow()) {
            val buttonsRow = mutableListOf<JButton>()
            for (j in 0 until gameModel.getBoardCol()) {
                val cellButton = JButton("")
                cellButton.addKeyListener(object : KeyAdapter() {
                    override fun keyTyped(e: KeyEvent) {
                        when (e.keyChar.toString().lowercase()) {
                            Direction.MOVE_UP.toString() -> gameModel.doMove(Direction.MOVE_UP)
                            Direction.MOVE_DOWN.toString() -> gameModel.doMove(Direction.MOVE_DOWN)
                            Direction.MOVE_LEFT.toString() -> gameModel.doMove(Direction.MOVE_LEFT)
                            Direction.MOVE_RIGHT.toString() -> gameModel.doMove(Direction.MOVE_RIGHT)
                        }
                    }
                })
                buttonsRow.add(cellButton)
                gamePanel.add(cellButton)
                updateFont(cellButton, 30.0f)
            }
            buttons.add(buttonsRow)
        }
        return gamePanel
    }

    private fun updateFont(component: JComponent, newFontSize: Float) {
        val font = component.font
        val derivedFont = font.deriveFont(newFontSize)
        component.font = derivedFont
    }

    override fun onModelChanged() {
        updateGameUI()
    }

    private fun updateGameUI() {
        val state = gameModel.state
        statusLabel.text = state.textValue

        for ((i, buttonRow) in buttons.withIndex()) {
            for ((j, button) in buttonRow.withIndex()) {
                val cell = gameModel.board[i][j]
                when (cell) {
                    Cell.ACTOR -> button.text = cell.toString()
                    Cell.FINISH -> button.text = cell.toString()
                    Cell.BLOCKER -> button.text = cell.toString()
                    else -> button.text = ""
                }

                UIManager.getDefaults()["Button.disabledText"] = Color.BLACK

                button.isEnabled = cell == Cell.ACTOR && state == State.WAITING

                when (cell) {
                    Cell.ACTOR -> {
                        button.requestFocus();
                        button.background = Color.YELLOW
                    }
                    Cell.BLOCKER -> button.background = Color.PINK
                    Cell.FINISH -> button.background = Color.RED
                    Cell.ROAD -> button.background = Color.GREEN
                }
            }
        }
    }
}