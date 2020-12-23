
@file:Suppress("PackageDirectoryMismatch")
package katas.dublicate
// https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/train/kotlin

import kotlin.time.measureTimedValue

val collector = mutableMapOf<String, String>()

/*

Write a function that will return the count of distinct case-insensitive 
alphabetic characters and numeric digits that occur more than once in the input string. 
The input string can be assumed to contain only alphabets 
(both uppercase and lowercase) and numeric digits.

Example
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
*/

@kotlin.time.ExperimentalTime
 fun code() {

    val input = "aA11"

    measure("ch8n-1") { println(duplicateCount(input)) }
    measure("community-1") { println(duplicateCount2(input)) }
    measure("community-2") { println(duplicateCount3(input)) }
 }

 fun duplicateCount(text: String): Int {
    return text.toCharArray()
            .fold(mutableMapOf<Char, Int>()) { acc, item ->
                val char = item.toLowerCase()
                val count = acc.get(char)
                if (count != null) {
                    acc.put(char, count + 1)
                } else {
                    acc.put(char, 1)
                }
            return@fold acc
    }
    .values
    .count { it > 1 }
}

fun duplicateCount2(text: String): Int {
    return text.toLowerCase()
    .groupingBy { it }
    .eachCount()
    .values
    .count { it> 1 }
}

fun duplicateCount3(text: String) = text
        .toLowerCase()
        .groupBy { it }
        .values
        .count { it.size> 1 }

// ------------------------------------------

 @kotlin.time.ExperimentalTime
fun main() {

    code()

    val usMap = collector.filter { (key, value) ->
        value.contains("us")
    }.map { (key, value) ->
        val spec = value.split("us")[0].toFloat()
        key to spec
    }.sortedBy { (_, value) ->
        value
    }

    val msMap = collector.filter { (key, value) ->
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
