package final_450.arrays

fun main() {

    val k = 3
    val input = listOf(3, 9, 12, 16, 20) // 6, 12, 9, 13, 17

    val lastIndex = input.lastIndex
    val result = mutableListOf<Int>()
    var lastResult = input.last()

    for (index in lastIndex downTo 0) {

        val current = input.get(lastIndex - index)
        val previous = lastResult
        val increment = current + k
        val decrement = current - k
        if (decrement <= 0) {
            result.add(increment)
        } else {

            val distanceInc = previous - increment
            val distancDec = previous - decrement
            val selected = if (distanceInc < distancDec) {
                decrement
            } else {
                increment
            }
            result.add(selected)
            lastResult = selected

        }

    }
    println(result)
    println(result.run { last() - first() })
}