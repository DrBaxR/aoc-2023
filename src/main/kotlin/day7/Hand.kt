package day7

enum class HandType(private val value: Int) {
    FIVE_OF_A_KIND(7),
    FOUR_OF_A_KIND(6),
    FULL_HOUSE(5),
    THREE_OF_A_KIND(4),
    TWO_PAIRS(3),
    ONE_PAIR(2),
    HIGH_CARD(1);

    infix fun beats(other: HandType): Boolean = this.value > other.value
}

class Hand(
    val cards: String, // string of 5 symbols
): Comparable<Hand> {

    private val handType = determineHandType()

    private fun determineHandType(): HandType {
        return if (isFiveOfAKind()) {
            HandType.FIVE_OF_A_KIND
        } else if (isFourOfAKind()) {
            HandType.FOUR_OF_A_KIND
        } else if (isFullHouse()) {
            HandType.FULL_HOUSE
        } else if (isThreeOfAKind()) {
            HandType.THREE_OF_A_KIND
        } else if (isTwoPairs()) {
            HandType.TWO_PAIRS
        } else if (isOnePair()) {
            HandType.ONE_PAIR
        } else {
            HandType.HIGH_CARD
        }
    }

    override operator fun compareTo(other: Hand): Int {
        if (this.handType beats other.handType) {
            return 1
        } else if (other.handType beats this.handType) {
            return -1
        }

        // hand types are equal, compare symbols
        for (i in cards.indices) {
            val thisSymbol = cards[i]
            val otherSymbol = other.cards[i]
            val comparison = compareSymbols(thisSymbol, otherSymbol)
            if (comparison != 0L) {
                return comparison.toInt()
            }
        }

        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Hand) {
            return false
        }
        return this.cards == other.cards
    }

    private fun isFiveOfAKind(): Boolean {
        val counters = mutableMapOf<Char, Int>()
        for (s in cards) {
            counters[s] = (counters[s] ?: 0) + 1
        }
        return counters.values.any { it == 5 }
    }

    private fun isFourOfAKind(): Boolean {
        val counters = mutableMapOf<Char, Int>()
        for (s in cards) {
            counters[s] = (counters[s] ?: 0) + 1
        }
        return counters.values.any { it == 4 }
    }

    private fun isFullHouse(): Boolean {
        val counters = mutableMapOf<Char, Int>()
        for (s in cards) {
            counters[s] = (counters[s] ?: 0) + 1
        }
        return counters.values.any { it == 3 } && counters.values.any { it == 2 }
    }

    private fun isThreeOfAKind(): Boolean {
        val counters = mutableMapOf<Char, Int>()
        for (s in cards) {
            counters[s] = (counters[s] ?: 0) + 1
        }
        return counters.values.any { it == 3 }
    }

    private fun isTwoPairs(): Boolean {
        val counters = mutableMapOf<Char, Int>()
        for (s in cards) {
            counters[s] = (counters[s] ?: 0) + 1
        }

        var pairsCount = 0
        for (value in counters.values) {
            if (value == 2) {
                pairsCount++
            }
        }

        return pairsCount == 2
    }

    private fun isOnePair(): Boolean {
        val counters = mutableMapOf<Char, Int>()
        for (s in cards) {
            counters[s] = (counters[s] ?: 0) + 1
        }
        return counters.values.any { it == 2 }
    }

    override fun hashCode(): Int {
        var result = cards.hashCode()
        result = 31 * result + handType.hashCode()
        return result
    }
}
