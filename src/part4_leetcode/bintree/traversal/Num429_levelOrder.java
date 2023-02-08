//package part4_leetcode.bintree.traversal;
//
//import java.util.*;
//
//public class Node {
//    public int val;
//    public List<Node> children;
//
//    public Node() {
//    }
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//};
//
//public class Num429_levelOrder {
//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> res = new LinkedList<>();
//        if (root == null) return res;
//
//        Deque<Node> que = new ArrayDeque<>();
//        que.offer(root);
//        while (!que.isEmpty()) {
//            int len = que.size();
//            List<Integer> list = new ArrayList<>();
//            while (len-- > 0) {
//                Node cur = que.poll();
//                list.add(cur.val);
//                if (cur.children != null) {
//                    for (Node child : cur.children) {
//                        que.offer(child);
//                    }
//                }
//            }
//            res.add(list);
//        }
//        return res;
//    }
//}
