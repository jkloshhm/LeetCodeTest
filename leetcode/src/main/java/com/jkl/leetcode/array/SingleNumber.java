package com.jkl.leetcode.array;


/**
 * 《数组题：只出现一次的元素》
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]  输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]  输出: 4
 *
 * @author jack.guo 2919-07-26
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(array));
    }


    /**
     * 思路：数组从第一个值开始与后面的数一次求异或。
     * 1.按位与（&）【有0则0】
     * 2.按位或（|）【有1则1】
     * 3.异或（^）【同0异1】
     */
    private static int singleNumber(int[] nums) {
        int a = 0;
        for (int n : nums) {
            a = a ^ n;
        }
        return a;
    }
}
