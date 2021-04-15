package final_450.arrays

fun main() {
    kadaneAlgo()
    return
    val input = arrayOf(1, 2, 3, -2, 5)
    val best = mutableListOf<Int>()
    val current = mutableListOf<Int>()
    var bestSum = 0
    var currentSum = 0

    input.forEach { item ->
        println("step $item")

        val futureSum = currentSum + item

        // if future sum is more than number
        // collect in current
        if (futureSum >= item) {
            currentSum = futureSum
            current.add(item)
        }

        // if even after sum, current number is more
        // reset current
        if (futureSum <= item) {
            current.clear()
            current.add(item)
            currentSum = item
        }

        // if currentSum is more than best sum
        // capture current series
        if (currentSum >= bestSum) {
            bestSum = currentSum
            best.clear()
            best.addAll(current)
        }

    }

    println(best.sum())

}

fun kadaneAlgo() {
    val input = listOf(1, 2, 3, -2, 5)
    val best = mutableListOf<Int>()
    val current = mutableListOf<Int>()
    var bestSum = 0
    var currentSum = 0

    input.forEach { item ->
        val futureSum = currentSum + item

        // if future sum is less than current item
        // drop item
        if (futureSum < item) {
            current.clear()
            current.add(item)
            currentSum = item
        }

        // if future sum is more than current item
        // update current sum
        if (futureSum >= item) {
            current.add(item)
            currentSum = futureSum
        }

        // if current sum is best
        // update best
        if (currentSum >= bestSum) {
            best.clear()
            best.addAll(current)
            bestSum = currentSum
        }

    }

    println(bestSum)


}