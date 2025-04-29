package org.lvJiang.song.hot100.matrix;

import java.util.Arrays;

/**
 * 题目：给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class SetZeroes {

    public static void main(String[] args) {
        setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }

    public static void setZeroes(int[][] matrix) {
        

        System.out.println(Arrays.toString(matrix));
    }
}
