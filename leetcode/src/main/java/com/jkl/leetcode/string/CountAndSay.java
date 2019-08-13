package com.jkl.leetcode.string;

/**
 * 《字符串题：报数》
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 *
 * @author jack.guo,  Date on 2019/8/5.
 */
public class CountAndSay {
    public static void main(String[] args) {

        int n = 10;
        System.out.println(countAndSay(n));
    }

    /**
     * 方法二思路：n是循环次数；那么每次都找到前一次循环的结果，作为下一次循环的参数s
     */
    private static String countAndSay(int n) {
        String s = "1";
        if (n < 1 || n > 30) {
            return "";
        } else if (n == 1) {
            return s;
        }

        int k = 1;
        while (k < n) {
            s = count(s);
            k++;
        }

        return s;
    }

    private static String count(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        char now = chars[0];
        int count = 0;
        int i = 0;
        while (i < chars.length) {
            if (now == chars[i]) {
                count++;
            } else {
                sb.append(count).append(now);
                now = chars[i];
                count = 1;
            }
            i++;
        }
        sb.append(count).append(now);
        return sb.toString();
    }

    /**
     * 方法一思路：输入的n是循环次数，与其他无关。--------居然252ms！！
     */
    private static String countAndSay1(int n) {
        String s = "1";
        int k = 1;
        while (k < n) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            int index = 0;
            while (index < chars.length) {
                int count = 0;
                int i = chars[index] - '0';
                while (index < chars.length && i == chars[index] - '0') {
                    index++;
                    count++;
                }
                s = sb.append(count).append(i).toString();
                System.out.println(s);
            }
            k++;
        }
        return s;
    }
}
