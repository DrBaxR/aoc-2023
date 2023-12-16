package day5

fun part1(text: String): Long {
    val gardenMapsSet = GardenMapsSet(text)

    return gardenMapsSet.getSmallestMapping()
}
