package final_450.arrays

fun main() {
    shiftPositiveAndNegative()
    shiftPositiveAndNegativeByGroup()
    shiftPositiveAndNegativePointer()
}

fun shiftPositiveAndNegative() {
    //O(n) and space O(2n)
    val input = arrayOf(-12, 11, -13, -5, 6, -7, 5, -3, -6, 0)
    val (pos, negs) = input.partition { it >= 0 }
    println(negs + pos)
}

fun shiftPositiveAndNegativeByGroup() {
    //O(2n) and space O(n)
    val input = arrayOf(-12, 11, -13, -5, 6, -7, 5, -3, -6, 0)
    val groups = input.groupBy { it >= 0 }.values.flatten()
    println(groups)
}

fun shiftPositiveAndNegativePointer() {
    // O(n)
    val input = arrayOf(-12, 11, -13, -5, 6, -7, 5, -3, -6, 0)
    val result = input.toMutableList()
    var pointers = 0 to input.lastIndex
    input.forEach {
        if (it >= 0) {
            // +ve number
            result.set(pointers.second, it)
            pointers = pointers.copy(second = pointers.second - 1)
        } else {
            // -ve number
            result.set(pointers.first, it)
            pointers = pointers.copy(first = pointers.first + 1)
        }
    }

    println(result)

}
