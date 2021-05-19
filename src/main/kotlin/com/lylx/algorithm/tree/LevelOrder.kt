package com.lylx.algorithm.tree

import java.util.*
import kotlin.collections.ArrayList

/**
 * BFS 广度优先搜索
 */
fun bfs(root: TreeNode?) {
    root ?: return
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    while (!queue.isEmpty()) {
        val node = queue.poll()
        print("${node.value} ")
        node.left?.let {
            queue.add(it)
        }
        node.right?.let {
            queue.add(it)
        }
    }
    println()
}

/**
 * 层次遍历
 *
 * BFS 广度优先搜索
 */
fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    root ?: return result
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val level = arrayListOf<Int>()
        for (i in queue.indices) {
            val node = queue.poll()
            level.add(node.value)
            node.left?.let {
                queue.add(it)
            }
            node.right?.let {
                queue.add(it)
            }
        }
        result.add(level)
    }
    return result
}

/**
 * Z 字遍历
 */
fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val result = LinkedList<List<Int>>()
    root ?: return result
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    var isOrderLeft = true
    while (!queue.isEmpty()) {
        val level = LinkedList<Int>()
        for (i in queue.indices) {
            val node = queue.poll()
            if (isOrderLeft) {
                level.addLast(node.value)
            } else {
                level.addFirst(node.value)
            }
            node.left?.let {
                queue.add(it)
            }
            node.right?.let {
                queue.add(it)
            }
        }
        result.add(level)
        isOrderLeft = !isOrderLeft
    }
    return result
}

/**
 * 自底向上的层次遍历
 */
fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    root ?: return result
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val level = arrayListOf<Int>()
        for (i in queue.indices) {
            val node = queue.poll()
            level.add(node.value)
            node.left?.let {
                queue.add(it)
            }
            node.right?.let {
                queue.add(it)
            }
        }
        result.add(0, level)
    }
    return result
}

/**
 * 二叉树的层平均值
 */
fun averageOfLevels(root: TreeNode?): List<Double> {
    val result = ArrayList<Double>()
    root ?: return result
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        var sum = 0.0
        val size = queue.size
        for (i in queue.indices) {
            val node = queue.poll()
            sum += node.value
            node.left?.let {
                queue.add(it)
            }
            node.right?.let {
                queue.add(it)
            }
        }
        result.add(sum/size)
    }
    return result
}

/**
 * 二叉树的右视图
 */
fun rightSideView(root: TreeNode?): List<Int> {
    val result = ArrayList<Int>()
    root ?: return result
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val node = queue.poll()
            node.left?.let {
                queue.add(it)
            }
            node.right?.let {
                queue.add(it)
            }
            if (i == size-1){
                result.add(node.value)
            }
        }
    }
    return result
}

/**
 * 找树的左下角的值
 */
fun findBottomLeftValue(root: TreeNode?): Int? {
    root?: return null
    var result = root.value
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        for (i in queue.indices) {
            val node = queue.poll()
            node.left?.let {
                queue.add(it)
            }
            node.right?.let {
                queue.add(it)
            }
            if (i == 0){
                result = node.value
            }
        }
    }
    return result
}

fun main(args: Array<String>) {
    val root = TreeNode(1)
    val left1 = TreeNode(2)
    val right1 = TreeNode(3)
    root.left = left1
    root.right = right1
    val left11 = TreeNode(4)
    val left12 = TreeNode(5)
    val left21 = TreeNode(8)
    left1.left = left11
    left1.right = left12
    left11.left = left21
    val right11 = TreeNode(6)
    val right12 = TreeNode(7)
    right1.left = right11
    right1.right = right12
//    bfs(root)

    val root1 = TreeNode(3)
    val node1 = TreeNode(9)
    val node2 = TreeNode(20)
    root1.left = node1
    root1.right = node2
    val node21 = TreeNode(15)
    val node22 = TreeNode(7)
    node2.left = node21
    node2.right = node22

    println(levelOrder(root1))
    println(levelOrder(root))
    println(zigzagLevelOrder(root1))
    println(zigzagLevelOrder(root))
    println(levelOrderBottom(root1))
    println(averageOfLevels(root1))
    println(rightSideView(root1))
    println(rightSideView(root))
    println(findBottomLeftValue(root1))
    println(findBottomLeftValue(root))
}
