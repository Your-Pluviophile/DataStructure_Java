package part4_leetcode.bintree.traversal;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, part4_leetcode.bintree.TreeNode left, part4_leetcode.bintree.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
