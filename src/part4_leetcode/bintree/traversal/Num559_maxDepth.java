package part4_leetcode.bintree.traversal;

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
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
}