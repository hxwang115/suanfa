package hxwang.com.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * <H2> 手写堆 </H2>
 * 如果 T 为基础类型需要给其包一层
 *
 * @author hxwang
 * @data 2023/1/2
 */

public class HeapGreater<T> {

    private class Inner<T> {
        public T value;

        public Inner(T v) {
            value = v;
        }
    }

    private ArrayList<Inner<T>> heap;
    private HashMap<Inner<T>, Integer> indexMap; // 反向索引表
    private int heapSize;
    private Comparator<Inner<T>> comp; // 比较器

    // 构造方法
    public HeapGreater(Comparator<Inner<T>> c) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        comp = c;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean contains(Inner<T> obj) {
        return indexMap.containsKey(obj);
    }

    public void push(Inner<T> obj) {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        // 整理堆数据然后 堆大小+1
        heapInsert(heapSize++);
    }

    public Inner<T> pop() {
        Inner<T> ans = heap.get(0);
        swap(0, heapSize - 1);
        indexMap.remove(ans);
        heap.remove(--heapSize);
        heapify(0);
        return ans;
    }

    public void resign(Inner<T> obj) {
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }

    public void remove(Inner<T> obj){
        int index = indexMap.get(obj);
        swap(index,heapSize-1);
        heap.remove(--heapSize);
        indexMap.remove(obj);
        heapInsert(index);
        heapify(index);
    }

    public List<Inner<T>> getAllElements(){
        return new ArrayList<>(heap);
    }

    private void heapify(int index) {
        // 左孩子的位置
        int left = (index >> 1) + 1;
        while (left < heapSize) {
            // 取出符合要求的孩子的下标
            int best = left + 1 < heapSize && comp.compare(heap.get(left + 1), heap.get(left)) < 0 ? (left + 1) : left;
            // 让符合要求的孩子和当前位置的数据进行比较
            best = comp.compare(heap.get(best), heap.get(index)) < 0 ? best : index;
            if (best == index) {
                break;
            }
            swap(best, index);
            index = best;
        }
    }

    private void heapInsert(int index) {
        while (comp.compare(heap.get(index), heap.get((index - 1) >> 1)) < 0) {
            swap(index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }

    private void swap(int i, int j) {
        Inner<T> o1 = heap.get(i);
        Inner<T> o2 = heap.get(j);
        // 将堆上的数据换位置
        heap.set(i, o2);
        heap.set(j, o1);
        // 反向索引表也需要更新
        indexMap.put(o1, j);
        indexMap.put(o2, j);
    }


}
