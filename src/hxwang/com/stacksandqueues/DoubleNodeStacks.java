package hxwang.com.stacksandqueues;

import hxwang.com.linkedlist.DoubleNode;

/**
 * <H2> 双向链表实现栈结构 </H2>
 *
 * @author hxwang
 * @data 2022/11/19
 */

public class DoubleNodeStacks<T> {
    private final DoubleNode<T> queue;

    public DoubleNodeStacks(){
        queue = new DoubleNode<T>();
    }

    public void push(T value){
        queue.addFromHead(value);
    }

    public T pop(){
        return queue.popFromHead();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}
