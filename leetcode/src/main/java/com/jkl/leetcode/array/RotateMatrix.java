package com.jkl.leetcode.array;

import java.util.Arrays;

/**
 * 《数组题：旋转图像》
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @author jkl on 2019/7/28 23:55.
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };


        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        rotate(matrix);
    }

    /**
     * 思路: (i.j)位置的元素旋转过后 变成 （j,length-1-i）的数据；
     */
    private static void rotate(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length) {
            return;
        }

        int length = matrix.length;
        int tmp;
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - 1 - i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][i];
                matrix[length - 1 - j][i] = matrix[length - 1 - i][length - 1 - j];
                matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
                matrix[j][length - 1 - i] = tmp;
            }
        }


        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
        System.out.println(Arrays.toString(matrix[3]));
        System.out.println(Arrays.toString(matrix[4]));
    }
}
