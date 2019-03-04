package marsrover

class Surface private constructor(private val coordinates: Coordinates) {

    companion object {
        fun ofSize(size: Int) = Surface(Coordinates(size, size))
    }

    fun contains(coordinates: Coordinates) = !coordinates.fartherThan(this.coordinates)

}
