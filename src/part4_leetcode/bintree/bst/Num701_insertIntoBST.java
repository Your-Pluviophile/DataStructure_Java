package part4_leetcode.bintree.bst;

import part4_leetcode.bintree.TreeNode;

public class Num701_insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
            return new TreeNode(val);

        if (val > root.val){
            root.right = insertIntoBST(root.right, val); // 递归创建右子树
        }else if (val < root.val ){
            root.left = insertIntoBST(root.left, val); // 递归创建左子树
        }
        return root;
    }
}
