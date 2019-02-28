package marsrover

import java.lang.IllegalArgumentException

data class Coordinates(private val horizontal: Int, private val vertical: Int) {

    init {
        if (horizontal < 0)
            throw IllegalArgumentException()
    }
    fun movedIn(direction: Direction) = Coordinates(
        horizontal + direction.stepsEast,
        vertical + direction.stepsNorth
    )
}