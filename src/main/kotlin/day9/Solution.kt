package day9

fun part1(text: String): Long {
    val sequences = text.lines()
        .filter { it.isNotBlank() }
        .map { Sequence(it) }

    return sequences.sumOf { it.predictNextValue() }
}

fun part2(text: String): Long {
    val sequences = text.lines()
        .filter { it.isNotBlank() }
        .map { Sequence(it) }

    return sequences.sumOf { it.predictPreviousValue() }
}
