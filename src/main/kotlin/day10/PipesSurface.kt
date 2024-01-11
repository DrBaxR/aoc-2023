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

    fun getConnectedPipes(position: Position): List<Pipe> {
        val pipe = getPipe(position) ?: return emptyList()
        val neighboursPositions = pipe.getNeighboursPositions()

        return listOfNotNull(
            getPipe(neighboursPositions.first),
            getPipe(neighboursPositions.second),
        )
            .filter {
                try {
                    val neighborPositions = it.getNeighboursPositions()
                    neighborPositions.first == pipe.position || neighborPositions.second == pipe.position
                } catch (e: IllegalArgumentException) {
                    false
                }
            }
    }

    // NOTE: only path and max distance and path is computed reliably
    fun generateDistanceMap(): Array<Array<Long>> {
        val start = getStart() ?: return emptyArray()

        val distanceMap = Array(pipes.size) { Array(pipes[0]!!.size) { 0L } }
        distanceMap[start.position.y.toInt()][start.position.x.toInt()] = 0

        val queue = getStartConnectedPipes().toMutableList()

        while (queue.isNotEmpty()) {
            val pipe = queue.removeFirst()
            val distance = distanceMap[pipe.position.x.toInt()][pipe.position.y.toInt()]

            val neighbours = getConnectedPipes(pipe.position)
            neighbours.forEach { neighbour ->
                if (distanceMap[neighbour.position.x.toInt()][neighbour.position.y.toInt()] != 0L) {
                    return@forEach
                }

                distanceMap[neighbour.position.x.toInt()][neighbour.position.y.toInt()] = distance + 1
                queue.add(neighbour)
            }
        }

        return distanceMap
    }
}
