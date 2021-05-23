package final_450.arrays

fun main() {
    val input = listOf(
        listOf(1, 2, 3, 4),
        listOf(9, 10, 11, 12),
        listOf(5, 6, 7, 8),
    )
    val row = input[0].lastIndex
    val column = input.lastIndex

    // print spiral
    var direction = Direction.LEFT
    var left = 0
    var right = row
    var top = 0
    var bottom = column

    while (left <= right && top <= bottom) {
        when (direction) {
            Direction.LEFT -> {
                for (index in left..right) {
                    print("${input[top][index]},")
                }
                top++
                direction = Direction.BOTTOM
            }
            Direction.BOTTOM -> {
                for (index in top..bottom) {
                    print("${input[index][right]},")
                }
                --right
                direction = Direction.RIGHT
            }
            Direction.RIGHT -> {
                for (index in right downTo left) {
                    print("${input[right][index]},")
                }
                --bottom
                direction = Direction.TOP
            }
            Direction.TOP -> {
                for (index in bottom downTo top) {
                    print("${input[index][left]},")
                }
                ++left
                direction = Direction.LEFT
            }
        }

    }

}

enum class Direction {
    LEFT,
    RIGHT,
    BOTTOM,
    TOP
}