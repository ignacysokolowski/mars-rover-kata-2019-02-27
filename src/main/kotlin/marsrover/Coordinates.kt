package marsrover

data class Coordinates(private val horizontal: Int, private val vertical: Int) {
    fun movedIn(direction: Direction) = copy(vertical = vertical + direction.stepsNorth)
}