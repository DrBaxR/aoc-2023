package day6

data class Race(
    val duration: Long,
    val distanceToBeat: Long,
) {

    fun getMarginOfError(): Long {
        var marginOfError = 0L
        for (i in 1 until duration) {
            marginOfError += if (isWonByTimeHeld(i)) 1 else 0
        }
        return marginOfError
    }

    private fun isWonByTimeHeld(holdTime: Long): Boolean {
        return duration * holdTime - holdTime * holdTime > distanceToBeat
    }
}
