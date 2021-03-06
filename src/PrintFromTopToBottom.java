
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * PrintFromTopToBottom
 * <p>
 * 从上往下打印二叉树
 * 即层序遍历
 *
 * @author lirongqian
 * @since 2018/02/11
 */
public class PrintFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            list.add(node.val);
        }
        return list;
    }
}