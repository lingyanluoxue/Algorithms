package com.lylx.algorithm.tree

fun invertTree(root: TreeNode?): TreeNode? {
    root ?: return null
    val left = root.left
    root.left = invertTree(root.right)
    root.right = invertTree(left)
    return root
}