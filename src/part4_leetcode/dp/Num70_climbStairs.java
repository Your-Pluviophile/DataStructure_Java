package part4_leetcode.dp;

public class Num70_climbStairs {
    public int climbStairs(int n) {
        //dp[i]： 爬到第i层楼梯，有dp[i]种方法
        //dp[i] = dp[i - 1] + dp[i - 2]
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[ i - 2];
        }
        return dp[n];
    }
}
