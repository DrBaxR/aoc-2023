import day10.part1

fun main() {
    val input = object {}::class.java.getResource("day10.txt")!!.readText()

    println(part1(input))
}
