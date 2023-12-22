package day7

const val symbolsByStrengthDesc = "AKQT98765432J"

fun compareSymbols(a: Char, b: Char): Long =
    (symbolsByStrengthDesc.indexOf(b) - symbolsByStrengthDesc.indexOf(a)).toLong()

fun part1(text: String): Long {
    val lines = text.lines()
    val handBids = lines.filter { it.isNotBlank() }.map { HandBid(it) }.sortedBy { it.hand }

    return handBids.foldIndexed(0L) { index, acc, handBid ->
        acc + (index + 1) * handBid.bid
    }
}

fun part2(text: String): Long {
    return 0
}
