package day2

val TOTAL_RED = 12
val TOTAL_GREEN = 13
val TOTAL_BLUE = 14

fun getPossibleGames(text: String): List<Game> {
    val games = text.split("\n").map { parse(it) }

    return games.filter { it.isValid(TOTAL_RED, TOTAL_GREEN, TOTAL_BLUE) }
}

fun getPowerSumOfMinimums(text: String): Int {
    val games = text.split("\n").map { parse(it) }
    val minimumSets = games.map { it.getMinimumSet() }

    return minimumSets.sumOf { it.getPower() }
}
