package part4_leetcode.bintree.construction;

import part4_leetcode.bintree.TreeNode;

public class Num106_buildTree {
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //index 一直跟随后序遍历的脚步
        index = postorder.length - 1;
        return buildTreeHelper(postorder, inorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int[] inorder, int l, int r) {
        if (l > r) return null;
        //先从后序里面挑根节点
        int val = postorder[index--];

        TreeNode root = new TreeNode(val);
        //找到该节点在中序中的位置
        int pos = findIndex(root.val, inorder);
        //递归

        root.right = buildTreeHelper(postorder, inorder, pos + 1, r);
        root.left = buildTreeHelper(postorder, inorder, l, pos - 1);
        return root;
    }

    private int findIndex(int val, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
