/**
 * @(#)IsPopOrder.java, 2018-02-11.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

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
            stack.push(in);
            while (!stack.empty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }
}