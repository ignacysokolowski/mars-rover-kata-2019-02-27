package marsrover

class Surface private constructor(private val northEastCoordinates: Coordinates) {

    private val southWestCoordinates = Coordinates(0, 0)

    companion object {
        fun ofSize(size: Int) = Surface(Coordinates(size, size))
    }

    fun contains(coordinates: Coordinates): Boolean {
        return !coordinates.fartherThan(this.northEastCoordinates) && !this.southWestCoordinates.fartherThan(coordinates)
    }

}
