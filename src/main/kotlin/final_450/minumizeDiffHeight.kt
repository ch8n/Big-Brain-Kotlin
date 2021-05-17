fun main() {

    val list = listOf(4, 2, 3, 6)
    val k = 3

    val updated =
            list.foldIndexed(mutableListOf<Pair</*index*/ Int, /*value*/ Int>>()) { index, acc, item
                ->
                if (item - k >= 0) {
                    acc.add(index to item - k)
                }
                acc.add(index to item + k)
                return@foldIndexed acc
            }

    val sorted = updated.sortedBy { it.second }
    val visited = mutableListOf<Int>(0, 0, 0, 0)
    val selected = mutableListOf<Int>(0, 0, 0, 0)

    sorted.forEach { (index, value) ->
        val vistedValue = visited[index]
        when (vistedValue) {
            0 -> {
                visited[index] = 1
                selected.set(index, value)
            }
        }
    }

    println(selected.joinToString(","))
}
