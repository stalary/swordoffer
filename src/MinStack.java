/**
 * @(#)MinStack.java, 2018-02-11.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * MinStack
 * <p>
 * 能够得到栈最小值的栈
 *
 * @author lirongqian
 * @since 2018/02/11
 */
public class MinStack {

    private int size;
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack = new Stack<>();
    private Integer[] elements = new Integer[10];

    public void push(int node) {
        // 添加元素时先进行扩容
        ensureCapacity(size + 1);
        elements[size++] = node;
        // 当新加入的元素比最小值小时，更新最小值
        if (node <= min) {
            minStack.push(node);
            min = minStack.peek();
        } else {
            minStack.push(min);
        }
    }

    private void ensureCapacity(int size) {
        int len = elements.length;
        if (size > len) {
            // 每次扩容为原来的1.5倍
            int newLen = (len * 3) / 2 + 1;
            // 将扩容后的数组进行复制
            elements = Arrays.copyOf(elements, newLen);
        }
    }

    public void pop() {
        Integer top = top();
        if (top != null) {
            elements[size - 1] = null;
        }
        size--;
        minStack.pop();
        min = minStack.peek();
        //    System.out.println(min+"");
    }

    public int top() {
        if (!empty()) {
            if (size - 1 >= 0) {
                return elements[size - 1];
            }
        }
        return (Integer) null;
    }

    public boolean empty() {
        return size == 0;
    }

    public int min() {
        return min;
    }
}