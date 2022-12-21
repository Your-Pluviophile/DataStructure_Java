package part4_leetcode.dp;

public class dp01_robotwalk {
    public static void main(String[] args) {
        System.out.println(new dp01_robotwalk().robot_walk(2, 4, 6, 5));
    }

    /**
     * 假设有一个 1 ～ N 的一维数列，和一个可以移动的机器人
     * 这个机器人，每次只能移动1步：
     * （1）在左边界1位置时，只能往右移1步
     * （2）在右边界N位置时，只能往左移1步
     * （3）在中间任意位置时，可以往左或往右移一步
     *
     * @param start，表示机器人的初始位置
     * @param aim，表示机器人的目标位置
     * @param k，代表机器人从start走到aim位置需要走的步数
     * @param n，代表这个一维数组的长度
     * @return 求机器人从start位置走k步到aim位置，有多少种方法？
     */
    int aim, n,k;

    public int robot_walk(int start, int aim, int k, int n) {
        this.aim = aim;
        this.n = n;
        this.k = k;
//        return process1(start,k);
//        该缓存表可以保存 1～N 和 0～k的所有计算结果
//        int[][] dp = new int[n + 1][k + 1];
//        //初始化dp，没有计算过的记为-1
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= k; j++) {
//                dp[i][j] = -1;
//            }
//        }
//        return process2(start, k, dp);
        return process3(start, k);

    }

    private int process3(int start, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= k; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < n ; cur++) {
                dp[cur][rest] = dp[cur - 1][rest- 1] + dp[cur + 1][rest- 1];
            }
            dp[n][rest] =dp[n- 1][rest - 1];
        }
        return dp[start][k];
    }

    /**
     * @param cur  当前的位置
     * @param rest 剩余的步数
     * @return 可能的方法数
     */
    private int process1(int cur, int rest) {
        //1.Base case 当没有步数的时候
        if (rest == 0) return cur == aim ? 1 : 0;
        //2.如果还有步数
        //2.1 机器人走到左边界,只能先往右走一步到2，然后再看2位置有多少种方法能走到aim
        if (cur == 1) return process1(2, rest - 1);
        //2.2 机器人走到右边界，同理
        if (cur == n) return process1(n - 1, rest - 1);
        //2.3 机器人在中间位置，能走的方法数等于往左走的方法数 + 往右走的方法数
        return process1(cur - 1, rest - 1) + process1(cur + 1, rest - 1);
    }

    /**
     * @param cur  当前的位置
     * @param rest 剩余的步数
     * @param dp   缓存表
     * @return
     */
    private int process2(int cur, int rest, int[][] dp) {
        //如果当前位置之前计算过，直接返回结果
        if (dp[cur][rest] != -1) return dp[cur][rest];
        //1.Base case 当没有步数的时候,保存这个位置的结果
        if (rest == 0) {
            dp[cur][rest] = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            dp[cur][rest] = process2(2, rest - 1, dp);
        } else if (cur == n) {
            dp[cur][rest] = process2(n - 1, rest - 1, dp);
        } else {
            dp[cur][rest] = process2(cur - 1, rest - 1, dp) + process2(cur + 1, rest - 1, dp);
        }
        //2.3 机器人在中间位置，能走的方法数等于往左走的方法数 + 往右走的方法数
        return dp[cur][rest];
    }

}
