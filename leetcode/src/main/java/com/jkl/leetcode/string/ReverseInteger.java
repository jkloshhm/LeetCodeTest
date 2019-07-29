package com.jkl.leetcode.string;

/**
 * 《字符串：整数反转》
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author jkl,  Date on 2019/7/30 00:13。
 */
public class ReverseInteger {
    public static void main(String[] args) {

        int x = -1563847412;
        System.out.println(reverse(x));
    }

    /**
     * 思路: 错误方法
     */
    private static int reverseInteger(int x) {

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        if (min >= x || x >= max) {
            x = 0;
        }

        String s1 = String.valueOf(x);
        if (x < 0) {
            s1 = s1.substring(1);
        }
        char[] s = s1.toCharArray();
        if (s.length < 1) {
            return x;
        }

        int i = 0, j = s.length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }

        s1 = String.valueOf(s);
        int x1 = Integer.parseInt(s1);
        if (x < 0) {
            x = -x1;
        } else {
            x = x1;
        }


        if (min > x || x > max) {
            return 0;
        }
        System.out.println(x);
        System.out.println(max);
        System.out.println(min);
        return x;

    }

    /**
     * 思路: 正确方法
     */

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

}
