package day8

fun part1(text: String): Long {
    val lines = text.lines()
    val directions = lines[0]
    val nodes = lines.subList(2, lines.size - 1).map { Node(it) }

    return Graph(nodes).traverse(directions).toLong()
}

