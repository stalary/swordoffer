/**
 * @(#)PrintByLevel.java, 2018-02-01.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * PrintByLevel
 *
 * 按层打印二叉树
 * @author lirongqian
 * @since 2018/02/01
 */
public class PrintByLevel {

    /**
     * 按层打印二叉树，可以使用一个队列，首先存储root结点，然后每次存储一层
     * @param root
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 通过循环存入当前层的所有结点
                TreeNode node = queue.poll();
                list.add(node.val);
                // 存在子结点则存入
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}