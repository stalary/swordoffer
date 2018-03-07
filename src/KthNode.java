
/**
 * KthNode
 * 二叉搜索树中第n个结点
 * @author lirongqian
 * @since 2018/01/31
 */
public class KthNode {

    /**
     * 二叉搜索的特点时左儿子小于根节点，右儿子大于根节点
     * 所以首先找到最左的结点即为第一个结点，最左结点的根节点为第二个结点，以此类推
     */
    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            // 找到最左的结点
            TreeNode node = KthNode(pRoot.left, k);
            // 如果node不为空，则代表找到了第k个结点
            if (node != null) {
                return node;
            }
            // 当最左结点为空时，则去找根节点，如果当前下标等于k，则输出
            index++;
            if (k == index) {
                return pRoot;
            }
            // 继续查找根节点的右结点
            node = KthNode(pRoot.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;
    }
}