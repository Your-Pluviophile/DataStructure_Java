package part4_leetcode.queue;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class mianshi1714_smallestK {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : arr) {
            queue.offer(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
