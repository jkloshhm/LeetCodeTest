package com.jkl.leetcode.string;

/**
 * 《字符串题：验证回文字符串》
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * @author jack.guo,  Date on 2019/8/1.
 */
public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = "0P";
        System.out.println(isPalindrome(s));
    }


    /**
     * 常规解法：先把字符串变成小写字母，然后分别比较最前面位置的字符和最后面位置的字符。
     * 提交时间：14ms，还是有点耗时。待优化。
     */
    private static boolean isPalindrome(String s) {

        String s1 = s.toLowerCase();
        int i = 0, j = s1.length() - 1;
        while (i < j) {
            if (!compareChar(s1.charAt(i))) {
                i++;
                continue;
            }
            if (!compareChar(s1.charAt(j))) {
                j--;
                continue;
            }
            if (s1.charAt(i) != s1.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 判断字符是否是小写字母或者数字。
     */
    private static boolean compareChar(char s) {
        return s >= 'a' && s <= 'z' || s >= '0' && s <= '9';
    }

}
