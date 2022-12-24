package part4_leetcode.dp;

public class Num1799_maxScore {
    int[] nums;
    int n;
    int[][] dp;

    public int maxScore(int[] nums) {

        this.nums = nums;
        this.n = nums.length / 2;
        dp = new int[n + 1][1 << (2 * n)];
        return help(1, 0);
    }

    private int help(int i, int mask) {
        if (i > n) return 0;

        //记忆化
        if (dp[i][mask] > 0) return dp[i][mask];

        int res = 0;
        for (int p = 0; p < n * 2; p++) {
            for (int j = p + 1; j < n * 2; j++) {
                if ((((1 << p) & mask) == 0) && ((1 << j) & mask) == 0) {
                    //每次从可选的数字中选出两个计算得分
                    res = Math.max(res, help(i + 1, mask | (1 << p) | (1 << j)) + i * gcd(nums[p], nums[j]));
                }
            }
        }

        return dp[i][mask] = res;

    }

    int gcd(int x, int y) {
        return x % y == 0 ? y : gcd(y, x % y);


    }
}
