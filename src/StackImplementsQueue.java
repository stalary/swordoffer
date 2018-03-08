
import java.util.Stack;

/**
 * StackImplementsQueue
 * <p>
 * 用两个栈实现队列
 *
 * @author lirongqian
 * @since 2018/02/14
 */
public class StackImplementsQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}