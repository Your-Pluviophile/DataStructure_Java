package part4_leetcode.tanxin;

public class Num53_maxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        //如果和 是负数 直接从下一位开始
        int sumMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumMax = Math.max(sum,sumMax);
            //如果和是负数，直接清零
            if (sum < 0){
                sum = 0;
            }
        }
        return sumMax;

    }
}
