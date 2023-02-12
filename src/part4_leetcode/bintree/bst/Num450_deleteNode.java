package part4_leetcode.bintree.bst;

import part4_leetcode.bintree.TreeNode;

public class Num450_deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                //找到右子树的最左节点
                while (cur.left != null) {
                    cur = cur.left;
                }
                //左子树挂上去
                cur.left = root.left;
                //右子树成为根节点
                root = root.right;
                return root;
            }
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }


}
