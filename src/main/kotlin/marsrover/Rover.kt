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

