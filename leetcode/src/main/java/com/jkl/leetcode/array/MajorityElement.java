package com.jkl.leetcode.array;

import java.util.Arrays;

/**
 * 《数组题：求众数》
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @author jack.guo,  Date on 2019/7/26.
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] array = new int[]{4, 4, 4, 0, 9};
        majorityElement(array);
    }

    /**
     * 思路：先排序，然后求最中间的数
     */
    private static void majorityElement(int[] nums) {
        //先给数组排序，排完序就是最中间那个数。
        Arrays.sort(nums);
        int a = nums[nums.length / 2];
        System.out.println(a);
    }

}
