/**
 * @(#)PrintMinNumber.java, 2018-02-08.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * PrintMinNumber
 * <p>
 * 将数组中的所有数字拼接，找到一个组合的最小数
 *
 * @author lirongqian
 * @since 2018/02/08
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        int[] numbers = new int[]{
                3, 32, 321
        };
        System.out.println(new PrintMinNumber().PrintMinNumber(numbers));
    }

    public String PrintMinNumber(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }
        // 按每个数字前后相加进行比较，相加和较小的放在前面
        list.sort((str1, str2) -> {
            String s1 = str1 + "" + str2;
            String s2 = str2 + "" + str1;
            return s1.compareTo(s2);
        });
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
}