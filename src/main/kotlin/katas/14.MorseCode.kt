// https://www.codewars.com/kata/54b724efac3d5402db00065e/train/kotlin

/**

Your task is to implement a function that would take the morse code as input and return a decoded human-readable string.
3 spaces are used to separate words
NOTE: Extra spaces before or after the code have no meaning and should be ignored.

"HEY JUDE", decodeMorse(".... . -.--   .--- ..- -.. .")

 */
fun main() {
    val signal = ".... . -.--  .--- ..- -.. ."
    val humanReadable = decodeMorse2(signal)
    println(humanReadable)
}

fun decodeMorse(code: String): String {
    val singalWords = code.split("   ")
    val morseChars = singalWords.map {
        it.split(" ")
        .map { MorseCode(it) }
        .joinToString("")
    }.filter { it.isNotEmpty() }
    return morseChars.joinToString(" ")
}

fun decodeMorse2(code: String): String {
    val singalWords = code.split("   ").also(::println)
    val morseChars = singalWords.

    return ""
}

private fun MorseCode(morseCode: String): String? =
    when (morseCode) {
        ".-" -> "A"
        "-..." -> "B"
        "-.-." -> "C"
        "-.." -> "D"
        "." -> "E"
        "..-." -> "F"
        "--." -> "G"
        "...." -> "H"
        ".." -> "I"
        ".---" -> "J"
        "-.-" -> "K"
        ".-.." -> "L"
        "--" -> "M"
        "-." -> "N"
        "---" -> "O"
        ".--." -> "P"
        "--.-" -> "Q"
        ".-." -> "R"
        "..." -> "S"
        "-" -> "T"
        "..-" -> "U"
        "...-" -> "V"
        ".--" -> "W"
        "-..-" -> "X"
        "-.--" -> "Y"
        "--.." -> "Z"
        ".----" -> "1"
        "..---" -> "2"
        "...--" -> "3"
        "....-" -> "4"
        "....." -> "5"
        "-...." -> "6"
        "--..." -> "7"
        "---.." -> "8"
        "----." -> "9"
        "-----" -> "0"
        "" -> " "
        ".-.-.-" -> "."
        "--..--" -> ","
        "---..." -> "."
        "..--.." -> "?"
        "-.-.--" -> "!"
        "...---..." -> "SOS"
        "-....-" -> "''"
        "-..-." -> "/"
        "-.--.-" -> "()"
        ".--.-." -> "@"
        "-...-" -> "="
        else -> null
    }
