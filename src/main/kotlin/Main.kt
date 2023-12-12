import day2.getPossibleGames

fun main() {
    val input = object {}::class.java.getResource("day2.txt")!!.readText()

    val possibleGames = getPossibleGames(input)
    val idSum = possibleGames.sumOf { it.id }

    println(idSum)
}