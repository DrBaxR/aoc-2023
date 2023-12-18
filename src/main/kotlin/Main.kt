import day5.part2

fun main() {
    val input = object {}::class.java.getResource("day5.txt")!!.readText()

    println(part2(input))
}
