package part4_leetcode.bintree.traversal;

import java.util.*;

public class Num145_postorderTraversal {
    //    public List<Integer> postorderTraversal(TreeNode root) {
//        //写法1 改写前序遍历
//        //前序 中左右 调整顺序 中右左，反转 左右中
//        //后序 左右中，
//        List<Integer> list = new ArrayList<>();
//        if (root == null) return list;
//
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode cur = stack.pop();
//            list.add(cur.val);
//            if (cur.left != null) stack.push(cur.left);
//            if (cur.right != null) stack.push(cur.right);
//
//        }
//        Collections.reverse(list);
//        return list;
//    }
    public List<Integer> postorderTraversal(TreeNode root) {
        //写法2 使用prev指针记录前次访问的节点

        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            //如果右节点被处理过
            if (cur.right == null || prev == cur.right) {
                list.add(cur.val);
                prev = cur;
                cur = null;
            } else {
                stack.push(cur.right);
                cur = cur.right;
            }

        }
        return list;
    }
}
