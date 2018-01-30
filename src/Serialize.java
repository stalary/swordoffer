/**
 * @(#)Serialize.java, 2018-01-31.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * Serialize
 * <p>
 * 序列化与反序列化二叉树
 *
 * @author lirongqian
 * @since 2018/01/31
 */
public class Serialize {

    /**
     * 序列化二叉树，为空的结点用#代表，序列化顺序为root->left->right
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    /**
     * 反序列化，通过，进行切割，遇到不是#才放入创建结点
     */
    int index = -1;
    TreeNode Deserialize(String str) {
        index++;
        if (index >= str.length()) {
            return null;
        }
        String[] strs = str.split(",");
        TreeNode node = null;
        if (!strs[index].equals("#")) {
            // 加入根节点后，去查找最左边的结点，依次回溯进行添加，再去找最右边的结点依次回溯添加
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}