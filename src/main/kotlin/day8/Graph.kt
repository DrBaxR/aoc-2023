package day8

class Graph(nodes: List<Node>) {

    private val map: Map<String, Node>

    init {
        val mutableMap = mutableMapOf<String, Node>()
        nodes.forEach { mutableMap[it.id] = it }
        map = mutableMap
    }

    fun traverse(instructions: String): Int {
        var currentNodes = map.keys.filter { it.endsWith("A") }.map { map[it]!! }

        var reachedDestination = false
        var stepsCount = 0
        while(!reachedDestination) {

            instructions.forEach {
                stepsCount++

                val nextNodes = currentNodes.map { cn -> map[cn.getNext(it)]!! }
                currentNodes = nextNodes

                if (currentNodes.all { it.id.endsWith("Z") }) {
                    reachedDestination = true
                }
            }
        }

        return stepsCount
    }
}
