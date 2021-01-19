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



fun findEvenIndex2(arr: IntArray): Int {
    for (i in arr.indices) {
        val left = arr.sliceArray(0..i).sum()
        val right = arr.sliceArray(i..arr.lastIndex).sum()
        if (left == right) {
            return i
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
