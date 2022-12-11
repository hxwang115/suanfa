package hxwang.com.sort.quicksort;

/**
 * <H2> </H2>
 *
 * @author hxwang
 * @data 2022/12/11
 */

public class HeLangGuoQi {
    public static int[] process(int[] arr) {
        int less = -1; // 小于边界
        int more = arr.length - 1; // 大于边界
        int index = 0;// 当前数的位置
        while (index < more) {
            if (arr[index] == arr[arr.length - 1]) { // 当前位置的数和目标数相等时，当前数的位置加一
                index++;
            } else if (arr[index] < arr[arr.length - 1]) { // 当前位置的数小于目标数时，当前数的位置加一,当前数和小于边界的下一个数交换，小于边界向后移
                swap(arr, index++, ++less);
            } else if (arr[index] > arr[arr.length - 1]) { // 当前位置的数大于目标数时，当前数的位置不动，当前数和大于边界的前一个数交换，大于向前移
                swap(arr, index, --more);
            }
        }
        swap(arr, arr.length - 1, more);// 让最后一个数
        return new int[]{less + 1, more};

    }

    private static void swap(int[] arr, int index, int less) {
        arr[index] ^= arr[less];
        arr[less] ^= arr[index];
        arr[index] ^= arr[less];
    }
}
