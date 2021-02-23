package final_450.strings

fun main() {
    val input = arrayOf(-12, 11, -13, -5, 6, -7, 5, -3, -6).toMutableList()

    // group
    val group = input.groupBy { it < 0 }.values.flatMap { it }
    println(group)

    // partition
    val parts = input.partition { it < 0 }
    val result = parts.first + parts.second
    println(result)

}
