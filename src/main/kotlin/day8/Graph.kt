package day8

class Graph(nodes: List<Node>) {

    private val map: Map<String, Node>

    init {
        val mutableMap = mutableMapOf<String, Node>()
        nodes.forEach { mutableMap[it.id] = it }
        map = mutableMap
    }

    fun traverse(instructions: String): Int {
        var currentNode = map["AAA"]!!

        var reachedDestination = false
        var stepsCount = 0
        while(!reachedDestination) {

            instructions.forEach {
                stepsCount++
                when (it) {
                    'L' -> currentNode = map[currentNode.left]!!
                    'R' -> currentNode = map[currentNode.right]!!
                }

                if (currentNode.id == "ZZZ") {
                    reachedDestination = true
                }
            }
        }

        return stepsCount
    }
}
