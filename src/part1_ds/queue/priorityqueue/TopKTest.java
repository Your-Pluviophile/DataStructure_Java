package part1_ds.queue.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class TopKTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,3,9,7,6,2,5,8,10};
        int k = 3;
        //JDK优先级队列默认小根堆，如果我们需要取前k个最小元素，我们需要传入比较器，构建大根堆

        //写法1 【匿名内部类】
//        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
        //写法2 【Lambda表达式】
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : arr) {
            queue.offer(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        System.out.println(queue);
    }
    }

