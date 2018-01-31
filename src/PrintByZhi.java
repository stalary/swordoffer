/**
 * @(#)PrintByZhi.java, 2018-02-01.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * PrintByZhi
 * <p>
 * 按之字型打印二叉树
 *
 * @author lirongqian
 * @since 2018/02/01
 */
public class PrintByZhi {

    /**
     * 按之字型打印二叉树，使用两个栈，一个存储奇数的层，一个存储偶数的层
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        int layer = 1;
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> even = new Stack<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // 注意需要判空
        if (root == null) {
            return result;
        }
        odd.push(root);
        while (!odd.isEmpty() || !even.isEmpty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!odd.isEmpty()) {
                    // 弹出末尾的的值，即刚加入的值
                    TreeNode node = odd.pop();
                    list.add(node.val);
                    // 偶数层的顺序是从右往左，因为stack是先进后出，所以先存入左边的结点，这样会后弹出，从而先弹出右边的结点
                    if (node.left != null) {
                        even.push(node.left);
                    }
                    if (node.right != null) {
                        even.push(node.right);
                    }
                }
                // 当list不是空时，加入到result中，代表当前层遍历完毕，层数+1
                if (!list.isEmpty()) {
                    result.add(list);
                    layer++;
                }
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!even.isEmpty()) {
                    TreeNode node = even.pop();
                    list.add(node.val);
                    if (node.right != null) {
                        odd.push(node.right);
                    }
                    if (node.left != null) {
                        odd.push(node.left);
                    }
                }
                if (!list.isEmpty()) {
                    result.add(list);
                    layer++;
                }
            }
        }
        return result;
    }

}