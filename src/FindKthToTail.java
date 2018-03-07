
/**
 * FindKthToTail
 *
 * 输出链表中倒数第k个结点
 * @author lirongqian
 * @since 2018/02/13
 */
public class FindKthToTail {

    /**
     * 申请一对快慢指针，快指针首先移动k，这样当快指针到达末尾时，慢指针刚好与快指针相差k个结点，即为倒数第k个结点
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        int len = 0;
        // 首先求出链表的总长度，判断是否存在倒数第k个结点
        while (node != null) {
            node = node.next;
            len++;
        }
        if (len < k) {
            return null;
        }
        // 申请快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 快指针移动k个结点
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // 当快指针到达末尾时，返回慢指针
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode FindKthToTail1(ListNode head,int k) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        int len = 0;
        // 首先求出链表的总长度，判断是否存在倒数第k个结点
        while (node != null) {
            node = node.next;
            len++;
        }
        if (len < k) {
            return null;
        }
        ListNode result = head;
        for (int i = 0; i < len - k; i++) {
            result = result.next;
        }
        return result;
    }
}