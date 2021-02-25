package final_450.arrays

fun main() {
    val array = arrayOf(1, 2, 3, 6, 3, 6, 1)
    array.groupBy { it }
        .values
        .filter { it.size > 1 }
        .flatMap { it }
        .distinct()

    val result1 = array.groupingBy { it }
        .eachCount()
        .filter { (key, count) ->
            count > 1
        }.keys


    val set = mutableSetOf<Int>()
    array.forEach {
        val size = set.size
        set.add(it)
        if (size == set.size) {
            println(it)
        }
    }

    println(result1.toList())
}