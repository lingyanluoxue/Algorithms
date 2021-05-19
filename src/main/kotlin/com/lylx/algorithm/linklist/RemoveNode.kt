package com.lylx.algorithm.linklist

fun main(args: Array<String>) {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(6)
    val node6 = ListNode(5)
    val node7 = ListNode(6)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7

//    val node11 = ListNode(1)
//    val node12 = ListNode(1)
//    node11.next = node12

//    displayLinkList(removeElements(node1, 6))
//    displayLinkList(removeElements(node11, 1))
//    displayLinkList(removeElements3(node1, 6))
//    displayLinkList(removeElements3(node11, 1))
//    displayLinkList(removeElements2(node1, 6))
//    displayLinkList(removeElements2(node1, 1))

//    testDeleteDuplicates()

//    displayLinkList(removeNthFromEnd(node1,2))
//    displayLinkList(removeNthFromEnd(node1,1))
//    displayLinkList(removeNthFromEnd(node1,7))

}

fun testDeleteDuplicates(){
    val node1 = ListNode(2)
    val node2 = ListNode(3)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    val node6 = ListNode(6)
    val node7 = ListNode(6)
    val node8 = ListNode(6)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = node8

//    displayLinkList(deleteDuplicates(node1))
    displayLinkList(deleteDuplicates1(node1))
}

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *      4 ——> 5 ——> 1 ——> 9
 *
 * 示例：
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
fun deleteNode(node: ListNode) {
    node.value = node.next!!.value
    node.next = node.next!!.next
}


/**
 * 删除链表中等于给定值 value 的所有节点
 *
 * 示例：
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
/**
 * 内存消耗：40.6 MB
 */
fun removeElements(head: ListNode?, value: Int): ListNode? {
    if (head == null) {
        return null
    }
    var headNode = head
    var currentNode = head
    var previousNode = head
    while (currentNode != null) {
        if (currentNode.value != value) {
            previousNode = currentNode
        } else {
            if (currentNode == headNode) {
                headNode = currentNode.next
                previousNode = currentNode.next
            } else {
                previousNode?.next = currentNode.next
            }
        }
        currentNode = currentNode.next
    }
    return headNode
}

/**
 * 删除链表中等于给定值 value 的所有节点
 *
 * 构造一个 dummy head node/假的头部节点，dummyNode.next 指向 head 节点
 * 遍历链表节点的值和指定的值是否相等，不相等则移动到链表的下一个节点进行对比；相等则将 next 指针指向下一个节点
 */
fun removeElements2(head: ListNode?, value: Int): ListNode? {
    val dummyNode = ListNode(0)
    dummyNode.next = head
    var currentNode: ListNode? = dummyNode
    while (currentNode?.next != null) {
        if (currentNode.next?.value != value) {
            currentNode = currentNode.next
        } else {
            currentNode.next = currentNode.next?.next
        }
    }
    return dummyNode.next
}

/**
 * 删除链表中等于给定值 value 的所有节点
 *
 * 递归
 * 内存消耗：40.7 MB
 */
fun removeElements3(head: ListNode?, value: Int): ListNode? {
    if (head == null)
        return null

    head.next = removeElements2(head.next, value)
    return if (head.value == value) {
        head.next
    } else {
        head
    }
}

/**
 * 删除有序链表中的重复元素
 */
fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    head.next = deleteDuplicates(head.next)
    return if (head.value == head.next?.value) head.next else head
}

/**
 * 删除有序链表中的重复元素
 */
fun deleteDuplicates1(head: ListNode?): ListNode? {
    var curr = head
    while (curr != null) {
        while (curr.value == curr.next?.value) {
            curr.next = curr.next?.next
        }
        curr = curr.next
    }
    return head
}

/**
 *  删除链表的倒数第 n 个节点
 *
 *  双指针
 */
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var fast: ListNode? = head
    var slow: ListNode? = dummy
    for (i in 0 until n) {
        fast = fast?.next
    }
    while (fast != null) {
        fast = fast.next
        slow = slow?.next
    }
    slow?.next = slow?.next?.next
    return dummy.next
}






