package udemy.dsa.recursion


fun List<Int>.printForward(index: Int = 0) {
    if (index > lastIndex) {
        println()
    } else {
        print(get(index))
        printForward(index + 1)
    }
}

fun List<Int>.printBack(index: Int = 0) {
    if (index > lastIndex) {
        println()
    } else {
        printBack(index + 1)
        print(get(index))
    }
}


fun List<Int>.printForward2(index: Int = lastIndex) {
    if (index < 0) {
        println()
    } else {
        printForward2(index - 1)
        print(get(index))
    }
}

fun List<Int>.printBackward2(index: Int = lastIndex) {
    if (index < 0) {
        println()
    } else {
        print(get(index))
        printBackward2(index - 1)
    }
}

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    list.printForward()
    list.printBack()

    list.printForward2()
    println()
    list.printBackward2()
}

