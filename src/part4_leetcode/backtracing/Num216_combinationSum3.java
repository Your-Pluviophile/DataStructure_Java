package part4_leetcode.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num216_combinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        back_tracing(n, k,1,0);
        return res;
    }
    void back_tracing(int n, int k,int startIndex,int sum){
        //终止条件
        if(path.size() == k ){
            if(sum == n){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (sum > n) {
            return;
        }


        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            //本层处理逻辑
            path.add(i);
            sum += i;
            //下一层
            back_tracing(n,k,i+1,sum);
            //回溯处理逻辑
            path.removeLast();
            sum -= i;
        }
    }
}
