package com.jkl.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 《数组题：两个数组的交集 II》
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author jack.guo,  Date on 2019/7/26.
 */
public class Intersect {

    public static void main(String[] args) {
        int[] array1 = new int[]{4, 0, 5, 0, 9};
        int[] array2 = new int[]{4, 0, 5, 1, 2};
        System.out.println(Arrays.toString(intersect(array1, array2)));
    }


    /**
     * 思路：两个数组循环，设置一个内层数组的boolean数组，当外层和内层相等的时候设置内层数组的值为true。
     */
    private static int[] intersect(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        boolean[] booleansNums2 = new boolean[length2];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (nums1[i] == nums2[j] && !booleansNums2[j]) {
                    list.add(nums2[j]);
                    booleansNums2[j] = true;
                    break;
                }
            }
        }

        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

}
