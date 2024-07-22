package `2`.neetcode.neetcode150


private fun main() {
    with(NeetCode150.Hashing) {
        validateSudoku()
    }

    with(NeetCode150.TwoPointers) {
        trappingWater()
    }
}

private object NeetCode150 {
    object Hashing {
        fun validateSudoku() {
            //https://leetcode.com/problems/valid-sudoku/description/

            fun solution(input: List<List<String>>) {
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

    object TwoPointers {
        fun trappingWater() {

            fun solution1(input: List<Int>) {
                val leftMax = Array(input.size) { 0 }
                val rightMax = Array(input.size) { 0 }

                var max = 0
                for (index in 0..input.lastIndex) {
                    max = maxOf(max, input.get(index))
                    leftMax.set(index, max)
                }

                max = 0
                for (index in input.lastIndex downTo 0) {
                    max = maxOf(max, input.get(index))
                    rightMax.set(index, max)
                }

                val boundary = (0..input.lastIndex).map {
                    minOf(leftMax.get(it), rightMax.get(it))
                }

                val waterTrapped = input.mapIndexed { index, height ->
                    maxOf(boundary.get(index) - height, 0)
                }.sum()

                println("soln1 | input $input, water trapped $waterTrapped")
            }

            fun solution2(heights: List<Int>) {
                var start = 0
                var end = heights.lastIndex
                var leftMax = heights.get(start)
                var rightMax = heights.get(end)
                val waterTrapped = mutableListOf<Int>()
                while (start < end) {
                    if (leftMax <= rightMax) {
                        start += 1
                        leftMax = maxOf(leftMax, heights.get(start))
                        waterTrapped += maxOf(0, leftMax - heights.get(start))
                    } else {
                        end -= 1
                        rightMax = maxOf(rightMax, heights.get(end))
                        waterTrapped += maxOf(0, rightMax - heights.get(end))
                    }
                }
                println("soln2 | input $heights , water trapped ${waterTrapped.sum()}")
            }

            val inputs = listOf(
                listOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1),//6
                listOf(4, 2, 0, 3, 2, 5)//9
            )

            inputs
                .onEach { solution1(it) }
                .onEach { solution2(it) }

        }
    }
}