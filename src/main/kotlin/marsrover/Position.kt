package marsrover

data class Position(internal val direction: Direction, internal val coordinates: Coordinates) {
    fun movedForward() = Position(direction, coordinates.movedIn(direction))
    fun movedBackward() = Position(direction, coordinates.movedIn(direction.opposite()))
    fun turnedRight() = Position(direction.nextToTheRight(), coordinates)
    fun turnedLeft() = Position(direction.nextToTheLeft(), coordinates)
}