class Node<T>(var data: T, var left: Node<T>? = null, var right: Node<T>? = null)

fun main() {
    listOf(1, 2, 3, 4, 5, 6).map { it % 2 }.also(::println)
}

// item => i , left ==> 2i right ==> 2i+1

//fun <T> treeOf(vararg nodes: T) {
//    var current: Node<T>? = null
//    nodes.forEachIndexed { index, item ->
//        if (current == null) {
//            current = Node(item)
//        } else {
//            current.left = Node(nodes.getOrNull(2 * index) ?: -1)
//            current.right = Node(nodes.getOrNull(2 * index + 1) ?: -1)
//        }
//    }
//}
