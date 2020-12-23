@file:Suppress("PackageDirectoryMismatch")
package katas.repeatString

// https://www.codewars.com/kata/57a0e5c372292dd76d000d7e/train/kotlin

import kotlin.time.measureTimedValue

val collector = mutableMapOf<String, String>()

/* 
 Write a function called repeat_str which repeats the given string src exactly count times.

repeatstr(6, "I") # "IIIIII"
repeatstr(5, "Hello") # "HelloHelloHelloHelloHello"
*/


@kotlin.time.ExperimentalTime
 fun code() {
    
    measure("ch8n-1") { println(repeatStr(4, "a")) }
    measure("ch8n-2") { println(repeatStr2(4, "a")) }
    measure("ch8n-3") { println(repeatStr3(4, "a")) }
    measure("ch8n-4") { println(repeatStr4(4, "a")) }
    measure("ch8n-5") { println(repeatStr5(4, "a")) }
    measure("ch8n-6") { println(repeatStr6(4, "a")) }
    
    
    
 }


fun repeatStr(r: Int, str: String) : String {
    var value = ""
    repeat(r){
        value = "$value$str"
    }
    return value
}

fun repeatStr3(times: Int, str: String) : String { 
    val output = StringBuilder()
    repeat(times){output.append(str)}
    return output.toString()
}


fun repeatStr2(r: Int, str: String) : String {
    return str.repeat(r)
}

fun repeatStr4(r: Int, str: String) = (1..r).map { str }.joinToString("")

fun repeatStr5(r: Int, str: String) = r.downTo(1).joinToString("") { str }

fun repeatStr6(r: Int, str: String) : String {
    var a = ""
    for (i in 1..r) {
        a += str

    }
    return a;
}

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
