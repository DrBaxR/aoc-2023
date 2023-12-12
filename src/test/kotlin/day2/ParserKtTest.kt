package day2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ParserKtTest {

    @Test
    fun parse1() {
        val line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
        val expected = Game(
            1,
            listOf(
                CubeSet(4, 0, 3),
                CubeSet(1, 2, 6),
                CubeSet(0, 2, 0)
            )
        )

        val actual = parse(line)
        assertEquals(expected, actual)
    }

    @Test
    fun parse2() {
        val line = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"
        val expected = Game(
            4,
            listOf(
                CubeSet(3, 1, 6),
                CubeSet(6, 3, 0),
                CubeSet(14, 3, 15)
            )
        )

        val actual = parse(line)
        assertEquals(expected, actual)
    }
}