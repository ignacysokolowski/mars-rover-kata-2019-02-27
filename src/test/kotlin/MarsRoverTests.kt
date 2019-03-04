import junit.framework.Assert.*
import marsrover.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import java.lang.IllegalArgumentException

class MarsRoverTests {

    @get:Rule
    val thrown = ExpectedException.none()!!

    @Test
    fun `lands with the given position`() {
        val rover = Rover.landingOn(Surface.ofSize(5), Direction.NORTH, Coordinates(2, 3))
        assertEquals(Position(Direction.NORTH, Coordinates(2, 3)), rover.position)
    }

    @Test
    fun `horizontal coordinate can not be negative`() {
        thrown.expect(IllegalArgumentException::class.java)
        Rover.landingOn(Surface.ofSize(5), Direction.NORTH, Coordinates(-1, 3))
    }

    @Test
    fun `vertical coordinate can not be negative`() {
        thrown.expect(IllegalArgumentException::class.java)
        Rover.landingOn(Surface.ofSize(5), Direction.NORTH, Coordinates(2, -1))
    }

    @Test
    fun `can not land the rover outside of the surface to the east`() {
        thrown.expect(IllegalArgumentException::class.java)
        Rover.landingOn(Surface.ofSize(5), Direction.NORTH, Coordinates(6, 3))
    }

    @Test
    fun `can not land the rover outside of the surface to the north`() {
        thrown.expect(IllegalArgumentException::class.java)
        Rover.landingOn(Surface.ofSize(5), Direction.NORTH, Coordinates(2, 6))
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
    fun `can not move backward outside of the surface when facing south`() {
        assertMovesBackward(Direction.SOUTH, Coordinates(2, 5), Coordinates(2, 5))
    }

    @Test
    fun `can not move backward outside of the surface when facing west`() {
        assertMovesBackward(Direction.WEST, Coordinates(5, 2), Coordinates(5, 2))
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
        val rover = Rover.landingOn(Surface.ofSize(5), direction, from)
        rover.moveForward()
        assertEquals(Position(direction, to), rover.position)
    }

    private fun assertMovesBackward(direction: Direction, from: Coordinates, to: Coordinates) {
        val rover = Rover.landingOn(Surface.ofSize(5), direction, from)
        rover.moveBackward()
        assertEquals(Position(direction, to), rover.position)
    }

    private fun assertTurnsRight(from: Direction, to: Direction) {
        val rover = Rover.landingOn(Surface.ofSize(5), from, Coordinates(2, 3))
        rover.turnRight()
        assertEquals(Position(to, Coordinates(2, 3)), rover.position)
    }

    private fun assertTurnsLeft(from: Direction, to: Direction) {
        val rover = Rover.landingOn(Surface.ofSize(5), from, Coordinates(2, 3))
        rover.turnLeft()
        assertEquals(Position(to, Coordinates(2, 3)), rover.position)
    }
}

class CoordinatesTests {

    @Test
    fun `not farther than another`() {
        assertFalse(Coordinates(3, 5).fartherThan(Coordinates(4, 6)))
    }

    @Test
    fun `as far as the other`() {
        assertFalse(Coordinates(3, 3).fartherThan(Coordinates(3, 3)))
    }

    @Test
    fun `farther north than another`() {
        assertTrue(Coordinates(3, 3).fartherThan(Coordinates(3, 2)))
    }

    @Test
    fun `farther east than another`() {
        assertTrue(Coordinates(3, 3).fartherThan(Coordinates(2, 3)))
    }
}
