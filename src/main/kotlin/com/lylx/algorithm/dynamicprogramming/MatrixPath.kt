package com.lylx.algorithm.dynamicprogramming


fun main(args: Array<String>) {
//    println(uniquePaths(3, 2))
//    println(uniquePaths(3, 7))
//    println(uniquePaths(7, 3))
//    println(uniquePaths(3, 3))
//    println(uniquePaths(2, 1))
//    println(uniquePaths(2, 2))

    println(minPathSum(arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))))
    println(minPathSum(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6))))
}

/**
 * 矩阵的总路径数
 */
fun uniquePaths(m: Int, n: Int): Int {
    val dp = IntArray(n){1}
    for (i in 1 until m) {
        for (j in 1 until n) {
            dp[j] = dp[j] + dp[j - 1]
        }
    }
    return dp[n - 1]
}

/**
 * 从矩阵 (m x n) 的左上角到右下角的最小路径和，每次只能向下或者向右移动一步
 */
fun minPathSum(grid: Array<IntArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) {
        return 0
    }
    val m = grid.size
    val n: Int = grid[0].size
    val dp = IntArray(n)
    for (i in 0 until m) {
        for (j in 0 until n) {
            when {
                j == 0 -> {
                    // 只能从上侧向下移动走到该位置
                    dp[j] = dp[j]
                }
                i == 0 -> {
                    // 只能从左侧向右移动走到该位置
                    dp[j] = dp[j - 1]
                }
                else -> {
                    dp[j] = Math.min(dp[j - 1], dp[j])
                }
            }
            dp[j] += grid[i][j]
        }
    }
    return dp[n - 1]
}