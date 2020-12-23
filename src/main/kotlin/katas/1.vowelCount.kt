// * Source: https://www.codewars.com/kata/54ff3102c1bad923760001f3

@file:Suppress("PackageDirectoryMismatch")

package katas.vowelCount

fun main() {

    val input = "The greatest victory is that which requires no battle"

    println("======== Chetan ==========")
    println("input size :${input.length} vowels count : ${countVowels0(input)}")
    println("input size :${input.length} vowels count : ${countVowels1(input)}")
    println("input size :${input.length} vowels count : ${countVowels2(input)}")

    println("======== Community ==========")
    println("input size :${input.length} vowels count : ${countVowelsC1(input)}")
    println("input size :${input.length} vowels count : ${countVowelsC2(input)}")

}

fun countVowels0(input: String): Int {
    val alpha = input.split("").filter { it.isNotEmpty() }
    var counter = 0
    alpha.forEach { item ->
        when (item) {
            "a", "e", "i", "o", "u" -> ++counter
        }
    }
    return counter
}

fun countVowels1(input: String) = input.toCharArray().filter { it in "aeiou" }.also { println(it) }.count()
fun countVowels2(input: String) = input.split("").filter { it in "aeiou" && it.isNotEmpty() }.also { println(it) }.count()

// ? community Answer ?

fun countVowelsC1(input: String) = input.filter { it in "aeiou" }.also { println(it) }.count()
fun countVowelsC2(input: String) = input.count { it in "aeiou" }
