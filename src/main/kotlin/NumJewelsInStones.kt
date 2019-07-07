fun main(args: Array<String>) {
    println(numJewelsInStones("aA", "aAAbbbb"))
    println(numJewelsInStones("z", "ZZ"))
    println(toLowerCase("loVEly"))
}

/**
 * 给定字符串 J 代表石头中宝石的类型，和字符串 S 代表你拥有的石头。 
 * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S 中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * 注意:
 * S 和 J 最多含有50个字母。
 * J 中的字符不重复。
 */
fun numJewelsInStones(J: String, S: String): Int {
    return S.count {
        J.contains(it)
    }
}

/**
 * 大写字母转小写字母
 * 将字符串中的大写字母转换成小写字母，之后返回新的字符串。
 */
fun toLowerCase(str: String): String {
    return str.toLowerCase()
}