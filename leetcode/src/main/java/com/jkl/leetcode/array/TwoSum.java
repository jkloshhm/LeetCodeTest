package com.jkl.leetcode.array;

import java.util.Arrays;

/**
 * 《数组题：两数之和》
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author jack.guo,  Date on 2019/7/26.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 2, 3, 2};
        System.out.println(Arrays.toString(twoSum(array, 7)));
    }

    /**
     * 思路：两次循环，每次j=i+1，这样就不会重复使用某个元素。
     */
    private static int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    array[0] = i;
                    array[1] = j;
                }
            }
        }
        return array;
    }
}
