/**
 * ReConstructBinaryTree
 *
 * 重建二叉树
 * @author lirongqian
 * @since 2018/02/15
 */
public class ReConstructBinaryTree {

    /**
     * 通过前序可以找到每一部分的根，通过递归找到每一部分的根进行重建
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        return help(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode help(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        // 根节点的值r
        int value = pre[ps];
        // 中序遍历中根节点的位置
        int index = is;
        while (index < ie && in[index] != value) {
            index++;
        }
        // 开始构建二叉树
        TreeNode root = new TreeNode(value);
        root.left = help(pre, ps + 1, ps + index - is, in, is, index - 1);
        root.right = help(pre, ps + index - is + 1, pe, in, index + 1, ie);
        return root;
    }
}