package hxwang.com.sort.mergeSort;

/**
 * <H2> 小和问题 </H2>
 * 给定一个数组，数组左边的数比右边的数小的数之和
 * 例：[3,2,1,1] 小和为0   [2,3,1,4]  小和为2+2+3+1
 *
 * @author hxwang
 * @data 2022/11/27
 */

public class SmallSum {
    // 在数组的 l - r 范围上有序并返回小和数
    public static int process(int l, int r, int[] array) {
        if (l == r) {
            return 0;
        }
        // 加号优先级要 大于 右移
        int m = l + ((r - l) >> 1);
        return process(l, m, array) + process(m + 1, r, array) + merger(l, r, m, array);
    }

    public static int merger(int l, int r, int m, int[] array) {
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        int i = 0;
        int[] newArray = new int[r - l + 1];
        while (p1 <= m && p2 <= r) {
            // 当左组中的数小时取左组的数 ,并且产生小和(右组中之后的数都会对左组的数产生小和)
            res += array[p1] < array[p2] ? (r - p2 + 1) * array[p1] : 0;
            // 当左左的数和右组的数相时去右边的数
            newArray[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }
        // 有一组数越界
        while (p1 <= m) {
            newArray[i++] = array[p1++];
        }
        while (p2 <= r) {
            newArray[i++] = array[p2++];
        }
        // 将排序好的数并入原数组
        for (i = 0; i < newArray.length; i++) {
            array[l + i] = newArray[i];
        }
        return res;
    }

    public static int smallSum(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return process(0, array.length - 1, array);
    }

    /**
     * 生成一个随机数组
     *
     * @param maxSize 数组最大的大小
     * @param max     数据最大的大小
     * @author hxwang
     * @date 2022/11/27
     */
    public static int[] makeArray(int maxSize, int max) {
        int[] array = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (max + 1)) - (int) (Math.random() * max);
        }
        return array;
    }

    public static int smallSum1(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                res += array[j] < array[i] ? array[j] : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = makeArray(100, 100);
    }

}
