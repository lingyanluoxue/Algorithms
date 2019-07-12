package com.lylx.leetcode

fun main(args: Array<String>) {
//    val result = twoSum(intArrayOf(2, 7, 11, 15), 9)
    val result = twoSum(intArrayOf(3, 2, 4), 6)
    println("[${result[0]},${result[1]}]")

    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
}

/**
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 返回 [0, 1] ：因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    var firstIndex = -1
    var secondIndex = -1
    loop@ for (i in 0 until nums.size) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                firstIndex = i
                secondIndex = j
                break@loop
            }
        }
    }
    return intArrayOf(firstIndex, secondIndex)
}

/**
 * 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ?
 * 找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]
 * 满足要求的三元组集合为：[[-1, -1, 2]，[-1, 0, 1]]
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    val result = arrayListOf<List<Int>>()
    val sortedNums = nums.sorted()
    val size = sortedNums.size
    for (i in 0 until size - 2) {
        if (sortedNums[i] > 0) break
        if (i > 0 && sortedNums[i] == sortedNums[i - 1]) continue
        var left = i + 1
        var right = size - 1
        while (left < right) {
            val sum = sortedNums[i] + sortedNums[left] + sortedNums[right]
            when {
                sum == 0 -> {
                    result.add(arrayListOf(sortedNums[i], sortedNums[left], sortedNums[right]))
                    while (left < right && sortedNums[left] == sortedNums[left + 1]) left++
                    while (left < right && sortedNums[right] == sortedNums[right - 1]) right--
                    left++
                    right--
                }
                sum > 0 -> {
                    while (left < right && sortedNums[right] == sortedNums[right - 1]) right--
                    right--
                }
                sum < 0 -> {
                    while (left < right && sortedNums[left] == sortedNums[left + 1]) left++
                    left++
                }
            }
        }
    }
    return result
}