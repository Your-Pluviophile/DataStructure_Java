package part4_leetcode.bintree.bst;

import part4_leetcode.bintree.TreeNode;

public class Num108_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums,0,nums.length - 1);
    }

    private TreeNode process(int[] nums, int l, int r) {
        if(l > r) return null;

        int mid = l + ((r - l) >> 1);
        TreeNode root = new TreeNode(nums[mid]);

        root.left = process(nums,l,mid - 1);
        root.right = process(nums,mid + 1,r);
        return root;



    }
}
