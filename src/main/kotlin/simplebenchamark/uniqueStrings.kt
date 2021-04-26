@file:Suppress("PackageDirectoryMismatch")

package simplebenchmark.uniqueString

import simplebenchamark.simpleMeasureTest


fun main() {
    val input: String = "this"
    println(input.isUniqueSet())
    println(input.isUniqueMap())
    println(input.isUniqueArray())
    println(input.isUniqueNoDS())
    println(input.isUniqueNoDSOptimized())

}

private fun String.isUniqueNoDSOptimized(): Boolean {
    val sort = this.toList().sorted()
    return (0 until sort.size - 1).none { index -> sort[index].equals(sort[index + 1], ignoreCase = true) }
}

private fun String.isUniqueNoDS(): Boolean {
    return this
        .map { alphabet -> this.count { alphabet == it } }
        .all { it <= 1 }
}

fun String.isUniqueSet() = toSet().size == length
fun String.isUniqueMap() = toList().groupingBy{it }.eachCount().values.none { it>1 }
fun String.isUniqueArray(): Boolean {
    // max chars in ASCII 256
    val intArray = Array(256) { 0 }
    this.forEach { char ->
        val index = char.toInt()
        intArray[index] = intArray[index] + 1
    }
    return intArray.all { it <= 1 }
}
