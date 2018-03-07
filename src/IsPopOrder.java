
import java.util.Stack;

/**
 * IsPopOrder
 *
 * 栈的压入、弹出序列
 * @author lirongqian
 * @since 2018/02/11
 */
public class IsPopOrder {

    /**
     * 将输入的数组依次压入栈中，当输出数组等于peek的元素时，则弹出，如果最后栈为空，则代表弹出序列是由压入序列组成的
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        for (int in : pushA) {
            // 将输入元素压入栈中
            stack.push(in);
            // 当第一个元素和输出元素相同时，则弹出
            while (!stack.empty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        // 当栈为空时，则代表符合条件
        return stack.empty();
    }
}