package com.lylx.algorithm.tree


/**
 * 验证二叉搜索树
 */
fun isValidBST(root: TreeNode?): Boolean {
    return isValidBST(root, Int.MIN_VALUE, Int.MAX_VALUE);
}

fun isValidBST(node: TreeNode?, lower: Int, upper: Int): Boolean {
    return when {
        node == null -> true
        node.value <= lower || node.value >= upper -> false
        else -> isValidBST(node.left, lower, node.value) && isValidBST(node.right, node.value, upper)
    }
}
