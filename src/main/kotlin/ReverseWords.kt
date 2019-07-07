fun main(args: Array<String>) {
    println(reverseWords("Let's take LeetCode contest"))
    println(reverseWords2("Let's take LeetCode contest"))
    println(reverseWords3("Let's take LeetCode contest"))
}

/**
 * 反转字符串中的单词
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 */
private fun reverseWords(s: String): String {
    val str = s.split(" ")
    var result = ""
    str.forEachIndexed { index, it ->
        result += it.reversed()
        if (index != str.size - 1) {
            result += " "
        }
    }
    return result
}

/**
 * 1. s.split(" ") 使用空字符串分割字符串：[Let's, take, LeetCode, contest]
 * 2. joinToString(" "){it.reversed}：反转 list 的每个元素并使用空字符串[分隔符]分割 list 所有元素创建 String 字符串
 */
private fun reverseWords2(s: String): String {
    return s.split(" ").joinToString(" ") {
        it.reversed()
    }
}

/**
 * 1. s.reversed() 反转字符串 s：tsetnoc edoCteeL ekat s'teL
 * 2. split(" ") 使用空字符串分割字符串：[tsetnoc, edoCteeL, ekat, s'teL]
 * 3. reversed() 反转 list： [s'teL, ekat, edoCteeL, tsetnoc]
 * 4. joinToString(" ") 使用空字符串[分隔符]分割 list 所有元素创建 String 字符串：s'teL ekat edoCteeL tsetnoc
 */
private fun reverseWords3(s: String): String {
    return s.reversed().split(" ").reversed().joinToString(" ")
}

