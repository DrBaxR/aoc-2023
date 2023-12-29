package day10

data class Position(
    val x: Long,
    val y: Long,
)

data class Pipe(
    val position: Position,
    val symbol: Char,
) {

    fun getNeighboursPositions(): Pair<Position, Position> =
        when (symbol) {
            '|' -> Pair(
                Position(position.x, position.y - 1),
                Position(position.x, position.y + 1),
            )

            '-' -> Pair(
                Position(position.x - 1, position.y),
                Position(position.x + 1, position.y),
            )

            'L' -> Pair(
                Position(position.x + 1, position.y),
                Position(position.x, position.y - 1),
            )

            'J' -> Pair(
                Position(position.x - 1, position.y),
                Position(position.x, position.y - 1),
            )

            '7' -> Pair(
                Position(position.x - 1, position.y),
                Position(position.x, position.y + 1),
            )

            'F' -> Pair(
                Position(position.x + 1, position.y),
                Position(position.x, position.y + 1),
            )

            else -> throw IllegalArgumentException("Not a pipe character: '$symbol'")
        }

    fun isStart(): Boolean =
        symbol == 'S'
}

class PipesSurface(text: String) {

    // pipes[x][y]
    private var pipes = arrayOf<Array<Pipe?>?>()

    init {
        pipes = text.lines().map { line ->
            arrayOfNulls<Pipe>(line.length)
        }.toTypedArray()

        text.lines().forEachIndexed { y, line ->
            pipes[y] = arrayOfNulls(line.length)

            line.forEachIndexed { x, symbol ->
                pipes[y]!![x] = Pipe(
                    Position(x.toLong(), y.toLong()),
                    symbol
                )
            }
        }
    }

    private fun getPipe(position: Position): Pipe? =
        pipes.getOrNull(position.y.toInt())?.getOrNull(position.x.toInt())

    private fun getStart(): Pipe? {
        pipes.forEach { row ->
            row?.forEach { pipe ->
                if (pipe?.isStart() == true) {
                    return pipe
                }
            }
        }

        return null
    }

    fun getStartConnectedPipes(): List<Pipe> {
        val start = getStart() ?: return emptyList()

        return listOfNotNull(
            getPipe(Position(start.position.x, start.position.y - 1)),
            getPipe(Position(start.position.x, start.position.y + 1)),
            getPipe(Position(start.position.x - 1, start.position.y)),
            getPipe(Position(start.position.x + 1, start.position.y)),
        )
            .filter {
                try {
                    val neighborPositions = it.getNeighboursPositions()
                    neighborPositions.first == start.position || neighborPositions.second == start.position
                } catch (e: IllegalArgumentException) {
                    false
                }
            }
    }

    fun generateDistanceMap(): Array<Array<Long>> {
        TODO("The map that is a matrix of distances from the start pipe")
    }
}
