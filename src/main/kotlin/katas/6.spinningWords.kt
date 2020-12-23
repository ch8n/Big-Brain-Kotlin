@file:Suppress("PackageDirectoryMismatch")
package katas.spinningwords

//https://www.codewars.com/kata/5264d2b162488dc400000001/train/kotlin

/*
 spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw" 
 spinWords( "This is a test") => returns "This is a test" 
 spinWords( "This is another test" )=> returns "This is rehtona test"

 */

 import kotlin.time.measureTimedValue

 @kotlin.time.ExperimentalTime
fun main(){
    val input = "Hey fellow warriors"
    
    measure("ch8n-1"){println(spinWords1(input))}
    measure("ch8n-2"){println(spinWords2(input))}
    measure("ch8n-3"){println(spinWords3(input))}
    measure("community-1"){println(spinWordsC1(input))}
    measure("community-2"){println(spinWordsC2(input))}

}

fun spinWords1(input:String):String= input.split(" ").map{word-> if(word.length>5) word.reversed() else word }.joinToString(" ")

fun spinWords2(input:String):String{
  val words = input.split(" ")
  var result = ""
  for (word in words) {
      if(word.length > 5){
         result = "$result ${word.reversed()}" 
      }else{
          result = "$result $word"
      }
  }
  return result
}

fun spinWords3(input:String):String{
  val words = input.split(" ")
  var result = ""
  for (word in words) {
      if(word.length > 5){
         result = "$result ${word.reverseAplhabet()}" 
      }else{
          result = "$result $word"
      }
  }
  return result
}

fun spinWordsC1(s: String) = s.split(" ").joinToString(" ") { if (it.length > 4) it.reversed() else it }

fun spinWordsC2(sentence: String): String {
    var words = sentence.split(" ")
    var reverse = StringBuilder()
    words.forEach { it ->
        if (it.length > 4){
            for(i in it.count() - 1 downTo 0){
                reverse.append(it[i].toString())
            }
            reverse.append(" ")
        } else reverse.append("$it ")
    }
    reverse.deleteCharAt(reverse.length - 1)
    return reverse.toString()
}




fun String.reverseAplhabet():String{
    val alphs = this.toCharArray()
    var reverse = ""
    for (alpha in alphs) {
        reverse = "$alpha$reverse"
    }
    return reverse
}



@kotlin.time.ExperimentalTime
fun measure(tag:String,block:()->Unit){
    Thread(Runnable{
        measureTimedValue { block.invoke() }.also{
            println(
"""
---------
Inside Thread ${Thread.currentThread().name} 
$tag took ${it.duration} ms
---------
""")
        }
    }).start()
}
