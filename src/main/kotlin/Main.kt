import day2.getPowerSumOfMinimums

fun main() {
    val input = object {}::class.java.getResource("day2.txt")!!.readText()

    println(getPowerSumOfMinimums(input))
}