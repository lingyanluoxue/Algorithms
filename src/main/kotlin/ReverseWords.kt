fun main(args: Array<String>) {
    print(reverseWords("Let's take LeetCode contest"))
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
