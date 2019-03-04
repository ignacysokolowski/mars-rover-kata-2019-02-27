package marsrover

class Surface(private val size: Int) {

    companion object {
        fun ofSize(size: Int) = Surface(size)
    }

    fun contains(coordinates: Coordinates) = !coordinates.fartherThan(this.coordinates())

    private fun coordinates() = Coordinates(size, size)

}
