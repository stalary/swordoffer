/**
 * @(#)IsSymmetrical.java, 2018-02-01.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * IsSymmetrical
 *
 * 判断二叉树是不是对称的
 * @author lirongqian
 * @since 2018/02/01
 */
public class IsSymmetrical {

    public boolean isSymmetrical(TreeNode root) {
        return root == null || help(root.left, root.right);
    }

    public boolean help(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        return left.val == right.val && help(left.left, right.right) && help(left.right, right.left);
    }
}