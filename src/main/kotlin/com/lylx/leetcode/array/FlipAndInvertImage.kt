package com.lylx.leetcode.array

fun main(args: Array<String>) {
    print(1 and 0)
}

/**
 * 翻转图像
 *
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 * 说明:
 *     a. 1 <= A.length = A[0].length <= 20
 *     b. 0 <= A[i][j] <= 1
 */
fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
    A.forEachIndexed { outIndex, outIt ->
        val reverseArray = outIt.reversed()
        val invertArray = reverseArray.toIntArray()
        reverseArray.forEachIndexed { index, it ->
            if (it == 0) {
                invertArray[index] = 1
            } else {
                invertArray[index] = 0
            }
        }
        A[outIndex] = invertArray
    }
    return A
}

fun flipAndInvertImage2(A: Array<IntArray>): Array<IntArray> {
    A.forEachIndexed { index, it ->
        val reverseArray = it.reversed()
        A[index] = reverseArray.map {
            1 - it
        }.toIntArray()
    }
    return A
}
