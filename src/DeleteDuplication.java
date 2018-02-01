/**
 * @(#)DeleteDuplication.java, 2018-02-01.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * DeleteDuplication
 *
 * 删除一个排序链表中重复的元素
 * @author lirongqian
 * @since 2018/02/01
 */
public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode head) {
        // 当仅有一个结点时，不会存在重复元素，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 当前结点和下个结点相等时，找到下一个不相等的结点，递归进行删除，注意要保存当前结点，防止链表断开
        if (head.val == head.next.val) {
            ListNode node = head.next;
            while (node != null && node.val == head.val) {
                node = node.next;
            }
            return deleteDuplication(node);
        } else {
            // 当不相同时直接开始遍历下一个结点
            head.next = deleteDuplication(head.next);
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}