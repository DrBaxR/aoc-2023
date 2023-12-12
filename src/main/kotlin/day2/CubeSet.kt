package day2

data class CubeSet(
    val red: Int,
    val green: Int,
    val blue: Int,
) {
    fun isValid(totalRed: Int, totalGreen: Int, totalBlue: Int): Boolean =
        red <= totalRed && green <= totalGreen && blue <= totalBlue

    fun getPower(): Int = red * green * blue
}