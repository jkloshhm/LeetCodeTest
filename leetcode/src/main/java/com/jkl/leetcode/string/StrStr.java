package com.jkl.leetcode.string;

/**
 * 《 字符串题：实现 strStr() 》
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回-1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author jack.guo,  Date on 2019/8/7.
 */
public class StrStr {

    public static void main(String[] args) {

        System.out.println(strStr2("helaoall", "ll"));
        System.out.println(strStr2("a", ""));
    }

    /**
     * 方法一：
     * 我自己的思路:先判断各种边界值；再判断haystack是否存在needle；最后使用while循环，每次都取第一个字母和needle长度的字符串进行比较。
     */
    private static int strStr1(String haystack, String needle) {
        if ("".equals(haystack) && !"".equals(needle)) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (haystack.contains(needle)) {
            int i = 0;
            while (i < haystack.length()) {
                if (needle.charAt(0) == haystack.charAt(i)) {
                    if (haystack.length() >= i + needle.length()) {
                        String s = haystack.substring(i, i + needle.length());
                        if (s.equals(needle)) {
                            return i;
                        }
                    }
                }
                i++;
            }
        }
        return -1;
    }

    /**
     * 方法二：直接使用haystack.indexOf(needle)求出下标。
     */
    private static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
