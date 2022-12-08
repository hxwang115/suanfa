package hxwang.com.xor;

/**
 * <p> </P>
 * 一个数组中有两种数a,b分别出现了奇数次  其他数出现偶数次  将a,b这两个数提取出来
 *
 * @author wanghongxu
 * @data 2022/11/7
 */

public class Demo2 {
    public static void main(String[] args) {
        int[] array = new int[]{233,233, 0, 2, 2, 3, 3, 3, 4, 4};
        extracted(array);
    }

    private static void extracted(int[] array) {
        int ero = 0;
        for (int j : array) {
            ero ^= j; // 结果为两个数的异或 a^b,两个相同的数异或为0
        }
        /* 取出ero最右边的1，
        *（获取随便一个位置上的1，因为这个位置上是1  a和b在这个位置上的数一定不相等）
        * 可以用此方法来过滤得到a,b两个数其中的一个
        * */
        int rightOne = ero & (-ero);
        int onlyOne = 0;
        for (int j : array) {
            if ((j & rightOne) != 0) { // 只会和相同位置上为1 的数异或
                onlyOne ^= j;
            }
        }
        System.out.println("这两个数分别为"+ onlyOne +","+(ero^onlyOne));
    }

}
