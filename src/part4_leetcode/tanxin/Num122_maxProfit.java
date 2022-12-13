package part4_leetcode.tanxin;

public class Num122_maxProfit {
    public int maxProfit(int[] prices) {
//        假如第0天买入，第3天卖出，那么利润为：prices[3] - prices[0]。
//
//        相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])。
//
//        此时就是把利润分解为每天为单位的维度，而不是从0天到第3天整体去考虑！
        int profit = 0;
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            profit = prices[i + 1] - prices[i];
            if(profit > 0) sum += profit;
            profit = 0;
        }
        return sum;
    }
}
