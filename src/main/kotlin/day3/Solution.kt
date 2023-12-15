package day3

fun getSum(text: String): Int {
    val engine = EngineMap(text)

    val numbers = engine.getNumbersWithAdjacentSymbols()
    return numbers.sum()
}

fun getGearRationSum(text: String): Int {
    val engine = EngineMap(text)

    val numbers = engine.getGearRatios()
    return numbers.sum()
}
