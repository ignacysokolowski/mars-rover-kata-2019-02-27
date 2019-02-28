package marsrover

class Surface(private val size: Int) {

    companion object {
        fun ofSize(size: Int) = Surface(size)
    }

    fun contains(coordinates: Coordinates) = coordinates.horizontal <= size && coordinates.vertical <= size

}
