package day5

class GardenMap(textBlock: String) {

    private val name: String
    private val ranges: List<GardenMapRange>

    init {
        val lines = textBlock.lines()

        name = lines[0].substringBefore(':')
        ranges = lines.subList(1, lines.size).map { GardenMapRange(it) }
    }

    fun getMapped(value: Long): Long {
        for (range in ranges) {
            try {
                return range.getMapped(value)
            } catch (e: OutOfRangeException) {
                continue
            }
        }

        return value
    }

    fun getMapped(seedRange: List<SeedRange>): List<SeedRange> {
        val output = mutableListOf<SeedRange>()

        for (range in ranges) {
            for (s in seedRange) {
                try {
                    output.addAll(range.getMapped(s))
                } catch (e: OutOfRangeException) {
                    continue
                }
            }
        }

        return SeedRange.mergeRanges(output)
    }
}
