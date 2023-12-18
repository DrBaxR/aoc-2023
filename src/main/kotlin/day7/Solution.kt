package day7

const val symbolsByStrengthDesc = "AKQJT98765432"

fun compareSymbols(a: Char, b: Char): Long =
    (symbolsByStrengthDesc.indexOf(b) - symbolsByStrengthDesc.indexOf(a)).toLong()

fun part1(): Long {
    TODO()
}
