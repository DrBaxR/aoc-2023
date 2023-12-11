fun main() {
    val input = object {}::class.java.getResource("day1-2.txt")!!.readText()

    println(processText(input))
}