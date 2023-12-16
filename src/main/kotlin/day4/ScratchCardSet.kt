package day4

class ScratchCardSet(lines: String) {

    private val cards: List<ScratchCard> = lines.lines().map { ScratchCard(it) }

    fun getFinalCardsCount(): Int {
        val lastCardId = cards.last().id
        val multipliersMap = mutableMapOf<Int, Int>()

        cards.forEach { multipliersMap[it.id] = 1 }

        for (currentId in 1 .. lastCardId) {
            val matchingNumbers = cards.first { it.id == currentId }.getMyWinningNumbers()
            val cardIdsCopied = currentId + 1..currentId + matchingNumbers.size

            for (cardIdCopied in cardIdsCopied) {
                val multiplier = multipliersMap[cardIdCopied] ?: 1
                multipliersMap[cardIdCopied] = multiplier + 1 * (multipliersMap[currentId] ?: 1)
            }
        }

        return multipliersMap.map { it.value }.sum()
    }
}
