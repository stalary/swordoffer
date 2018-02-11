/**
 * @(#)VerifySquenceOfBST.java, 2018-02-11.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * VerifySquenceOfBST
 * <p>
 * 判断一个数组是不是二叉搜索树的后序遍历。
 *
 * @author lirongqian
 * @since 2018/02/11
 */
public class VerifySquenceOfBST {

    public static void main(String[] args) {
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(new int[]{
                4, 8, 6, 12, 16, 14, 10
        }));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        return help(sequence, 0, sequence.length);
    }

    public boolean help(int[] sequence, int start, int end) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int root = sequence[end - 1];
        int i;
        for (i = 0; i < end - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j;
        for (j = i; j < end - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > 0) {
            left = help(sequence, start, i);
        }
        boolean right = true;
        if (i < end - 1) {
            right = help(sequence, start + i, end - 1);
        }
        return left && right;
    }
}