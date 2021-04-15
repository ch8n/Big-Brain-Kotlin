package final_450.arrays

fun main() {
    val rotateBy = 0
    val array = arrayOf(1, 2, 3, 4, 5)
    println(array.rotate(rotateBy))
    println(array.rotateReverse(rotateBy))
}

fun Array<*>.rotate(by: Int): List<*> {
    if (!isValid(by)) return this.toList()
    return takeLast(by) + dropLast(by)
}

fun Array<*>.rotateReverse(by: Int): List<*> {
    if (!isValid(by)) return this.toList()
    return drop(1) + take(1)
}

fun isValid(number:Int)= number>0

