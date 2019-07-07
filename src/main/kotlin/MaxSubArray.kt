fun main(args: Array<String>) {
    val nums = args.map {
        it.toInt()
    }.toIntArray()
    println(maxSubArray(nums))
    print(maxSubArray(intArrayOf(1)))
}

/**
 * 最大连续子序列和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 */

/**
 * Q(n)
 */
fun maxSubArray(nums: IntArray): Int {
    var sum = nums[0]
    var max = nums[0]
    for (index in 1 until nums.size) {
        sum = if (sum > 0) {
            sum + nums[index]
        } else {
            nums[index]
        }
        if (sum > max) {
            max = sum
        }
    }
    return max
}

