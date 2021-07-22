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
                (left..right).forEach { print("${input[top][it]},") }
                top++
                direction = Direction.BOTTOM
            }
            Direction.BOTTOM -> {
                (top..bottom).forEach { print("${input[it][right]},") }
                --right
                direction = Direction.RIGHT
            }
            Direction.RIGHT -> {
                (right downTo left).forEach { print("${input[right][it]},") }
                --bottom
                direction = Direction.TOP
            }
            Direction.TOP -> {
                (bottom downTo top).forEach { print("${input[left][it]},") }
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
