package com.jkl.leetcode.string;

import java.util.Arrays;

/**
 * 《字符串题：反转字符串》
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * @author jack.guo,  Date on 2019/7/29.
 */
public class ReverseString {

    public static void main(String[] args) {

        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString1(s);
    }

    /**
     * 思路: 翻转数组就是最前面的i位置元素和最后面length-1-i位置的元素相互交换。使用for循环。
     */
    private static void reverseString(char[] s) {

        if (s.length < 1) {
            return;
        }
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }

        System.out.println(Arrays.toString(s));
    }

    /**
     * 思路: 翻转数组就是最前面的i位置元素和最后面length-1-i位置的元素相互交换。使用while循环。
     */
    private static void reverseString1(char[] s) {
        if (s.length < 1) {
            return;
        }

        int i = 0, j = s.length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }

        System.out.println(Arrays.toString(s));
    }
}
