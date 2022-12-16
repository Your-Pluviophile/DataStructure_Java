package part4_leetcode.tanxin;

public class Num714_maxProfit {
    public int maxProfit(int[] prices, int fee) {
        //计算每天的利润 收集正利润 买卖只收一笔交易费
        //1, 3, 2, 8, 4, 9 buy=6
        //         5     3 sum =8
        int sum = 0;
        //默认买第一天
        int buy = prices[0] + fee;
        for (int price : prices) {
            if(price + fee < buy){
                //如果后面几天的价格+fee 比第一天的低，那就买那一天的
                buy = price + fee;
            }else if(price > buy){ //如果后面几天价格比买+fee的时候高，就卖出去
                sum += price - buy;
                buy = price;
            }
        }
        return sum;
    }
}
