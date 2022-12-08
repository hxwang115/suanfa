package hxwang.com.linkedlist;

/**
 * <H2> 双向链表 </H2>
 *
 * @author hxwang
 * @data 2022/11/20
 */

public class DoubleNode<T> {
    public T value;
    public DoubleNode<T> next;
    public DoubleNode<T> last;

    public DoubleNode(T data) {
        value = data;
    }
    public DoubleNode(){}

    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    /**
     * 从链表头部插入数据
     *
     * @author hxwang
     * @date 2022/11/20
     */
    public void addFromHead(T value) {
        DoubleNode<T> cur = new DoubleNode<>(value);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.next = head;
            head.last = cur;
            head = cur;
        }
    }

    /**
     * 从底部插入元素
     *
     * @author hxwang
     * @date 2022/11/20
     */
    public void addFromBottom(T value) {
        DoubleNode<T> cur = new DoubleNode<>(value);
        if (head == null) {
            head = cur;
        } else {
            tail.next = cur;
            cur.last = tail;
        }
        tail = cur;
    }

    /**
     * 从头部返回数据
     *
     * @author hxwang
     * @date 2022/11/20
     */
    public T popFromHead() {
        if (head == null) {
            return null;
        }
        DoubleNode<T> cur = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.last = null;
            cur.next = null;
        }
        return cur.value;
    }

    /**
     * 从尾部返回数据
     *
     * @author hxwang
     * @date 2022/11/20
     */
    public T popFromBottom() {
        if (head == null) {
            return null;
        }
        DoubleNode<T> cur = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.last;
            tail.next = null;
            cur.last = null;
        }
        return cur.value;
    }

    /**
     * 判断链表是否为空
     *
     * @author hxwang
     * @date 2022/11/20
     */
    public boolean isEmpty() {
        return head == null;
    }
}
