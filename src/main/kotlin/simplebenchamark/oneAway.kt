package simplebenchamark

fun main() {
    val input1 = "pale"
    val input2 = "bae"
    println(input1.oneAwayCompare(input2))
    println(input1.oneAwayMerge(input2))
}

fun String.oneAwayCompare(that: String): Boolean {
    val end = this.toList()
    val start = that.toList()
    return end.filter { it !in start }.also { println(it) }.size <= 1
}

fun String.oneAwayMerge(that: String): Boolean {
    return "$this$that".toSet().size <= length + 1
}