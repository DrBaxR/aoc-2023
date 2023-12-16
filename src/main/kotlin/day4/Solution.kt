package day4

fun part1(text: String): Int =
    text.lines()
        .map { ScratchCard(it) }.sumOf { it.getPoints() }

fun part2(text: String): Int {
    return ScratchCardSet(text).getFinalCardsCount()
}