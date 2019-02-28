import junit.framework.Assert.assertEquals
import marsrover.Coordinates
import marsrover.Direction
import marsrover.Rover
import org.junit.Test

class MarsRoverTests {

    @Test
    fun `lands with the given position`() {
        val rover = Rover(Direction.NORTH, Coordinates(2, 3))
        assertEquals(Direction.NORTH, rover.direction)
        assertEquals(Coordinates(2, 3), rover.coordinates)
    }

    @Test
    fun `moves forward north`() {
        assertMovesForward(Direction.NORTH, Coordinates(2, 3), Coordinates(2, 4))
    }

    @Test
    fun `moves forward south`() {
        assertMovesForward(Direction.SOUTH, Coordinates(2, 3), Coordinates(2, 2))
    }

    private fun assertMovesForward(direction: Direction, from: Coordinates, to: Coordinates) {
        val rover = Rover(direction, from)
        rover.moveForward()
        assertEquals(to, rover.coordinates)
    }
}

