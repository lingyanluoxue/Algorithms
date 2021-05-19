package com.lylx.algorithm.linklist


/**
 * 链表的中间节点
 */
fun middleNode(head: ListNode): ListNode? {
    var fast: ListNode? = head
    var slow: ListNode? = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}