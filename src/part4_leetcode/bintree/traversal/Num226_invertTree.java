package part4_leetcode.bintree.traversal;

import java.util.ArrayDeque;
import java.util.Deque;

public class Num226_invertTree {
    /*
    先序遍历 -- 深度优先遍历
     */
    public TreeNode invertTree(TreeNode root) {
        //递归终止条件
        if (root == null) return root;
        //交换当前节点的左右孩子
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归交换左子树
        invertTree(root.left);
        //递归交换右子树
        invertTree(root.right);
        return root;
    }

    /*
    层序遍历 -- 广度优先遍历
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;

        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            while (len-- > 0) {
                TreeNode cur = que.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;

                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
        }

        return root;
    }
}
