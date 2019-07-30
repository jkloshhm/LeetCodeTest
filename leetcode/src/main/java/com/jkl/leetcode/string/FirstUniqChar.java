package com.jkl.leetcode.string;

/**
 * 《字符串题：字符串中的第一个唯一字符》
 * <p>
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author jack.guo,  Date on 2019/7/30.
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String x = "qeqrett";
        System.out.println(firstUniqChar2(x));
    }

    /**
     * 思路2: s.indexOf(a)从前面取得到index，s.lastIndexOf(a)从后面依次取index；判断两个index是否想等。
     */
    private static int firstUniqChar2(String s) {

        char a = ' ';
        for (int i = 0; i < s.length(); i++) {
            a = s.charAt(i);
            if (s.indexOf(a) == s.lastIndexOf(a)) {
                return i;
            }
        }
        return -1;

    }

    /**
     * 思路1: 常规算法，提交超时！！！不能用！！！
     */
    private static int firstUniqChar(String s) {

        char[] chars = s.toCharArray();
        boolean[] booleans = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j] && (!booleans[i] || !booleans[j])) {
                    booleans[i] = true;
                    booleans[j] = true;
                }
            }
        }

        for (int i = 0; i < booleans.length; i++) {
            if (!booleans[i]) {
                return i;
            }
        }
        return -1;
    }
}
