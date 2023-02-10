package part4_leetcode.bintree.construction;

import java.util.Scanner;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }

    public TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class KY11 {
    static int index = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            TreeNode root = build(str);
            inorderdfs(root);
        }
    }
    private static void inorderdfs(TreeNode root) {
        if (root == null) return;

        inorderdfs(root.left);

        System.out.print(root.val + " ");

        inorderdfs(root.right);
    }
    private static TreeNode build(String str) {
        char c = str.charAt(index);
        if (c == '#') {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(c);
        index++;
        root.left = build(str);
        root.right = build(str);

        return root;
    }
}
