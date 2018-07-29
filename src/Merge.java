
/**
 * Merge
 *
 * 合并两个已经排好序的链表，并且要满足单调不减
 * @author lirongqian
 * @since 2018/02/12
 */
public class Merge {

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(4);
        root.next.next = new ListNode(5);
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(2);
        root1.next.next = new ListNode(8);
        System.out.println(new Merge().Merge(root, root1));
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            // 跳过小的值直到末尾，进行返回
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}