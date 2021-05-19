package com.lylx.algorithm.tree

fun maxDepth(root: TreeNode?): Int {
    return root?.let { Math.max(maxDepth(root.left), maxDepth(root.right)) + 1 } ?: 0
//    return if (root == null) 0 else Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
}

fun minDepth(root: TreeNode?): Int {
    root ?: return 0
    var minDepth = Int.MAX_VALUE
    if (root.left != null) {
        minDepth = Math.min(minDepth(root.left), Int.MAX_VALUE)
    }
    if (root.right != null) {
        minDepth = Math.min(minDepth(root.right), minDepth)
    }
    return minDepth

}