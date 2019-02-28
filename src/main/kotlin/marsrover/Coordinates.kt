package marsrover

data class Coordinates(private val horizontal: Int, private val vertical: Int) {
    fun movedIn(direction: Direction): Coordinates {
        return if (direction == Direction.north()) {
            movedVerticallyBy(+1)
        } else {
            movedVerticallyBy(-1)
        }
    }

    private fun movedVerticallyBy(points: Int) = Coordinates(horizontal, vertical + points)
}