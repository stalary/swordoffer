
/**
 * EntryNodeOfLoop
 *
 * 查找一个带环链表的入口
 * @author lirongqian
 * @since 2018/02/01
 */
public class EntryNodeOfLoop {

    /**
     * 从相遇点向后移动，当再次回到这个点的时候，就能统计出环中元素的数量
     * @param head
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (slow == fast) {
                break;
            }
        }
        // 存在null时代表无环
        if (slow == null || fast == null) {
            return null;
        }
        // 将fast指针重置，当与相遇点再次相遇时，即为入口
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}