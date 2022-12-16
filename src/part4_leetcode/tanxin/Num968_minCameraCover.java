package part4_leetcode.tanxin;

import part4_leetcode.bintree.TreeNode;

public class Num968_minCameraCover {
    int res = 0;

    public int minCameraCover(TreeNode root) {

        //摄像头不能安装在根节点或者叶子结点
        //从下往上看，局部最优：让叶子节点的父节点安摄像头，所用摄像头最少，整体最优：全部摄像头数量所用最少！
        //后序遍历
        // 0 代表 无覆盖 ；1 代表 有覆盖 ；2 代表有摄像头
        if (process(root) == 0) {
            res++;
        }
        return res;
    }

    private int process(TreeNode root) {
        if (root == null) {
            //叶子节点 ，默认 是有覆盖的状态
            return 1;
        }

        int left = process(root.left);
        int right = process(root.right);
        //左右孩子都有覆盖，本节点无覆盖
        if (left == 1 && right == 1) {
            return 0;
        } else if (left == 0 ||  right == 0) {
            //左右孩子有无覆盖的情况
            res++;
            return 2;
        }else{
            //左右孩子 至少有一个摄像头
            return 1;
        }


    }
}
