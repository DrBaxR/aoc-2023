package day8

class Graph(nodes: List<Node>) {

    private val map: Map<String, Node>

    init {
        val mutableMap = mutableMapOf<String, Node>()
        nodes.forEach { mutableMap[it.id] = it }
        map = mutableMap
    }

    fun traverse(start: String, instructions: String): Int {
        var currentNode = map[start]!!

        var reachedDestination = false
        var stepsCount = 0
        while(!reachedDestination) {

            instructions.forEach {
                stepsCount++

                currentNode = map[currentNode.getNext(it)]!!

                if (currentNode.id.endsWith("Z")) {
                    reachedDestination = true
                }
            }
        }

        return stepsCount
    }
}
