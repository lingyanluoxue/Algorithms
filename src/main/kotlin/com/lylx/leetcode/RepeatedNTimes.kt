package com.lylx.leetcode

fun main(args: Array<String>) {
    println(repeatedNTimes(intArrayOf(1,2,3,3)))
    println(repeatedNTimes(intArrayOf(2,1,2,5,3,2)))
    println(repeatedNTimes(intArrayOf(5,1,5,2,5,3,5,4)))
    println(repeatedNTimes2(intArrayOf(1,2,3,3)))
    println(repeatedNTimes2(intArrayOf(2,1,2,5,3,2)))
    println(repeatedNTimes2(intArrayOf(5,1,5,2,5,3,5,4)))
}

/**
 * 重复 N 次的元素
 *
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。返回重复了 N 次的那个元素。
 *
 * 输入：[1,2,3,3]
 * 输出：3
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 *
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *
 * 提示：
 *     a. 4 <= A.length <= 10000
 *     b. 0 <= A[i] < 10000
 *     c. A.length 为偶数
 */
fun repeatedNTimes(A: IntArray): Int {
    val map = hashMapOf<Int, Int>()
    val n = A.size / 2
    A.forEach {
        val count = map[it]
        map.put(it, (count ?: 0) + 1)
    }
    return map.filter {
        it.value == n
    }.keys.first()
}

fun repeatedNTimes2(A: IntArray): Int {
    val array = arrayListOf<Int>()
    A.forEach {
        if (array.contains(it)){
            return it
        }else{
            array.add(it)
        }
    }
    return -1
}