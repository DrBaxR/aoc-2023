package day3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class EngineMapTest {

    val inputText = """
        467..114..
        ...*......
        ..35..633.
        ......#...
        617*......
        .....+.58.
        ..592.....
        ......755.
        ...${'$'}.*....
        .664.598..
    """.trimIndent()

    @Test
    fun parse() {
        val engine = EngineMap(inputText)

        assertEquals(4, engine.getPart(0, 0))
        assertEquals(".", engine.getPart(0, 3))
        assertEquals("*", engine.getPart(1, 3))
    }

    @Test
    fun adjacent() {
        val engine = EngineMap(inputText)

        assertEquals(listOf(6, ".", "."), engine.getAdjacent(0, 0))
        assertEquals(listOf(4, 7, ".", ".", "."), engine.getAdjacent(0, 1))
        assertEquals(listOf(6, 7, ".", ".", "*", ".", 3, 5), engine.getAdjacent(1, 2))
    }

    @Test
    fun symbolAdjacent() {
        val engine = EngineMap(inputText)

        val numbers = engine.getNumbersWithAdjacentSymbols()
        assertEquals(listOf(467, 35, 633, 617, 592, 755, 664, 598), numbers)
    }
}