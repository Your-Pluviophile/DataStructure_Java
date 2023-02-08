package part4_leetcode.bintree.traversal;

import java.util.List;

;
public class Num559_maxDepth {
    public int maxDepth(Node root) {
        if (root == null) return 0;

        //求子树的最大高度
        int depth = 0;
        if (root.children != null){
            for (Node child : root.children) {
                depth = Math.max(maxDepth(child),depth);
            }
        }
        return depth + 1;//处理当前节点

    }

    static class Node {
        public int val;
        public List<part4_leetcode.bintree.traversal.Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<part4_leetcode.bintree.traversal.Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
