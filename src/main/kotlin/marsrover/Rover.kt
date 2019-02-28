package marsrover

class Rover(direction: Direction, coordinates: Coordinates) {
    var direction = direction
        private set
    var coordinates = coordinates
        private set

    fun moveForward() {
        coordinates = coordinates.movedIn(direction)
    }

    fun turnRight() {
        direction = if (direction == Direction.NORTH) {
            Direction.EAST
        } else {
            Direction.SOUTH
        }
    }
}

