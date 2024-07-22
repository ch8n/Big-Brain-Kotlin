package `2`.neetcode.blind75


private fun main() {
    val neetCodeBlind75 = NeetCodeBlind75()
    with(neetCodeBlind75) {
        containDuplicate()
        isAnagram()
        twoSum()
        groupAnagram()
        topKFrequent()
        encodeDecode()
        productOfSelf()
    }
}


private class NeetCodeBlind75() {

    fun containDuplicate() {
        // https://leetcode.com/problems/contains-duplicate/description/

        fun solution(input: List<Int>) {
            val isContainingDuplicate = input.toSet().size != input.size
            println("input $input | isContainingDuplicate $isContainingDuplicate")
        }

        val inputs = listOf(
            listOf(1, 2, 3, 1),
            listOf(1, 2, 3, 4),
            listOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2),
        )

        inputs.onEach { solution(it) }
    }

    fun isAnagram() {
        //https://leetcode.com/problems/valid-anagram/description/
        fun solution(input1: String, input2: String) {
            val chars = Array(256) { 0 }
            input1.onEach {
                val count = chars.get(it.code)
                chars.set(it.code, count + 1)
            }

            input2.onEach {
                val count = chars.get(it.code)
                chars.set(it.code, count - 1)
            }

            val isAnagram = chars.all { it == 0 }
            println("inputs $input1, $input2 | isAnagram:$isAnagram")
        }

        val inputs = listOf(
            listOf("anagram", "nagaram"),
            listOf("rat", "car")
        )

        inputs.onEach {
            solution(it.get(0), it.get(1))
        }
    }

    fun twoSum() {
        //https://leetcode.com/problems/two-sum/

        fun solution(input: List<Int>, target: Int) {
            val acc = hashMapOf<Int, Int>()
            val result = mutableListOf<Int>()
            input.onEachIndexed() { index, first ->
                val other = target - first
                val otherIndex = acc.get(other) ?: -1
                if (otherIndex != -1) {
                    result.add(index)
                    result.add(otherIndex)
                    return@onEachIndexed
                }
                acc.put(first, index)
            }
            println("input : $input - target $target result $result")
        }

        val inputs = listOf(
            listOf(3, 4, 5, 6) to 7,
            listOf(4, 5, 6) to 10,
            listOf(5, 5) to 10,
            listOf(2, 7, 11, 15) to 9,
            listOf(3, 2, 4) to 6,
            listOf(3, 3) to 6
        )

        inputs.onEach { (input, target) ->
            solution(input, target)
        }
    }

    fun groupAnagram() {
        //https://leetcode.com/problems/group-anagrams/description/
        fun solution(input: List<String>) {
            val result = input
                .groupBy { it.toCharArray().sorted() }
                .values
            println("input:$input \n result:$result")
        }

        val inputs = listOf(
            listOf("eat", "tea", "tan", "ate", "nat", "bat"),
            listOf(""),
            listOf("a")
        )

        inputs.onEach {
            solution(it)
        }
    }

    fun topKFrequent() {
        //https://leetcode.com/problems/top-k-frequent-elements/description/
        fun solution(input: List<Int>, target: Int) {
            val bucket = Array(input.size + 1) { 0 }
            val groups = input.groupBy { it }
            groups.onEach { (num, count) ->
                bucket.set(count.size, num)
            }
            val result = bucket.filter { it != 0 }.takeLast(target)
            println("input:$input topK:$target = $result")
        }


        val inputs = listOf(
            listOf(1, 1, 1, 2, 2, 3) to 2,
            listOf(1) to 1
        )

        inputs.onEach { (input, target) ->
            solution(input, target)
        }
    }

    fun encodeDecode() {
        fun solution(input: List<String>) {
            val encode = input.joinToString("%20")
            val decode = encode.split("%20")
            println("encoded $encode -> decoded $decode")
        }

        val input = listOf(
            listOf("neet", "code", "love", "you"),
            listOf("we", "say", ":", "yes")
        )
        input.onEach { solution(it) }
    }

    fun productOfSelf() {

        fun solution(input: List<Int>) {

            val pre = Array(input.size) { 0 }
            var current = 1
            for (index in 0..input.lastIndex) {
                current *= input.get(index)
                pre.set(index, current)
            }


            val post = Array(input.size) { 0 }
            current = 1
            for (index in input.lastIndex downTo 0) {
                current *= input.get(index)
                post.set(index, current)
            }

            val result = Array(input.size) { 0 }
            for (index in 0..result.lastIndex) {
                val prev = pre.getOrNull(index - 1) ?: 1
                val next = post.getOrNull(index + 1) ?: 1
                val product = prev * next
                result.set(index, product)
            }

            println("input:$input selfProduct:${result.joinToString()}")
        }

        val inputs = listOf(
            listOf(1, 2, 3, 4),
            listOf(-1, 1, 0, -3, 3),
        )

        inputs.onEach {
            solution(it)
        }
    }

    fun longestSequence() {

    }


}