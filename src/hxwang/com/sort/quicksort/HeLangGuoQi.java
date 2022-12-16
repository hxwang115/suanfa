package hxwang.com.sort.quicksort;

/**
 * <H2> 快速排序 </H2>
 *
 * @author hxwang
 * @data 2022/12/11
 */

public class HeLangGuoQi {
    /**
     * 荷兰国旗问题，以最后一个数为基准，让数组中小于这个数的放左边，大于这个数的放右边，等于这个数的放中间
     *
     * @param l 数组的做下标
     * @param r 数组的有下标
     * @return 等于目标数的下标范围
     * @author hxwang
     * @date 2022/12/15
     */
    public static int[] flag(int[] arr, int l, int r) {
        int less = l - 1; // 小于边界
        int more = r; // 大于边界
        int index = l;// 当前数的位置
        while (index < more) {
            if (arr[index] == arr[r]) { // 当前位置的数和目标数相等时，当前数的位置加一
                index++;
            } else if (arr[index] < arr[r]) { // 当前位置的数小于目标数时，当前数的位置加一,当前数和小于边界的下一个数交换，小于边界向后移
                swap(arr, index++, ++less);
            } else if (arr[index] > arr[r]) { // 当前位置的数大于目标数时，当前数的位置不动，当前数和大于边界的前一个数交换，大于向前移
                swap(arr, index, --more);
            }
        }
        swap(arr, arr[r], arr[more]);// 让最后一个数和右边界的第一个数交换
        return new int[]{less + 1, more};
    }

    /**
     * 使数组[l...r]有序
     *
     * @author hxwang
     * @date 2022/12/15
     */
    public static void process(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 从数组中取一个作为目标数这样可以避免最差情况，时间复杂度为O(N^2),可以将时间复杂度降为O(n*㏒N)
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        // 荷兰国旗问题
        int[] ints = flag(arr, l, r);
        process(arr, l, ints[0] - 1);
        process(arr, ints[1] + 1, r);
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void swap(int[] arr, int index, int less) {
        arr[index] ^= arr[less];
        arr[less] ^= arr[index];
        arr[index] ^= arr[less];
    }
}
