/**
 * @(#)FindNumsAppearOnce.java, 2018-02-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * FindNumsAppearOnce
 * <p>
 * 查找数组中只出现一次的两个数
 *
 * @author lirongqian
 * @since 2018/02/07
 */
public class FindNumsAppearOnce {

    /**
     * 两个相同的数字异或为0，所以如果数组只只有一个不重复的数字，就是异或整个数组最后得到的数字
     * 所以我们可以想办法对数组进行拆分，将两个不重复的数字分别放到两个数组中
     * 如何去拆分呢？因为有两个只出现一次的数字，所以异或的结果肯定不为0，即肯定有一位为1
     * 所以我们找到1的位置第n位，然后把所有第n位为1的放到一个数组中，不为1的放到另一个数组中
     * 然后分别异或，就找到了两个只出现一次的数字
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        // 第一次异或找到，两个只出现一次的数字的异或的结果
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp ^= array[i];
        }
        // 找到为1的第一个位置
        int indexOf1 = findFirstBitIs(temp);
        for (int i = 0; i < array.length; i++) {
            if (isBit(array[i], indexOf1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 查找第一次为1的位的位置
     * @param num
     * @return
     */
    public int findFirstBitIs(int num) {
        int indexBit = 0;
        // 当数字num&1为0时即代表，当前位不是1，直到找到当前位为1的位置
        while (((num & 1) == 0) && (indexBit) < 8 * 4) {
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    /**
     * 判断第n位是否为1
     */
    public boolean isBit(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;
    }
}