package part4_leetcode.array.twopointer;

public class Num209_minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;

        int min_len = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0;right < nums.length; right++) {
            //窗口维持sum 刚好>= target 的连续子序列
            //right 一直向右走，遇到一个sum >= target时，尝试收缩left（left++）
            //维持sum >= target时，left的最大收缩幅度
            sum += nums[right];
            while (sum >= target){
                min_len = Math.min(min_len,right - left + 1);
                sum -= nums[left++];
            }
        }
        return min_len == Integer.MAX_VALUE ? 0 : min_len;
    }
}
