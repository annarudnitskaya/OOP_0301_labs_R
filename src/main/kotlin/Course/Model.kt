//package lab1.Course
//
//enum class StateCells (private val textValue: String){
//    FREE("F"),
//    BUSY("B"),
//    EMPTY(" ");
//
//    override fun toString(): String = textValue
//}
//enum class TimeW (private val textValue: String){
//    FIRST("8:00-9:30"),
//    SECOND("9:50-11:20"),
//    THIRD("11:40-13:10"),
//    FOURTH("13:40-15:10"),
//    FIFTH("15:35-17:05"),
//    SIXTH("17:20-18:40");
//
//    override fun toString(): String = textValue
//}
//data class InfoC(
//    val group: String,
//    val teacher: String,
//)
//
////data class Class(
////    val number: String,
////    val state: StateCells,
////    val information: List<InfoC>,
////)
//
//data class Cell (
//    val day: String,
//    val time: TimeW,
//    val number: String,
//    val state: StateCells,
//    val information: List<InfoC>
////    val classes: List<Class>,
//)
//
//
//   const val BOARD_SIZE = 6
//enum class State(val textValue: String) {
//    DT_MOVE("Waiting for tour choice of day and time..."),
//    C_STATE("Waiting for tour choice of classroom..."),
//    CH_STATE("Changing the information..."),
//    T_STATE("Waiting for type of move..."),
//    S_STATE("Waiting for saving"),
//    BOOKED("The changes have been saved"),
//    CHANGING("You've changed the information"),
//}
//    private val FIRST_MOVE = State.DT_MOVE
//    val WORK_NOT_FINISHED = setOf(State.S_STATE, State.C_STATE, State.T_STATE, State.DT_MOVE, State.CH_STATE)
//
//    interface ModelChangeListener {
//        fun onModelChanged()
//    }
//
//    class Model {
//        private val _board: MutableList<MutableList<Cell>> = initEmptyBoard()
//        val board: List<List<Cell>>
//        get() = _board
//        var MOVE = State.DT_MOVE
//             private set
//        private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()
//
//        fun addModelChangeListener(listener: ModelChangeListener) {
//            listeners.add(listener)
//        }
//
//        fun removeModelChangeListener(listener: ModelChangeListener) {
//            listeners.remove(listener)
//        }
////        fun doMove(col: Int, row: Int) {
////            require(col in 0 until BOARD_SIZE) { "Wrong column" }
////            require(row in 0 until BOARD_SIZE) { "Wrong row" }
////            require(board[row][col] == EMPTY) { "Wrong move" }
////
////            // update board
////            _board[row][col] = if (state == State.CH_STATE) X else O
////
////            // check win
////            val player = if (state == State.X_MOVE) X else O
////
////            if (checkWin(player)) {
////                state = when (player) {
////                    X -> State.X_WIN
////                    O -> State.O_WIN
////                    else -> error("Player can not be empty")
////                }
////            } else {
////
////                if (checkCHANGING()) {
////                    state = State.CHANGING
////                } else {
////                    state = when (state) {
////                        State.X_MOVE -> State.O_MOVE
////                        State.O_MOVE -> State.X_MOVE
////                        else -> state
////                    }
////                }
////            }
////
////            notifyListeners()
////       }
//
//        private fun notifyListeners() {
//            listeners.forEach { it.onModelChanged() }
//        }
////
//       private fun checkChanging(rr : Cell): Boolean {
//            if (rr.state != StateCells.FREE) return true
//
//        }
//
//        private fun checkFree(player: Cell): Boolean {
//            if (MOVE == State.BOOKED) return false
//        }
//
//        private fun isSecondDiagWin(player: Cell) = (0 until BOARD_SIZE).all { index ->
//            board[index][BOARD_SIZE - 1 - index] == player
//        }
//
//        private fun isFirstDiagWin(player: Cell) = (0 until BOARD_SIZE).all { index ->
//            board[index][index] == player
//        }
//
//        private fun isColWin(player: Cell) = (0 until BOARD_SIZE).any { colIndex ->
//            (0 until BOARD_SIZE).all { rowIndex ->
//                board[rowIndex][colIndex] == player
//            }
//        }
//
//        private fun isRowWin(player: Cell): Boolean = board.any { row -> row.all { it == player } }
//
//        private fun initEmptyBoard() = MutableList(BOARD_SIZE){
//            MutableList(BOARD_SIZE) { StateCells.FREE }
//        }
//
//        override fun toString(): String {
//            return buildString {
//                append(MOVE).appendLine()
//
//                board.forEach {
//                    append(it).appendLine()
//                }
//            }
//        }
//
//}