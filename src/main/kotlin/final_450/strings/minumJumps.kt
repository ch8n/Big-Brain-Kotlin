package final_450.strings

import kotlin.math.max

fun main() {

    val array = arrayOf(1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)
    if (array[0] == 0) {
        println(0)
    }
    var maxReach = 0
    array.forEachIndexed { index, it ->
        if (maxReach < index){
            println("cant reach")
            return
        }
        maxReach = max(maxReach,it+index)
    }
    println(maxReach)
}