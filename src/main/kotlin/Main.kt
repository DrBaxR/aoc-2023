import day9.part1

fun main() {
    val input = object {}::class.java.getResource("day9.txt")!!.readText()

    println(part1(input))
}
