import java.lang.Exception

fun processText(input: String): Int =
    input.lines()
        .map { processLine(it) }
        .reduce { acc, number -> (acc + number) }

fun processLine(input: String): Int {
    val firstDigit = findFirstDigit(input)
    val lastDigit = findLastDigit(input)

    return firstDigit * 10 + lastDigit
}

fun findFirstDigit(line: String): Int {
    val firstDigitIndex = indexOfFirstDigit(line)
    val firstLetterDigitIndex = indexOfFirstLetterDigit(line)

    return if (firstDigitIndex == -1 && firstLetterDigitIndex == -1) {
        -1
    } else if(firstDigitIndex == -1) {
        letterDigitFromIndex(line, firstLetterDigitIndex)
    } else if(firstLetterDigitIndex == -1) {
        digitFromIndex(line, firstDigitIndex)
    } else {
        if (firstDigitIndex < firstLetterDigitIndex) {
            digitFromIndex(line, firstDigitIndex)
        } else {
            letterDigitFromIndex(line, firstLetterDigitIndex)
        }
    }
}

fun findLastDigit(line: String): Int {
    val lastDigitIndex = indexOfLastDigit(line)
    val lastLetterDigitIndex = indexOfLastLetterDigit(line)

    return if (lastDigitIndex == -1 && lastLetterDigitIndex == -1) {
        -1
    } else if(lastDigitIndex == -1) {
        letterDigitFromIndex(line, lastLetterDigitIndex)
    } else if(lastLetterDigitIndex == -1) {
        digitFromIndex(line, lastDigitIndex)
    } else {
        if (lastDigitIndex > lastLetterDigitIndex) {
            digitFromIndex(line, lastDigitIndex)
        } else {
            letterDigitFromIndex(line, lastLetterDigitIndex)
        }
    }
}

val digits = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
fun digitFromIndex(line: String, index: Int): Int {
    return line[index].toString().toInt()
}

fun indexOfFirstDigit(input: String): Int {
    val indices = digits.map { digit ->
        if (input.contains(digit.toString())) {
            input.indexOf(digit.toString())
        } else {
            -1
        }
    }

    val relevantIndices = indices.filter { it != -1 }

    return try {
        var min = relevantIndices[0]
        for (i in relevantIndices) {
            if (i < min) {
                min = i
            }
        }

        min
    } catch (e: Exception) {
        -1
    }
}

fun indexOfLastDigit(input: String): Int {
    val indices = digits.map { digit ->
        if (input.contains(digit.toString())) {
            input.lastIndexOf(digit.toString())
        } else {
            -1
        }
    }

    val relevantIndices = indices.filter { it != -1 }
    return try {
        var max = relevantIndices[0]
        for (i in relevantIndices) {
            if (i >= max) {
                max = i
            }
        }

        max
    } catch (e: Exception) {
        -1
    }
}

val digitsLetters = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
fun letterDigitFromIndex(line: String, index: Int): Int {
    val relevantPart = line.substring(index)

    digitsLetters.forEachIndexed { i, s ->
        if (relevantPart.startsWith(s)) {
            return i + 1
        }
    }

    return 0
}

fun indexOfFirstLetterDigit(input: String): Int {
    val indices = digitsLetters.map { digit ->
        if (input.contains(digit)) {
            input.indexOf(digit)
        } else {
            -1
        }
    }

    val relevantIndices = indices.filter { it != -1 }

    return try {
        var min = relevantIndices[0]
        for (i in relevantIndices) {
            if (i < min) {
                min = i
            }
        }

        min
    } catch (e: Exception) {
        -1
    }

}

fun indexOfLastLetterDigit(input: String): Int {
    val indices = digitsLetters.map { digit ->
        if (input.contains(digit)) {
            input.lastIndexOf(digit)
        } else {
            -1
        }
    }

    val relevantIndices = indices.filter { it != -1 }
    return try {
        var max = relevantIndices[0]
        for (i in relevantIndices) {
            if (i >= max) {
                max = i
            }
        }

        max
    } catch (e: Exception) {
        -1
    }
}