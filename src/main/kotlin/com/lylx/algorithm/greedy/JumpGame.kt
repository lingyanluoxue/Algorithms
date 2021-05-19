package com.lylx.algorithm.greedy

fun canJump(A: IntArray): Boolean {
    if (A.isEmpty()) return false
    var farthest = 0
    for (i in A.indices) {
        if (i <= farthest) {
            farthest = Math.max(farthest, A[i] + i)
            if (farthest >= A.size - 1) {
                return true
            }
        }
    }
    return false
}