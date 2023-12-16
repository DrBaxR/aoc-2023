package day5

class GardenMapsSet(text: String) {
    private val seeds: List<Long>
    private val maps: List<GardenMap>

    init {
        val lines = text.lines()

        seeds = lines[0].substringAfter(":")
            .trim().split(" ")
            .map { it.toLong() }

        val gardenMaps = mutableListOf<GardenMap>()
        var blockStart = 1
        for (blockEnd in 2 until lines.size) {
            if (lines[blockEnd].isBlank()) {
                gardenMaps.add(GardenMap(lines.subList(blockStart + 1, blockEnd).joinToString("\n")))

                blockStart = blockEnd + 1
            }
        }

        maps = gardenMaps
    }

    fun getSmallestMapping(): Long {
        val seedMappings = seeds.map { seed ->
            maps.fold(seed) { acc, gardenMap ->
                gardenMap.getMapped(acc)
            }
        }

        return seedMappings.minOrNull()!!
    }
}
