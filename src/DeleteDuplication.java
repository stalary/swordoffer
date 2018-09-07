import java.util.HashSet;
import java.util.Set;

/**
 * DeleteDuplication
 *
 * 删除一个排序链表中重复的元素
 *
 * @author lirongqian
 * @since 2018/02/01
 */
public class DeleteDuplication {


    public static void main(String[] args) {
        ListNode root = new ListNode(2);
        root.next = new ListNode(3);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(5);
        System.out.println(new DeleteDuplication().deleteDuplication(root));
    }
    /**
     * 删除重复结点，直到找到不重复的为止、
     * 2，3，3，5
     * 2  3，3，5
     * 2  3，5
     * 2，5
     * @param head
     * @return
     */
    public ListNode deleteDuplication(ListNode head) {
        // 当仅有一个结点时，不会存在重复元素，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 当前结点和下个结点相等时，找到下一个不相等的结点，递归进行删除，注意要保存当前结点，防止链表断开
        if (head.val == head.next.val) {
            // 保存head结点的下一个结点，防止结点断开
            ListNode node = head.next;
            // 直到下一个结点不等于头结点
            while (node != null && node.val == head.val) {
                node = node.next;
            }
            // 继续判断后面的结点是否有重复元素
            return deleteDuplication(node);
        } else {
            // 当不相同时直接开始遍历下一个结点，最后会返回不同的节点
            head.next = deleteDuplication(head.next);
            return head;
        }
    }

    /**
     * 使用set删除重复元素，但保留第一次出现的元素,
     * 1,2,3,3,4,4,5 -> 1,2,3,4,5
     * @param head
     */
    public ListNode deleteDuplication1(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        ListNode pre = null;
        while (temp != null) {
            if (set.contains(temp.val)) {
                // 第二次出现时，替换元素
                pre.next = temp.next;
            } else {
                // 第一次出现时，存储当前元素到前一个节点
                set.add(temp.val);
                pre = temp;
            }
            // 继续向后移动
            temp = temp.next;
        }
        return head;
    }

}