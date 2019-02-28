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
        val rover = Rover(Direction.NORTH, Coordinates(2, 3))
        rover.moveForward()
        assertEquals(Coordinates(2, 4), rover.coordinates)
    }

    @Test
    fun `moves forward south`() {
        val rover = Rover(Direction.SOUTH, Coordinates(2, 3))
        rover.moveForward()
        assertEquals(Coordinates(2, 2), rover.coordinates)
    }
}

