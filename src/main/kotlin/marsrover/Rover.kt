package marsrover

import java.lang.IllegalArgumentException

class Rover(direction: Direction, coordinates: Coordinates, surface: Surface? = null) {
    var direction = direction
        private set
    var coordinates = coordinates
        private set

    init {
        if (surface != null && coordinates.horizontal > surface.size)
            throw IllegalArgumentException()
    }

    fun moveForward() {
        coordinates = coordinates.movedIn(direction)
    }

    fun moveBackward() {
        coordinates = coordinates.movedIn(direction.opposite())
    }

    fun turnRight() {
        direction = direction.nextToTheRight()
    }

    fun turnLeft() {
        direction = direction.nextToTheLeft()
    }
}

