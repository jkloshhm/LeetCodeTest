package com.jkl.leetcode.array;

import java.util.HashMap;

/**
 * 《数组题二：存在重复》
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @author jack.guo,  Date on 2019/7/26.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(array));
    }


    /**
     * 思路：创建一个hashMap用来存放每个数的次数，
     * 循环一次数组，把数组中的值设置为hashMap的key，value用1表示。
     */
    private static boolean containsDuplicate(int[] nums) {
        if (nums.length < 1) {
            return false;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int a : nums) {
            if (hashMap.containsKey(a)) {
                return true;
            } else {
                hashMap.put(a, 1);
            }
        }
        return false;
    }
}
