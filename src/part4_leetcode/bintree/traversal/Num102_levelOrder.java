package part4_leetcode.bintree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //需要借助队列
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            List<Integer> list = new ArrayList<>();
            while (len-- > 0) {
                TreeNode cur = que.poll();
                list.add(cur.val);
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
            res.add(list);
        }
        return res;
    }

}
