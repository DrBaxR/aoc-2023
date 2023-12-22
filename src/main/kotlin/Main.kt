import day7.part1

fun main() {
    val input = object {}::class.java.getResource("day7.txt")!!.readText()

    println(part1(input))
    // low:  253759181
    // curr:
    // high: 254281466
}
