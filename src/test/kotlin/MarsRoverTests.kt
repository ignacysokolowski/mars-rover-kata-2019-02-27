import junit.framework.Assert.assertEquals
import marsrover.Coordinates
import marsrover.Direction
import marsrover.Rover
import marsrover.Surface
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import java.lang.IllegalArgumentException

class MarsRoverTests {

    @get:Rule
    val thrown = ExpectedException.none()!!

    @Test
    fun `lands with the given position`() {
        val rover = Rover(Direction.NORTH, Coordinates(2, 3), Surface.ofSize(5))
        assertEquals(Direction.NORTH, rover.direction)
        assertEquals(Coordinates(2, 3), rover.coordinates)
    }

    @Test
    fun `horizontal coordinate can not be negative`() {
        thrown.expect(IllegalArgumentException::class.java)
        Rover(Direction.NORTH, Coordinates(-1, 3), Surface.ofSize(5))
    }

    @Test
    fun `vertical coordinate can not be negative`() {
        thrown.expect(IllegalArgumentException::class.java)
        Rover(Direction.NORTH, Coordinates(2, -1), Surface.ofSize(5))
    }

    @Test
    fun `can not land the rover outside of the surface to the east`() {
        thrown.expect(IllegalArgumentException::class.java)
        Rover(Direction.NORTH, Coordinates(6, 3), Surface.ofSize(5))
    }

    @Test
    fun `can not land the rover outside of the surface to the north`() {
        thrown.expect(IllegalArgumentException::class.java)
        Rover(Direction.NORTH, Coordinates(2, 6), Surface.ofSize(5))
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
    fun `can not move forward north outside of the surface`() {
        assertMovesForward(Direction.NORTH, Coordinates(2, 5), Coordinates(2, 5))
    }

    @Test
    fun `can not move forward east outside of the surface`() {
        assertMovesForward(Direction.EAST, Coordinates(5, 2), Coordinates(5, 2))
    }

    @Test
    fun `can not move forward south from position zero`() {
        assertMovesForward(Direction.SOUTH, Coordinates(2, 0), Coordinates(2, 0))
    }

    @Test
    fun `can not move forward west from position zero`() {
        assertMovesForward(Direction.WEST, Coordinates(0, 2), Coordinates(0, 2))
    }

    @Test
    fun `moves backward when facing north`() {
        assertMovesBackward(Direction.NORTH, Coordinates(2, 3), Coordinates(2, 2))
    }

    @Test
    fun `moves backward when facing south`() {
        assertMovesBackward(Direction.SOUTH, Coordinates(2, 3), Coordinates(2, 4))
    }

    @Test
    fun `moves backward when facing east`() {
        assertMovesBackward(Direction.EAST, Coordinates(2, 3), Coordinates(1, 3))
    }

    @Test
    fun `moves backward when facing west`() {
        assertMovesBackward(Direction.WEST, Coordinates(2, 3), Coordinates(3, 3))
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

    @Test
    fun `turns left from west to south`() {
        assertTurnsLeft(Direction.WEST, Direction.SOUTH)
    }

    @Test
    fun `turns left from south to east`() {
        assertTurnsLeft(Direction.SOUTH, Direction.EAST)
    }

    @Test
    fun `turns left from east to north`() {
        assertTurnsLeft(Direction.EAST, Direction.NORTH)
    }

    private fun assertMovesForward(direction: Direction, from: Coordinates, to: Coordinates) {
        val rover = Rover(direction, from, Surface.ofSize(5))
        rover.moveForward()
        assertEquals(to, rover.coordinates)
    }

    private fun assertMovesBackward(direction: Direction, from: Coordinates, to: Coordinates) {
        val rover = Rover(direction, from, Surface.ofSize(5))
        rover.moveBackward()
        assertEquals(to, rover.coordinates)
    }

    private fun assertTurnsRight(from: Direction, to: Direction) {
        val rover = Rover(from, Coordinates(2, 3), Surface.ofSize(5))
        rover.turnRight()
        assertEquals(to, rover.direction)
    }

    private fun assertTurnsLeft(from: Direction, to: Direction) {
        val rover = Rover(from, Coordinates(2, 3), Surface.ofSize(5))
        rover.turnLeft()
        assertEquals(to, rover.direction)
    }
}

