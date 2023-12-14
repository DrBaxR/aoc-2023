import day3.getSum

fun main() {
    val input = object {}::class.java.getResource("day3.txt")!!.readText()

    println(getSum(input))
}