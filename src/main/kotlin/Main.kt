import day5.part1

fun main() {
    val input = object {}::class.java.getResource("day5.txt")!!.readText()

    println(part1(input))
}
