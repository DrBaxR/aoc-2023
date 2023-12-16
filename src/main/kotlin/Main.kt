import day4.part2

fun main() {
    val input = object {}::class.java.getResource("day4.txt")!!.readText()

    println(part2(input))
}
