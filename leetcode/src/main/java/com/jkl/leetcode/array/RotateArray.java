package com.jkl.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
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

public class RotateArray {

    public static void main(String[] args) {
        int[] d = new int[]{997};
        rotate(d, 2);
    }

    /**
     * 方法一：错误哦！！重新做
     * 思路：K是一个分水岭，新建一个ArrayList, K之后的放在ArrayList前面，K之前的放在ArrayList后面
     */
    private static void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - k; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            list.add(nums[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        System.out.println(Arrays.toString(nums));
    }
}
