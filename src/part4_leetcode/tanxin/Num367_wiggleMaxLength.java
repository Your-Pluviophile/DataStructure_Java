package part4_leetcode.tanxin;

public class Num367_wiggleMaxLength {
    /*
    如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
    第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
     */
    public int wiggleMaxLength(int[] nums) {
        //统计峰值的个数即可
        if(nums.length < 1) return 0;

        int preDiff = 0;
        int curDiff = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[ i + 1] - nums[i];

            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)){
                count++;
                preDiff = curDiff;
            }
        }
        return count + 1;//序列长度等于峰值 + 1
    }
}
