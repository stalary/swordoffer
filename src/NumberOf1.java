/**
 * @(#)NumberOf1.java, 2018-02-13.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * NumberOf1
 *
 * 求二进制中1的个数
 * @author lirongqian
 * @since 2018/02/13
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}