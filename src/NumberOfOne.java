/**
 * @(#)NumberOfOne.java, 2018-02-08.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * NumberOfOne
 * <p>
 * 求1的数量
 *
 * @author lirongqian
 * @since 2018/02/08
 */
public class NumberOfOne {

    public static void main(String[] args) {
        System.out.println(new NumberOfOne().getOne(1231));
    }

    public int NumberOf1Between1AndN_Solution1(int n) {
        // 1的个数
        int count = 0;
        // 当前位
        int i = 1;
        int current, after, before;
        while ((n / i) != 0) {
            // 当前位数字
            current = (n / i) % 10;
            // 高位数字
            before = n / (i * 10);
            // 低位数字
            after = n - (n / i) * i;
            // 如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if (current == 0) {
                count += before * i;
            } else if (current == 1) {
                // 如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count += before * i + after + 1;
            } else {
                // 如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
                count += (before + 1) * i;
            }
            // 前移一位
            i = i * 10;
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += getOne(i);
        }
        return sum;
    }

    public int getOne(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 1) {
                count++;
            }
            num = num / 10;
        }
        return count;
    }
}