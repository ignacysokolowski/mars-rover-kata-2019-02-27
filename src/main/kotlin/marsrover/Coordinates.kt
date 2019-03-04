package marsrover

import java.lang.IllegalArgumentException

data class Coordinates(val horizontal: Int, val vertical: Int) {

    init {
        if (horizontal < 0 || vertical < 0)
            throw IllegalArgumentException()
    }

    fun movedIn(direction: Direction) = Coordinates(
        zeroIfNegative(horizontal + direction.stepsEast),
        zeroIfNegative(vertical + direction.stepsNorth)
    )

    private fun zeroIfNegative(coordinate: Int) = if (coordinate < 0) 0 else coordinate

    fun furtherThan(coordinates: Coordinates): Boolean {
        return false
    }
}