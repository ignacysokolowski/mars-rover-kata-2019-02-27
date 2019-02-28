package marsrover

class Rover(direction: Direction, coordinates: Coordinates) {
    var direction = direction
        private set
    var coordinates = coordinates
        private set

    fun moveForward() {
        coordinates = coordinates.movedIn(direction)
    }

    fun moveBackward() {
        coordinates = coordinates.movedIn(Direction.SOUTH)
    }

    fun turnRight() {
        direction = direction.nextToTheRight()
    }

    fun turnLeft() {
        direction = direction.nextToTheLeft()
    }
}

