package part4_leetcode.bintree.traversal;

public class Num104_maxDepth {
    public int maxDepth(TreeNode root) {
        //后序遍历 左右中
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);//左
        int rightDepth = maxDepth(root.right);///右
        int depth = Math.max(leftDepth,rightDepth) + 1;//当前节点高度 = 1+ 左右子树的最大高度

        return depth;

    }
}
