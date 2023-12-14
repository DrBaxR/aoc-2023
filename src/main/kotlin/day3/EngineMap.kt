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

    fun getNumbersWithAdjacentSymbols(): List<Int> {
        val result = mutableListOf<Int>()

        map.forEachIndexed { lineIndex, line ->
            var current = 0
            var start = 0
            var end = 0

            for (c in line) {

                if (c is Int) {
                    if (current == 0) {
                        start = end
                    }
                    current = current * 10 + c
                } else {
                    if (current != 0) {
                        for (i in start until end) {
                            val adjacent = getAdjacent(lineIndex, i)
                            if (adjacent.any { it is String && it != "." }) {
                                result.add(current)
                                break
                            }
                        }
                    }

                    current = 0
                }

                end += 1
            }
        }

        return result
    }
}