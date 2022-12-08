package hxwang.com.stacksandqueues;

/**
 * <H2> 数组实现队列 </H2>
 *
 * @author hxwang
 * @data 2022/11/20
 */

public class ArrayQueue<T> {
    // 队列的长度
    private final int limit;
    // 加数的位置
    private int pushI;
    // 取数的位置
    private int popI;
    // 队列的长度
    private int size;

    private final int[] array;

    public ArrayQueue(Integer value) {
        pushI = 0;
        popI = 0;
        size = 0;
        array = new int[value];
        limit = value;
    }

    public void push(int value) {
        if (size == limit) {
            throw new RuntimeException("队列已满，不能添加了");
        }
        array[pushI] = value;
        size++;
        pushI = nextIndex(pushI);
    }

    public int pop() {
        if (size == 0) {
            throw new RuntimeException("队列已空，不能再取了");
        }
        size--;
        int value = array[popI];
        popI = nextIndex(popI);
        return value;
    }

    private int nextIndex(int i) {
        return i < limit - 1 ? i + 1 : 0;
    }

}
