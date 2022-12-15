package part4_leetcode.tanxin;

import java.util.Arrays;

public class Num4335_eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        //求最大非交叉区间的个数
        Arrays.sort(intervals,(a,b)->{
            return a[1] - b[1];
        });

        int edge = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            // 若上一个区间的右边界小于当前区间的左边界，说明无交集
            if (edge <= intervals[i][0]){
                edge = intervals[i][1];
            }else{
                count++;
            }
        }

        return count;
    }
}
