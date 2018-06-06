/**
 * LowestCommonAncestorOfABinaryTree236
 * 最小公共祖先
 * @author lirongqian
 * @since 2018/05/07
 */
public class LowestCommonAncestorOfABinaryTree236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 递归查找左右结点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左右不为空时，找root
        return left == null ? right : right == null ? left : root;
    }
}