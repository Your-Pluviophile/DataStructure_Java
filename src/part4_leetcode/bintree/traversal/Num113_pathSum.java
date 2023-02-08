package part4_leetcode.bintree.traversal;

import java.util.LinkedList;
import java.util.List;

public class Num113_pathSum {
    List<List<Integer>> list = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root, targetSum);
        return list;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            list.add(new LinkedList<>(path));
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        path.removeLast();
    }
}
