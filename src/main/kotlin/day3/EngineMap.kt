package day3

class EngineMap(text: String) {

    private val map: List<List<Any>>

    init {
        val lines = text.split("\n")

        map = lines.map { line ->
            val splitLine = line.trim().split("")
            groupDigits(splitLine.subList(1, splitLine.size - 1)).map { char ->
                try {
                    char.toInt()
                } catch (e: NumberFormatException) {
                    char
                }
            }
        }
    }

    private fun groupDigits(list: List<String>): List<String> {
        val result = mutableListOf<String>()

        var current = ""
        for (char in list) {
            if (char.toIntOrNull() != null) {
                current += char
            } else {
                if (current.isNotEmpty()) {
                    result.add(current)
                    current = ""
                }
                result.add(char)
            }
        }

        return result
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

    fun getNumberIndices(): List<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()

        for (i in map.indices) {
            for (j in map[i].indices) {
                if (map[i][j] is Int) {
                    result.add(Pair(i, j))
                }
            }
        }

        return result
    }

    fun getNumbersWithAdjacentSymbols(): List<Int> {
        val numberIndices = getNumberIndices()

        return numberIndices.filter { numberIndex ->
            val adjacent = getAdjacent(numberIndex.first, numberIndex.second)
            adjacent.any { it is String && it != "." }
        }.map { numberIndex ->
            getPart(numberIndex.first, numberIndex.second) as Int
        }
    }
}