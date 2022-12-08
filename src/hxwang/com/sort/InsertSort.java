package hxwang.com.sort;

import java.util.Arrays;

/**
 * <p> 插入排序</p>
 * 时间复杂度和数据排序有关，不是固定的
 *
 * @author wanghongxu
 * @data 2022/10/26
 */
public class InsertSort {
    public static void main(String[] args) {
        int testTime = 5000;
        boolean re = true;
        for (int i = 0; i < testTime; i++) {
            int[] randomArray = getRandomArray(50, 200);
            int[] array1 = insertSort(randomArray);
            int[] array2 = sort(randomArray);
            boolean equal = isEqual(array1, array2);
            if (!equal) {
                System.out.println("数组1：" + Arrays.toString(array1));
                System.out.println("数组2：" + Arrays.toString(array2));
                re = false;
                break;
            }
        }
        System.out.println(re ? "Nice" : "Fuck!!!");
    }

    private static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j + 1] < array[j]; j--) {
                /*
                 * 交换位置
                 * @Param array
                 * @return
                 * @author wanghongxu
                 * @date 2022/10/27
                 */
                array[j] = array[j] ^ array[j + 1];
                array[j + 1] = array[j] ^ array[j + 1];
                array[j] = array[j] ^ array[j + 1];
            }
        }
        return array;
    }

    /*
     * 生成随机数组
     * @Param null
     * @return {@link null}
     * @author wanghongxu
     * @date 2022/10/29
     */
    private static int[] getRandomArray(int maxSize, int maxValue) {
        // 生成[0,n-1]的随机数组
        int[] array = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
        }
        return array;
    }

    /*
     * 使用系统方法对数组排序
     * @Param null
     * @return {@link null}
     * @author wanghongxu
     * @date 2022/10/29
     */
    private static int[] sort(int[] array) {
        Arrays.sort(array);
        return array;
    }


    private static boolean isEqual(int[] array1, int[] array2) {
        if (array1 == null && array2 == null) {
            return true;
        }
        if (array1 == null && array2 != null || (array1 != null && array2 == null)) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

}
