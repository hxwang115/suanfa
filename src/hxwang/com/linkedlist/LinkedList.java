package hxwang.com.linkedlist;


/**
 * <p> </P>
 * 链表练习
 *
 * @author hxwang
 * @data 2022/11/15
 */

public class LinkedList {

    /*
     * 单链表的反转
     * @author hxwang
     * @date 2022/11/15
     */
    public  Node<Integer> reverseLinkedList(Node<Integer> head) {
        // 两个变量
        Node<Integer> next = null;
        Node<Integer> pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /*
     * 双链表的反转
     * @author hxwang
     * @date 2022/11/19
     */
    public  DoubleNode<Integer> reverseDoubleLinkedList(DoubleNode<Integer> head) {
        // 创建两个变量
        DoubleNode<Integer> next = null;
        DoubleNode<Integer> pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /*
     * 删除链表中指定的值
     * @author hxwang
     * @date 2022/11/19
     */
    public  Node<Integer> removeValue(Node<Integer> head, int num) {
        // 让head来到第一个不需要删的位置
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        // 1.当链表里全部都是num时 head == null
        // 2.head != null
        Node<Integer> pre = head;
        Node<Integer> cur = head;
        while (cur != null) {
            // 值不为 num 时向后挂， 值为num时跳过
            if (cur.value != num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
