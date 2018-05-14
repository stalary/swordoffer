
/**
 * Convert
 * <p>
 * 将二叉搜索树转化为排序的双向链表，不能新增结点
 *
 * @author lirongqian
 * @since 2018/02/09
 */
public class Convert {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(12);
        System.out.println(new Convert().Convert(root));
    }

    /**
     *              8
     *         5          11            --->  3 5 7 8 9 11 12  即将左子树的最后一个结点和根结点相连，根节点与右子树的第一个结点相连
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
            //例如 3.right=5, 5.left=3
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        // 因为根结点直接与左结点相连接，所以无需再进行查找第一个结点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right != null) {
            // 7.left=5, 5.right=7
            right.left = root;
            root.right = right;
        }
        return left != null ? left : root;
    }


}