import java.util.ArrayList;

/**
 * PrintListFromTailToHead
 *
 * 从尾到头打印链表
 * @author lirongqian
 * @since 2018/02/15
 */
public class PrintListFromTailToHead {

    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}