// https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec/train/kotlin

import kotlin.time.measureTimedValue

val collector = mutableMapOf<String, String>()

/*

Example
persistence(39) == 3 // because 3*9 = 27, 2*7 = 14, 1*4=4
                    and 4 has only one digit
 persistence(999) == 4 // because 9*9*9 = 729, 7*2*9 = 126,
                         1*2*6 = 12, and finally 1*2 = 2

 persistence(4) == 0 // because 4 is already a one-digit number
*/

@kotlin.time.ExperimentalTime
 fun code() {

    val input = 39

    measure("ch8n-1") { println(persistence(input)) }
    measure("ch8n-2") { println(persistence2(input)) }
 }

 fun persistence(num: Int): Int {
    var count = 1
    var breakDown = "$num".map { it.toString().toInt() }.fold(1) { acc, it -> acc*it }
    while (breakDown > 9) {
        breakDown = "$breakDown".map { it.toString().toInt() }.fold(1) { acc, it -> acc*it }
        ++count
    }
    return count
}

fun persistence2(num: Int): Int =
    if (num < 10) 0 else 1 + persistence2(num.toString().map { it - '0' }.reduce(Int::times))

// ------------------------------------------

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
    }

    val msMap = collector.filter { (_, value) ->
        value.contains("ms")
    }.map { (key, value) ->
        val spec = value.split("ms")[0].toFloat()
        key to spec
    }.sortedBy { (_, value) ->
        value
    }

    val resultMap = mutableMapOf<String, Float>().apply {
        putAll(usMap)
        putAll(msMap)
    }

    println("=================")
    println("=================")
    resultMap.forEach { (key, value) ->
        println(" $key --- $value ms ")
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
