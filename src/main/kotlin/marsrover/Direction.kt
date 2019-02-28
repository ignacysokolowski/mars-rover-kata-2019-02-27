package marsrover

enum class Direction (val stepsEast: Int, val stepsNorth: Int) {
    NORTH(0, +1),
    EAST(+1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    fun nextToTheRight() = values().elementAtOrElse(this.ordinal + 1) {values().first()}
}