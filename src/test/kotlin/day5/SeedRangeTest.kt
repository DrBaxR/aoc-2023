package day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SeedRangeTest {

    @Test
    fun intersection1() {
        val range1 = SeedRange(0, 10)
        val range2 = SeedRange(5, 15)
        val intersection = range1.intersection(range2)
        assertEquals(SeedRange(5, 10), intersection)
    }

    @Test
    fun intersection2() {
        val range1 = SeedRange(0, 10)
        val range2 = SeedRange(11, 15)
        val intersection = range2.intersection(range1)
        assertEquals(null, intersection)
    }

    @Test
    fun difference1() {
        val range1 = SeedRange(0, 10)
        val range2 = SeedRange(5, 15)
        val difference = range1.difference(range2)
        assertEquals(listOf(SeedRange(0, 5)), difference)
    }

    @Test
    fun difference2() {
        val range1 = SeedRange(0, 10)
        val range2 = SeedRange(2, 7)
        val difference = range1.difference(range2)
        assertEquals(listOf(SeedRange(0, 2), SeedRange(7, 10)), difference)
    }

    @Test
    fun difference3() {
        val range1 = SeedRange(0, 10)
        val range2 = SeedRange(0, 10)
        val difference = range1.difference(range2)
        assertEquals(listOf<SeedRange>(), difference)
    }

    @Test
    fun difference4() {
        val range1 = SeedRange(0, 10)
        val range2 = SeedRange(-10, 5)
        val difference = range1.difference(range2)
        assertEquals(listOf(SeedRange(5, 10)), difference)
    }

    @Test
    fun union1() {
        val range1 = SeedRange(0, 10)
        val range2 = SeedRange(5, 15)
        val union = range1.union(range2)
        assertEquals(SeedRange(0, 15), union)
    }

    @Test
    fun union2() {
        val range1 = SeedRange(0, 10)
        val range2 = SeedRange(12, 15)
        val union = range1.union(range2)
        assertEquals(SeedRange(0, 10), union)
    }

    @Test
    fun union3() {
        val range1 = SeedRange(0, 10)
        val range2 = SeedRange(10, 15)
        val union = range1.union(range2)
        assertEquals(SeedRange(0, 15), union)
    }

    @Test
    fun mergeAll() {
        val actual = SeedRange.mergeRanges(
            listOf(SeedRange(5, 7),
                SeedRange(17, 20),
                SeedRange(17, 27))
        )
        val expected = listOf(SeedRange(5, 7), SeedRange(17, 27))

        assertEquals(expected, actual)
    }

    @Test
    fun mergeAll2() {
        val actual = SeedRange.mergeRanges(
            listOf(SeedRange(5, 7),
                SeedRange(17, 20),
                SeedRange(17, 27),
                SeedRange(25, 40))
        )
        val expected = listOf(SeedRange(5, 7), SeedRange(17, 40))

        assertEquals(expected, actual)
    }

    @Test
    fun mergeAll3() {
        val actual = SeedRange.mergeRanges(
            listOf(SeedRange(4188359137, 3200563801),
                SeedRange(4188359137, 3200563801))
        )

        val expected = listOf(SeedRange(4188359137, 3200563801))
        assertEquals(expected, actual)
    }
}
