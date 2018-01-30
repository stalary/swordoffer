/**
 * @(#)MovingCount.java, 2018-01-30.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * MovingCount
 *
 * 机器人的移动范围
 * @author lirongqian
 * @since 2018/01/30
 */
public class MovingCount {

    /**
     * 要判断能够走多少个格子
     * 首先需要一个boolean数组记录已经走过的点，然后向四个方向进行遍历
     */
    public int movingCount(int threshold, int rows, int cols) {
        // 申请一个记录已经走过的点的数组
        boolean[][] flag = new boolean[rows][cols];
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private int helper(int i, int j, int rows, int cols, boolean[][] flag, int threshold) {
        // 首先判断边界，以及横纵坐标相加是否小于等于临界值和是否访问过该点
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j]) {
            return 0;
        }
        // 将当前坐标作为已经到达过的点
        flag[i][j] = true;
        // 向四个方向进行移动，每次+1代表到达一个点
        return helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold)
                + 1;
    }

    /**
     * 求一个数字各位之和的函数
     * @param i
     * @return
     */
    private int numSum(int i) {
        int sum = 0;
        while (i >= 10) {
            sum += i % 10;
            i = i / 10;
        }
        sum += i;
        return sum;
    }
}