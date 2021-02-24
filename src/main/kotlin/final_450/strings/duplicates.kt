package final_450.strings

fun main() {
    val array = arrayOf(1, 2, 3, 6, 3, 6, 1)
    array
        .groupBy { it }
        .values
        .filter { it.size > 1 }
        .flatMap { it }
    println()
}