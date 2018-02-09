/**
 * @(#)Convert.java, 2018-02-09.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Stack;

/**
 * Convert
 * <p>
 * 将二叉搜索树转化为排序的双向链表，不能新增结点
 *
 * @author lirongqian
 * @since 2018/02/09
 */
public class Convert {

    /**
     *              8
     *         5          11            --->  3 5 7 8 9 11 12  即将右子树的最后一个结点和根结点相连，根节点与左子树的第一个结点相连
     *     3      7    9       12
     *
     * @param root
     * @return
     */
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while (p != null && p.right != null) {
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表(即将左子树的最右结点与root相连)
        if (left != null) {
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right != null) {
            right.left = root;
            root.right = right;
        }
        return left != null ? left : root;
    }


}