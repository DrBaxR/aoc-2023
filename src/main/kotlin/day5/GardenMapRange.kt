package day5

import java.lang.Exception

data class SeedRange(
    val start: Long,
    val end: Long
) {

    companion object {

        // ranges should be sorted by start
        fun mergeRanges(ranges: List<SeedRange>): List<SeedRange> {
            val output = mutableListOf<SeedRange>()

            var currentRange = ranges[0]
            for (i in 1 until ranges.size) {
                val nextRange = ranges[i]

                if (currentRange.end >= nextRange.start) {
                    currentRange = SeedRange(currentRange.start, nextRange.end)
                } else {
                    output.add(currentRange)
                    currentRange = nextRange
                }
            }

            output.add(currentRange)
            return output.distinct()
        }
    }

    fun intersection(range: SeedRange): SeedRange? {
        val start = maxOf(this.start, range.start)
        val end = minOf(this.end, range.end)
        return if (start < end) {
            SeedRange(start, end)
        } else {
            null
        }
    }

    fun difference(range: SeedRange): List<SeedRange> {
        val intersection = this.intersection(range)
        val output = mutableListOf<SeedRange>()

        if (intersection == null) {
            output.add(this)
            return output
        }

        if (intersection.start > this.start) {
            output.add(SeedRange(this.start, intersection.start))
        }

        if (intersection.end < this.end) {
            output.add(SeedRange(intersection.end, this.end))
        }

        return output
    }

    fun union(range: SeedRange): SeedRange {
        if (end == range.start) {
            return SeedRange(start, range.end)
        }

        if (start == range.end) {
            return SeedRange(range.start, end)
        }

        if (this.intersection(range) == null) {
            return this
        }

        val start = minOf(this.start, range.start)
        val end = maxOf(this.end, range.end)
        return SeedRange(start, end)
    }
}

data class GardenMapRange(
    val destinationRangeStart: Long,
    val sourceRangeStart: Long,
    val rangeLength: Long,
) {

    constructor(line: String) : this(
        line.split(" ")[0].toLong(),
        line.split(" ")[1].toLong(),
        line.split(" ")[2].toLong(),
    )

    private fun getSourceEnd(): Long = sourceRangeStart + rangeLength

    fun getMapped(value: Long): Long {
        if (value < sourceRangeStart || value >= sourceRangeStart + rangeLength)
            throw OutOfRangeException(value)

        return destinationRangeStart + (value - sourceRangeStart)
    }

    private fun toSeedRange(): SeedRange = SeedRange(sourceRangeStart, getSourceEnd())

    fun getMapped(range: SeedRange): List<SeedRange> {
        val output = mutableListOf<SeedRange>()

        // outside ranges unchanged
        val outsideRanges = range.difference(toSeedRange())
        output.addAll(outsideRanges)

        // inside ranges mapped
        val insideRange = range.intersection(toSeedRange()) ?: return output

        val mappedStart = try {
            getMapped(insideRange.start)
        } catch (e: OutOfRangeException) {
            insideRange.start
        }

        val mappedEnd = try {
            getMapped(insideRange.end - 1)
        } catch (e: OutOfRangeException) {
            insideRange.end - 1
        }

        output.add(SeedRange(mappedStart, mappedEnd + 1))
        return SeedRange.mergeRanges(output.sortedBy { it.start })
    }
}

class OutOfRangeException(value: Long) : Exception("Value $value is out of range")
