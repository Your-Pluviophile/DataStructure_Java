package part4_leetcode.bintree.bst;

import part4_leetcode.bintree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NUm501_findMode {
    int count;
    int maxCount;
    TreeNode pre;
    List<Integer> result;
    public int[] findMode(TreeNode root) {
        count = 0;
        maxCount = 0;
        result = new ArrayList();
        int[] res = new int[result.size()];
        process(root);
        for(int i = 0; i < result.size();i++){
            res[i] = result.get(i);
        }
        return res;
    }

    private void process(TreeNode root) {
        if (root == null) return;

        process(root.left);

        if (pre == null || pre.val != root.val){
            count = 1;
        }else{
            count++;
        }
        //出现比集合中频率更大的数，清空集合，重新添加
        if(count > maxCount){
            result.clear();
            result.add(root.val);
            maxCount = count;
        }else if(count == maxCount){
            result.add(root.val);
        }

        pre = root;

        process(root.right);
    }
}
