package part4_leetcode.tanxin;

public class Num135_candy {
    public int candy(int[] ratings) {
        //每个孩子至少分配到 1 个糖果。
        //相邻两个孩子评分更高的孩子会获得更多的糖果。
        // 评分：1 2 2       1 2 2 5 4 3 2    1 3 4 5 2
        // 糖果：1 2 1       1 2 1 4 3 2 1    1 2 3 4 1

        //这道题目一定是要确定一边之后，再确定另一边，例如比较每一个孩子的左边，然后再比较右边，如果两边一起考虑一定会顾此失彼。

        int sum = 0;

        // 1 只要右边孩子比左边孩子大，就+1，否则1(从前向后遍历)
        int[] csndys = new int[ratings.length];
        csndys[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]){
                csndys[i] = csndys[i - 1] + 1;
            }else{
                csndys[i] = 1;
            }
        }
        //2 再确定左孩子大于右孩子的情况（从后向前遍历）
        for (int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]){
                csndys[i] = Math.max(csndys[i + 1] + 1,csndys[i]);
            }
        }

        for (int i = 0; i < csndys.length; i++) {
            sum += csndys[i];
        }
        return sum;
    }
}
