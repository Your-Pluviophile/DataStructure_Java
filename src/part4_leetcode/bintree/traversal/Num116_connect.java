package part4_leetcode.bintree.traversal;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Num116_connect {
    public Node connect(Node root) {
        if (root == null) return root;
        Deque<Node> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            while (len-- > 0) {
                Node cur = que.poll();
                if (len == 0) {
                    cur.next = null;
                } else {
                    cur.next = que.peek();
                }
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
        }
        return root;
    }
}

