/**
 * @(#)MoreThanHalfNum.java, 2018-02-09.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * MoreThanHalfNum
 * <p>
 * 数组中超过一半的数字
 *
 * @author lirongqian
 * @since 2018/02/09
 */
public class MoreThanHalfNum {

    public static void main(String[] args) {
        System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(new int[]{
                1, 2, 3, 2, 2, 2, 5, 4, 2
        }));
    }

    /**
     * 设置一个哨兵，初始值为第一个元素，当下一个元素相同是，哨兵前进一位，否则后退
     * 当为0时，更换哨兵，最后循环判断留下的哨兵移动的数量，如果大于数组的一半，则输出
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        // 哨兵初始化步数1，元素为第一个元素
        int temp = 1;
        int result = array[0];
        for (int i : array) {
            // 步数为0时即切换哨兵
            if (temp == 0) {
                result = i;
            }
            // 相同时，哨兵前进，否则后退一步
            if (result == i) {
                temp++;
            } else {
                temp--;
            }
        }
        temp = 0;
        for (int i : array) {
            if (i == result) {
                temp++;
            }
        }
        if (temp > array.length / 2) {
            return result;
        }
        return 0;
    }
}