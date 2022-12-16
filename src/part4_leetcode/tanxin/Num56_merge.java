package part4_leetcode.tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num56_merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(x,y)->{
            return x[0] - y[0];
        });

        List<int[]> res = new ArrayList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > right){
                res.add(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            }else{
                right = Math.max(right,intervals[i][1]);
            }
        }

        res.add(new int[]{left,right});



        return res.toArray(new int[res.size()][]);
    }
}
