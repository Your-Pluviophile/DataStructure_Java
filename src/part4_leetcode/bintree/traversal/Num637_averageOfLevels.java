package part4_leetcode.bintree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num637_averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            int temp = len;
            double levelSum = 0;
            while (len-- > 0) {
                TreeNode cur = que.poll();
                levelSum += cur.val;
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
            res.add(levelSum / temp);
        }
        return res;
    }
}
