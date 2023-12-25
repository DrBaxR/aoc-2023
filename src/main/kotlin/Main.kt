import day8.part1

fun main() {
    val input = object {}::class.java.getResource("day8.txt")!!.readText()

    println(part1(input))
}
