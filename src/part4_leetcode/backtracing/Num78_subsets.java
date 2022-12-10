package part4_leetcode.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num78_subsets {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> subsets(int[] nums) {
        back_tracing(nums,0);
        return res;
    }

    private void back_tracing(int[] nums,int startIndex) {
        res.add(new ArrayList<>(path));
        //终止条件
        if (startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            back_tracing(nums, i + 1);
            path.removeLast();
        }
    }
}
