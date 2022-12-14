package part4_leetcode.tanxin;

public class Num134_canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //如果cost总和 > gas总和,肯定回不到最初的点
        int curSum = 0;//以当前位置为起点剩余的汽油数
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
            curSum += gas[i] - cost[i];//剩余的汽油数
            if (curSum < 0) { //剩余汽油数不足，说明当时那个位置不行
                curSum = 0;//重新走
                index = (i + 1) % gas.length;//下一次走从i + 1位置开始
            }

        }
        if (totalSum < 0) return -1;
        return index;
    }
}
