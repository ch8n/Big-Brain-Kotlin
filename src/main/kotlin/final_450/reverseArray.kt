package final_450

fun main() {
    val input = listOf(1, 2, 3)
    println(input.reverseList1())

}

private fun List<Int>.reverseList1(): MutableList<Int> {
    val reverseList = mutableListOf<Int>()
    for (reverseIndex in this.lastIndex downTo 0) {
        reverseList.add(this.get(reverseIndex))
    }
    return reverseList
}

private fun List<Int>.reverseList2(): MutableList<Int> {
    val reverseList = mutableListOf<Int>()
    for (reverseIndex in this.lastIndex downTo 0) {
        reverseList.add(this.get(reverseIndex))
    }
    return reverseList
}

