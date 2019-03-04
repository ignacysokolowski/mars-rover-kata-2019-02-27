package marsrover

data class Position(private val direction: Direction, internal val coordinates: Coordinates) {
    fun movedForward() = withCoordinatesMovedIn(direction)
    fun movedBackward() = withCoordinatesMovedIn(direction.opposite())
    fun turnedRight() = facingDirection { nextToTheRight() }
    fun turnedLeft() = facingDirection { nextToTheLeft() }

    private fun withCoordinatesMovedIn(direction: Direction) = copy(coordinates = coordinates.movedIn(direction))
    private fun facingDirection(rotated: Direction.() -> Direction) = copy(direction = direction.rotated())
}