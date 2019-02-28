package marsrover

import java.lang.IllegalArgumentException

class Rover(direction: Direction, coordinates: Coordinates, surface: Surface) {
    var direction = direction
        private set
    var coordinates = coordinates
        private set

    init {
        if (coordinates.horizontal > surface.size)
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

