@file:Suppress("PackageDirectoryMismatch")

package katas.sumOfPositiveNeagtive

import kotlin.time.measureTimedValue


@kotlin.time.ExperimentalTime
fun code() {
    val input = arrayOf(0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14)
    measure("ch8n-1"){ println(countPositivesSumNegatives1(input).joinToString(","))}
    measure("ch8n-2"){println(countPositivesSumNegatives2(input).joinToString(","))}
    measure("ch8n-3"){println(countPositivesSumNegatives3(input).joinToString(","))}
}

fun countPositivesSumNegatives1(input: Array<Int>): Array<Int> {
    val positiveSum = input.filter { it > 0 }.sum()
    val negativeSum = input.filter { it < 0 }.sum()
    return arrayOf(positiveSum, negativeSum)
}

fun countPositivesSumNegatives2(input: Array<Int>): Array<Int> {
    val (pos, negs) = input.partition { it > 0 }
    return arrayOf(pos.sum(), negs.sum())
}

fun countPositivesSumNegatives3(input: Array<Int>): Array<Int> {
    val (pos, negs) = input.groupBy { it > 0 }.values.toList()
    return arrayOf(pos.sum(), negs.sum())
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
