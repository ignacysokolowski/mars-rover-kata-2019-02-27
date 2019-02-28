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

    @Test
    fun `moves forward east`() {
        assertMovesForward(Direction.EAST, Coordinates(2, 3), Coordinates(3, 3))
    }

    @Test
    fun `moves forward west`() {
        assertMovesForward(Direction.WEST, Coordinates(2, 3), Coordinates(1, 3))
    }

    @Test
    fun `turns right from north to east`() {
        assertTurnsRight(Direction.NORTH, Direction.EAST)
    }

    @Test
    fun `turns right from east to south`() {
        assertTurnsRight(Direction.EAST, Direction.SOUTH)
    }

    @Test
    fun `turns right from south to west`() {
        assertTurnsRight(Direction.SOUTH, Direction.WEST)
    }

    @Test
    fun `turns right from west to north`() {
        assertTurnsRight(Direction.WEST, Direction.NORTH)
    }

    @Test
    fun `turns left from north to west`() {
        assertTurnsLeft(Direction.NORTH, Direction.WEST)
    }

    private fun assertMovesForward(direction: Direction, from: Coordinates, to: Coordinates) {
        val rover = Rover(direction, from)
        rover.moveForward()
        assertEquals(to, rover.coordinates)
    }

    private fun assertTurnsRight(from: Direction, to: Direction) {
        val rover = Rover(from, Coordinates(2, 3))
        rover.turnRight()
        assertEquals(to, rover.direction)
    }

    private fun assertTurnsLeft(from: Direction, to: Direction) {
        val rover = Rover(from, Coordinates(2, 3))
        rover.turnLeft()
        assertEquals(to, rover.direction)
    }
}

