package part4_leetcode.bintree.traversal;

import java.util.*;

public class Num107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
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
            res.add(0, list);
        }
        return res;
    }
}
