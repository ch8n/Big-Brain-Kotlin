fun main() {
    val input = mutableListOf(2, 3, 4, 5, 1, 6)
    val result = mergeSort(input)
    println(result)
}

fun mergeSort(list: List<Int>): List<Int> {
    val middle = list.size / 2
    var left = list.take(middle);
    var right = list.drop(middle);
    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: List<Int>, right: List<Int>): List<Int>  {
    var leftIndex = 0
    var indexRight = 0
    var newList : MutableList<Int> = mutableListOf()

    while (leftIndex < left.count() && indexRight < right.count()) {
        if (left[leftIndex] <= right[indexRight]) {
            newList.add(left[leftIndex])
            leftIndex++
        } else {
            newList.add(right[indexRight])
            indexRight++
        }
    }

    while (leftIndex < left.size) {
        newList.add(left[leftIndex])
        leftIndex++
    }

    while (indexRight < right.size) {
        newList.add(right[indexRight])
        indexRight++
    }
    return newList;
}