package final_450.strings

fun main() {
    //Reverse the array
    val input = arrayOf(4, 5, 1, 2).toMutableList()

    // same array
    val length = input.size - 1
    for (i in input.lastIndex downTo length / 2) {
        val lastIndex = i
        val firstIndex = length - i
        val last = input[lastIndex]
        val first = input[firstIndex]
        input[firstIndex] = last
        input[lastIndex] = first
    }
    println(input)

    // new array
    val mutableList = mutableListOf<Int>()
    for (index in input.lastIndex downTo 0) {
        mutableList.add(input[index])
    }


}

