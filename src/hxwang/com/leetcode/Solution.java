package hxwang.com.leetcode;

/**
 * <H2> </H2>
 *
 * @author hxwang
 * @data 2022/12/18
 */

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean flag = true;
        int total = nums1.length + nums2.length;
        int m = total / 2;
        if (total % 2 == 0) {
            flag = false;
        }
        int p1 = 0;
        int p2 = 0;
        if (nums1.length == 0) {
            if (nums2.length == 1) {
                return nums2[0];
            }
            return flag ? nums2[m] : (double) (nums2[m] + nums2[m - 1]) / 2;
        }
        if (nums2.length == 0) {
            if (nums1.length == 1) {
                return nums1[0];
            }
            return flag ? nums1[m] : (double) (nums1[m] + nums1[m - 1]) / 2;
        }
        int[] help = new int[nums1.length + nums2.length];
        int i = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            help[i] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
            if (i == m) {
                return flag ? help[m] : (double) (help[m] + help[m - 1]) / 2;
            }
            i++;
        }
        while (p1 < nums1.length) {
            help[i] = nums1[p1++];
            if (i == m) {
                return flag ? help[m] : (double) (help[m] + help[m - 1]) / 2;
            }
            i++;
        }
        while (p2 < nums2.length) {
            help[i] = nums2[p2++];
            if (i == m) {
                return flag ? help[m] : (double) (help[m] + help[m - 1]) / 2;
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] num1 = {2, 3, 4};
        int[] num2 = {};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
    }
}
