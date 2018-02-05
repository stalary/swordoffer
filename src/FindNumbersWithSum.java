/**
 * @(#)FindNumbersWithSum.java, 2018-02-06.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * FindNumbersWithSum
 * <p>
 * 在递增数组中，查找两个数和为s，且乘积最小的数
 *
 * @author lirongqian
 * @since 2018/02/06
 */
public class FindNumbersWithSum {

    public static void main(String[] args) {
        int[] array = new int[] {
                1, 3, 5, 6, 8, 9
        };
        System.out.println(new FindNumbersWithSum().FindNumbersWithSum(array, 11));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int temp = 0;
        for (int i : array) {
            if (set.contains(sum - i)) {
                if (min > i * (sum - i)) {
                    min = i * (sum - i);
                    temp = i;
                }

            }
            set.add(i);
        }
        if (temp != 0) {
            result.add(sum - temp);
            result.add(temp);
        }
        return result;
    }
}