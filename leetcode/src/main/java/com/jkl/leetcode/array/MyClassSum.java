package com.jkl.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * @author jkl on 2019/6/4 01:18.  算法习题1
 */

public class MyClassSum {

    public static void main(String[] args) {
        int[] d = new int[]{7, 1, 5, 3, 6, 4};
        rotate(d, 3);
    }

    /**
     * 思路：
     */
    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (i <= k) {
                nums[i + k - 1] = nums[i];
            } else {
                nums[i - 1 - 3] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
