package part4_leetcode.bintree.construction;

import part4_leetcode.bintree.TreeNode;

public class Num617_mergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        //本节点如何构建
        root1.val += root2.val;
        //指定新的二叉树左右孩子该如何构建
        //如果是遍历，这里就不需要返回值
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}
