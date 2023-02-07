package part4_leetcode.bintree.traversal;

public class Num111_minDepth {
    public int minDepth(TreeNode root) {
        //左子树和右子树的最小深度
        if (root == null) return 0;
        int leftheight = minDepth(root.left);
        int rightheight = minDepth(root.right);

        return (leftheight == 0 || rightheight == 0) ? leftheight + rightheight + 1 : Math.min(leftheight, rightheight) + 1;

    }
}
