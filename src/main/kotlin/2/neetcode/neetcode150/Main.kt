package `2`.neetcode.neetcode150


private fun main() {
    val neetCode150 = NeetCode150()
    with(neetCode150) {
        validateSudoku()
    }
}

private class NeetCode150 {
    fun validateSudoku() {
        fun solution(input: List<List<String>>) {
            //https://leetcode.com/problems/valid-sudoku/description/
            val rowMatrix = Array(9) { mutableListOf<String>() }
            val colMatrix = Array(9) { mutableListOf<String>() }
            val boxMatrix = Array(9) { mutableListOf<String>() }

            for (rowIndex in 0 until 9) {
                for (colIndex in 0 until 9) {
                    val boxIndex = ((rowIndex / 3) * 3) + (colIndex / 3)
                    val entry = input.get(rowIndex).get(colIndex)
                    if (entry == ".") continue
                    rowMatrix.get(rowIndex).add(entry)
                    colMatrix.get(colIndex).add(entry)
                    boxMatrix.get(boxIndex).add(entry)
                }
            }

            val isRowValid = rowMatrix.all { enties -> enties.size == enties.toSet().size }
            val isColValid = colMatrix.all { enties -> enties.size == enties.toSet().size }
            val isBoxValid = boxMatrix.all { enties -> enties.size == enties.toSet().size }
            println("row->$isRowValid col->$isColValid box->$isBoxValid")
            println(isRowValid && isColValid && isBoxValid)
        }


        val inputs = listOf(
            listOf(
                listOf("5", "3", ".", ".", "7", ",", ".", ".", "."),
                listOf("6", ".", ".", "1", "9", "5", ".", ".", "."),
                listOf(".", "9", "8", ".", ".", ".", ".", "6", "."),
                listOf("8", ".", ".", ".", "6", ".", ".", ".", "3"),
                listOf("4", ".", ".", "8", ".", "3", ".", ".", "1"),
                listOf("7", ".", ".", ".", "2", ".", ".", ".", "6"),
                listOf(".", "6", ".", ".", ".", ".", "2", "8", "."),
                listOf(".", ".", ".", "4", "1", "9", ".", ".", "5"),
                listOf(".", ".", ".", ".", "8", ".", ".", "7", "9"),
            )
        )

        inputs.onEach {
            solution(it)
        }
    }
}