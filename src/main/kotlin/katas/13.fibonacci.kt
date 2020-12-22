// https://www.codewars.com/kata/556deca17c58da83c00002db/train/kotlin

/*
Fibonacci bigger brother, AKA Tribonacci.

[1, 1, 1]
[1, 1 ,1, 3, 5, 9, 17, 31, ...]
*/

import kotlin.time.measureTimedValue

@kotlin.time.ExperimentalTime
fun code() {

    measure("ch8n-1") { println(tribonacci(doubleArrayOf(1.0,1.0,1.0),1).joinToString()) }

}

fun tribonacci(signature: DoubleArray, n: Int): DoubleArray {
    
    if (n == 0) {
       return doubleArrayOf()
    }

    var tribo = signature.toMutableList()
    (0 until n-3).forEach { 
        var entry = tribo[it]+tribo[it+1]+tribo[it+2]
        tribo.add(entry)
    }
    return tribo.toDoubleArray()
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
