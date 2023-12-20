package day7

data class HandBid(
    val hand: Hand,
    val bid: Long,
) {

    constructor(line: String) : this(
        Hand(line.substringBefore(" ").trim()),
        line.substringAfter(" ").trim().toLong(),
    )
}
