package final_450.arrays

fun main() {
    sorting()
    countOccurance()
    threePointers()
}

fun sorting() {
    val input = listOf(0, 2, 1, 2, 0)
    val result = input.sorted()
    println(result)
}

fun countOccurance() {
    val input = mutableListOf(0, 2, 1, 2, 0)
    val result = mutableListOf<Int>()
    val counts = input.fold(Triple(0, 0, 0)) { acc, item ->
        return@fold when {
            item == 0 -> acc.copy(first = acc.first + 1)
            item == 1 -> acc.copy(second = acc.second + 1)
            item == 2 -> acc.copy(third = acc.third + 1)
            else -> acc
        }
    }
    val (zeros, one, two) = counts
    repeat(zeros) { result.add(0) }
    repeat(one) { result.add(1) }
    repeat(two) { result.add(2) }
    println(result)
}

fun threePointers() {
    val input = mutableListOf(0, 2, 1, 2, 0)
    val result = input.toMutableList<Int>()
    var pointers = Triple(0, 0, input.lastIndex)
    input.forEach() { item ->
        when (item) {
            0 -> {
                result.set(pointers.first, item)
                pointers = pointers.copy(first = pointers.first + 1, second = pointers.second + 1)
            }
            1 -> {
                pointers = pointers.copy(second = pointers.second + 1)
            }
            2 -> {
                result.set(pointers.third, item)
                pointers = pointers.copy(second = pointers.second - 1)
            }
        }
    }
    println(result)
}
