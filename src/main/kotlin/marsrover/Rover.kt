package marsrover

class Rover(val direction: Direction, var coordinates: Coordinates) {
    fun moveForward() {
        coordinates = coordinates.movedIn(direction)
    }
}

