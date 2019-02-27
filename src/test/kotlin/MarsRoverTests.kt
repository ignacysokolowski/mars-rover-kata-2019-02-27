import junit.framework.Assert.assertEquals
import org.junit.Test

class MarsRoverTests {

    @Test
    fun `lands with the given position`() {
        val rover = Rover(Direction.north(), Coordinates(2, 3))
        assertEquals(Direction.north(), rover.direction)
        assertEquals(Coordinates(2, 3), rover.coordinates)
    }

    @Test
    fun `moves forward north`() {
        val rover = Rover(Direction.north(), Coordinates(2, 3))
        rover.moveForward()
        assertEquals(Coordinates(2, 4), rover.coordinates)
    }

    @Test
    fun `moves forward south`() {
        val rover = Rover(Direction.south(), Coordinates(2, 3))
        rover.moveForward()
        assertEquals(Coordinates(2, 2), rover.coordinates)
    }
}

class Rover(val direction: Direction, var coordinates: Coordinates) {
    fun moveForward() {
        coordinates = coordinates.movedIn(direction)
    }
}

data class Direction(private val symbol: String) {
    companion object {
        fun north() = Direction("N")
        fun south() = Direction("S")
    }
}

data class Coordinates(private val horizontal: Int, private val vertical: Int) {
    fun movedIn(direction: Direction): Coordinates {
        return if (direction == Direction.north()) {
            movedVerticallyBy(+1)
        } else {
            movedVerticallyBy(-1)
        }
    }

    private fun movedVerticallyBy(points: Int) = Coordinates(horizontal, vertical + points)
}
