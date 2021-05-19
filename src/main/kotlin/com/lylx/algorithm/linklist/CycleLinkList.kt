package com.lylx.algorithm.linklist

/**
 * 快慢指针
 */
fun hasCycle(head: ListNode): Boolean {
    var fast: ListNode? = head
    var slow: ListNode? = head
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
        if (fast?.value == slow?.value) {
            return true
        }
    }
    return false
}

fun main(args: Array<String>) {
    val head = ListNode(3)
    val node2 = ListNode(2)
    val node3 = ListNode(0)
    val node4 = ListNode(4)
    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2

    println(hasCycle(head))

    val head1 = ListNode(1)
    println(hasCycle(head1))
}