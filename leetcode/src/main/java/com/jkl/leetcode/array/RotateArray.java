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
        rotate1(d, 2);
    }

    /**
     * 方法一：K可能超出数组长度，所以k要取模。k = k % nums.length;
     * 思路：K是一个分水岭，新建一个ArrayList, K之后的放在ArrayList前面，K之前的放在ArrayList后面
     */
    private static void rotate(int[] nums, int k) {

        if (nums == null || nums.length < 2 || k == 0) {
            return;
        }

        k = k % nums.length;

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


    /**
     * 方法二：
     * 思路：写一个翻转数组的方法，先翻转整个数组，再翻转前面K个元素，再反转后面的元素。如下：k=3
     * [1,2,3,4,5,6,7]
     * [7,6,5,4,3,2,1]---第一步
     * [5,6,7,4,3,2,1]---第二步
     * [5,6,7,1,2,3,4]---第二步
     */
    private static void rotate1(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 0) {
            return;
        }

        //因为 k 可能超出 n，索引需要先取模
        k = k % nums.length;

        //使用多次翻转的方法 (先观察规律，发现其实总共进行三步翻转即可)
        //1.翻转整体
        reverse(nums, 0, nums.length - 1);
        //2.翻转前 k 个元素
        reverse(nums, 0, k - 1);
        //翻转后面 n-k 个元素
        reverse(nums, k, nums.length - 1);

    }

    /**
     * 翻转数组的方法
     */
    private static void reverse(int[] nums, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }


    /**
     * 方法三：
     * 思路：先clone一个源数组tmp，在通过System.arraycopy() 方法把tmp中的元素复制到nums中。
     */
    private static void rotate2(int[] nums, int k) {

        if (nums == null || nums.length < 2 || k == 0) {
            return;
        }

        k = k % nums.length;
        int[] tmp = nums.clone();

        //@param      src      the source array.源数组
        //@param      srcPos   starting position in the source array.源数组要复制的起始位置
        //@param      dest     the destination array.目标数组（将原数组复制到目标数组）
        //@param      destPos  starting position in the destination data.目标数组起始位置（从目标数组的哪个下标开始复制操作）
        //@param      length   the number of array elements to be copied.复制源数组的长度
        System.arraycopy(tmp, tmp.length - k, nums, 0, k);
        System.arraycopy(tmp, 0, nums, k, tmp.length - k);
    }
}