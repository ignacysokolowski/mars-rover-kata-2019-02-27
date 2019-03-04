package marsrover

data class Position(private val direction: Direction, internal val coordinates: Coordinates) {
    fun movedForward() = copy(coordinates = coordinates.movedIn(direction))
    fun movedBackward() = copy(coordinates = coordinates.movedIn(direction.opposite()))
    fun turnedRight() = copy(direction = direction.nextToTheRight())
    fun turnedLeft() = copy(direction = direction.nextToTheLeft())
}