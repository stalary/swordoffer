/**
 * @(#)GetUglyNumber.java, 2018-02-08.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * GetUglyNumber
 * <p>
 * 求第n个丑数
 * 只包含因子2、3和5的数称作丑数
 *
 * @author lirongqian
 * @since 2018/02/08
 */
public class GetUglyNumber {

    public int GetUglyNumber_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        // 先加入最小的丑数1
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < n) {
            // 找到下一个最小的丑数
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            // 存入最小值时，将对应的个数++
            if (min == m2) {
                i2++;
            }
            if (min == m3) {
                i3++;
            }
            if (min == m5) {
                i5++;
            }
        }
        // 因为n是从1开始
        return list.get(n - 1);
    }
}