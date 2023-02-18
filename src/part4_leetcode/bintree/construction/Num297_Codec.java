package part4_leetcode.bintree.construction;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mumu
 * @since 2023-02-18
 */
public class Num297_Codec {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null){
                return "";
            }
            StringBuilder res = new StringBuilder();
            res.append("[");
            //此处不能使用ArrayDeque，？似乎是不能加入null节点
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node != null){
                    res.append("" + node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else{
                    res.append("null");
                }
                res.append(",");
            }
            res.append("]");
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == ""){
                return null;
            }
            String[] dataList = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(!"null".equals(dataList[i])){
                    node.left = new TreeNode(Integer.parseInt(dataList[i]));
                    queue.offer(node.left);
                }
                i++;
                if(!"null".equals(dataList[i])){
                    node.right = new TreeNode(Integer.parseInt(dataList[i]));
                    queue.offer(node.right);
                }
                i++;
            }
            return root;
        }
    }
}
