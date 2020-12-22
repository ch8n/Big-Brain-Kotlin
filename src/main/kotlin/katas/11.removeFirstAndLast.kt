// https://www.codewars.com/kata/56bc28ad5bdaeb48760009b0/solutions/kotlin

import kotlin.time.measureTimedValue

val collector = mutableMapOf<String, String>()

/* 
 It's pretty straightforward. Your goal is to create a function that removes the first and last characters of a string.
 You're given one parameter, the original string. You don't have to worry with strings with less than two characters.
*/


@kotlin.time.ExperimentalTime
 fun code() {

    
    val input = "eloquent"
    measure("ch8n-1") { println(removeChar1(input)) }
    measure("ch8n-2") { println(removeChar2(input)) }
    measure("ch8n-3") { println(removeChar3(input)) }
    measure("ch8n-4") { println(removeChar4(input)) }
    
 }

 fun removeChar1(str: String): String = str.substring(1,str.lastIndex)
 fun removeChar2(str: String): String = str.dropLast(1).drop(1) 
 fun removeChar3(str: String): String = str.filterIndexed{ index, _ -> index != 0 && index!= str.length -1   }
 fun removeChar4(str: String): String = StringBuilder(str).let {
     it.deleteAt(0)
     it.deleteAt(str.length - 2)
     it.toString()
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
