package marsrover

class Rover(var direction: Direction, var coordinates: Coordinates) {
    fun moveForward() {
        coordinates = coordinates.movedIn(direction)
    }

    fun turnRight() {
        direction = Direction.EAST
    }
}

