package com.lylx.algorithm.linklist

/**
 * Definition for singly-linked list.
 */
class ListNode(var value: Int) {
    var next: ListNode? = null

    fun displayLink() {
        print("$value")
    }
}

fun displayLinkList(head: ListNode?) {
    var currentLink = head
    while (currentLink != null) {
        currentLink.displayLink()
        currentLink = currentLink.next
        if (currentLink != null) {
            print(" -> ")
        } else {
            print(" -> NULL")
        }
    }
    println()
}