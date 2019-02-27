import junit.framework.Assert.assertEquals
import org.junit.Test

class MarsRoverTests {

    @Test
    fun `lands with the given position`() {
        val rover = Rover(Direction.north(), Coordinates(2, 3))
        assertEquals(Direction.north(), rover.direction)
        assertEquals(Coordinates(2, 3), rover.coordinates)
    }
}

class Rover(val direction: Direction, val coordinates: Coordinates)

data class Direction(private val symbol: String) {
    companion object {
        fun north() = Direction("N")
    }
}

data class Coordinates(private val horizontal: Int, private val vertical: Int)
