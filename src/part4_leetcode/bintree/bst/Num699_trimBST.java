package part4_leetcode.bintree.bst;

import part4_leetcode.bintree.TreeNode;

public class Num699_trimBST {
    /**
     * 如果在范围内，那么说明root是要保留的，也就是说不用处理root，处理左右子树就可以了。
     * 如果不再范围内，假如root-val > low，且根据BST性质，就会发现，左子树和root都在区间外，要保留的只可能是处理后的右子树
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // root在[low,high]范围内
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
