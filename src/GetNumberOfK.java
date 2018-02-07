/**
 * @(#)GetNumberOfK.java, 2018-02-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * GetNumberOfK
 * <p>
 * 统计一个数字在排序数组中出现的次数
 *
 * @author lirongqian
 * @since 2018/02/07
 */
public class GetNumberOfK {

    /**
     * 由于是一个排序的数组，所以要计算重复次数，只需要通过二分法求出第一次出现和最后一次出现的位置
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int first = getFirst(array, k);
        int last = getLast(array, k);
        // 当未找到时则返回0
        if (first != -1 && last != -1) {
            return last - first + 1;
        }
        return 0;
    }

    /**
     * 查找第一次出现的位置
     * @param array
     * @param k
     * @return
     */
    public int getFirst(int[] array, int k) {
        int length = array.length;
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int mid = (end + start) >> 1;
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
                // 当mid的前一个命中时，则减1
            } else if (mid - 1 >= 0 && array[mid - 1] == k) {
                end = mid - 1;
            } else {
                // 当命中时，且前一个元素已经无法命中，输出
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找最后一次出现的位置
     * @param array
     * @param k
     * @return
     */
    public int getLast(int[] array, int k) {
        int length = array.length;
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int mid = (end + start) >> 1;
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else if (mid + 1 <= length - 1 && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}