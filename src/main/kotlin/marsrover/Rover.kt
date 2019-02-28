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
        direction = direction.nextToTheRight()
    }

    fun turnLeft() {
        direction = direction.nextToTheLeft()
    }
}

