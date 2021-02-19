package final_450

fun main() {
//    printSquareFilled(10, 5)
//    printSquareNumber(10, 5)
//    printSquareHollow(10, 5)
    //printOne()
    // printTwo(10)
    // printThree(9)
    printFour(9)
}


fun printOne() {

    /*
    *  12345
    *  1234
    *  123
    *  12
    *  1
     */

    (5 downTo 1).forEach { height ->
        println()
        (1..height).forEach { width ->
            print(width)
        }
    }


}

fun printTwo(n: Int) {

    /*
    *  1
    *  12
    *  123
    *  1234
    *  12345
    *  1234
    *  123
    *  12
    *  1
    *
     */

    (1..n).forEach { height ->
        println()
        (1..height).forEach { width ->
            print(width)
        }
    }

    (n - 1 downTo 1).forEach { height ->
        println()
        (1..height).forEach { width ->
            print(width)
        }
    }


}

fun printThree(n: Int) {

    /*
     *     1
     *    12
     *   123
     *  1234
     * 12345
     */

    (1..n).forEach { height ->
        println()
        ((n - height) downTo 1).forEach { space ->
            print("*")
        }
        (1..height).forEach { number ->
            print(number)
        }
    }


}

fun printFour(n: Int) {

    /*
     *    1
     *   12
     *  123
     * 1234
     *12345
     * 1234
     *  123
     *   12
     *    1
     *
     */
    (5 downTo 1).forEach { height ->
        (1..height).forEach {
            print("*")
        }
        (5 - height downTo 1).forEach {
            print(it)
        }
        println()

    }

    (1..4).forEach { height ->
        (1..height + 1).forEach {
            print("*")
        }
        (4 - height downTo 1).forEach {
            print(it)
        }
        println()
    }

}


/***
 *  12345
 *  1234
 *  123
 *  12
 *  1
 *
 *  1
 *  12
 *  123
 *  1234
 *  12345
 *  1234
 *  123
 *  12
 *  1
 *
 *          1
 *         23
 *        123
 *       1234
 *      12345
 *
 *          1
 *         23
 *        123
 *       1234
 *      12345
 *       1234
 *        123
 *         12
 *          1
 *
 *
 *           1
 *          121
 *         12321
 *        1234321
 *       123454321
 *
 *           1
 *          121
 *         12321
 *        1234321
 *       123454321
 *        1234321
 *         12321
 *          121
 *           1
 *
 *     55555
 *    44444
 *   33333
 *  2222
 * 1111
 *
 * 0
 * 10
 * 010
 * 1010
 * 01010
 * 101010
 *
 *       1
 *     1 2 3
 *   1 2 3 4 5
 *     1 2 3
 *       1
 *
 *      *       *
 *  *       *       *
 */

fun printSquareFilled(height: Int, width: Int) {
    repeat(height) { _ ->
        println()
        repeat(width) { _ ->
            print("*")
        }
    }
}

fun printSquareNumber(height: Int, width: Int) {
    repeat(height) { coloumn ->
        println()
        repeat(width) { _ ->
            print("${coloumn + 1}")
        }
    }
}

fun printSquareHollow(height: Int, width: Int) {
    // height loop
    println("Method---1-----")
    (0 until height).forEach { heightIndex ->
        val coloumn = heightIndex + 1
        println()
        (0 until width).forEach { widthIndex ->
            val row = widthIndex + 1
            when {
                coloumn == 1 || coloumn == height -> print("${heightIndex + 1}")
                row == 1 || row == width -> print("${heightIndex + 1}")
                else -> print("*")
            }
        }
    }

    println("Method---2-----")

    repeat(height) { coloumn ->
        println()
        repeat(width) { row ->
            when {
                coloumn == 0 || coloumn == height - 1 -> print("${coloumn + 1}")
                row == 0 || row == width - 1 -> print("${coloumn + 1}")
                else -> print("*")
            }
        }
    }

}

