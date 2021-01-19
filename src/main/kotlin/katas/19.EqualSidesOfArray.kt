@file:Suppress("PackageDirectoryMismatch")

package katas.equalsSideOfArray

import kotlin.time.measureTimedValue


//https://www.codewars.com/kata/5679aa472b8f57fb8c000047/train/kotlin

/**
 * Let's say you are given the array {1,2,3,4,3,2,1}:
 * Your function will return the index 3, because at
 * the 3rd position of the array, the sum of left side
 * of the index ({1,2,3}) and the sum of the right side
 * of the index ({3,2,1}) both equal 6.
 */

@kotlin.time.ExperimentalTime
fun code() {
    val input = intArrayOf(1, 2, 3, 4, 3, 2, 1)

    measure("ch8n-0") {
        println(findEvenIndex0(input))
    }

    measure("ch8n-1") {
        println(findEvenIndex1(input))
    }

    measure("comm-1") {
        println(findEvenIndex2(input))
    }

    measure("comm-2") {
        println(findEvenIndex3(input))
    }

    measure("comm-3") {
        println(findEvenIndex4(input))
    }

}


fun findEvenIndex1(arr: IntArray): Int {
    println("///")
    val list = mutableListOf(1, 2, 3, 4, 5)
    println(list)
    val subs = list.subList(0, 3)
    println(subs)
    println(list)

    list[0] = 5
    println(subs)
    println(list)

    println("///")

    for (index in arr.indices) {
        val left = arr.toList().subList(0, index + 1).sum()
        val right = arr.toList().subList(index, arr.size).sum()
        if (left == right) {
            return index
        }
    }
    return -1
}


fun findEvenIndex0(arr: IntArray): Int {

    var evenIndex = 0

    // Loop max till the size of array
    while (evenIndex != arr.size) {

        // sum accumulator loop
        var loopCounter = 0

        // indicates sum from left side
        var leftSum = 0

        // indicates sum of remaining items
        var rightSum = 0

        // loop till the end of list and compute left and write sums
        while (loopCounter != arr.size) {
            when{
                loopCounter < evenIndex -> leftSum += arr[loopCounter]
                loopCounter == evenIndex -> {
                    leftSum+=arr[loopCounter]
                    rightSum+=arr[loopCounter]
                }
                else -> rightSum += arr[loopCounter]
            }
            ++loopCounter
        }

        // compare sum
        if (leftSum == rightSum) {
            // return found index
            return evenIndex
        } else {
            // proceed for second round in loop
            ++evenIndex
        }
    }

    // index not found
    return -1
}


fun findEvenIndex2(arr: IntArray): Int {
    for (index in arr.indices) {
        val left = arr.sliceArray(0..index).sum()
        val right = arr.sliceArray(index..arr.lastIndex).sum()
        if (left == right) {
            return index
        }
    }
    return -1
}

fun findEvenIndex3(arr: IntArray) = arr.indices.indexOfFirst {
    arr.take(it).sum() == arr.drop(it + 1).sum()
}

fun findEvenIndex4(arr: IntArray): Int {
    if (arr.isEmpty()) return 0
    val total = arr.sum()
    arr.foldIndexed(0) { index, leftSum, value ->
        if ((leftSum * 2) + value == total) return index
        leftSum + value
    }
    return -1
}


// ------------------------------------------

val collector = mutableMapOf<String, String>()

@kotlin.time.ExperimentalTime
fun main() {

    code()

    val usMap = collector.filter { (_, value) ->
        value.contains("us")
    }.map { (key, value) ->
        val spec = value.split("us")[0].toFloat()
        key to spec
    }.sortedBy { (_, value) ->
        value
    }.map { (key, value) ->
        key to "$value us"
    }.toMap()

    val msMap = collector.filter { (_, value) ->
        value.contains("ms")
    }.map { (key, value) ->
        val spec = value.split("ms")[0].toFloat()
        key to spec
    }.sortedBy { (_, value) ->
        value
    }.map { (key, value) ->
        key to "$value ms"
    }.toMap()

    val resultMap = mutableMapOf<String, String>().apply {
        putAll(usMap)
        putAll(msMap)
    }

    println("=================")
    println("=================")
    resultMap.forEach { (key, value) ->
        println(" $key --- $value")
    }
    println("=================")
    println("=================")
}

@kotlin.time.ExperimentalTime
fun measure(tag: String, block: () -> Unit) {
    measureTimedValue { block.invoke() }.also {
        collector.put(tag, "${it.duration}")
    }
}
