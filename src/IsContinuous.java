/**
 * @(#)IsContinuous.java, 2018-02-04.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;

/**
 * IsContinuous
 *
 * 判断是不是扑克牌的顺子，大小王可以当作任意的牌，大小王为0
 * @author lirongqian
 * @since 2018/02/04
 */
public class IsContinuous {

    /**
     * 首先排序，统计出0的数量，然后判断是否有非0的重复元素，然后判断相差的元素的数量是否小于0
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        // 当牌的数量小于5的时候不是顺子
        if (numbers.length < 5) {
            return false;
        }
        // 当前数组的下标
        int index = 0;
        // 0的数量
        int zero = 0;
        // 排序
        Arrays.sort(numbers);
        // 统计0的数量，当非0时退出
        for (; index < numbers.length; index++) {
            if (numbers[index] == 0) {
                zero++;
            } else {
                break;
            }
        }
        // 从非0数字开始遍历，当有重复元素时返回false；然后判断当前元素+1+0的数量是否大于等于下一个元素
        for (; index < numbers.length - 1; index++) {
            if (numbers[index] == numbers[index + 1]) {
                return false;
            }
            if (numbers[index] + 1 +zero >= numbers[index + 1]) {
                zero = zero - (numbers[index + 1] - numbers[index] - 1);
            } else {
                return false;
            }
        }
        // 如果下标能够移动到最后，代表能够组成顺子
        return index == numbers.length - 1;
    }
}