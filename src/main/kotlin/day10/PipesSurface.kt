package day10

data class Pipe(
    val x: Long,
    val y: Long,
    val symbol: Char,
)

class PipesSurface(text: String) {

    // pipes[x][y]
    val pipes = arrayOf<Array<Pipe>>()

    init {
        TODO("Parse text into pipes")
    }
}
