package final_450

fun main() {
    printSquareFilled(10, 5)
    printSquareNumber(10, 5)
    printSquareHollow(10, 5)
}

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

