package com.lylx.algorithm.search

/**
 * 二分查找
 */
fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        // 使用 left + (right - left) / 2 是避免发生整形溢出的问题，若 right 和 left 都是一个很大的数，那么 right + left 有可能会发生整型溢出
        val mid = left + (right - left) / 2
        when {
            nums[mid] == target -> return mid
            nums[mid] > target -> right = mid - 1
            else -> left = mid + 1
        }
    }
    return -1
}

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
fun searchRange(nums: IntArray, target: Int): IntArray {
    // 第一个等于 target 目标值的 index
    val firstIndex = binarySearch(nums, target, true)
    // 最后一个等于 target 目标值的 index = 第一个大于 target 目标值的 index - 1
    val lastIndex = binarySearch(nums, target, false) - 1
    return if (firstIndex <= lastIndex && lastIndex < nums.size && nums[firstIndex] == target && nums[lastIndex] == target) {
        intArrayOf(firstIndex, lastIndex)
    } else intArrayOf(-1, -1)
}

fun binarySearch(nums: IntArray, target: Int, lower: Boolean): Int {
    var left = 0
    var right = nums.size - 1
    var ans = nums.size
    while (left <= right) {
        val mid = (left + right) / 2
        if (nums[mid] > target || lower && nums[mid] >= target) {
            right = mid - 1
            ans = mid
        } else {
            left = mid + 1
        }
    }
    return ans
}

fun searchRange1(nums: IntArray, target: Int): IntArray {
    // 第一个大于等于 target 的 index
    val firstIndex = binarySearch(nums, target)
    // 第一个大于等于 target+1 的 index - 1
    val lastIndex = binarySearch(nums, target + 1) - 1
    return if (firstIndex <= lastIndex && lastIndex < nums.size && nums[firstIndex] == target && nums[lastIndex] == target) {
        intArrayOf(firstIndex, lastIndex)
    } else intArrayOf(-1, -1)
}

// 第一个大于等于目标值的 index
fun binarySearch(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    var ans = nums.size
    while (left <= right) {
        val mid = (left + right) / 2
        if (nums[mid] >= target) {
            right = mid - 1
            ans = mid
        } else {
            left = mid + 1
        }
    }
    return ans
}

fun getNumberOfTarget(nums: IntArray, target: Int): Int {
    val firstIndex = binarySearch(nums, target)
    val lastNextIndex = binarySearch(nums, target + 1)
    return if (firstIndex >= nums.size || nums[firstIndex] != target) 0 else lastNextIndex - firstIndex
}
