package part4_leetcode.bintree.traversal;

public class Num112_hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return dfs(root.left, targetSum - root.val) || dfs(root.right, targetSum - root.val);
    }
}
