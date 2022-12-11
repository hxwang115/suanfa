package hxwang.com.sort.mergeSort;

/**
 * <H2> 归并排序</H2>
 * 给你一个整数数组nums 以及两个整数lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含lower和upper）之内的 区间和的个数 。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-of-range-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hxwang
 * @data 2022/12/5
 */

public class CountRangeSum {
    /*
    问题转换：求出数组的区间和数组
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //1. 获得区间和数组
        long [] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return process(sum, 0, sum.length - 1, lower, upper);

    }

    private int process(long[] sum, int l, int r, int lower, int upper) {
        // 当区间内只有一个数时判断这个数是否符合条件
        if (l == r) {
            return sum[l] >= lower && sum[l] <= upper ? 1 : 0;
        }
        // 2. 左组符合范围的个数+右组符合范围的个数+合并过程中符合范围的个数
        int m = l + ((r - l) >> 1);// 取中点
        return process(sum, l, m, lower, upper)
                + process(sum, m + 1, r, lower, upper)
                + merge(sum, l, m, r, lower, upper);
    }

    private int merge(long[] arr, int l, int m, int r, int lower, int upper) {
        // 3. 符合条件的数是 右组的数-左组的数在条件范围内 转化为 左组的数在[右组的数-upper,左组的数-lower]范围内
        int ans = 0;
        // 设定一个窗口，因为左组和右组分别有序所以窗口不会回退 时间复杂度为
        int windowL = l;
        int windowR = l;
        for (int i = m + 1; i <= r; i++) {
            long min = arr[i] - upper;
            long max = arr[i] - lower;
            // 右边界不能大于max
            while (windowR <= m && arr[windowR] <= max) {
                windowR++;
            }
            // 左边界不能小于min,如果小于min边界向右移
            while (windowL <= m && arr[windowL] < min) {
                windowL++;
            }
            // 窗口内的数为符合条件的数
            ans += windowR - windowL;
        }
        long[] help = new long[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 有一个不满足条件下面两个while 只会执行一个
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        // 将help数组复制回原始数组
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return ans;
    }
}
