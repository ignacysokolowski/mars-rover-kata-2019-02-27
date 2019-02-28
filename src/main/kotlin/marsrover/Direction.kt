package marsrover

enum class Direction (val stepsEast: Int, val stepsNorth: Int) {
    NORTH(0, +1),
    SOUTH(0, -1),
    EAST(+1, 0),
    WEST(-1, 0);

    fun nextToTheRight(): Direction {
        return when (this) {
            Direction.NORTH -> Direction.EAST
            Direction.EAST -> Direction.SOUTH
            Direction.SOUTH -> Direction.WEST
            else -> Direction.NORTH
        }
    }
}