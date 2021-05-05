package simplebenchamark

fun main() {
    val input = "tactcopapa"
    println(input.isPermutationOfPalindrome())
}

fun String.isPermutationOfPalindrome(): Boolean {
    val oddCharCount = this
        .toList()
        .groupingBy { it }
        .eachCount()
        .values.count { it % 2 != 0 }
    return oddCharCount <= 1
}