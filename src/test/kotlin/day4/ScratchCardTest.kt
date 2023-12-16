package day4

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ScratchCardTest {

    @Test
    fun parse() {
        val line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
        val card = ScratchCard(line)

        assertEquals(1, card.id)
        assertEquals(listOf(41, 48, 83, 86, 17), card.winningNumbers)
        assertEquals(listOf(83, 86, 6, 31, 17, 9, 48, 53), card.myNumbers)
    }

    @Test
    fun myWinningNumbers() {
        val line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
        val card = ScratchCard(line)

        assertEquals(listOf(83, 86, 17, 48), card.getMyWinningNumbers())
    }

    @Test
    fun points() {
        val line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
        val card = ScratchCard(line)

        assertEquals(8, card.getPoints())
    }
}