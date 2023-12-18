import day5.part2

fun main() {
    val input = object {}::class.java.getResource("day5.txt")!!.readText()

    // 209124047 - too high
    println(part2(input))
}
