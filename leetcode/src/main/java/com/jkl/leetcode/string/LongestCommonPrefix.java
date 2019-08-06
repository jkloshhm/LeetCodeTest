package com.jkl.leetcode.string;

/**
 * 《字符串题：最长公共前缀》
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["w","w","w"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明: 所有输入只包含小写字母 a-z 。
 *
 * @author jack.guo,  Date on 2019/8/6.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] stringArray1 = new String[]{"abca"};
        String[] stringArray2 = new String[]{"w", "w", "a"};
        System.out.println(longestCommonPrefix(stringArray1));
        System.out.println(longestCommonPrefix(stringArray2));
    }

    /**
     * 思路:先求出数组中最小长度的字符串，根据这个字符串来循环。
     * 外层是取每个字符串的第i个字符，内层是取数组内第j个字符串和第j-1个做比较。
     */
    private static String longestCommonPrefix(String[] strs) {

        //小于1直接return
        if (strs.length < 1) {
            return "";
        }

        //等于1直接return本身
        if (strs.length == 1) {
            return strs[0];
        }

        //先计算出来数组中长度最小的字符串。
        int minLength = strs[0].length();
        for (String s : strs) {
            if (s.length() < minLength) {
                minLength = s.length();
            }
        }

        //数组中每次取第j个和第j-1个字符串作比较，比较第i个位置的字符串。
        for (int i = 0; i < minLength; i++) {
            for (int j = 1; j < strs.length; j++) {
                int compare = strs[j].charAt(i) - strs[j - 1].charAt(i);
                //第j个和第j-1个字符串的i位置的字符不相等就返回。
                if (compare != 0) {
                    return strs[j].substring(0, i);
                }
                //假如所有的都比较完了，那么返回整个字符串。
                if (i == minLength - 1 && j == strs.length - 1) {
                    return strs[j].substring(0, minLength);
                }
            }
        }
        return "";
    }
}
