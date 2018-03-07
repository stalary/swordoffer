
import java.util.ArrayList;

/**
 * FindPath
 * <p>
 * 查找二叉树中和为某一值的路径
 *
 * @author lirongqian
 * @since 2018/02/10
 */
public class FindPath {

    /**
     * 使用深度优先遍历
     */
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        list.add(root.val);
        target -= root.val;
        // 当无左右儿子，则达到叶结点，当和达到target时，则代表找到了一条路径，加入到结果中
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }
        // 继续搜索左右子结点
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 回退，继续搜索
        list.remove(list.size() - 1);
        return result;
    }
}