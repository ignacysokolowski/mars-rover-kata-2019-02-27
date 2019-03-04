package marsrover

data class Position(internal val direction: Direction, internal val coordinates: Coordinates) {
    fun turnedRight() = Position(direction.nextToTheRight(), coordinates)
}