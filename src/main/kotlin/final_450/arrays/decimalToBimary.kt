package final_450.arrays

import kotlin.math.floor

fun main() {
    val input = 233
    println(decimalToBinary(input))
}


fun decimalToBinary(input: Int): String {
    if (input == 0) {
        return ""
    }
    val div = input / 2
    val rem = input % 2
    return  decimalToBinary(div) + "$rem"
}