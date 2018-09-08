import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * PrintByZhi
 * <p>
 * 按之字型打印二叉树
 *
 * @author lirongqian
 * @since 2018/02/01
 */
public class PrintByZhi {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(6);
        root1.right = new TreeNode(10);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(7);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(11);
        root.right.right = root1;
        long start1 = System.currentTimeMillis();
        System.out.println("queue: " + new PrintByZhi().print1(root));
        System.out.println("queue time." + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        System.out.println("stack: " + new PrintByZhi().print(root));
        System.out.println("stack time." + (System.currentTimeMillis() - start2));
    }


    public ArrayList<ArrayList<Integer>> print1(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 使用null作为层分隔符
        queue.addLast(null);
        queue.addLast(root);
        boolean leftToRight = true;
        while (queue.size() != 1) {
            ArrayList<Integer> list = new ArrayList<>();
            TreeNode node = queue.removeFirst();
            // 到达层分隔符
            if (node == null) {
                Iterator<TreeNode> it;
                // 从左往右打印
                if (leftToRight) {
                    it = queue.iterator();
                } else {
                    // 从右往左打印
                    it = queue.descendingIterator();
                }
                // 反转打印顺序
                leftToRight = !leftToRight;
                while (it.hasNext()) {
                    TreeNode temp = it.next();
                    list.add(temp.val);
                }
                result.add(list);
                // 添加层分隔符
                queue.addLast(null);
                // 直接跳到下一次循环
                continue;
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return result;
    }

    /**
     * 按之字型打印二叉树，使用两个栈，一个存储奇数的层，一个存储偶数的层，队列无法实现，队列无法实现内部顺序倒置
     *
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> print(TreeNode root) {
        int layer = 1;
        // 奇数
        Stack<TreeNode> odd = new Stack<>();
        // 偶数
        Stack<TreeNode> even = new Stack<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // 注意需要判空
        if (root == null) {
            return result;
        }
        odd.push(root);
        while (!odd.isEmpty() || !even.isEmpty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!odd.isEmpty()) {
                    // 弹出末尾的的值，即刚加入的值
                    TreeNode node = odd.pop();
                    list.add(node.val);
                    // 偶数层的顺序是从右往左，因为stack是先进后出，所以先存入左边的结点，这样会后弹出，从而先弹出右边的结点
                    if (node.left != null) {
                        even.push(node.left);
                    }
                    if (node.right != null) {
                        even.push(node.right);
                    }
                }
                // 当list不是空时，加入到result中，代表当前层遍历完毕，层数+1
                if (!list.isEmpty()) {
                    result.add(list);
                    layer++;
                }
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!even.isEmpty()) {
                    TreeNode node = even.pop();
                    list.add(node.val);
                    if (node.right != null) {
                        odd.push(node.right);
                    }
                    if (node.left != null) {
                        odd.push(node.left);
                    }
                }
                if (!list.isEmpty()) {
                    result.add(list);
                    layer++;
                }
            }
        }
        return result;
    }

}