package day2

data class Game(
    val id: Int,
    val sets: List<CubeSet>,
) {

    fun isValid(totalRed: Int, totalGreen: Int, totalBlue: Int): Boolean =
         sets.all { it.isValid(totalRed, totalGreen, totalBlue) }
}
