package lab1.Lab4


class Controller(private val model: Model) {
    init {
        startGame()
    }

    private fun startGame() {
        while (model.state == State.WAITING) {
            val input = readLine()
            try {
                when (input?.lowercase()) {
                    Direction.MOVE_UP.toString() -> model.doMove(Direction.MOVE_UP)
                    Direction.MOVE_DOWN.toString() -> model.doMove(Direction.MOVE_DOWN)
                    Direction.MOVE_LEFT.toString() -> model.doMove(Direction.MOVE_LEFT)
                    Direction.MOVE_RIGHT.toString() -> model.doMove(Direction.MOVE_RIGHT)
                    Direction.ENDGAME.toString() -> model.doMove(Direction.ENDGAME)
                }

            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}