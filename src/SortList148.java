/**
 * SortList148
 * 对list进行排序
 * @author lirongqian
 * @since 2018/05/07
 */
public class SortList148 {

    /**
     * 因为时间复杂度要求O(nlogn)，所以按照归并排序的思路进行排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = partition(head);
        // 先进行划分
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
        // 归并排序
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    /**
     * 通过快慢指针找到一半的结点
     * @param head
     * @return
     */
    private ListNode partition(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
}