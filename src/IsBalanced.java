/**
 * @(#)IsBalanced.java, 2018-02-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * IsBalanced
 *
 * 判断是不是一颗平衡二叉树
 * @author lirongqian
 * @since 2018/02/07
 */
public class IsBalanced {

    boolean flag = true;

    /**
     * 平衡二叉树要求左右结点的高度差不能大于1
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        getDepth(root);
        return flag;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归的计算左结点和右结点的高度差，当高度差大于1时即不满足
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
            return 0;
        }
        return right > left ? right + 1 : left + 1;
    }
}