package part4_leetcode.tanxin;

import java.util.Arrays;

public class Num452_findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        //如果气球重叠了，重叠气球中右边边界的最小值 之前的区间一定需要一个弓箭。
        //先按左边界排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            //i左边界 > i-1右边界，不挨着
            if (points[i][0] > points[i - 1][1]){
                count++;
            }else{
                //挨着，更新最右重叠边界
                points[i][1] = Math.min(points[i][1],points[i - 1][1]);
            }
        }
        return count;
    }
}
