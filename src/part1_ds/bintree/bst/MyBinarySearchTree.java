package part1_ds.bintree.bst;


import java.util.NoSuchElementException;

public class MyBinarySearchTree {
    //储存的节点个数
    private int size;
    private TreeNode root;
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    //添加节点并返回
    public void add(int val){
         root = add(root,val);
    }
    private TreeNode add(TreeNode root,int val){
        if(root == null){
            TreeNode node = new TreeNode(val);
            size++;
            return node;
        }
        if(val < root.val){
            root.left = add(root.left,val);
        }
        if(val > root.val){
            root.right = add(root.right,val);
        }
        return root;
    }
    //查询节点是否存在
    public boolean contains(int val){
        return contains(root,val);
    }
    private boolean contains(TreeNode root,int val){
        if(root == null) return false;

        if(root.val == val){
            return true;
        }else if(val < root.val){
            return contains(root.left,val);
        }else{
            return contains(root.right,val);
        }
    }
    //打印节点

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }

    private void generateBSTString(TreeNode root, int depth, StringBuilder sb) {
        if (root == null) {
            sb.append(generateHeightString(depth)).append("NULL\n");
            return;
        }
        // 根左右
        sb.append(generateHeightString(depth)).append(root.val).append("\n");
        // 再递归访问左子树并将结果存在sb中
        generateBSTString(root.left,depth + 1,sb);
        // 再递归访问右子树并将结果存在sb中
        generateBSTString(root.right,depth + 1,sb);
    }

    private String generateHeightString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
    //查询最小值
    public int min() {
        if (size == 0) {
            throw new NoSuchElementException("bst is empty!no min");
        }
        TreeNode min = findMinNode(root);
        return min.val;
    }
    private TreeNode findMinNode(TreeNode root) {
        if (root.left == null) {
            // 此时root即为所求
            return root;
        }
        return findMinNode(root.left);
    }
    //删除最小值
    public int removeMin() {
        if (size == 0) {
            throw new NoSuchElementException("bst is empty!cannot removeMin");
        }
        TreeNode minNode = findMinNode(root);
        root = removeMin(root);
        return minNode.val;
    }
    private TreeNode removeMin(TreeNode root) {
        if (root.left == null) {
            // 当前root就是待删除节点
            TreeNode right = root.right;
            // 真正将这个节点从原来的树中删除
            root.right = root = null;
            size--;
            return right;
        }
        // 在左子树中删除
        root.left = removeMin(root.left);
        return root;
    }

    //任意位置删除
    public void remove(int val) {
        if (size == 0) {
            throw new NoSuchElementException("bst is empty!cannot remove!");
        }
        root = remove(root,val);
    }

    private TreeNode remove(TreeNode root, int val) {
        if(root == null){
            //val节点不存在
            throw new NoSuchElementException("bst has not this val");
        }else if(val < root.val){
            remove(root.left,val);
            return root;
        }else if(val > root.val){
            remove(root.right,val);
            return root;

        }else{
            // 此时val == root.val
            // 当前树根就是待删除的节点！
            if (root.left == null) {
                // 待删除节点左子树为空，类似删除最大值
                TreeNode right = root.right;
                root.right = root = null;
                size --;
                return right;
            }else if (root.right == null) {
                // 待删除节点的右子树为空，类似删除最小值
                TreeNode left = root.left;
                root.left = root = null;
                size --;
                return left;
            }
            // 此时待删除节点的左右子树都不为空
            // 找到后继节点，恰好是右子树的最小值
            TreeNode successor = findMinNode(root.right);
            // 1.先在右子树中删除后继节点，连接到后继节点的右子树
            successor.right = removeMin(root.right);
            // 2.拼接原来的左子树
            successor.left = root.left;
            // 断掉root
            root.left = root.right = root = null;
            return successor;
        }
    }
}


