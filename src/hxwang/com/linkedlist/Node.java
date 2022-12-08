package hxwang.com.linkedlist;

/**
 * <H2> 链表 </H2>
 *
 * @author hxwang
 * @data 2022/11/20
 */

public class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T data) {
        value = data;
    }
}
