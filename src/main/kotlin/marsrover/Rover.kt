package marsrover

import java.lang.IllegalArgumentException

class Rover(private val surface: Surface, private var direction: Direction, private var coordinates: Coordinates) {
    val position: Position
        get() = Position(direction, coordinates)

    companion object {
        fun landingOn(
            surface: Surface,
            direction: Direction,
            coordinates: Coordinates
        ): Rover {
            return Rover(surface, direction, coordinates)
        }
    }

    init {
        if (!surface.contains(coordinates))
            throw IllegalArgumentException()
    }

    fun moveForward() {
        moveTo(coordinates.movedIn(direction))
    }

    fun moveBackward() {
        moveTo(coordinates.movedIn(direction.opposite()))
    }

    private fun moveTo(coordinates: Coordinates) {
        if (surface.contains(coordinates))
            this.coordinates = coordinates
    }

    fun turnRight() {
        direction = direction.nextToTheRight()
    }

    fun turnLeft() {
        direction = direction.nextToTheLeft()
    }
}

