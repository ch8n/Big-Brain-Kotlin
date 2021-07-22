package final_450.arrays

fun main() {
    // Reverse the array
    val input = arrayOf(4, 5, 1, 6, 2)
    reverseWithExtraSpace(input.toIntArray())
    reverseWithNoExtraSpace(input.toIntArray())
    println(reverseRecursion(input.toList()))
}

fun reverseRecursion(list: List<Int>): List<Int> {
    if (list.size == 1) {
        return list
    }
    return listOf(list.last()) + reverseRecursion(list.dropLast(1))
}

fun reverseWithExtraSpace(input: IntArray) {
    val reversed = mutableListOf<Int>()
    for (index in input.lastIndex downTo 0) {
        reversed.add(input[index])
    }
    println(reversed.toString())
}

fun reverseWithNoExtraSpace(input: IntArray) =
    with(input) {
        val current = toMutableList()
        val mid = lastIndex / 2
        for (index in lastIndex downTo mid) {
            val firstIndex = lastIndex - index
            val first = input.get(firstIndex)
            val last = input.get(index)
            current.set(index, first)
            current.set(firstIndex, last)
        }
        println(current)
    }
