package com.jkl.leetcode.array;

import java.util.Arrays;

/**
 * 《数组题：  移动零》
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 1、必须在原数组上操作，不能拷贝额外的数组。
 * 2、尽量减少操作次数。
 *
 * @author jack.guo,  Date on 2019/7/26.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] array = new int[]{4, 0, 5, 0, 9};
        System.out.println(Arrays.toString(moveZeroes(array)));
    }

    /**
     * 思路：每一轮循环都把遇到的0和0后面离得最近的数交换位置；如下：
     *
     * 4，0,5,0,9
     * 4,0,5,0,9（i=0）
     * 4,0,5,0,9（i=1）4,5,0,0,9
     * 4,5,0,0,9(i=2) 4,5,9,0,0
     * 4,5,9,0,0(i=3) 4,5,9,0,0
     */
    private static int[] moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        j = nums.length;
                    }
                }
            }
        }
        return nums;
    }
}
