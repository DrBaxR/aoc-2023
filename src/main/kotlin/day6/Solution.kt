package day6

fun part1(text: String): Long {
    val races = parse(text)

    return races.map { it.getMarginOfError() }.reduce { acc, i -> acc * i }
}

fun part2(text: String): Long {
    val races = parse2(text)

    return races.map { it.getMarginOfError() }.reduce { acc, i -> acc * i }
}

fun parse(text: String): List<Race> {
    val lines = text.lines().map { line ->
        line.substringAfter(":").trim().split(" ")
            .filter { it != "" }
            .map { it.trim().toLong() }
    }

    val races = mutableListOf<Race>()
    for (i in 0 until lines[0].size) {
        races.add(Race(lines[0][i], lines[1][i]))
    }
    return races
}

fun parse2(text: String): List<Race> {
    val lines = text.lines().map { line ->
        line.substringAfter(":").trim().split(" ")
            .filter { it != "" }
            .map { it.trim().toLong() }
    }

    val firstNumber = lines[0].map { it.toString() }.fold("") { acc, i -> acc + i }.toLong()
    val secondNumber = lines[1].map { it.toString() }.fold("") { acc, i -> acc + i }.toLong()

    return listOf(Race(firstNumber, secondNumber))
}
