package hxwang.com.sort.heapsort;

import hxwang.com.sort.quicksort.HeLangGuoQi;

/**
 * <H2>  堆排序 </H2>
 *
 * @author hxwang
 * @data 2022/12/18
 */

public class HeapSort {
    public void heapSort(int[] arr) {
        // 1. 先让数组变为大根堆
        // 从上往下建大根堆 时间复杂度为 O(N*㏒N)
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        // 从下往上建大根堆 时间复杂度为 O(N)
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        // 2. 0位置是最大的数，和数组的最后一个数进行交换，让堆的大小减1(heapSize-1).
        HeLangGuoQi.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            //3. 让换到0位置的数调整为大根堆
            heapify(arr, 0, heapSize);
            //4.0位置是最大的数，和数组的最后一个数进行交换，让堆的大小减1(heapSize-1).
            HeLangGuoQi.swap(arr, 0, --heapSize);
        }
    }

    // 将指定位置的数向下调整位置到达不能再向下的位置
    private void heapify(int[] arr, int index, int heapSize) {
        // 左孩子的位置
        int left = (index << 1) + 1;
        while (left < heapSize) {
            // 取出较大孩子的下标
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 让孩子大的数和当前位置数比较
            largest = arr[largest] > arr[index] ? largest : index;
            // 如果相等 说明孩子没有比他大的，结束循环
            if (largest == index) {
                break;
            }
            // 当前数和比他大的孩子进行交换
            HeLangGuoQi.swap(arr, largest, index);
            index = largest;
            left = (index << 1) + 1;
        }
    }

    // 向堆中添加数(从上往下建大根堆)
    private void heapInsert(int[] arr, int index) {
        // 当前位置和父节点进行比较
        while (arr[index] > arr[(index - 1) >> 1]) {
            HeLangGuoQi.swap(arr, index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }
}
