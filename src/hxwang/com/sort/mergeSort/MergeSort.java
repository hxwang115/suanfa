package hxwang.com.sort.mergeSort;

import java.util.Arrays;

/**
 * <H2> 归并排序 </H2>
 * 时间复杂度为 O(N*㏒N)
 *
 * @author hxwang
 * @data 2022/11/26
 */

public class MergeSort {
    /**
     * 将 数组 在 L-R 范围上排序
     *
     * @author hxwang
     * @date 2022/11/26
     */
    public static void process(int l, int r, int[] array) {
        if (l == r) {
            return;
        }
        // 1.取中点的下标
        int mid = l + ((r - l) >> 1);
        // 2.让数组的左边有序
        process(l, mid, array);
        // 3.让数组的右边有序
        process(mid + 1, r, array);
        // 4.将左右两个合在一起
        merge(mid, l, r, array);
    }

    private static void merge(int m, int l, int r, int[] array) {
        int[] newArray = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        // 左数组和又数组比较 那边数小取那个  如果相等取左边
        while (p1 <= m && p2 <= r) {
            newArray[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }
        // p1越界 或者 p2越界
        while (p1 <= m) {
            newArray[i++] = array[p1++];
        }
        while (p2 <= r) {
            newArray[i++] = array[p2++];
        }
        // 将排列好的数组复制回原数组
        for (int j = 0; j < newArray.length; j++) {
            array[l + j] = newArray[j];
        }
    }

    /**
     * 使用递归的方式实现归并排序
     *
     * @author hxwang
     * @date 2022/11/26
     */
    public static void mergeSort1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        process(0, array.length - 1, array);
    }

    /**
     * 使用非递归的方式实现
     *
     * @author hxwang
     * @date 2022/11/26
     */
    public static void mergeSort2(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int n = array.length;
        // 1.设置步长
        int mergeSize = 1;
        while (mergeSize < n) {
            // 当前左组的第一个位置
            int l = 0;
            while (l < n) {
                int m = l + mergeSize - 1;
                // 剩余的数不够
                if (m >= n) {
                    break;
                }
                // 如果对于此步长数据够的话 取 （m+步长），如果不够取 数组最后一位
                int r = Math.min(m + mergeSize, n - 1);
                merge(m, l, r, array);
                l = m + 1;
                // 防止整数溢出
                if (mergeSize > n / 2) {
                    break;
                }
            }
            // 步长乘2
            mergeSize <<= 1;
        }
    }

    public static void main(String[] args) {
        int[] array = SmallSum.makeArray(10, 100);
        System.out.println(Arrays.toString(array));
        mergeSort1(array);
        System.out.println(Arrays.toString(array));
    }
}

