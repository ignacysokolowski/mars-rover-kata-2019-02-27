package marsrover

import java.lang.IllegalArgumentException

class Rover(direction: Direction, coordinates: Coordinates, surface: Surface) {
    var direction = direction
        private set
    var coordinates = coordinates
        private set

    init {
        if (!surfaceContains(coordinates, surface))
            throw IllegalArgumentException()
    }

    private fun surfaceContains(coordinates: Coordinates, surface: Surface) =
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

