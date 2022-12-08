package hxwang.com.stacksandqueues;

import hxwang.com.linkedlist.DoubleNode;

/**
 * <H2> 双向链表实现队列 </H2>
 *
 * @author hxwang
 * @data 2022/11/20
 */

public class DoubleNodeQueue<T> {
    private final DoubleNode<T> queue;

    public DoubleNodeQueue(){
        queue = new DoubleNode<>();
    }

    public void push(T value){
        queue.addFromBottom(value);
    }

    public T pop(){
        return queue.popFromHead();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}
