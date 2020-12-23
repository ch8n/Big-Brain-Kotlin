//? https://www.codewars.com/kata/554b4ac871d6813a03000035/train/kotlin ?
// return the highest and lowest number.

@file:Suppress("PackageDirectoryMismatch")

package katas.highlow

import kotlin.system.measureNanoTime

fun main() {
    val input = "8 3 -5 42 -1 0 0 -9 4 7 4 -4"


    measure("Chetan-1") {
        highAndLow1(input)
    }

    measure("Chetan-2") {
        highAndLow2(input)
    }

    measure("Community-1") {
        highAndLowC1(input)
    }

    measure("Community-2") {
        highAndLowC2(input)
    }

    measure("Appache-1") {
        appacheSolution(input)
    }

    measure("holloRedditAnswer-1") {
        holloRedditAnswer(input)
    }

}

fun measure(tag: String, block: () -> Unit) {
    Thread(Runnable {
        measureNanoTime { block.invoke() }.also {
            println("""$tag took ${it * 0.000001} ms-----""")
        }
    }).start()
}

fun highAndLow1(numbers: String): String {
    val nums = numbers.split(" ").map { it.toIntOrNull() }.filterNotNull()
    val max = nums.maxOrNull() ?: -1
    val min = nums.minOrNull() ?: -1
    return "$max $min"
}

fun highAndLow2(numbers: String): String {
    val firstNumber: Int = numbers.split(" ").get(0).toIntOrNull() ?: -1
    val result = numbers.split(" ").fold(Pair</*max*/Int,/*min*/Int>(firstNumber, firstNumber)) { acc, it ->
        val item = it.toIntOrNull() ?: -1
        return@fold when {
            item > acc.first -> acc.copy(first = item)
            item < acc.second -> acc.copy(second = item)
            else -> acc
        }
    }
    return "${result.first} ${result.second}"
}

fun highAndLowC1(numbers: String) = numbers.split(' ').map(String::toInt).let { "${it.max()} ${it.min()}" }

fun highAndLowC2(numbers: String): String {
    val nums = numbers.split(" ").map { it.toInt() }.sorted()
    return "${nums.last()} ${nums.first()}"
}

fun appacheSolution(numbers: String): String {
    val result = numbers.split(' ')
            .map(String::toInt)
            .sorted()
    return "${result.first()} ${result.last()}"
}

fun niharikaSolution() {
    //https://twitter.com/theDroidLady

    val DEFAULT_MIN = -1
    val DEFAULT_MAX = -1

    fun getMinAndMax(numberString: String): String =
            numberString
                    .split(' ')
                    .mapNotNull { stringItem -> stringItem.toIntOrNull() }
                    .distinct()
                    .let { numbersList -> "${numbersList.maxOrNull() ?: DEFAULT_MAX} ${numbersList.minOrNull() ?: DEFAULT_MIN}" }

    println(getMinAndMax("1 2 13 41 5 hh -1 17 0 5 -1"))
}

//Reddit
fun holloRedditAnswer(numbers: String): String {
    val seq = numbers.splitToSequence(' ')
    val first: Int = seq.first().toInt()
    val result = seq.fold(Pair(first, first)) { acc, item ->
        val numb = item.toIntOrNull()
        return@fold if (numb != null) {
            acc.copy(first = maxOf(acc.first, numb), second = minOf(acc.second, numb))
        } else {
            acc
        }
    }
    return "${result.first} ${result.second}"
}

