package part4_leetcode.bintree.bst;

import part4_leetcode.bintree.TreeNode;

public class Num530_getMinimumDifference {
    //二叉查找树中，中间节点的值一定是其左右节点值的中间数，因此最小差别一定是在中间节点与左右节点之间
    //中序遍历二叉查找树，每次比较当前节点与前一节点差值的绝对值与目前result中保存的最小值的大小，将较小的保存在result中
    int res = Integer.MAX_VALUE;
    TreeNode pre ;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        process(root);
        return res;
    }

    private void process(TreeNode root) {
        if(root == null) return;

        process(root.left);

        if(pre != null){
            res = Math.min(res,root.val - pre.val);
        }

        pre = root;

        process(root.right);
    }
}
