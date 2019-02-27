import junit.framework.Assert.assertEquals
import org.junit.Test

class MarsRoverTests {

    @Test
    fun `lands with the given position`() {
        val rover = Rover(Coordinates(2, 3))
        assertEquals(Coordinates(2, 3), rover.coordinates)
    }
}

class Rover(val coordinates: Coordinates)

data class Coordinates(private val horizontal: Int, private val vertical: Int)
