package part4_leetcode.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num39_combinationSum {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        back_tracing(candidates,target,0,0);
        return res;
    }

    private void back_tracing(int[] candidates, int target, int startIndex,int sum) {
        if(sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            back_tracing(candidates,target,i,sum);
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
