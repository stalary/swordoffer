/**
 * @(#)Multiply.java, 2018-02-03.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * Multiply
 *
 * 构建一个乘积数组
 * @author lirongqian
 * @since 2018/02/03
 */
public class Multiply {

    /**
     * A[0,1,2...n-1]
     * B[0,1,2...n-1]
     * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
     * 即为除了A[i]都要相乘，可以分成两部分A[0]*A[1]...A[i-1]，和A[i+1]*A[i+2]...A[n-1]
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            //求前半部分的乘积
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            //求后半部分的乘积
            for (int j = length - 1; j >= 1; j--) {
                temp *= A[j];
                B[j - 1] *= temp;
            }
        }
        return B;
    }
}