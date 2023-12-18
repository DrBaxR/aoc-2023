package day5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RangeTest {

    @Test
    fun simple1() {
        val seedRange = SeedRange(5, 10)
        val gardenMapRange = GardenMapRange(0, 0, 10)

        val mapped = gardenMapRange.getMapped(seedRange)
        val expected = listOf(SeedRange(5, 10))
        assertEquals(expected, mapped)
    }

    @Test
    fun simple2() {
        val seedRange = SeedRange(5, 10)
        val gardenMapRange = GardenMapRange(5, 0, 10)

        val mapped = gardenMapRange.getMapped(seedRange)
        val expected = listOf(SeedRange(10, 15))
        assertEquals(expected, mapped)
    }

    @Test
    fun simple3() {
        val seedRange = SeedRange(5, 10)
        val gardenMapRange = GardenMapRange(5, 10, 10)

        val mapped = gardenMapRange.getMapped(seedRange)
        val expected = listOf(SeedRange(5, 10))
        assertEquals(expected, mapped)
    }

    @Test
    fun double1() {
        val seedRange = SeedRange(5, 10)
        val gardenMapRange = GardenMapRange(0, 7, 10)

        val mapped = gardenMapRange.getMapped(seedRange)
        val expected = listOf(SeedRange(0, 3), SeedRange(5, 7))
        assertEquals(expected, mapped)
    }

    @Test
    fun double2() {
        val seedRange = SeedRange(5, 8)
        val gardenMapRange = GardenMapRange(17, 7, 10)

        val mapped = gardenMapRange.getMapped(seedRange)
        val expected = listOf(SeedRange(5, 7), SeedRange(17, 18))
        assertEquals(expected, mapped)
    }

    @Test
    fun triple1() {
        val seedRange = SeedRange(5, 20)
        val gardenMapRange = GardenMapRange(17, 7, 10)

        val mapped = gardenMapRange.getMapped(seedRange)
        val expected = listOf(SeedRange(5, 7), SeedRange(17,  27))
        assertEquals(expected, mapped)
    }
}
