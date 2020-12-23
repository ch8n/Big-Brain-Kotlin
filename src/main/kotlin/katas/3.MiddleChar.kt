// https://www.codewars.com/kata/56747fd5cb988479af000028/train/kotlin
// Your job is to return the middle character of the word. 
//If the word's length is odd, return the middle character. 
//If the word's length is even, return the middle 2 characters.

@file:Suppress("PackageDirectoryMismatch")
package katas.middleChar

fun main(){
    val input = "test"
    println("======== Chetan ==========")
    println(getMiddle1(input))
    println(getMiddle2(input))

    println("======== Community ==========")
    println(getMiddleC1(input))
    println(getMiddleC2(input))
    println(getMiddleC3(input))
}

fun getMiddle1(word : String) : String {
    val chars = word.toCharArray()
    val mid = chars.size/2
    return if(chars.size%2==0){
        "${chars.get(mid-1)}${chars.get(mid)}"
    }else{
        "${chars.get(mid)}"
    }
}

fun getMiddle2(word : String) : String {
  val isEven = word.length % 2 == 0
  if(!isEven){
      val middleElement = word.length/2
      return word.toCharArray().get(middleElement).toString()    
  }
  else {
      val middleElement = word.length/2 - 1
      return word.toCharArray().slice(middleElement..middleElement+1).joinToString("")
  }
}

fun getMiddleC1(word : String) : String {
    val len = word.length
    val mid = len / 2
    return word.substring (mid - (len + 1) % 2, mid + 1)
}


fun getMiddleC2(word : String) : String {
    val worldLength = (word.length - 1) / 2
    return word.drop(worldLength).dropLast(worldLength)
}

fun getMiddleC3(word: String): String = word.substring( (word.length-1)/2 .. word.length/2)