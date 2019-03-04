package marsrover

import java.lang.IllegalArgumentException

class Rover private constructor(
    private val surface: Surface,
    private var direction: Direction,
    private var coordinates: Coordinates
) {
    val position: Position
        get() = Position(direction, coordinates)

    companion object {
        fun landingOn(surface: Surface, position: Position): Rover {
            return Rover(surface, position.direction, position.coordinates)
        }
    }

    init {
        if (!surface.contains(coordinates))
            throw IllegalArgumentException()
    }

    fun moveForward() {
        moveTo(position.movedForward().coordinates)
    }

    fun moveBackward() {
        moveTo(position.movedBackward().coordinates)
    }

    private fun moveTo(coordinates: Coordinates) {
        if (surface.contains(coordinates))
            this.coordinates = coordinates
    }

    fun turnRight() {
        direction = position.turnedRight().direction
    }

    fun turnLeft() {
        direction = position.turnedLeft().direction
    }
}

