package com.lylx.algorithm.dynamicprogramming


fun main(args: Array<String>) {
    println(lengthOfLIS(intArrayOf(1, 3, 1)))
    println(lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)))
    println(lengthOfLIS(intArrayOf(0,1,0,3,2,3)))

    println(lengthOfLIS1(intArrayOf(1, 3, 1)))
    println(lengthOfLIS1(intArrayOf(10,9,2,5,3,7,101,18)))
    println(lengthOfLIS1(intArrayOf(0,1,0,3,2,3)))

}

/**
 * 最长递增子序列
 */
fun lengthOfLIS(nums: IntArray): Int {
    val dp = IntArray(nums.size)
    for (i in nums.indices) {
        dp[i] = 1
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1)
            }
        }
    }
    return dp.max() ?: 0
}

/**
 * 最长递增子序列
 */
fun lengthOfLIS1(nums: IntArray): Int {
    val dp = IntArray(nums.size)
    var max = 0
    for (i in nums.indices) {
        dp[i] = 1
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1)
            }
        }
        max = Math.max(max, dp[i])
    }
    return max
}

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val m = text1.length
    val n = text2.length
    val dp = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
        for (j in 1..n) {
            if (text1[i - 1] == text2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    return dp[m][n]
}