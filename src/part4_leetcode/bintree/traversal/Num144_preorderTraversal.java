package part4_leetcode.bintree.traversal;

import java.util.*;

public class Num144_preorderTraversal {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        //递归写法
//        List<Integer> list = new ArrayList<>();
//        traversal(root, list);
//        return list;
//    }
//
//    private void traversal(TreeNode root, List<Integer> list) {
//        if (root == null) return;
//        //前序 中左右
//        list.add(root.val);
//        traversal(root.left, list);
//        traversal(root.right, list);
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        //迭代写法-需要借助栈
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return list;
    }

}
