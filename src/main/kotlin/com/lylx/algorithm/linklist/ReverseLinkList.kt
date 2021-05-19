package com.lylx.algorithm.linklist

/**
 * 反转链表
 */
fun reverseList(head: ListNode?): ListNode? {
    if (head == null) return head
    // current 是当前节点
    var current = head
    // prev 表示前继节点
    var prev: ListNode? = null
    while (current != null) {
        // next 记录下一个节点
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev
}

/**
 * 反转链表
 * 递归：返回链表头节点？？？
 */
fun reverseList1(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val next = head.next
    val newHead = reverseList1(next)
    next?.next = head
    head.next = null
    return newHead
}

fun main(args: Array<String>) {
    val node1 = ListNode(8)
    val node2 = ListNode(4)
    val node3 = ListNode(2)
    val node4 = ListNode(0)
    val node5 = ListNode(6)
    val node6 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    displayLinkList(reverseList(node1))
//    displayLinkList(reverseList1(node1))
}