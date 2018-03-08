
/**
 * TreeDepth
 *
 * 求一颗二叉树的深度
 * @author lirongqian
 * @since 2018/02/07
 */
public class TreeDepth {

    /**
     * 直接递归的查找左儿子和右儿子的深度，每次获取左右结点较大一边的值，每深入一层要+1
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}