package part4_leetcode.bintree.traversal;

public class Num101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right == null) return false;
        if (left == null && right != null) return false;
        if (left.val != right.val) return false;

        return dfs(left.right, right.left) && dfs(left.left, right.right);
    }
}
