package `2`.neetcode.blind75


private fun main() {
    with(NeetCodeBlind75.Hashing) {
        containDuplicate()
        isAnagram()
        twoSum()
        groupAnagram()
        topKFrequent()
        encodeDecode()
        productOfSelf()
        longestSequence()
    }

    with(NeetCodeBlind75.TwoPointer) {
        validatePalindrome()
        threeSumToZero()
        containMostWater()
    }

    with(NeetCodeBlind75.SlidingWindow) {
        buyAndSellStock()
        longestSubStringWithoutRepeat()
        longestRepeatingCharacterReplacement()
    }
}


private object NeetCodeBlind75 {

    object Hashing {
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
            //https://leetcode.com/problems/longest-consecutive-sequence/description/
            fun solution(input: List<Int>) {
                val itemIndexed = buildMap {
                    input.onEachIndexed { index, item -> put(item, index) }
                }
                var maxCount = 0
                input.onEach { entry ->
                    val prev = entry - 1
                    if (itemIndexed.containsKey(prev)) return@onEach
                    var current = entry
                    var count = 0
                    while (itemIndexed.containsKey(current)) {
                        count += 1
                        current += 1
                    }
                    maxCount = maxOf(maxCount, count)
                }

                println("input $input, longestSequenceCount $maxCount")
            }

            val inputs = listOf(
                listOf(100, 4, 200, 1, 3, 2),
                listOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1),
            )
            inputs.onEach {
                solution(it)
            }
        }
    }

    object TwoPointer {

        fun validatePalindrome() {
            //https://leetcode.com/problems/valid-palindrome/description/

            fun solution(input: String) {
                val normalized = input.lowercase().filter { it.isLetterOrDigit() }
                val reversed = normalized.reversed()
                val isPalindrome = normalized == reversed
                println("input $input isPalindrome? $isPalindrome")
            }

            val inputs = listOf(
                "A man, a plan, a canal: Panama",
                "race a car",
                " "
            )

            inputs.onEach { solution(it) }
        }

        fun threeSumToZero() {
            //https://leetcode.com/problems/3sum/description/
            fun solution(input: List<Int>) {

                val sorted = input.sorted()
                val result = mutableListOf<Triple<Int, Int, Int>>()
                sorted.onEachIndexed { firstIndex, first ->
                    val prev = sorted.getOrNull(firstIndex - 1)
                    if (prev == first) return@onEachIndexed

                    var start = firstIndex + 1
                    var end = sorted.lastIndex

                    while (start < end) {
                        val second = sorted.get(start)
                        val third = sorted.get(end)
                        val sum = first + second + third
                        println("sum $sum start:$start end:$end")
                        when {
                            sum > 0 -> end -= 1
                            sum < 0 -> start += 1
                            else -> {
                                result.add(Triple(first, second, third))
                                var current = sorted.get(start)
                                while (current == second && start < end) {
                                    start += 1
                                    current = sorted.get(start)
                                }

                                current = sorted.get(end)
                                while (current == third && start < end) {
                                    end -= 1
                                    current = sorted.get(end)
                                }
                            }
                        }
                    }
                }

                println("input $input -> sumToZeros@:$result")
            }

            val input = listOf(
                listOf(-1, 0, 1, 2, -1, -4),
                listOf(0, 1, 1),
                listOf(0, 0, 0)
            )

            input.onEach { solution(it) }
        }

        fun containMostWater() {
            // https://leetcode.com/problems/container-with-most-water/description/

            fun solution(input: List<Int>) {
                var start = 0
                var end = input.lastIndex
                var maxArea = 0
                while (start < end) {
                    val tower1 = input.get(start)
                    val tower2 = input.get(end)
                    val length = minOf(tower1, tower2)
                    val breath = end - start
                    val area = length * breath
                    maxArea = maxOf(maxArea, area)
                    if (tower1 > tower2) {
                        end -= 1
                    } else {
                        start += 1
                    }
                }

                println("towers: $input, maxArea: $maxArea")
            }

            val inputs = listOf(
                listOf(1, 8, 6, 2, 5, 4, 8, 3, 7), // 49
                listOf(1, 1), // 1
                listOf(1, 7, 2, 5, 4, 7, 3, 6), // 36
                listOf(2, 2, 2) //4
            )

            inputs.onEach { solution(it) }
        }
    }

    object SlidingWindow {

        fun buyAndSellStock() {
            //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

            fun solution(input: List<Int>) {
                var buy = 0
                var sell = buy + 1

                var maxProfit = 0
                while (sell < input.lastIndex) {
                    val buyValue = input.get(buy)
                    val sellValue = input.get(sell)
                    val profit = maxOf(sellValue - buyValue, 0)
                    maxProfit = maxOf(maxProfit, profit)
                    if (buyValue > sellValue) {
                        buy += 1
                        sell = buy + 1
                    } else {
                        sell += 1
                    }
                }

                println("input $input, maxProfit $maxProfit")
            }

            val inputs = listOf(
                listOf(7, 1, 5, 3, 6, 4),//5
                listOf(7, 6, 4, 3, 1),//0
            )
            inputs.onEach { solution(it) }
        }

        fun longestSubStringWithoutRepeat() {
            // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

            fun solution(input: String) {
                //abcabcbb
                val charIndex = hashMapOf<Char, Int>()
                var start = 0
                var length = 0
                for (index in 0..input.lastIndex) {
                    val char = input.get(index)
                    if (charIndex.containsKey(char)) {
                        val charIndex = charIndex.get(char) ?: -1
                        start = maxOf(charIndex + 1, start)
                    }

                    charIndex.put(char, index)
                    length = maxOf(length, index - start + 1)
                }
                println("input $input, noRepeatSubStringLength->$length")
            }

            val inputs = listOf(
                "abcabcbb", // 3
                "bbbbb", // 1
                "pwwkew", // 3
            )

            inputs.onEach { solution(it) }
        }

        fun longestRepeatingCharacterReplacement() {
            // https://leetcode.com/problems/longest-repeating-character-replacement/description/

            fun solution(input: String, limit: Int) {
                val countMap = hashMapOf<Char, Int>()
                var countStartIndex = 0

                var maxFrequency = 0
                var maxLength = 0

                for ((currentIndex, currentChar) in input.withIndex()) {

                    val count = countMap.getOrDefault(currentChar, 0)
                    countMap.put(currentChar, count + 1)
                    maxFrequency = maxOf(maxFrequency, count + 1)

                    val windowLength = currentIndex - countStartIndex + 1
                    if (windowLength - maxFrequency > limit) {
                        val countStartChar = input.get(countStartIndex)
                        val charCount = countMap.get(countStartChar) ?: 0
                        countMap.put(countStartChar, charCount - 1)
                        countStartIndex += 1
                    }

                    maxLength = maxOf(maxLength, windowLength)
                }

                println("$input | $limit -> $maxLength")
            }

            val input = listOf(
                "ABAB" to 2,
                "AABABBA" to 1,
            )

            input.onEach { solution(it.first, it.second) }
        }
    }
}