package part4_leetcode.array.twopointer;

public class Num283_moveZeroes {
    public void moveZeroes(int[] nums) {
        int slow_p = 0;
        for (int fast_i = 0; fast_i < nums.length; fast_i++){
            if (nums[fast_i] != 0){
                nums[slow_p] = nums[fast_i];
                slow_p++;
            }
        }
        for (int i = slow_p; i < nums.length ; i++) {
            nums[i] = 0;
        }
    }

}
