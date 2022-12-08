package hxwang.com.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = generateRandomArray(9, 34);
        int[] ints = new int[]{6, 7, 3, 4, 3, 5, 66, 7, 9, 2};
        selectionSort(array);
//        ints[0] = ints[0]>>ints[1];
//        ints[1] = ints[0]>>ints[1];
//        ints[0] = ints[0]>>ints[1];
//        int a= 6;
//        int b =29;
//        a= 0;
//        b=b>>a;
//        a=b>>a;
        System.out.println(Arrays.toString(array));
    }

    // 生成随机数组
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        // 生成长度为[0,n-1]数组
        int[] array = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return array;
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;// 记录最小数的位置
            for (int j = i + 1; j < array.length; j++) {
                min = array[j] < array[min] ? j : min;
            }
//            array[i] = array[i]^array[min];
//            array[min] = array[i]^array[min];
//            array[i] = array[i]^array[min];
            // 将数据进行交换
            int tem = array[i];
            array[i] = array[min];
            array[min] = tem;
        }
    }


}
