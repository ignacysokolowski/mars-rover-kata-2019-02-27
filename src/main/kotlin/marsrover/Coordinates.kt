package marsrover

data class Coordinates(private val horizontal: Int, private val vertical: Int) {
    fun movedIn(direction: Direction): Coordinates {
        return movedVerticallyBy(direction.stepsNorth)
    }

    private fun movedVerticallyBy(points: Int) = copy(vertical = vertical + points)
}