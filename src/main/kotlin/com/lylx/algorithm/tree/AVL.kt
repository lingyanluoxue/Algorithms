package com.lylx.algorithm.tree

fun isBalanced(root: TreeNode?): Boolean {
    return when {
        root == null -> true
        Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1 -> false
        else -> isBalanced(root.left) && isBalanced(root.right)
    }
}

fun treeDepth(root: TreeNode?): Int {
    return if (root == null) 0 else Math.max(treeDepth(root.left), treeDepth(root.right)) + 1
}