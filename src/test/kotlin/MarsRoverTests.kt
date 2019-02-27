import junit.framework.Assert.assertEquals
import org.junit.Test

class MarsRoverTests {

    @Test
    fun `lands with the given position`() {
        val rover = Rover("N", Coordinates(2, 3))
        assertEquals("N", rover.direction)
        assertEquals(Coordinates(2, 3), rover.coordinates)
    }
}

class Rover(val direction: String, val coordinates: Coordinates)

data class Coordinates(private val horizontal: Int, private val vertical: Int)
