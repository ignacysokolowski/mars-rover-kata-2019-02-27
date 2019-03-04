package marsrover

data class Coordinates(private val horizontal: Int, private val vertical: Int) {

    fun movedIn(direction: Direction) = Coordinates(
        horizontal + direction.stepsEast,
        vertical + direction.stepsNorth
    )

    fun fartherThan(other: Coordinates) = vertical > other.vertical || horizontal > other.horizontal
}