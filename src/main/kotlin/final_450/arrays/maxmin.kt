package final_450.arrays

fun main() {
    val input = arrayOf(4, 5, 1, 2)
    val sorted = input.sorted()
    val max = sorted.last()
    val min = sorted.first()
    println("$max:$min")

    val maxmin = input.fold(input[0] to input[0]) { acc, value ->
        return@fold when {
            acc.first < value /*Max*/ -> acc.copy(first = value)
            acc.second > value /*Min*/ -> acc.copy(second = value)
            else -> acc
        }
    }
    println("${maxmin.first}:${maxmin.second}")

}
