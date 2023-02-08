package part4_leetcode.bintree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num199_ghtSideView {
    public List<Integer> ghtSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            while (len-- > 0) {
                TreeNode cur = que.poll();
                if (len == 0){
                    res.add(cur.val);
                }
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
        }
        return res;
    }
}
