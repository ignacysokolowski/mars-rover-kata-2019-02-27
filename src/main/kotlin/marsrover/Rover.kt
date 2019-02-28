package marsrover

import java.lang.IllegalArgumentException

class Rover(direction: Direction, coordinates: Coordinates, private val surface: Surface) {
    var direction = direction
        private set
    var coordinates = coordinates
        private set

    init {
        if (!surface.contains(coordinates))
            throw IllegalArgumentException()
    }

    fun moveForward() {
        val newCoordinates = coordinates.movedIn(direction)
        if (surface.contains(newCoordinates))
            coordinates = newCoordinates
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

