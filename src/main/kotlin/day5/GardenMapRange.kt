package day5

import java.lang.Exception

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

    fun getMapped(value: Long): Long {
        if (value < sourceRangeStart || value > sourceRangeStart + rangeLength)
            throw OutOfRangeException(value)

        return destinationRangeStart + (value - sourceRangeStart)
    }
}

class OutOfRangeException(value: Long): Exception("Value $value is out of range")
