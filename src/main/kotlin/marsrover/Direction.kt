package marsrover

data class Direction(private val symbol: String) {
    companion object {
        fun north() = Direction("N")
        fun south() = Direction("S")
    }
}