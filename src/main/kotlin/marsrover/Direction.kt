package marsrover

enum class Direction (val stepsEast: Int, val stepsNorth: Int) {
    NORTH(0, +1),
    EAST(+1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    fun nextToTheRight() = nextAtIndex(+1) ?: first()
    fun nextToTheLeft() = nextAtIndex(-1) ?: last()
    fun opposite() = nextAtIndex(+2) ?: nextAtIndex(-2)!!

    private fun nextAtIndex(index: Int) = values().elementAtOrNull(this.ordinal + index)
    private fun first() = values().first()
    private fun last() = values().last()
}

