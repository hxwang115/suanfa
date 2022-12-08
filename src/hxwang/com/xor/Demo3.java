package hxwang.com.xor;

/**
 * <p> </P>
 * 一个数组中有一种数n出现K次，其他都出现了M次 k&lt;M M&gt;1 返回这个出现K次的数
 *
 * @author hxwang
 * @data 2022/11/13
 */

public class Demo3 {
    public static void main(String[] args) {
        int[] array = new int[10];
        int a = onleTimes(array, 2, 5);
        System.out.println(a);
    }

    private static int onleTimes(int[] array, int k, int m) {
        // 新建一个长度为32的数组记录这个数组中的数在每个位置上1的个数
        int[] a = new int[32];
        for (int num : array) {
            for (int i = 0; i < 32; i++) {
                // i位置是1 进行记录
//                if (((num>>i)&1) == 1){
//                    a[i]++;
//                }
                // 第二种写法
                a[i] += (num >> i) & 1;
            }
        }
        int an = 0;
        for (int i = 0; i < 32; i++) {
            if ((a[i] % m) != 0) { // 这个位置上不是m的倍数，所以这种数n在这个位置上有1
                an |= (1 << i);// 得到结果
            }
        }
        return an;
    }
}
