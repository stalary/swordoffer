/**
 * @(#)SumSolution.java, 2018-02-04.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * SumSolution
 *
 * 求1+2+...+n的和，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * @author lirongqian
 * @since 2018/02/04
 */
public class Sum {

    public static void main(String[] args) {
        System.out.println(new Sum().Sum_Solution(5));
    }

    /**
     * 不能使用乘除法，所以我们可以使用位运算和加减法
     */
    public int Sum_Solution(int n) {
        int sum = n;
        // 当n > 0时，把sum加上上一个和
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}