package marsrover

import java.lang.IllegalArgumentException

class Rover private constructor(
    private val surface: Surface,
    position: Position
) {
    var position = position
        private set

    companion object {
        fun landingOn(surface: Surface, position: Position): Rover {
            return Rover(surface, position)
        }
    }

    init {
        if (!surface.contains(position.coordinates))
            throw IllegalArgumentException()
    }

    fun moveForward() {
        moveTo(position.movedForward())
    }

    fun moveBackward() {
        moveTo(position.movedBackward())
    }

    private fun moveTo(position: Position) {
        if (surface.contains(position.coordinates))
            this.position = position
    }

    fun turnRight() {
        position = position.turnedRight()
    }

    fun turnLeft() {
        position = position.turnedLeft()
    }
}

