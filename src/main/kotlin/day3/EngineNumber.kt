package day3

data class EngineNumber(
    val lineNumber: Int,
    val startIndex: Int,
    val endIndex: Int,
    val number: Int
) {

    fun isAdjacentTo(i: Int, j: Int): Boolean {
        return j in startIndex - 1..endIndex + 1 && i in lineNumber - 1..lineNumber + 1
    }
}
