@file:Suppress("PackageDirectoryMismatch")
package katas.longestCount

//https://www.codewars.com/kata/5656b6906de340bd1b0000ac/train/kotlin

import kotlin.time.measureTimedValue


/**
 * 
 * Take 2 strings s1 and s2 including only letters from a to z.
 * Return a new sorted string, the longest possible, containing distinct letters,

 each taken only once - coming from s1 or s2.
Examples:
a = "xyaabbbccccdefww"
b = "xxxxyyyyabklmopq"
longest(a, b) -> "abcdefklmopqwxy"

a = "abcdefghijklmnopqrstuvwxyz"
longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"

 * 
 * 
 */


@kotlin.time.ExperimentalTime
 fun code() {
        val s1 = "xyaabbbccccdefww"
        val s2 = "xxxxyyyyabklmopq"
        
        measure("ch8n-1") { longest(s1, s2) }
        measure("ch8n-2") { longest2(s1, s2) }
        measure("ch8n-3") { longest3(s1, s2) }
        measure("ch8n-4") { longest4(s1, s2) }
        
 }



 fun longest(s1:String, s2:String):String {   
    return "$s1$s2".toCharArray().sorted().toSet().joinToString("").also(::println)
}


fun longest2(s1:String, s2:String):String {
    return "$s1$s2".toSortedSet().joinToString("").also(::println)
}

fun longest3(s1:String, s2:String):String {
    return (s1.toList() union s2.toList()).sorted().joinToString("").also(::println)
}

fun longest4(s1:String, s2:String):String {
    return "$s1$s2".toCharArray().distinct().sorted().joinToString("").also(::println)
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
