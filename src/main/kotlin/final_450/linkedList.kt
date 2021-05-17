package final_450

data class Node<T>(var data: T, var next: Node<T>? = null)

class LinkedList<T> {

    var _node: Node<T>? = null
        private set

    private fun isEmpty() = _node == null
    private fun isSizeOne(): Boolean {
        val first = _node
        val second = first?.next
        return second == null
    }

    fun createCircularLinkedList(first: T, vararg others: T) {
        val head: Node<T> = Node(first)
        var current: Node<T>? = head
        others.forEach { item ->
            current?.next = Node(item)
            current = current?.next
        }
        current?.next = head
        _node = head
    }

    val valueCircleLL: List<T?>
        get() {
            //---- print
            val cHead = _node
            var curr = cHead
            var collector = mutableListOf<T?>()
            do {
                collector.add(curr?.data)
                curr = curr?.next
            } while (curr != cHead)
            return collector.toList()
        }

    fun insertAtTailOrHeadCircular(data: T) {
        val node = Node(data)
        val head = _node
        var current: Node<T>? = head
        while (current?.next != head) {
            current = current?.next
        }
        current?.next = node
        node.next = head
    }


    fun createCyclic(cyclePos: Int, vararg values: T) {
//        _node = values.map { Node(it) }
//            .zipWithNext { current, next ->
//                current.next = next
//                current
//            }
//            .toList()
//            .apply { last().next = getOrNull(cyclePos) }
//            .first()


        val nodes = values.map {
            Node(it)
        }
        nodes.forEachIndexed { index, node ->
            if (index < nodes.lastIndex) {
                node.next = nodes[index + 1]
            }
        }
        nodes.last().next = nodes.getOrNull(cyclePos)
        _node = nodes.get(0)
    }

    fun add(first: T, vararg others: T) {

        if (isEmpty()) {
            _node = Node(data = first)
        }

        if (others.isEmpty()) {
            return
        }

        var current = _node
        others.forEach { item ->
            val node = Node(item)
            current?.next = node
            current = current?.next
        }
    }

    val values: List<T>
        get() {
            val collector = mutableListOf<T>()
            var current = _node
            while (current != null) {
                collector.add(current.data)
                current = current.next
            }
            return collector.toList()
        }


    fun reverse(): List<T> {
        if (isEmpty()) {
            return emptyList()
        }

        if (isSizeOne()) {
            return listOf(_node!!.data)
        }

        var prev: Node<T>? = null
        var current: Node<T>? = _node

        while (current != null) {
            // hold next reference
            val next = current.next

            // break link to next
            current.next = null

            // point current to previous
            current.next = prev

            // previous pointer point to the address of current node
            // we can directly use that to assign previous
            prev = current

            // proceed loop
            current = next
        }
        _node = prev
        return values
    }

    fun reverseK(): List<T> {

        fun reverse(node: Node<T>?, k: Int): Node<T>? {
            var tail: Node<T>? = null
            var current: Node<T>? = node
            var next: Node<T>? = null
            var iterations = 0
            while (current != null && iterations < k) {
                next = current.next
                current.next = null
                current.next = tail
                tail = current
                current = next
                ++iterations
            }

            if (next != null) {
                _node?.next = reverse(next, k)
            }

            return tail
        }

        reverse(_node, 2)

        return values
    }

    fun loopStart(): T? {
        var slow = _node
        var fast = _node
        while (fast?.next != null) {
            fast = fast?.next?.next
            slow = slow?.next
            if (fast == slow) {
                break
            }
        }
        fast = _node
        while (fast?.next != slow?.next) {
            fast = fast?.next
            slow = slow?.next
        }
        return slow?.next?.data
    }

    fun breakCycle() {
        var slow = _node
        var fast = _node
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
            if (slow == fast) {
                break
            }
        }
        fast = _node
        while (fast?.next != slow?.next) {
            fast = fast?.next
            slow = slow?.next
        }
        slow?.next = null
    }

    val isCyclic: Boolean
        get() {
            if (isEmpty() || isSizeOne()) return false

            var slow = _node
            var fast = _node?.next?.next
            while (fast?.next != null) {
                slow = slow?.next
                fast = fast?.next?.next
                if (slow == fast) {
                    return true
                }
            }
            return false
        }


    fun removeDuplicateSorted() {
        var current = _node
        while (current != null) {
            var next = current.next
            if (next?.data == current.data) {
                current.next = next?.next
            } else {
                current = current.next
            }
        }
    }

    fun circularTwoEquals() {
        var slow = _node
        var fast = _node
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        fast = _node
        while (fast != slow) {
            slow = slow?.next
            fast = fast?.next
        }
//        val end = slow
//        val middle = slow?.next
//        val nextToMiddle = middle?.next
//
//        middle?.next = _node
//        end?.next = nextToMiddle
//
//        val first = _node
//        val second = end
//

        val end = slow
        val middle = slow?.next
        val nextToMiddle = middle?.next

        val first = mutableListOf<T?>()
        var firstCurrent = _node
        while (firstCurrent != nextToMiddle) {
            first.add(firstCurrent?.data)
            firstCurrent = firstCurrent?.next
        }

        val second = mutableListOf<T?>()
        var secondCurrent = nextToMiddle
        while (firstCurrent != end) {
            second.add(secondCurrent?.data)
            secondCurrent = secondCurrent?.next
        }

        println(first)
        println(second)

    }

    fun swapHeadAndTail() {
        var current = _node
        var previous: Node<T>? = null
        while (current?.next != null) {
            previous = current
            current = current.next
        }
        val other = _node?.next
        val head = current
        val tail = _node
        tail?.next = null

        previous?.next = tail
        head?.next = other
        _node = head
    }

    fun middle(): Node<T>? {
        var slow = _node
        var fast = _node
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        return slow
    }
}

fun LinkedList<Int>.addOne(): List<Int> {

    var current = this._node
    var prev: Node<Int>? = null

    reverse()

    val reversed = this._node
    current = reversed
    var addInNext = true
    while (current != null) {
        if (current.data < 9 && addInNext) {
            current.data += 1
            addInNext = false
        } else {
            current.data = 0
            addInNext = true
        }
        current = current.next
    }

    if (addInNext) {
        reversed?.next = Node(1)
        addInNext = false
    }

    reverse()

    val collector = mutableListOf<Int>()
    current = prev
    while (current != null) {
        collector.add(current.data)
        current = current.next
    }
    return collector.toList()
}

fun <T> linkedListOf(first: T, vararg others: T) = LinkedList<T>().apply {
    add(first, *others)
}

fun <T> cyclicLinkedListOf(cyclePos: Int, vararg items: T) = LinkedList<T>().apply {
    createCyclic(cyclePos, *items)
}

fun <T> circularLinkedListOf(first: T, vararg items: T) = LinkedList<T>().apply {
    createCircularLinkedList(first, *items)
}


fun main() {
    val list = linkedListOf(1, 2, 3, 4, 5)
    println(list.values)

    val reversed = list.reverse()
    println(reversed)

    val reversedK = list.reverseK()
    println(reversedK)

    println(list.isCyclic)

    val listCylic = cyclicLinkedListOf(cyclePos = 3, items = arrayOf(1, 2, 3, 4, 5))
    val listNonCylic = cyclicLinkedListOf(cyclePos = -1, items = arrayOf(1, 2, 3, 4, 5))
    println(listCylic.isCyclic)
    println(listNonCylic.isCyclic)

    println("--- breakcycle---")
    println(listCylic.isCyclic)
    println(listCylic.breakCycle())
    println(listCylic.isCyclic)
    println(listCylic.values)

    val listCylic2 = cyclicLinkedListOf(cyclePos = 3, items = arrayOf(1, 2, 3, 4, 5))
    println(listCylic2.loopStart())

    val sortedLinkedList = linkedListOf(1, 1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 6, 6)
    sortedLinkedList.removeDuplicateSorted()
    println(sortedLinkedList.values)

    sortedLinkedList.swapHeadAndTail()
    println(sortedLinkedList.values)

    val addList1 = linkedListOf(1, 2, 3)
    val addList2 = linkedListOf(1, 2, 9)
    val addList3 = linkedListOf(1, 9, 9)
    val addList4 = linkedListOf(9, 9, 9)
    println(addList1.addOne())
    println(addList2.addOne())
    println(addList3.addOne())
    println(addList4.addOne())

    val listMiddle = linkedListOf(1, 2, 3, 4)
    println(listMiddle.middle())

    val circleList = circularLinkedListOf(1, 2, 3, 4, 5)
    println(circleList.valueCircleLL)
    circleList.insertAtTailOrHeadCircular(6)
    println(circleList.valueCircleLL)

    val splitTwoCircleList = circularLinkedListOf(1,2,3,4,5)
    splitTwoCircleList.circularTwoEquals()
}