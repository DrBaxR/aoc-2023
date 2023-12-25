package day8

class Node(line: String) {

    val id: String

    val left: String
    val right: String

    init {
        val parts = line.split("=").map { it.trim() }
        val neighbors = parts[1].split(", ").map { it.trim() }
        id = parts[0]
        left = neighbors[0].filter { it != '(' }
        right = neighbors[1].filter { it != ')' }
    }
}
