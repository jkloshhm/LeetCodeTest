package com.jkl.leetcode.array;

import java.util.Arrays;

/**
 * 《数组题：加一》
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author jack.guo,  Date on 2019/7/26.
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] array = new int[]{9, 9, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(array)));
    }

    /**
     * 假如是[1,2,3]这种很容易加一，
     * 假如是[1,9,9,9]这种就要特殊处理了
     */
    private static int[] plusOne(int[] digits) {

        if (digits.length < 1) {
            return digits;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }

        //数组扩容，比如[1,9,9,9]这种，加完1就是[2,0,0,0,0]
        if (digits[0] == 0) {
            int[] a = new int[digits.length + 1];
            a[0] = 1;
            for (int i = 1; i < digits.length + 1; i++) {
                a[i] = 0;
            }
            return a;
        }

        return digits;
    }
}
