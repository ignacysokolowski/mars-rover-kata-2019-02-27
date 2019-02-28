package marsrover

class Rover(direction: Direction, var coordinates: Coordinates) {
    var direction = direction
        private set

    fun moveForward() {
        coordinates = coordinates.movedIn(direction)
    }

    fun turnRight() {
        direction = Direction.EAST
    }
}

