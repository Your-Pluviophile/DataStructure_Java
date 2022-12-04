package part4_leetcode.bintree.bst;

import part4_leetcode.bintree.TreeNode;

public class Num98_isValidBST {
    class ReturnType {
        boolean isBST;
        int min;
        int max;

        ReturnType(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }

    private ReturnType process(TreeNode root) {
        if(root == null) return null;

        ReturnType leftData = process(root.left);
        ReturnType rightData = process(root.right);

        int min = root.val;
        int max = root.val;
        boolean isBST = true;

        if(leftData != null){
            min = Math.min(min,leftData.min);
            max = Math.max(max, leftData.max);
        }
        if(rightData != null){
            min = Math.min(min,rightData.min);
            max = Math.max(max,rightData.max);
        }
        //判断违规条件
        //左子树存在，但不是平衡树，或者左子树最大值大于root
        if(leftData != null && (!leftData.isBST || leftData.max >= root.val)){
            isBST = false;
        }
        //右子树存在，但不是平衡树，或者右子树最小值大于root
        if(rightData != null && (!rightData.isBST || rightData.min <= root.val)){
            isBST = false;
        }
        return new ReturnType(isBST,min,max);
    }
}
