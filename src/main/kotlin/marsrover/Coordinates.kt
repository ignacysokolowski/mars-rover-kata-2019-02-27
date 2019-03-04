package marsrover

import java.lang.IllegalArgumentException

data class Coordinates(private val horizontal: Int, private val vertical: Int) {

    init {
        if (horizontal < 0 || vertical < 0)
            throw IllegalArgumentException()
    }

    fun movedIn(direction: Direction) = Coordinates(
        zeroIfNegative(horizontal + direction.stepsEast),
        zeroIfNegative(vertical + direction.stepsNorth)
    )

    private fun zeroIfNegative(coordinate: Int) = if (coordinate < 0) 0 else coordinate

    fun fartherThan(other: Coordinates) = vertical > other.vertical || horizontal > other.horizontal
}