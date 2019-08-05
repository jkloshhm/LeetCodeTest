package com.jkl.leetcode.string;

/**
 * 《字符串转换整数 (atoi)》
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：
 * 假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 *
 * @author jack.guo,  Date on 2019/8/1.
 */
public class MyAtoi {

    public static void main(String[] args) {
        String x1 = "+";
        String x2 = "4193 with words";
        String x3 = "+0 123";
        String x4 = "-91283472332";
        String x5 = "+-2";
        String x6 = "-0012a42";
        String x7 = "+0012a42";
        System.out.println("x1==" + myAtoi(x1));
        System.out.println("x2==" + myAtoi(x2));
        System.out.println("x3==" + myAtoi(x3));
        System.out.println("x4==" + myAtoi(x4));
        System.out.println("x5==" + myAtoi(x5));
        System.out.println("x6==" + myAtoi(x6));
        System.out.println("x7==" + myAtoi(x7));
    }


    /**
     * 思路：从字符串的第一个字符开始算起，依次计算、并考虑各种边界问题。
     */
    private static int myAtoi(String str) {

        int n = str.length();
        int i = 0;

        if (n < 1) {
            return 0;
        }

        //去除字符串最前面的空格
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        //判断第一个不为空格的字符
        if (i == n || !((str.charAt(i) == '+') || str.charAt(i) == '-' || (str.charAt(i) >= '0' && str.charAt(i) <= '9'))) {
            return 0;
        }

        //新建StringBuilder用来保存需要的字符
        StringBuilder stringBuilder = new StringBuilder();
        //获取第一个字符，判断是否是正负号；
        if (str.charAt(i) == '-') {
            stringBuilder.append('-');
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        //判断接下来的字符是否是数字；
        if (i == n || !(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
            return 0;
        }
        //循环接下来的字符;
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            stringBuilder.append(str.charAt(i));
            i++;
        }

        //使用try-catch来获取最后输出的值；
        try {
            return Integer.valueOf(stringBuilder.toString());
        } catch (Exception e) {
            if (stringBuilder.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }


}
