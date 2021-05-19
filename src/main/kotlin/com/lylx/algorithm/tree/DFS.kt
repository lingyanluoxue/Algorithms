package com.lylx.algorithm.tree

import java.util.*

/**
 * DFS 深度优先搜索
 *
 * 递归：隐含使用系统的栈
 */
fun dfs(root: TreeNode?) {
    root ?: return
    print("${root.value} ")
    dfs(root.left)
    dfs(root.right)
}

/**
 * DFS 深度优先搜索
 *
 * 栈
 */
fun dfsByStack(root: TreeNode?) {
    root ?: return
    val stack = Stack<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()) {
        val node = stack.pop()
        print("${node.value} ")
        node.right?.let {
            stack.push(it)
        }
        node.left?.let {
            stack.push(it)
        }
    }
    println()
}

fun preTraverse(root: TreeNode?) {
    root ?: return
    println(root.value)
    preTraverse(root.left)
    preTraverse(root.right)
}

fun inTraverse(root: TreeNode?) {
    root ?: return
    preTraverse(root.left)
    println(root.value)
    preTraverse(root.right)
}

fun postTraverse(root: TreeNode?) {
    root ?: return
    preTraverse(root.left)
    println(root.value)
    preTraverse(root.right)
}

fun preorderTraversal(root: TreeNode?): List<Int> {
    val result = arrayListOf<Int>()
    preOrder(root, result)
    return result
}

private fun preOrder(root: TreeNode?, result: ArrayList<Int>) {
    root ?: return
    result.add(root.value)
    preOrder(root.left, result)
    preOrder(root.right, result)
}

fun preorderTraversal1(root: TreeNode?): List<Int> {
    val result: MutableList<Int> = ArrayList()
    root ?: return result
    val stack = Stack<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()) {
        val node = stack.pop() ?: continue
        result.add(node.value)
        // 先右后左，保证左子树先遍历
        stack.push(node.right)
        stack.push(node.left)
    }
    return result
}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = arrayListOf<Int>()
    inOrder(root, result)
    return result
}

private fun inOrder(root: TreeNode?, result: ArrayList<Int>) {
    root ?: return
    inOrder(root.left, result)
    result.add(root.value)
    inOrder(root.right, result)
}

fun inorderTraversal1(root: TreeNode?): List<Int> {
    val result: MutableList<Int> = ArrayList()
    root ?: return result
    val stack = Stack<TreeNode>()
    var curNode: TreeNode? = root
    while (stack.isNotEmpty() || curNode != null) {
        while (curNode != null) {
            stack.push(curNode)
            curNode = curNode.left
        }
        val node = stack.pop()
        result.add(node.value)
        curNode = node.right
    }
    return result
}

fun postorderTraversal(root: TreeNode?): List<Int> {
    val result = arrayListOf<Int>()
    postOrder(root, result)
    return result
}

private fun postOrder(root: TreeNode?, result: ArrayList<Int>) {
    root ?: return
    postOrder(root.left, result)
    postOrder(root.right, result)
    result.add(root.value)
}

fun postorderTraversal1(root: TreeNode?): List<Int> {
    val result = LinkedList<Int>()
    root ?: return result
    val stack = LinkedList<TreeNode>()
    stack.addFirst(root)
    while (!stack.isEmpty()) {
        val node = stack.removeFirst()
        result.addFirst(node.value)
        node.left?.let {
            stack.addFirst(it)
        }
        node.right?.let {
            stack.addFirst(it)
        }
    }
    return result
}

