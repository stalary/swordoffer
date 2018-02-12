/**
 * @(#)HasSubtree.java, 2018-02-12.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * HasSubtree
 *
 * 输入两颗二叉树A,B判断B是不是A的子结构
 * @author lirongqian
 * @since 2018/02/12
 */
public class HasSubtree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        // 当root1或root2为null时，返回false
        if (root1 == null || root2 == null) {
            return false;
        }
        if (help(root1, root2)) {
            return true;
        }
        // 递归判断子树，查找开始的结点
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean help(TreeNode root1, TreeNode root2) {
        // 当root2已经遍历完时，即代表是子树
        if (root2 == null) {
            return true;
        }
        // 如果root2还没遍历完，root1就已经遍历完，则代表不是子树
        if (root1 == null) {
            return false;
        }
        // 值不相同时，不是子树
        if (root1.val != root2.val) {
            return false;
        }
        return help(root1.left, root2.left) && help(root1.right, root2.right);
    }
}