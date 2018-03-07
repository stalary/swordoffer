
import java.util.HashSet;
import java.util.Set;

/**
 * FindFirstCommonNode
 *
 * 查找两个链表的第一个公共结点
 * @author lirongqian
 * @since 2018/02/07
 */
public class FindFirstCommonNode {

    /**
     * 首先判断出两个链表谁的的长度长，然后让长度较长的链表走差值
     * 再进行同步的移动，遇到相同的点的时候即返回
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = len(pHead1);
        int len2 = len(pHead2);
        if (len1 > len2) {
            pHead1 = walk(pHead1, len1 - len2);
        } else {
            pHead2 = walk(pHead2, len2 - len1);
        }
        while (pHead1 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    public int len(ListNode node) {
        if (node == null) {
            return 0;
        }
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public ListNode walk(ListNode node, int step) {
        while (step > 0) {
            node = node.next;
            step--;
        }
        return node;
    }

    /**
     * 使用HashSet进行存储pHead1，然后遍历pHead2，当发现有set中存在的元素时，直接返回
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set = new HashSet<>();
        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (set.contains(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }
}