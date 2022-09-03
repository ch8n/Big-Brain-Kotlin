package udemy.dsa.recursion


fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    list.headRecursion { print(it) }
    println()
    list.tailRecursion { print(it) }
}
fun <T> List<T>.headRecursion(index: Int = lastIndex, next: (item: T) -> Unit) {
    if (index >= 0) {
        headRecursion(index - 1, next)
        next.invoke(get(index))
    }
}
fun <T> List<T>.tailRecursion(index: Int = 0, next: (item: T) -> Unit) {
    if (lastIndex >= index) {
        next.invoke(get(index))
        tailRecursion(index + 1, next)
    }
}

fun <T> List<T>.reverseHeadRecursion(index: Int = 0, next: (item: T) -> Unit) {
    if (lastIndex >= index) {
        reverseHeadRecursion(index + 1, next)
        next.invoke(get(index))
    }
}

fun <T> List<T>.reverseTailRecursion(index: Int = lastIndex, next: (item: T) -> Unit) {
    if (index >= 0) {
        next.invoke(get(index))
        reverseTailRecursion(index - 1, next)
    }
}


