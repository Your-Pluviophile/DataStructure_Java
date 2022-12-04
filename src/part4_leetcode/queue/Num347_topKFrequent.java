package part4_leetcode.queue;

import java.util.*;

public class Num347_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        //统计词频
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        //小顶堆保存
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        //存入数组
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
