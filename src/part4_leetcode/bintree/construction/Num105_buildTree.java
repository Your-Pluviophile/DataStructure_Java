package part4_leetcode.bintree.construction;

import part4_leetcode.bintree.TreeNode;

public class Num105_buildTree {
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int l, int r) {
        if(l > r) return null;
        TreeNode root = new TreeNode(preorder[index++]);

        int pos = findIndex(inorder, root.val);

        root.left = buildTreeHelper(preorder, inorder, l, pos - 1);
        root.right = buildTreeHelper(preorder, inorder, pos + 1, r);

        return root;
    }

    private int findIndex(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
