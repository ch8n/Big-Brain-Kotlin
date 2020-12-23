@file:Suppress("PackageDirectoryMismatch")
package katas.agent


//https://www.codewars.com/kata/5526fc09a1bbd946250002dc/train/kotlin

import kotlin.time.measureTimedValue

val collector = mutableMapOf<String,String>()


@kotlin.time.ExperimentalTime
 fun code(){
    //val input = arrayOf(2,6,8,-10,3)
    val input = arrayOf(206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781)
    //val input = arrayOf(Integer.MAX_VALUE, 0, 1)
    measure("ch8n-1") { println(imposter(input)) }
    measure("community-1") { println(imposterC1(input)) }
    measure("community-2") { println(imposterC2(input)) }
    measure("community-3") { println(imposterC3(input)) }
    measure("community-4") { println(imposterC4(input)) }
    measure("community-5") { println(imposterC5(input)) }
    measure("community-6") { println(imposterC6(input)) }
    measure("community-7") { println(imposterC7(input)) }

 }



 @kotlin.time.ExperimentalTime
fun main(){
    
    code()

    Thread(Runnable{
        Thread.sleep(3000)
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
    }).start()
}

fun Int.isEven() = this%2 == 0


fun imposter(integers: Array<Int>): Int {
    val flattened = integers.map{Math.abs(it%2)}
    val (evens,odds) = flattened.take(3).fold(0 to 0){ acc, item->
            return@fold when{
                item == 0 -> acc.copy(first = acc.first+1)
                else -> acc.copy(second = acc.second+1)
            }
    }
    val whatToFind = if(odds > evens) 0 else 1
    val oulinerIndex = flattened.indexOf(whatToFind)
    return if(oulinerIndex!=-1)integers[oulinerIndex] else -1
}


fun imposterC1(integers: Array<Int>) = integers.singleOrNull { it % 2 == 0 } ?: integers.single { it % 2 != 0 }

fun imposterC2(integers: Array<Int>): Int {
    val evens = integers.filter { it % 2 == 0 }
    val odds = integers.filter { it % 2 != 0 }
    return if(evens.size == 1){
        evens.first()
    }else{
        odds.first()
    }
}

fun imposterC3(integers: Array<Int>): Int {
  val (even, odd) = integers.partition { it % 2 == 0 }
  return if (even.size == 1) even[0] else odd[0]
}

fun imposterC4(integers: Array<Int>): Int =
    if( integers.take(3).count {it % 2 == 0} > 1 )
        integers.first {it % 2 != 0}
    else
        integers.first {it % 2 == 0}

fun imposterC5(integers: Array<Int>): Int =
    integers.groupBy { it % 2 == 0 }.values.first { it.size == 1 }.first()

fun imposterC6(integers: Array<Int>): Int {
        val s =integers.map{
            kotlin.math.abs(it % 2)
        }
        val odd = s.count { it == 0 }
        val even = s.count { it == 1 }
       return if(odd > even) integers[s.indexOf(1)] else integers[s.indexOf(0)]
    }

fun imposterC7(integers: Array<Int>): Int {
    fun isMostlyEven() = integers.take(3).count { it % 2 == 0 } > 1
    if (isMostlyEven()) return integers.first { it % 2 != 0 }
    else return integers.first { it % 2 == 0}
}

//------------------------------

@kotlin.time.ExperimentalTime
fun measure(tag:String,block:()->Unit){
    Thread(Runnable{
        measureTimedValue { block.invoke() }.also{
            collector.put(tag,it.duration.toString())
        }
    }).start()
}
