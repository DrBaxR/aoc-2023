import day6.part2

fun main() {
    val input = object {}::class.java.getResource("day6.txt")!!.readText()

    println(part2(input))
}
