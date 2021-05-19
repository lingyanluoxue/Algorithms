package com.lylx.algorithm.linklist


/**
 *  两个链表的第一个公共节点
 */
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var node1 = headA
    var node2 = headB
    while (node1 != node2) {
        node1 = if (node1 == null) headB else node1.next
        node2 = if (node2 == null) headA else node2.next
    }
    return node1
}


fun main(args: Array<String>) {
    val node1 = ListNode(7)
    val node2 = ListNode(9)
    val node3 = ListNode(1)
    val node4 = ListNode(6)
    val node5 = ListNode(8)
    val node6 = ListNode(4)
    val node7 = ListNode(6)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7


    val node21 = ListNode(8)
    val node22 = ListNode(7)
    val node23 = ListNode(3)
    node21.next = node22
    node22.next = node23
    node23.next = node6
    println(getIntersectionNode(node1, node21)?.value)
}