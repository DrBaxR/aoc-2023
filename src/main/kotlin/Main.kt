import day4.part1

fun main() {
    val input = object {}::class.java.getResource("day4.txt")!!.readText()

    println(part1(input))
}
