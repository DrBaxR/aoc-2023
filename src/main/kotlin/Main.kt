import day9.part2

fun main() {
    val input = object {}::class.java.getResource("day9.txt")!!.readText()

    println(part2(input))
}
