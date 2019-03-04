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
        moveTo(position.movedForward())
    }

    fun moveBackward() {
        moveTo(position.movedBackward())
    }

    private fun moveTo(position: Position) {
        if (surface.contains(position.coordinates))
            this.coordinates = position.coordinates
    }

    fun turnRight() {
        direction = position.turnedRight().direction
    }

    fun turnLeft() {
        direction = position.turnedLeft().direction
    }
}

