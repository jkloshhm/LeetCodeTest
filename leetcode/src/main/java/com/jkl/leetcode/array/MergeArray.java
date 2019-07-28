package com.jkl.leetcode.array;

import java.util.Arrays;

/**
 * 《合并两个有序数组》
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 *
 * @author jack.guo,  Date on 2019/7/26.
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] array1 = new int[]{0, 3, 4, 0, 0, 0};
        int[] array2 = new int[]{2, 8, 9};
        merge(array1, 3, array2, 3);
    }


    /**
     * 思路：while循环，两个数组分别从最后面开始遍历，大的放在数组1的m+n-1位置，依次类推。
     *      当数组1遍历完了，数组2还没有遍历完，那么数组2剩余的数还是遍历到数组1中
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
        System.out.println(Arrays.toString(nums1));
    }

}
