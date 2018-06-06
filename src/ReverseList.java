
/**
 * ReverseList
 *
 * 反转链表
 * @author lirongqian
 * @since 2018/02/12
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(3);
        root.next.next = new ListNode(5);
        root.next.next.next = new ListNode(7);
        System.out.println(new ReverseList().reverse(root));
    }

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

    // 倒置
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            // 下一个结点
            ListNode next = head.next;
            // 下一个节点等于前一个结点
            head.next = prev;
            // 保存当前节点，代表上一个节点
            prev = head;
            // 将当前节点向后移动
            head = next;
        }
        return prev;
    }
}