package leetcode

fun runningSum(nums: IntArray): IntArray {
    var currentSum = 0
    for (index in nums.indices) {
        currentSum += nums[index]
        nums[index] = currentSum
    }
    return nums
}


