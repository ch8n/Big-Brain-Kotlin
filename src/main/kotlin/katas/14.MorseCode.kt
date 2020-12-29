@file:Suppress("PackageDirectoryMismatch")

package katas.morseCode

import kotlin.time.measureTimedValue


// https://www.codewars.com/kata/54b724efac3d5402db00065e/train/kotlin

/**

Your task is to implement a function that would take the morse code as input and return a decoded human-readable string.
3 spaces are used to separate words
NOTE: Extra spaces before or after the code have no meaning and should be ignored.

"HEY JUDE", decodeMorse(".... . -.--   .--- ..- -.. .")

 */


@kotlin.time.ExperimentalTime
fun code() {

    //val signal = ".... . -.--  .--- ..- -.. ."

    val morseResult = "you have a big brain for kotlin".toMorse()
    println(morseResult)

    measure("ch8n") {
        println(decodeMorse(morseResult))
    }

    measure("ch8n2") {
        println(decodeMorse2(morseResult))
    }

    measure("ch8n3") {
        println(decodeMorse3(morseResult))
    }

    measure("ch8n4") {
        println(decodeMorse4(morseResult))
    }

    measure("ch8n5") {
        println(decodeMorse5(morseResult))
    }

    measure("ch8n6") {
        println(decodeMorse6(morseResult))
    }
    measure("ch8n7") {
        println(decodeMorse7(morseResult))
    }
    measure("ch8n8") {
        println(decodeMorse8(morseResult))
    }

    measure("ch8n9") {
        println(decodeMorse9(morseResult))
    }

}


val morseCodeTranslator = mapOf<String, String>(
        ".-" to "A",
        "-..." to "B",
        "-.-." to "C",
        "-.." to "D",
        "." to "E",
        "..-." to "F",
        "--." to "G",
        "...." to "H",
        ".." to "I",
        ".---" to "J",
        "-.-" to "K",
        ".-.." to "L",
        "--" to "M",
        "-." to "N",
        "---" to "O",
        ".--." to "P",
        "--.-" to "Q",
        ".-." to "R",
        "..." to "S",
        "-" to "T",
        "..-" to "U",
        "...-" to "V",
        ".--" to "W",
        "-..-" to "X",
        "-.--" to "Y",
        "--.." to "Z",
        ".----" to "1",
        "..---" to "2",
        "...--" to "3",
        "....-" to "4",
        "....." to "5",
        "-...." to "6",
        "--..." to "7",
        "---.." to "8",
        "----." to "9",
        "-----" to "0",
        "" to " ",
        ".-.-.-" to ".",
        "--..--" to ",",
        "---..." to ".",
        "..--.." to "?",
        "-.-.--" to "!",
        "...---..." to "SOS",
        "-....-" to "''",
        "-..-." to "/",
        "-.--.-" to "()",
        ".--.-." to "@",
        "-...-" to "="
)

val morseCodeConverter: Map<String, String>
    get() {
        return morseCodeTranslator.entries.associate { (key, value) -> value.toLowerCase() to key }
    }

fun String.toMorse(): String {
    val morseMapper = morseCodeConverter
    val sentense = this
    val words = sentense.split(" ")
    val morse = words
            .map { word ->
                return@map word
                        .toCharArray()
                        .map { alpha -> morseMapper.get(alpha.toString()) }
                        .joinToString(separator = " ")
            }.joinToString(separator = "   ")
    return morse
}

fun decodeMorse(code: String): String {
    val singalWords = code.split("   ")
    val morseChars = singalWords.map {
        it.split(" ")
                .map { morseCodeTranslator.get(it) }
                .joinToString("")
    }.filter { it.isNotEmpty() }
    return morseChars.joinToString(" ")
}

fun decodeMorse2(code: String): String {
    return code.split(" ")
            .map { x -> morseCodeTranslator.get(x) ?: " " }
            .joinToString("")
            .replace("  ", " ")
            .trim()
}

fun decodeMorse3(code: String) = code.trim()
        .replace("   ", "  ")
        .split(" ")
        .joinToString("") { if (it == "") " " else morseCodeTranslator[it] ?: "" }


fun decodeMorse4(code: String): String {
    val morseWords = code.split("   ")
    val humanized = StringBuilder()
    for (morseWord in morseWords) {
        println("word:$morseWord")
        val morseChars = morseWord.split(" ")
        for (morseChar in morseChars) {
            println("char:$morseChar")
            if (morseChar.isNotEmpty()) {
                humanized.append(morseCodeTranslator.get(morseChar))
            }
        }
        humanized.append(" ")
    }
    return humanized.toString()
}

fun decodeMorse7(code: String): String {
    fun decodeMorse(code: String) = code
            .trim()
            .split("   ")
            .joinToString(separator = " ") { word ->
                word.split(" ")
                        .map { letter -> morseCodeTranslator[letter] ?: "" }
                        .joinToString(separator = "")
            }
    return decodeMorse(code)
}

fun decodeMorse8(code: String): String {
    fun decodeMorse(code: String) = code
            .split("   ")
            .fold("") { acc, word ->
                val res = word.split(" ").fold("") { acc, code -> "$acc${morseCodeTranslator[code] ?: ""}" }
                "$acc $res"
            }
    return decodeMorse(code)
}

fun decodeMorse9(code: String): String {
    fun decodeMorse(code: String) = code
            .split("  ")
            .flatMap { it.split(" ") }
            .map { morseCodeTranslator.get(it) }
            .joinToString("")
    return decodeMorse(code)
}

fun decodeMorse6(code: String): String {
    fun decodeMorse(code: String) = code
            .replace("  ", " ")
            .split(" ")
            .map { morseCodeTranslator[it] }
            .joinToString("")
    return "6"+decodeMorse(code)
}

fun decodeMorse5(code: String): String {
    val SPACE = " "
    val MORSE_SPACE = "  "

    fun toHumanReadableCharacter(letter: String) = morseCodeTranslator[letter] ?: SPACE

    fun decodeMorse(code: String): String {
        return code.split(SPACE)
                .map(::toHumanReadableCharacter)
                .joinToString("")
                .replace(MORSE_SPACE, SPACE)
                .trim()
    }

    return decodeMorse(code)
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
