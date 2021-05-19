package com.lylx.algorithm.linklist

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1
    return if (l1.value < l2.value) {
        l1.next = mergeTwoLists(l1.next, l2)
        l1
    } else {
        l2.next = mergeTwoLists(l1, l2.next)
        l2
    }
}

fun mergeTwoLists1(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var l1Current: ListNode? = l1
    var l2Current: ListNode? = l2
    var curr: ListNode? = dummy
    while (l1Current != null && l2Current != null) {
        if (l1Current.value > l2Current.value) {
            curr?.next = l2Current
            l2Current = l2Current.next
        } else {
            curr?.next = l1Current
            l1Current = l1Current.next
        }
        curr = curr?.next
    }
    curr?.next = l1Current ?: l2Current
    return dummy.next
}

fun main(args: Array<String>) {
    val node1 = ListNode(3)
    val node2 = ListNode(8)
    val node3 = ListNode(10)
    val node4 = ListNode(15)
    node1.next = node2
    node2.next = node3
    node3.next = node4

    val node11 = ListNode(1)
    val node12 = ListNode(5)
    val node13 = ListNode(13)
    val node14 = ListNode(20)
    node11.next = node12
    node12.next = node13
    node13.next = node14

//    println(displayLinkList(mergeTwoLists(node1, node11)))
    println(displayLinkList(mergeTwoLists1(node1, node11)))
}