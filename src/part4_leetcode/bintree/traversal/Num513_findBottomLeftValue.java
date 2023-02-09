package part4_leetcode.bintree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num513_findBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        int temp = 0;

        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = que.poll();
                if (i == 0) {
                    temp = cur.val;
                }
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
        }
        return temp;
    }
}
