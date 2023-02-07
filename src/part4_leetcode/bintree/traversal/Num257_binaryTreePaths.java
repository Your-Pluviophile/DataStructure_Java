package part4_leetcode.bintree.traversal;

import java.util.ArrayList;
import java.util.List;

public class Num257_binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null) return;

        //如果是叶子结点说明找到了一条路径
        if (root.left == null && root.right == null) {
            paths.add(path + root.val);
            return;
        }
        //否则递归左右子树
        dfs(root.left, path + root.val + "->", paths);
        dfs(root.right, path + root.val + "->", paths);

    }
}
