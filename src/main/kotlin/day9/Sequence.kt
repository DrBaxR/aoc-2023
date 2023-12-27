package day9

class Sequence(private val numbers: List<Long>) {

    constructor(text: String) : this(text.split(" ").map { it.toLong() })

    fun predictNextValue(): Long {
        if (isAllZeros()) {
            return 0
        }

        return getLastNumber() + getDifferenceSequence().predictNextValue()
    }

    fun predictPreviousValue(): Long {
        if (isAllZeros()) {
            return 0
        }

        return getFirstNumber() - getDifferenceSequence().predictPreviousValue()
    }

    private fun getLastNumber(): Long = numbers.last()

    private fun getFirstNumber(): Long = numbers.first()

    private fun isAllZeros(): Boolean {
        return numbers.all { it == 0L }
    }

    private fun getDifferenceSequence(): Sequence {
        val differenceNumbers = mutableListOf<Long>()

        for (i in 1 until numbers.size) {
            differenceNumbers.add(numbers[i] - numbers[i - 1])
        }

        return Sequence(differenceNumbers)
    }
}
