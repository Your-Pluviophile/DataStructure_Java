package part4_leetcode.bintree.traversal;

public class Num404_sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        //怎么判定是左叶子？
        //得从上上级判断 if(root.left != null && root.left.left == null && root.left.right == null )
        int val = 0;
        if(root.left != null && root.left.left == null && root.left.right == null ){
            val += root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.left) + val;
    }

}
