package day2

data class Game(
    val id: Int,
    val sets: List<CubeSet>,
) {

    fun isValid(totalRed: Int, totalGreen: Int, totalBlue: Int): Boolean =
         sets.all { it.isValid(totalRed, totalGreen, totalBlue) }

    fun getMinimumSet(): CubeSet {
        var maxRed = 0
        var maxGreen = 0
        var maxBlue = 0

        sets.forEach {
            if (it.red > maxRed) {
                maxRed = it.red
            }
            if (it.green > maxGreen) {
                maxGreen = it.green
            }
            if (it.blue > maxBlue) {
                maxBlue = it.blue
            }
        }

        return CubeSet(maxRed, maxGreen, maxBlue)
    }
}
