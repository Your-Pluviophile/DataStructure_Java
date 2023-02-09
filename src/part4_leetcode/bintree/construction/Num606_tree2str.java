package part4_leetcode.bintree.construction;

import part4_leetcode.bintree.TreeNode;

public class Num606_tree2str {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        // 当前值
        sb.append(node.val);
        //不需要处理的情况：
        // 1.左右子节点都为空，直接返回
        if (node.left == null && node.right == null) {
            return;
        }
        //右节点为空

        //2.需要处理的情况：
        // 1.左子节点都需要处理
        sb.append("(");
        dfs(node.left, sb);
        sb.append(")");

        // 2.右子节点不为空的时候才需要处理
        if (node.right != null) {
            sb.append("(");
            dfs(node.right, sb);
            sb.append(")");
        }
    }
}
