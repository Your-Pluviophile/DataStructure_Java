package part4_leetcode.bintree.bst;

import part4_leetcode.bintree.TreeNode;

public class Num538_convertBST {
    //反中序遍历式累加 右 中 左
    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        process(root);
        return root;
    }

    private void process(TreeNode root) {
        if(root ==  null) return;

        process(root.right);

        sum += root.val;
        root.val =  sum;

        process(root.left);
    }
}
