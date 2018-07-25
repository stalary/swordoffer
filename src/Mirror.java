
/**
 * Mirror
 *
 * 转化为二叉树的镜像
 * @author lirongqian
 * @since 2018/02/12
 */
public class Mirror {

    /**
     * 递归的遍历子树，将左右结点交换
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        // 递归左右子树
        Mirror(root.left);
        Mirror(root.right);
        // 开始交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}