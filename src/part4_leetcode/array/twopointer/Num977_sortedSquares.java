package part4_leetcode.array.twopointer;

public class Num977_sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] new_nums = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int l_num = nums[left] * nums[left];
            int r_num = nums[right] * nums[right];
            if (l_num >= r_num){
                new_nums[i] = l_num;
                left++;
            }else{
                new_nums[i] = r_num;
                right--;
            }
        }

        return new_nums;
    }
}
