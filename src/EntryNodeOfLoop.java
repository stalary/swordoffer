
/**
 * EntryNodeOfLoop
 *
 * 查找一个带环链表的入口
 * @author lirongqian
 * @since 2018/02/01
 */
public class EntryNodeOfLoop {

    /**
     * 使用一对快慢指针来判断是否有环，快指针每次移动2，慢指针每次移动1
     * @param pHead
     * @return
     */
    public ListNode meetNode(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        // 创建快慢指针
        ListNode slow = pHead.next;
        ListNode fast = slow.next;
        // 当快慢指针都不为空时一直向后遍历
        while (fast != null && slow != null) {
            // 当两指针相遇时，返回相遇点
            if (fast == slow) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            // 快指针移动一次后要判断是否以及有相遇点，如果没有再继续移动
            if (fast != slow) {
                fast = fast.next;
            }
        }
        return null;
    }

    /**
     * 从相遇点向后移动，当再次回到这个点的时候，就能统计出环中元素的数量
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        // 查找相遇的点
        ListNode meetNode = meetNode(pHead);
        if (meetNode == null) {
            return null;
        }
        // 统计从相遇点再次到相遇点的数量，即环内元素的数量
        int count = 1;
        ListNode p1 = meetNode;
        while (p1.next != meetNode) {
            p1 = p1.next;
            count++;
        }
        // p1先移动环内数量的距离
        p1 = pHead;
        for (int i = 0; i < count; i++) {
            p1 = p1.next;
        }
        // 此时p2再从头开始运动，相遇时即为环的入口。
        ListNode p2 = pHead;
        while (p2 != p1) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}