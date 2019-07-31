package com.jkl.leetcode.string;

import java.util.Arrays;

/**
 * 《字符串题：有效的字母异位词》
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author jkl,  Date on 2019/7/31.
 */
public class IsAnagram {

    public static void main(String[] args) {
        String s = "aagram中国", t = "aa中国gram";
        System.out.println(isAnagram2(s, t));
    }


    /**
     * 常规解法：思路是新建两个数组，保存两个字符串的字母出现次数；然后再比较这两个数组；
     */
    private static boolean isAnagram1(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] a = new int[26];
        int[] b = new int[26];

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            b[t.charAt(i) - 'a']++;
        }

        for (int j = 0; j < a.length; j++) {
            if (a[j] != b[j]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 方法二：假如字符串中有Unicode字符，比如汉字，那么上述方法1就不能用了。下面方法思路如下：
     * 先把两个字符串转化成char数组，在进行排序，排完续用新的字符串表示，然后再用equals比较。
     */
    private static boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        String newString1 = new String(chars1);
        String newString2 = new String(chars2);
        return newString1.equals(newString2);
    }
}
