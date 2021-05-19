package com.lylx.algorithm.linklist


/**
 * 两数之和
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1Current: ListNode? = l1
    var l2Current: ListNode? = l2
    val dummyNode = ListNode(0)
    var current: ListNode? = dummyNode
    var carry = 0
    while (l1Current != null || l2Current != null) {
        val n1 = l1Current?.value ?: 0
        val n2 = l2Current?.value ?: 0
        val sum = n1 + n2 + carry
        carry = sum / 10
        current?.next = ListNode(sum % 10)
        current = current?.next
        l1Current = l1Current?.next
        l2Current = l2Current?.next
    }
    if (carry > 0) {
        current?.next = ListNode(carry)
    }
    return dummyNode.next
}

fun main(args: Array<String>) {
    val node1 = ListNode(2)
    val node2 = ListNode(4)
    val node3 = ListNode(3)
    node1.next = node2
    node2.next = node3

    val node11 = ListNode(5)
    val node12 = ListNode(6)
    val node13 = ListNode(4)
    node11.next = node12
    node12.next = node13

    println(displayLinkList(addTwoNumbers(node1, node11)))
}
