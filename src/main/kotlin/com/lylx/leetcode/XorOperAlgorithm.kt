package com.lylx.leetcode


fun main(args: Array<String>) {
    println(hammingDistance(1, 4))
    println(hammingDistance2(1, 4))
    println(hammingDistance3(1, 4))
}

/**
 * 汉明距离
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释: 1   (0 0 0 1)
 *      4   (0 1 0 0)
 * @param 0 ≤ x, y < 231.
 */

/**
 * 内存消耗31.3 MB
 */
fun hammingDistance(x: Int, y: Int): Int {
    // 位异或 : 只要位不同结果为1，不然结果为0
    val value = x xor  y
    // 输出一个数二进制表示的1的数量
    return Integer.bitCount(value)
}

/**
 * 内存消耗：31.6 MB
 */
fun hammingDistance2(x: Int, y: Int): Int {
    // 位异或 : 只要位不同结果为1，不然结果为0
    val value = x xor  y
    return Integer.toBinaryString(value).count {
        it.toString() == "1"
    }
}

/**
 * 内存消耗：37.3 MB
 */
fun hammingDistance3(x: Int, y: Int): Int {
    // 位异或 : 只要位不同结果为1，不然结果为0
    val value = x xor  y
    return Integer.toBinaryString(value).replace("0","").length
}



