package final_450.strings

fun main() {
    val input = arrayOf(0, 2, 1, 2, 0)
    val result = input.toMutableList()

    var leftPointer = 0
    var centerPointer = 0
    var rightPointer = input.size - 1


    input.forEach { it ->
        when (it) {
            0 -> {
                // swap pos with left pointer
                // inc left & center
                result.swap(leftPointer, centerPointer)
                ++leftPointer
            }
            1 -> {
                // inc center pointer
                ++centerPointer
            }
            2 -> {
                // swap last with center
                // dec last
                result.swap(centerPointer, rightPointer)
                --rightPointer

            }
        }
    }
    println(result)
}

fun MutableList<Int>.swap(`this`: Int, that: Int) {
    val first = get(`this`)
    val last = get(that)
    this.add(`this`, last)
    this.add(that, first)
}