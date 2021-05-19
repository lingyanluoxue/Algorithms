package com.lylx.algorithm

fun main(args: Array<String>) {
    println(defangIPaddr("1.1.1.1"))
    print(defangIPaddr("255.100.50.0"))
}

/**
 *  IP 地址无效化
 *
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *
 * @param address 一个有效的 IPv4 地址
 */
fun defangIPaddr(address: String): String {
    return address.replace(".","[.]")
}