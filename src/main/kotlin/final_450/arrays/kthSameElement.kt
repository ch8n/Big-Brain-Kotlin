package final_450.arrays

fun main() {
    // Given an array arr[] and a number K where K is smaller
    // than size of array, the task is to find the Kth smallest
    // element in the given array.
    // It is given that all array elements are distinct.

    /***
     * N = 6
    arr[] = 7 10 4 3 20 15
    K = 3
    Output : 7
    Explanation :
    3rd smallest element in the given
    array is 7.
     */
    val k = 3
    val input = arrayOf(7, 10, 4, 3, 20, 15)
    val kSmallest = input.sorted().get(k - 1)
    println(kSmallest)

    mergesort(input.toList(), mutableListOf())
}

// 7,10,4,3,20,15
// 7 10 4  | 3 20 15
fun mergesort(list: List<Int>, acc: MutableList<List<Int>>) {
    sliceOrAdd(list, acc)
    println(acc)
}

fun sliceOrAdd(list: List<Int>, acc: MutableList<List<Int>>) {
    val (first, last) = list.equalSplit()
    val isFirstHavingOneItem = first.size == 1
    val isLastHavingOneItem = last.size == 1
    if (!isFirstHavingOneItem) {
        sliceOrAdd(first, acc)
    } else {
        val index = acc.indexOfFirst { it[0] < first[0] }
        acc.add(index,first)
    }
    if (!isLastHavingOneItem) {
        sliceOrAdd(last, acc)
    } else {
        val index = acc.indexOfFirst { it[0] < last[0] }
        acc.add(index,last)
    }
}

fun merge() {

}


fun List<Int>.equalSplit(): Pair<List<Int>, List<Int>> {
    val length = size
    return take(length / 2) to drop(length / 2)
}