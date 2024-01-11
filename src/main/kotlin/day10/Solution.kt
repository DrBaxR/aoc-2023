package day10

fun part1(text: String): Long {
    val surface = PipesSurface(text)
    val distanceMap = surface.generateDistanceMap()

    return getMaxValue(distanceMap)
}
//
//fun printDistanceMap(distanceMap: Array<Array<Long>>) {
//    distanceMap.forEach { line ->
//        line.forEach { distance ->
//            print("$distance ")
//        }
//        println()
//    }
//}

fun getMaxValue(distanceMap: Array<Array<Long>>): Long {
    var max = 0L
    distanceMap.forEach { line ->
        line.forEach { distance ->
            if (distance > max) {
                max = distance
            }
        }
    }
    return max + 1
}
