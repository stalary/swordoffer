/**
 * @(#)ReverseList.java, 2018-02-12.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * ReverseList
 *
 * 反转链表
 * @author lirongqian
 * @since 2018/02/12
 */
public class ReverseList {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 移动到倒数第二个元素，获取当前链表
        ListNode node = ReverseList(head.next);
        // 下下个元素设置为当前结点(跳过末尾结点)
        head.next.next = head;
        // 断开与之前结点的关联
        head.next = null;
        return node;
    }
}