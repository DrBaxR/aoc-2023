package day2

fun parse(line: String): Game {
    val (gameString, cubeSets) = line.split(": ")

    val gameId = gameString.split(" ")[1].toInt()
    val gameSets = cubeSets.split("; ").map { parseCubeSet(it.trim()) }

    return Game(gameId, gameSets)
}

fun parseCubeSet(cubeSetString: String): CubeSet {
    val parts = cubeSetString.split(", ")

    val red = parts.find { it.lowercase().contains("red") }
    val green = parts.find { it.lowercase().contains("green") }
    val blue = parts.find { it.lowercase().contains("blue") }

    return CubeSet(
        red?.removeSuffix("red")?.trim()?.toInt() ?: 0,
        green?.removeSuffix("green")?.trim()?.toInt() ?: 0,
        blue?.removeSuffix("blue")?.trim()?.toInt() ?: 0
    )
}
