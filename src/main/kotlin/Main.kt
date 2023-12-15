import day3.getGearRationSum

fun main() {
    val input = object {}::class.java.getResource("day3.txt")!!.readText()

    println(getGearRationSum(input))
}
