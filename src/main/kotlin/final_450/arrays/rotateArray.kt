package final_450.arrays

fun main() {
    val rotateBy = 1
    val array = arrayOf(1, 2, 3, 4, 5)
    val rotate = array.takeLast(rotateBy) + array.dropLast(rotateBy)
    println(rotate)
}