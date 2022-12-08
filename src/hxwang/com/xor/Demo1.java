package hxwang.com.xor;

/**
 * <p> 异或练习</P>
 * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
 *
 * @author wanghongxu
 * @data 2022/10/30
 */

public class Demo1 {
    public static void main(String[] args) {
        int[] array = new int[]{233, 233, 2, 2, 2, 3, 3, 3, 4, 4};
        int[] array1 = new int[]{233, 233, 2, 2, 2, 2, 3, 3, 3, 4, 4};
        printOddTimesNum2(array);
        System.out.println(test1(array1));
    }

    /*
     * 有一种数出现奇数次
     * n^0=N
     * N^n=0
     * 异或符合交换律 结合律
     * @author wanghongxu
     * @date 2022/10/30
     */
    private static int test1(int[] array) {
        int eor = 0;
        for (int j : array) {
            // 一个数异或自己为0
            eor = eor ^ j;
        }
        return eor;
    }

    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // a 和 b是两种数
        // eor != 0
        // eor最右侧的1，提取出来
        // eor :     00110010110111000
        // rightOne :00000000000001000
        int rightOne = eor & (-eor); // 提取出最右的1


        int onlyOne = 0; // eor'
        for (int i = 0; i < arr.length; i++) {
            //  arr[1] =  111100011110000
            // rightOne=  000000000010000
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

}
