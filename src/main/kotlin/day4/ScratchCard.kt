package day4

import kotlin.math.pow

class ScratchCard(line: String) {

    val id: Int
    val winningNumbers: List<Int>
    val myNumbers: List<Int>

    init {
        id = line.substringBefore(":").substringAfter(" ").trim().toInt()

        val numbersPart = line.substringAfter(":").trim()
        val winningNumbersPart = numbersPart.substringBefore("|").trim()
        val myNumbersPart = numbersPart.substringAfter("|").trim()

        winningNumbers = parseNumbers(winningNumbersPart)
        myNumbers = parseNumbers(myNumbersPart)
    }

    private fun parseNumbers(numbersPart: String): List<Int> {
        return numbersPart.split(" ").mapNotNull {
            try {
                it.toInt()
            } catch (e: NumberFormatException) {
                null
            }
        }
    }

    fun getMyWinningNumbers(): List<Int> =
        myNumbers.filter { it in winningNumbers }

    fun getPoints(): Int =
        2.0.pow(getMyWinningNumbers().size.toDouble() - 1.0).toInt()
}