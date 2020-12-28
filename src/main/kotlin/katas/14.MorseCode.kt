@file:Suppress("PackageDirectoryMismatch")

package katas.morseCode


// https://www.codewars.com/kata/54b724efac3d5402db00065e/train/kotlin

/**

Your task is to implement a function that would take the morse code as input and return a decoded human-readable string.
3 spaces are used to separate words
NOTE: Extra spaces before or after the code have no meaning and should be ignored.

"HEY JUDE", decodeMorse(".... . -.--   .--- ..- -.. .")

 */
fun main() {
    //val signal = ".... . -.--  .--- ..- -.. ."

    val morseResult = "big brain kotlin".toMorse()
    println(morseResult)

    val humanReadable = decodeMorse2(morseResult)
    println(humanReadable)

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

