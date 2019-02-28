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
        coordinates = coordinates.movedIn(when (direction) {
            Direction.NORTH -> Direction.SOUTH
            Direction.SOUTH -> Direction.NORTH
            Direction.EAST -> Direction.WEST
            else -> Direction.EAST
        })
    }

    fun turnRight() {
        direction = direction.nextToTheRight()
    }

    fun turnLeft() {
        direction = direction.nextToTheLeft()
    }
}

