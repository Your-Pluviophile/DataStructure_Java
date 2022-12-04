package part4_leetcode.bintree.bst;

import part4_leetcode.bintree.TreeNode;

public class Num700_searchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return root;
        }else if(val < root.val){
            return searchBST(root.left,val);
        }else if(val > root.val){
            return searchBST(root.right,val);
        }else{
            return root;
        }
    }
}
