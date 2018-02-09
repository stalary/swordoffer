/**
 * @(#)GetNext.java, 2018-02-01.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * GetNext
 *
 * 二叉树中序遍历的下一个结点
 * @author lirongqian
 * @since 2018/02/01
 */
public class GetNext {

    /**
     * 中序遍历的顺序为左->中->右
     * 所以一共会有两种情况
     * 1 有右结点，去查找右结点的最左结点，即为所求值，无左结点，当前右结点即为所求值
     * 2 无右结点，如果为父结点的左结点，则父结点为所求值，否则一直向父结点查找，直到找到父结点为父结点的父结点的左儿子的点
     * @param node
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) {
            return null;
        }
        // 有右结点的情况
        if (node.right != null) {
            node = node.right;
            // 查找最左结点
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        // 无右结点的情况
        while (node.next != null) {
            // 如果父结点的左结点为当前结点，则为所求值
            if (node.next.left == node) {
                return node.next;
            }
            // 否则一直向上查找父结点
            node = node.next;
        }
        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}