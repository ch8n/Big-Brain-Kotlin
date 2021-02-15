package final_450

fun main() {
    val input = listOf(6, 1, 5, 4, 2, 3)
    println(input.maxMin())

}

private fun List<Int>.maxMin(): Pair<Int, Int> {
    val sorted = this.sorted()
    return Pair(sorted.first(), sorted.last())
}
