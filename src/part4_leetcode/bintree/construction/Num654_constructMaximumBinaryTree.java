package part4_leetcode.bintree.construction;

import part4_leetcode.bintree.TreeNode;

public class Num654_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeHelper(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTreeHelper(int[] nums, int l, int r) {
        if (l > r) return null;
        int pos = findIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[pos]);
        root.left = constructMaximumBinaryTreeHelper(nums, l, pos - 1);
        root.right = constructMaximumBinaryTreeHelper(nums, pos + 1, r);
        return root;
    }

    private int findIndex(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
