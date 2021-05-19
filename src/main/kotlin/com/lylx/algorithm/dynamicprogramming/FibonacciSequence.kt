package com.lylx.algorithm.dynamicprogramming

fun main(args: Array<String>) {
    println(fibonacci(4))
    println(fibonacci1(4))
    println(fibonacci2(4))

//    println(climbStairs(4))
//    println(climbStairs1(4))
//    println(climbStairs2(4))
//    println(climbStairs3(4))
}

fun fibonacci(n: Int): Int {
    return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
}

fun fibonacci1(n:Int):Int{
    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 1
    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n]
}

fun fibonacci2(n:Int):Int{
    if (n<=1) return n
    var pre2 = 0
    var pre1 = 1
    for (i in 2..n) {
        val current = pre1 + pre2
        pre2 = pre1
        pre1 = current
    }
    return pre1
}

/**
 * 爬楼梯
 */
fun climbStairs(n: Int): Int {
    if (n <= 2) {
        return n
    }
    var pre2 = 1
    var pre1 = 2
    for (i in 3 until n) {
        val cur = pre1 + pre2
        pre2 = pre1
        pre1 = cur
    }
    return pre1
}

fun climbStairs1(n: Int): Int {
    return if (n <= 2) n else climbStairs1(n - 1) + climbStairs1(n - 2)
}


fun climbStairs2(n: Int): Int {
    if (n <= 2) return n
    val dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 2
    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n]
}


fun climbStairs3(n: Int): Int {
    val dp = IntArray(n + 1)
    dp[0] = 1
    dp[1] = 1
    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n]
}
