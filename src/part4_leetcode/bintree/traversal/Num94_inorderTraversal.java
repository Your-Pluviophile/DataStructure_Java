package part4_leetcode.bintree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num94_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        //迭代序 左中右

        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> stack = new ArrayDeque<>();
        //先把左边界全部入栈
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            //每到一个节点 cur，因为根的访问在中间，将 cur 入栈。
            while (cur != null){
                stack.push(cur);
                cur = cur.left;//左
            }
            //此时栈顶节点的左孩子不存在，可以访问他自己了（中）
            cur = stack.pop();
            list.add(cur.val);//中
            cur  = cur.right;//右
        }

        return list;

    }
}
