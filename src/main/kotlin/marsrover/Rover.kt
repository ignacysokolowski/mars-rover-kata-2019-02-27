package marsrover

import java.lang.IllegalArgumentException

class Rover(direction: Direction, coordinates: Coordinates, private val surface: Surface) {
    var direction = direction
        private set
    var coordinates = coordinates
        private set

    init {
        if (!surfaceContains(coordinates))
            throw IllegalArgumentException()
    }

    private fun surfaceContains(coordinates: Coordinates) =
        coordinates.horizontal <= surface.size && coordinates.vertical <= surface.size

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

