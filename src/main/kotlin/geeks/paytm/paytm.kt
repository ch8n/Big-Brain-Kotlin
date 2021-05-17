@file:Suppress("ControlFlowWithEmptyBody")

package geeks.paytm


// https://www.geeksforgeeks.org/Paytm-topics-interview-preparation/


// 1  2  3  4  5
// 5-6  7  8  9  10
// 10-11 12 13 14 15
// 15-16 17 18 19 20
// 20-21 22 23 24 25
fun main() {
    seperate0and1()
    angleBetweenHourAndMin()
    whichFinger(1)
    whichFinger(5)
    whichFinger(11)
    whichFinger(18)
    whichFinger(22)
    whichFinger(30)
    listOf(1, 2, 3, 4, 5, 6, 7, 8).binarySearch(2).also(::println)
    listOf(1,2,3,7,5).subArrayOf(20)
}

fun whichFinger(number: Int) {
    println(
        when (number % 5) {
            0 -> "thumb"
            1 -> "first"
            2 -> "middle"
            3 -> "ring"
            else -> "pinky"
        }
    )
}

fun angleBetweenHourAndMin() {
    // (13 * h) - (11/2 * min)


}

fun seperate0and1() {
    //Segregate 0s and 1s in an array
    val input = listOf<Int>(0, 1, 0, 1, 0, 0, 1, 1, 1, 0).toMutableList()
    fun sort() {
        val sorted = input.sorted()
        println(sorted)
    }

    fun count() {
        val count0 = input.count { it == 0 }
        val count1 = input.count { it == 1 }
        val result = mutableListOf<Int>().also { list ->
            repeat(count0) { list.add(0) }
            repeat(count1) { list.add(1) }
        }
        println(result)
    }

    fun part() {
        val (zeros, ones) = input.partition { it == 0 }
        println(zeros + ones)
    }

    fun pointers() {
        var start = 0
        var end = input.lastIndex
        while (start < end) {
            while (input[start] == 0) {
                ++start
            }
            while (input[end] == 1) {
                --end
            }
            input.set(end, 1)
            input.set(start, 0)
        }
        println(input)
    }


    sort()
    count()
    part()
    pointers()

}

fun mergeSort2(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }

    val middle = list.size / 2
    var left = list.subList(0, middle);
    var right = list.subList(middle, list.size);

    return merge(mergeSort2(left), mergeSort2(right))
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    var indexLeft = 0
    var indexRight = 0
    var newList: MutableList<Int> = mutableListOf()

    while (indexLeft < left.count() && indexRight < right.count()) {
        if (left[indexLeft] <= right[indexRight]) {
            newList.add(left[indexLeft])
            indexLeft++
        } else {
            newList.add(right[indexRight])
            indexRight++
        }
    }

    while (indexLeft < left.size) {
        newList.add(left[indexLeft])
        indexLeft++
    }

    while (indexRight < right.size) {
        newList.add(right[indexRight])
        indexRight++
    }
    return newList;
}


fun List<Int>.mergeSort(): List<Int> {

    fun merge(first: List<Int>, second: List<Int>): List<Int> {
        var indexFirst = 0
        var indexSecond = 0
        val collector = mutableListOf<Int>()

        // add min of two item until one list is exausted
        while (indexFirst < first.size && indexSecond < second.size) {
            val itemFirst = first.get(indexFirst)
            val itemSecond = first.get(indexSecond)
            val minItem = kotlin.math.min(itemFirst, itemSecond)
            when (minItem) {
                itemFirst -> ++indexFirst
                itemSecond -> ++indexSecond
            }
            collector.add(minItem)
        }

        while (indexFirst < first.size) {
            collector.add(first[indexFirst])
            ++indexFirst
        }

        while (indexSecond < second.size) {
            collector.add(second[indexSecond])
            ++indexSecond
        }
        return collector
    }

    if (size == 1) return this
    val middle = size / 2
    val first = take(middle)
    val second = drop(middle)
    return merge(first.mergeSort(), second.mergeSort())

}

fun List<Int>.binarySearch(item: Int): Int {
    var start = 0
    var end = lastIndex
    var mid = (start + end) / 2
    while (start <= end) {
        when {
            get(mid) == item -> return mid
            get(mid) < item -> start = mid
            get(mid) > item -> end = mid
        }
        mid = (start + end) / 2
    }
    return -1
}

// 1,2,3,7,5 | 12
// 1+2 = 3+3=6 + 7 = 13
// 2+3
fun List<Int>.subArrayOf(sum: Int) {

    var startIndex = 0
    var endIndex = 0
    var currentSum = 0

    while (startIndex <= lastIndex) {

        val current = getOrNull(endIndex)?:0
        currentSum += current
        println("$startIndex|$endIndex|$currentSum")
        
        if(currentSum == sum){
            break
        }

        if(currentSum < sum){
            ++endIndex
        }

        
        
    }

    println("$startIndex $endIndex")

}


