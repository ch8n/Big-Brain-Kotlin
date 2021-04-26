package simplebenchamark

fun main() {
    val word1: String = "dog".toLowerCase()
    val word2: String = "god".toLowerCase()
    println(word1.checkPermutationCountChars(word2))
    println(word1.checkPermutationSort(word2))
    println(word1.checkPermutationSet(word2))

}

fun String.checkPermutationCountChars(that: String): Boolean {
    // count characters in both string
    if (that.length != this.length) {
        return false
    }
    val word1Chars = this.groupingBy { it }.eachCount()
    val word2Chars = that.groupingBy { it }.eachCount()
    return word1Chars == word2Chars
}

fun String.checkPermutationSort(that: String): Boolean {
    // sort and compare
    if (that.length != this.length) {
        return false
    }
    val sortedWord1 = this.toCharArray().sorted().joinToString()
    val sortedWord2 = that.toCharArray().sorted().joinToString()
    return sortedWord1 == sortedWord2
}

fun String.checkPermutationSet(that: String): Boolean {
    // sort and compare
    if (that.length != this.length) {
        return false
    }
    val aggrigateSize = "$this$that".toSet().size
    val wordLength = this.length
    return aggrigateSize == wordLength
}