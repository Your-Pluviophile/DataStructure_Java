package part4_leetcode.backtracing;

import java.util.*;

public class Num90_subsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort( nums );
        back_tracing(nums,0);
        return res;
    }

    private void back_tracing(int[] nums, int startIndex) {

        res.add( new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++){
            if(i > startIndex && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            back_tracing(nums, i + 1);
            path.removeLast();
        }
    }
}
