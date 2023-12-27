package day9

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SequenceTest {

    @Test
    fun predictNextValue() {
        val sequence = Sequence("0 3 6 9 12 15")

        assertEquals(18, sequence.predictNextValue())
    }
    @Test
    fun predictNextValue1() {
        val sequence = Sequence("1 3 6 10 15 21")

        assertEquals(28, sequence.predictNextValue())
    }

    @Test
    fun predictNextValue2() {
        val sequence = Sequence("10 13 16 21 30 45")

        assertEquals(68, sequence.predictNextValue())
    }
}
