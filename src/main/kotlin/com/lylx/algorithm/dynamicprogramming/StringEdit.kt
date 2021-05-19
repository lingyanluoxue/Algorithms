package com.lylx.algorithm.dynamicprogramming

import kotlin.math.sqrt

fun main(args: Array<String>) {
//    println(minSteps(2))
//    println(minSteps(3))
//    println(minSteps(6))
//    println(minSteps(10))

//    println(minDistance("horse", "ros"))
//    println(minDistance("intention", "execution"))

//    println(numDistinct("rabbbit", "rabbit"))
//    println(numDistinct("babgbag", "bag"))
//    println(numDistinct("babgbag", ""))
//    println(numDistinct("", ""))
//    println(numDistinct("", "hhh"))

    println(minEditCost("abc", "adc", 5, 3, 2))
    println(minEditCost("abc", "adc", 5, 3, 100))
    println(minEditCost("abc", "", 5, 3, 100))
    println(minEditCost("", "abc", 5, 3, 100))
}


/**
 * 最初只有一个字符 'A'，给定一个数字 n，计算出得到 n 个 'A' 使用最少的操作次数，可执行的两种操作：
 * - Copy All (复制全部) : 可复制当前的所有字符(部分的复制是不允许的)
 * - Paste (粘贴) : 可粘贴你上一次复制的字符
 */
fun minSteps(n: Int): Int {
//    if (n == 1) return 0
//    var i = 2
//    while (i <= sqrt(n.toDouble())) {
//        if (n % i == 0) return i + minSteps(n / i)
//        i++
//    }
//    return n

    if (n == 1) return 0
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return i + minSteps(n / i)
    }
    return n
}

/**
 * 编辑距离
 */
fun minDistance(word1: String?, word2: String?): Int {
    if (word1 == null || word2 == null) {
        return 0
    }
    val m = word1.length
    val n = word2.length
    val dp = Array(m + 1) { IntArray(n + 1) }
    // 一个字符串为空串时，编辑次数显然为另一个字符串的长度
    // word2 为空，编辑次数为 word1 的长度；word1 为空，编辑次数为 word2 的长度
    for (i in 1..m) {
        dp[i][0] = i
    }
    for (i in 1..n) {
        dp[0][i] = i
    }
    for (i in 1..m) {
        for (j in 1..n) {
            dp[i][j] = if (word1[i - 1] == word2[j - 1]) {
                // 当前字符相等，则当前字符不需要修改，问题变为求解更短一个字符的子串的编辑次数
                dp[i - 1][j - 1]
            } else {
                // 当前字符不相等，则最小步数为1 + （插入、删除、替换三个操作前的最小步数）
                // insert = dp[i][j - 1]; delete = dp[i - 1][j]; replace = dp[i - 1][j - 1];
                Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1
            }
        }
    }
    return dp[m][n]
}

/**
 * 最小编辑代价
 */
fun minEditCost(str1: String?, str2: String?, ic: Int, dc: Int, rc: Int): Int {
    if (str1 == null || str2 == null) {
        return 0
    }
    val m = str1.length
    val n = str2.length
    val dp = Array(m + 1) { IntArray(n + 1) }
    // 一个字符串为空串时，编辑代价显然为另一个字符串的长度 * 操作代价
    // word2 为空，编辑代价为 word1 的长度 * dc；word1 为空，编辑次数为 word2 的长度 * ic
    for (i in 1..m) {
        dp[i][0] = i * dc
    }
    for (i in 1..n) {
        dp[0][i] = i * ic
    }
    for (i in 1..m) {
        for (j in 1..n) {
            dp[i][j] = if (str1[i - 1] == str2[j - 1]) {
                // 当前字符相等，则当前字符不需要修改，问题变为求解更短一个字符的子串的编辑代价
                dp[i - 1][j - 1]
            } else {
                // 当前字符不相等，则最小编辑代价为（插入、删除、替换三个操作的最小编辑代价）
                // insert = dp[i][j - 1]; delete = dp[i - 1][j]; replace = dp[i - 1][j - 1];
                // insertCost = dp[i][j - 1] + ic; deleteCost = dp[i - 1][j] + dc; replaceCost = dp[i - 1][j - 1] + rc;
                Math.min(dp[i - 1][j - 1] + rc, Math.min(dp[i][j - 1] + ic, dp[i - 1][j] + dc))
            }
        }
    }
    return dp[m][n]
}

/**
 * 不同的子序列
 */
fun numDistinct(s: String, t: String): Int {
    val dp = Array(s.length + 1) { IntArray(t.length + 1) }
    for (i in 0..s.length) {
        dp[i][0] = 1
    }
    for (i in 1..s.length) {
        for (j in 1..t.length) {
            if (s[i - 1] == t[j - 1]) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]
            } else {
                dp[i][j] = dp[i - 1][j]
            }
        }
    }
    return dp[s.length][t.length]
}
