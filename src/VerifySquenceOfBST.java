
/**
 * VerifySquenceOfBST
 * <p>
 * 判断一个数组是不是二叉搜索树的后序遍历。
 *
 * @author lirongqian
 * @since 2018/02/11
 */
public class VerifySquenceOfBST {

    public static void main(String[] args) {
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(new int[]{
                4, 8, 6, 12, 16, 14, 10
        }));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        return help(sequence, 0, sequence.length);
    }

    public boolean help(int[] sequence, int start, int end) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        // 后续遍历根为最后一个元素
        int root = sequence[end - 1];
        int i;
        // 因为是二叉搜索树，所以找到比根大的元素下标即为右子树
        for (i = 0; i < end - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j;
        // 右子树中如果存在比根小的，即不符合要求
        for (j = i; j < end - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > 0) {
            // 递归判断左子树
            left = help(sequence, start, i);
        }
        boolean right = true;
        if (i < end - 1) {
            // 递归判断右子树
            right = help(sequence, start + i, end - 1);
        }
        // 当左右子树都满足时返回true
        return left && right;
    }
}