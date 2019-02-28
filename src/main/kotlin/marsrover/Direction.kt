package marsrover

enum class Direction (val stepsEast: Int, val stepsNorth: Int) {
    NORTH(0, +1),
    EAST(+1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    fun nextToTheRight() = nextAtIndexOrElse(+1, values().first())
    fun nextToTheLeft() = nextAtIndexOrElse(-1, values().last())

    fun opposite(): Direction {
        return when (this) {
            NORTH -> SOUTH
            SOUTH -> NORTH
            EAST -> WEST
            WEST -> EAST
        }
    }

    private fun nextAtIndexOrElse(index: Int, default: Direction): Direction {
        return values().elementAtOrElse(this.ordinal + index) {default}
    }
}