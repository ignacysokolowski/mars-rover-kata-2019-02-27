package marsrover

import java.lang.IllegalArgumentException

class Rover(private val surface: Surface, direction: Direction, coordinates: Coordinates) {
    var direction = direction
        private set
    var coordinates = coordinates
        private set
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

