package marsrover

enum class Direction (val stepsEast: Int, val stepsNorth: Int) {
    NORTH(0, 1),
    SOUTH(0, -1),
    EAST(1, 0),
    WEST(-1, 0),
}