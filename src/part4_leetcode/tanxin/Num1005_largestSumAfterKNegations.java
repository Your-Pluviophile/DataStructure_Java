package part4_leetcode.tanxin;

import java.util.Arrays;

public class Num1005_largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //先排序 优先取反最小的负数
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        //如果k还有剩，再排序一次，持续反转最小的
        if(k > 0){
            Arrays.sort(nums);
            while(k-- > 0){
                nums[0] = -nums[0];
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
