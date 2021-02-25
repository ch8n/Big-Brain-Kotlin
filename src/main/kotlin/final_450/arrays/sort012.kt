package final_450.arrays

fun main() {
    val input = arrayOf(0, 2, 1, 2, 0)
    val result = input.toMutableList()

    var leftPointer = 0
    var centerPointer = 0
    var rightPointer = input.size - 1

    //k =3
    // 2n -> min max

//    13, 14, 21, 35, 40
//    10, 11,19,32, 37
//    16, 14[], 21, 35, 37
//
//    1,1,2,5,2,5,1,2
//    best = 4
//    current = 4
//    11
//    k =3
//    diff = 6-2 = 4
//    4,5,6
//    7, 5 , 3
//    3 5 7
    // 2n + n = n
    // max, min
    // max - k, min + k
    // others -> item[i(1->lastIndex-1)] > item+k < max, item-k > min


   // 3, 9, 12, 16, 20



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