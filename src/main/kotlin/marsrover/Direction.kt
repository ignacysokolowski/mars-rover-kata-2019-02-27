package marsrover

enum class Direction (val stepsEast: Int, val stepsNorth: Int) {
    NORTH(0, +1),
    EAST(+1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    fun nextToTheRight() = nextAtIndexOrElse(+1) {values().first()}
    fun nextToTheLeft() = nextAtIndexOrElse(-1) {values().last()}
    fun opposite(): Direction = nextAtIndexOrElse(+2) {nextAtIndex(-2)}

    private fun nextAtIndex(index: Int): Direction {
        return values().elementAt(this.ordinal + index)
    }

    private fun nextAtIndexOrElse(index: Int, default: (Int) -> Direction): Direction {
        return values().elementAtOrElse(this.ordinal + index, default)
    }
}