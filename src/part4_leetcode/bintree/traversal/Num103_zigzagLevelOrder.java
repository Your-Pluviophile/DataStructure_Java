package part4_leetcode.bintree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author mumu
 * @since 2023-03-03
 */
public class Num103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        boolean flag = false;
        while(!que.isEmpty()){
            ArrayList<Integer> arr = new ArrayList<>();
            int size = que.size();
            while(size-- > 0){
                TreeNode cur = que.poll();
                if(flag){
                    arr.add(0,cur.val);
                }else{
                    arr.add(cur.val);
                }
                if(cur.left != null) que.add(cur.left);
                if(cur.right != null) que.add(cur.right);
            }
            flag = !flag;
            res.add(arr);
        }
        return res;
    }
}
