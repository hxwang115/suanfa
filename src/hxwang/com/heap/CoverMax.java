package hxwang.com.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <H2> 最大线段重合问题 </H2>
 * 给定很多线段，每个线段都有两个数[start, end]，
 * 表示线段开始位置和结束位置，左右都是闭区间
 * 规定：
 * 1）线段的开始和结束位置一定都是整数值
 * 2）线段重合区域的长度必须>=1
 * 返回线段最多重合区域中，包含了几条线段
 *
 * @author hxwang
 * @data 2022/12/22
 */

public class CoverMax {
    /**
     * 线段的类
     *
     * @author hxwang
     * @date 2022/12/22
     */
    public static class Line {
        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 以 线段起始值 进行对比的比较器
     * @author hxwang
     * @date 2022/12/23
     */
    public static class StartCompare implements Comparator<Line> {
        @Override
        public int compare(Line o1, Line o2) {
            return o1.start - o2.start;
        }
    }

    public static int maxCover(int[][] m){
        Line[] lines = new Line[m.length];
        for (int i=0;i<m.length;i++){
            lines[i] = new Line(m[i][0],m[i][1]);
        }
        // 将数组按 起始位置大小排序
        Arrays.sort(lines,new StartCompare());
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 记录线段数
        int max = 0;
        for (int i=0;i<lines.length;i++){
            while (!heap.isEmpty() && heap.peek() <= lines[i].start){
                heap.poll();
            }
            heap.add(lines[i].end);
            max = Math.max(max, heap.size());
        }
        return max;
    }

}
