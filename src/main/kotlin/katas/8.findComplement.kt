@file:Suppress("PackageDirectoryMismatch")
package katas.complement

// https://www.codewars.com/kata/554e4a2f232cdd87d9000038/train/kotlin


import kotlin.time.measureTimedValue

val collector = mutableMapOf<String,String>()

/*

In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G".
 You have function with one side of the DNA (string, except for Haskell); 
More similar exercise are found here http://rosalind.info/problems/list-view/ (source)

makeComplement("ATTGC") // return "TAACG"
makeComplement("GTAT") // return "CATA"

*/


@kotlin.time.ExperimentalTime
 fun code(){
    
    val input = "ATTGC"
    
    measure("ch8n-1") { println(makeComplement(input)) }
    measure("ch8n-2") { println(makeComplement2(input)) }
    measure("community-1") { println(makeComplement3(input)) }
 }


 @kotlin.time.ExperimentalTime
fun main(){
    
    code()

    val sortedMap: Map<String, Float> = collector.map{ (key,value)->
        val spec = value.split("ms")[0].toFloat()
        key to spec
    }.sortedBy { (_,value)-> 
        value
    }.toMap()
    println("=================")
    println("=================")
    sortedMap.forEach {(key,value)->
        println(" $key --- $value ms ")
    }
    println("=================")
    println("=================")
}

//------------------------------

@kotlin.time.ExperimentalTime
fun measure(tag:String,block:()->Unit){
    measureTimedValue { block.invoke() }.also{
        collector.put(tag,it.duration.toString())
    }
}



fun makeComplement(dna : String) : String {
    return dna.toCharArray().map{ char->
        return@map when(char){
            'A' -> 'T'
            'T' -> 'A'
            'G'-> 'C'
            'C' -> 'G'
            else -> '#'
        }
    }.joinToString("")
}

fun makeComplement2(dna : String) : String {
    return dna.toCharArray().joinToString(""){ char->
        return@joinToString when(char){
            'A' -> "T"
            'T' -> "A"
            'G'-> "C"
            'C' -> "G"
            else -> "#"
        }
    }
}



fun makeComplement3(dna : String) : String {
    val map = mapOf('C' to 'G', 'G' to 'C', 'A' to 'T', 'T' to 'A')
    return dna.map { map[it] }.joinToString(separator = "")
}