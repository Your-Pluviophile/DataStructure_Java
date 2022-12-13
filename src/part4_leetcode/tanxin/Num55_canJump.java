package part4_leetcode.tanxin;

public class Num55_canJump {
    //    给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//    判断你是否能够到达最后一个下标
    public boolean canJump(int[] nums) {
        //3 2 1 0 4
    //怎么表示覆盖范围？ i + nums[i]
        //3 3 3 3
        if(nums.length == 1) return true;

        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover,i + nums[i]);
            if (cover >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
