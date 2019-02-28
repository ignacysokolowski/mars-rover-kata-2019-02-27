package marsrover

enum class Direction (val stepsEast: Int, val stepsNorth: Int) {
    NORTH(0, +1),
    EAST(+1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    fun nextToTheRight() = nextAtIndexOrElse(this.ordinal + 1, values().first())
    fun nextToTheLeft() = values().elementAtOrElse(this.ordinal - 1) {values().last()}
    private fun nextAtIndexOrElse(index: Int, default: Direction) = values().elementAtOrElse(index) {default}
}