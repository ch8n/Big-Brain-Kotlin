//https://www.codewars.com/kata/517abf86da9663f1d2000003/train/kotlin

@file:Suppress("PackageDirectoryMismatch")

package katas.toCamelCase

import kotlin.time.measureTimedValue


@kotlin.time.ExperimentalTime
fun code() {
    val input = "the_stealth_warrior"
    //val input = "EAnF-H-ymE-O-Zqk-typGMv-DmnE"
    //EAnFHYm[EOZqkTypGMvDmnE]>
    println(toCamelCase(input))
}



fun toCamelCase(str: String): String =
        str.split("-", "_")
                .mapIndexed { index, word ->
                    if (index != 0) word.capitalize() else word
                }
                .joinToString("")


fun toCamelCase1(str: String): String =
        when {
            str.contains("-") -> str.split("-").mapIndexed { index, word ->
                if (index == 0) {
                    return@mapIndexed word
                }
                word.mapIndexed { index, char ->
                    if (index == 0) char.toUpperCase() else char
                }.joinToString("")
            }.joinToString("")
            str.contains("_") -> str.split("_").mapIndexed { index, word ->
                if (index == 0) {
                    return@mapIndexed word
                }
                word.mapIndexed { index, char ->
                    if (index == 0) char.toUpperCase() else char
                }.joinToString("")
            }.joinToString("")
            else -> str
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
