package day3

class EngineMap(text: String) {

    private val map: List<List<Any>>

    init {
        val lines = text.split("\n")

        map = lines.map { line ->
            val splitLine = line.trim().split("")
            splitLine.subList(1, splitLine.size - 1).map { char ->
                try {
                    char.toInt()
                } catch (e: NumberFormatException) {
                    char
                }
            }
        }
    }

    fun getPart(i: Int, j: Int): Any {
        return map[i][j]
    }

    fun getAdjacent(i: Int, j: Int): List<Any> {
        val result = mutableListOf<Any>()

        val iRange = -1..1
        val jRange = -1..1

        for (iOffset in iRange) {
            for (jOffset in jRange) {
                try {
                    if (iOffset == 0 && jOffset == 0) {
                        continue
                    }
                    result.add(map[i + iOffset][j + jOffset])
                } catch (e: IndexOutOfBoundsException) {
                    continue
                }
            }
        }

        return result
    }

    private fun getNumbers(): List<EngineNumber> {
        val result = map.mapIndexed { lineIndex, line ->
            getLineNumbers(line, lineIndex)
        }.flatten()

        return result
    }

    private fun getLineNumbers(line: List<Any>, lineIndex: Int): List<EngineNumber> {
        val result = mutableListOf<EngineNumber>()

        var current = 0
        var start = 0
        var end = 0

        for (c in line) {
            if (c is Int) {
                current = current * 10 + c

                try {
                    if (line[end - 1] is String) {
                        start = end
                    }
                } catch (e: IndexOutOfBoundsException) {
                    start = 0
                }

                try {
                    if (line[end + 1] is String) {
                        result.add(EngineNumber(lineIndex, start, end, current))
                        current = 0
                    }
                } catch (e: IndexOutOfBoundsException) {
                    result.add(EngineNumber(lineIndex, start, end, current))
                    current = 0
                }
            }

            end += 1
        }

        return result
    }

    private fun getAdjacent(number: EngineNumber): List<Any> {
        val result = mutableListOf<Any>()

        val iRange = number.startIndex - 1..number.endIndex + 1
        val jRange = number.lineNumber - 1..number.lineNumber + 1

        for (iOffset in iRange) {
            for (jOffset in jRange) {
                try {
                    if (jOffset == number.lineNumber && iOffset in number.startIndex..number.endIndex) {
                        continue
                    }
                    result.add(map[jOffset][iOffset])
                } catch (e: IndexOutOfBoundsException) {
                    continue
                }
            }
        }

        return result
    }



    fun getNumbersWithAdjacentSymbols(): List<Int> {
        val numbers = getNumbers()

        return numbers.filter { number ->
            val adjacent = getAdjacent(number)

            adjacent.any { isSymbol(it) }
        }.map { it.number }
    }

    private fun isSymbol(c: Any): Boolean = c is String && c != "."

    fun getGearRatios(): List<Int> {
        val gears = getGearsPositions()

        val gearAdjacentNumbers = gears.map { (i, j) ->
            val possibleAdjacent = getLineNumbers(map[i], i).toMutableList()

            try {
                possibleAdjacent.addAll(getLineNumbers(map[i - 1], i - 1))
            } catch (_: IndexOutOfBoundsException) {}

            try {
                possibleAdjacent.addAll(getLineNumbers(map[i + 1], i + 1))
            } catch (_: IndexOutOfBoundsException) {}

            possibleAdjacent.filter { number ->
                number.isAdjacentTo(i, j)
            }.map { it.number }
        }

        return gearAdjacentNumbers.filter { it.size == 2 }.map { (a, b) ->
            a * b
        }
    }

    private fun getAdjacentDigitPositions(i: Int, j: Int): List<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()

        val iRange = -1..1
        val jRange = -1..1

        for (iOffset in iRange) {
            for (jOffset in jRange) {
                try {
                    if (iOffset == 0 && jOffset == 0) {
                        continue
                    }

                    if (map[iOffset][jOffset] is Int) {
                        result.add(Pair(i + iOffset, j + jOffset))
                    }
                } catch (e: IndexOutOfBoundsException) {
                    continue
                }
            }
        }

        return result
    }

    private fun getGearsPositions(): List<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()

        for (i in map.indices) {
            for (j in map[i].indices) {
                if (map[i][j] == "*") {
                    result.add(Pair(i, j))
                }
            }
        }

        return result
    }
}
