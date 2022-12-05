package part4_leetcode.backtracing;

import java.util.*;

public class Num77_combine {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k,1);//返回范围 [1, n]
        return res;
    }

    private void combineHelper(int n, int k, int startIndex) {
        //递归的深度
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        //单层搜索的逻辑
        //已经选择的元素个数：path.size()；
        //还需要的元素个数为: k - path.size()；
        //剩余的数 n - i + 1
        //在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
        for(int i = startIndex; i <= n - (k - path.size()) + 1;i++){
            path.add(i);
            combineHelper(n,k,i + 1);
            path.removeLast();
        }
    }
}
