/**
 * @(#)GetMedian.java, 2018-01-30.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.PriorityQueue;

/**
 * GetMedian
 * 数据流中的中位数
 *
 * @author lirongqian
 * @since 2018/01/30
 */
public class GetMedian {

    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    /**
     * 在插入时，进行操作，最后直接求出中位数
     * 可以利用一个大根堆，一个小根堆来进行操作
     * 当输入个数为偶数时，先进入大根堆进行调整，然后将大根堆中最小的元素放入小根堆
     * 如果输入个数为奇数，则先进入小根堆进行调整，然后将小跟堆中最大的元素放入小根堆
     * 这样大根堆中的最小元素和小根堆中的最大元素即可决定中位数。
     * 因为当总数奇数时，会向minHeap中加入比maxHeap多1的元素，所以中位数直接在minHeap中获取
     *
     * @param num
     */
    public void Insert(Integer num) {
        /**
         *
         1、void add(Object e):将指定元素加入队列的尾部，直接调用offer。

         2、Object element():获取但不删除队列头部的元素。

         3、boolean offer(Object e):将指定元素加入队列的尾部，值为空时抛出异常。

         4、Object peek():获取但不删除该元素，如果队列为空，则返回null。

         5、Object poll():获取并删除队列头部的元素，如果队列为空，则返回null。

         6、Object remove():获取并删除队列头部的元素，如果队列为空，抛出异常。
         */
        if (count % 2 == 0) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        count++;
    }

    /**
     * 通过判断总数的数量来求中位数
     *
     * @return
     */
    public Double GetMedian() {
        if (count % 2 == 0) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return (double) minHeap.peek();
        }
    }
}