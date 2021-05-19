package com.lylx.algorithm.dynamicprogramming

/**
 * 给定一个整数数组 nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点
 *
 * - sums[i] 表示 nums[0] + ... + nums[i-1] 的和，即数组下标 index 为 0～i-1 的和
 * - 区间 i~j 的和，可转化为 sums[j+1] - sums[i]
 */
class NumArray(nums: IntArray) {

    private val sums: IntArray = IntArray(nums.size + 1)

    init {
        for (i in 1..nums.size) {
            sums[i] = sums[i - 1] + nums[i - 1]
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return sums[j + 1] - sums[i]
    }
}

class NumArray1(nums: IntArray) {
    private val sums: IntArray = IntArray(nums.size)

    init {
        sums[0] = nums[0]
        for (i in 1 until nums.size) {
            sums[i] = sums[i - 1] + nums[i]
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return sums[j] - if (i > 0) sums[i - 1] else 0
    }
}

/**
 * 最大连续子序列和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 */
fun maxSubArray(nums: IntArray): Int {
    val dp = IntArray(nums.size + 1)
    dp[0] = nums[0]
    var max = dp[0]
    for (i in 1 until nums.size) {
        dp[i] = nums[i] + if (dp[i - 1] > 0) dp[i - 1] else 0
        max = Math.max(max, dp[i])
    }
    return max
}

/**
 * Q(n)
 */
fun maxSubArray1(nums: IntArray): Int {
    var sum = nums[0]
    var max = nums[0]
    for (index in 1 until nums.size) {
        sum = nums[index] + if (sum > 0) sum else 0
        max = Math.max(max, sum)
    }
    return max
}

fun main(args: Array<String>) {
//    val numArray = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
//    println(numArray.sumRange(0, 2))

//    val numArray1 = NumArray1(intArrayOf(-2, 0, 3, -5, 2, -1))
//    println(numArray1.sumRange(0, 2))

    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(maxSubArray1(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))

    println(maxSubArray(intArrayOf(-100000)))
    println(maxSubArray1(intArrayOf(-100000)))

    println(maxSubArray(intArrayOf(-1)))
    println(maxSubArray1(intArrayOf(-1)))

    println(maxSubArray(intArrayOf(1)))
    println(maxSubArray1(intArrayOf(1)))

}


