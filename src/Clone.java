/**
 * @(#)Clone.java, 2018-02-10.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * Clone
 * <p>
 * 复杂链表的复制
 *
 * @author lirongqian
 * @since 2018/02/10
 */
public class Clone {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        RandomListNode currentNode = pHead;
        // 首先复制每个结点，并将每个复制的结点添加到每个结点的后面
        while (currentNode != null) {
            // 创建复制的结点
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            // 保存当前结点的下一个结点，供添加复制结点时使用
            RandomListNode nextNode = currentNode.next;
            // 添加复制后的结点
            currentNode.next = cloneNode;
            // 将复制后的结点与当前结点的下一个结点相连
            cloneNode.next = nextNode;
            // 当前结点向后移动一位(移动到下一个原结点)
            currentNode = nextNode;
        }

        currentNode = pHead;
        // 然后重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while (currentNode != null) {
            // 将当前结点的随机指针赋值给复制结点，当随机结点不为空时，则移动到随机结点的下一个
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            // 当前结点移动到下一个原结点
            currentNode = currentNode.next.next;
        }

        // 最后拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        // 保存复制结点的头结点
        RandomListNode pCloneHead = pHead.next;
        while (currentNode != null) {
            // 复制结点为当前结点的下一个结点
            RandomListNode cloneNode = currentNode.next;
            // 当前结点的下一个结点为复制结点的下一个结点
            currentNode.next = cloneNode.next;
            // 复制结点的下一个结点不为空，则后移一位
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            // 当前结点移动到下一个原结点
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}