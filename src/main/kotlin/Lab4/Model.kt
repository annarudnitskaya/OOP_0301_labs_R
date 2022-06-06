package lab1.Lab4

import java.io.File

enum class Cell(private val textValue: String) {
    ACTOR("\uD83D\uDD74"),
    BLOCKER("#"),
    FINISH("F"),
    ROAD("-");

    override fun toString(): String = textValue
}

enum class Direction(private val textValue: String) {
    MOVE_UP("w"),
    MOVE_LEFT("a"),
    MOVE_DOWN("s"),
    MOVE_RIGHT("d"),
    ENDGAME("FINISH");

    override fun toString(): String = textValue
}

enum class State(val textValue: String) {
    WAITING("You are still in labyrinth"),
    FINISH("The labyrinth has been passed")
}

interface ModelChangeListener {
    fun onModelChanged()
}

class Model {
    private var player = Pair(0, 0)
    private var BoardRow = 0
    private var BoardCol = 0
    val board: MutableList<MutableList<Cell>> = initStartBoard()

    var state: State = State.WAITING
        private set

    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()

    fun addModelChangeListener(listener: ModelChangeListener) {
        listeners.add(listener)
    }

    fun removeModelChangeListener(listener: ModelChangeListener) {
        listeners.remove(listener)
    }

    private fun notifyListeners() {
        listeners.forEach { it.onModelChanged() }
    }

    fun doMove(direction: Direction) {
        if (direction == Direction.MOVE_UP) {
            if (player.first != 0) {
                if (board[player.first - 1][player.second] == Cell.ROAD) {

                    board[player.first][player.second] = Cell.ROAD
                    board[player.first - 1][player.second] = Cell.ACTOR
                    player = Pair(player.first - 1, player.second)
                }
                else if (board[player.first - 1][player.second] == Cell.FINISH ) {
                    board[player.first][player.second] = Cell.ROAD
                    board[player.first - 1][player.second] = Cell.ACTOR
                    state = State.FINISH
                }
            }
        }
        else if (direction == Direction.MOVE_DOWN) {
            if (player.first != BoardRow - 1) {
                if (board[player.first + 1][player.second] == Cell.ROAD) {
                    board[player.first][player.second] = Cell.ROAD
                    board[player.first + 1][player.second] = Cell.ACTOR
                    player = Pair(player.first + 1, player.second)
                }
                else if (board[player.first + 1][player.second] == Cell.FINISH){
                    board[player.first][player.second] = Cell.ROAD
                    board[player.first + 1][player.second] = Cell.ACTOR
                    state = State.FINISH
                }
            }
        }
        else if (direction == Direction.MOVE_RIGHT) {
            if (player.second != BoardCol - 1) {
                if (board[player.first][player.second + 1] == Cell.ROAD) {
                    board[player.first][player.second] = Cell.ROAD
                    board[player.first][player.second + 1] = Cell.ACTOR
                    player = Pair(player.first, player.second + 1)
                }
                else if (board[player.first][player.second + 1] == Cell.FINISH){
                    board[player.first][player.second] = Cell.ROAD
                    board[player.first][player.second + 1] = Cell.ACTOR
                    state = State.FINISH
                }
            }
        }
        else if (direction == Direction.MOVE_LEFT) {
            if (player.second != 0) {
                if (board[player.first][player.second - 1] == Cell.ROAD) {
                    board[player.first][player.second] = Cell.ROAD
                    board[player.first][player.second - 1] = Cell.ACTOR
                    player = Pair(player.first, player.second - 1)
                }
                else if (board[player.first][player.second - 1] == Cell.FINISH){
                    board[player.first][player.second] = Cell.ROAD
                    board[player.first][player.second - 1] = Cell.ACTOR
                    state = State.FINISH
                }
            }
        }
        else if (direction == Direction.ENDGAME) {state = State.FINISH}
        notifyListeners()
    }

    fun getBoardRow(): Int {
        return BoardRow
    }

    fun getBoardCol(): Int {
        return BoardCol
    }

    private fun initStartBoard(): MutableList<MutableList<Cell>> {
        val Board = File("test.txt").readLines()
        BoardRow = Board.size
        BoardCol = Board[0].length
        val StartBoard = MutableList(BoardRow) {
            MutableList(BoardCol) { Cell.BLOCKER }
        }
        for (i in 0 until BoardRow) {
            for (j in 0 until BoardCol) {
                when (Board[i][j]) {
                    'P' -> {
                        StartBoard[i][j] = Cell.ACTOR
                        player = Pair(i, j)
                    }
                    '-' -> StartBoard[i][j] = Cell.ROAD
                    'E' -> StartBoard[i][j] = Cell.FINISH
                    '#' -> StartBoard[i][j] = Cell.BLOCKER
                }
            }
        }
        return StartBoard
    }

    override fun toString(): String {
        return buildString {
            append(state).appendLine()

            board.forEach {
                append(it).appendLine()
            }
        }
    }

}