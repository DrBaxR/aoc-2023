import day6.part1

fun main() {
    val input = object {}::class.java.getResource("day6.txt")!!.readText()

    println(part1(input))
}
