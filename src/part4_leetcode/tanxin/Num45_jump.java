package part4_leetcode.tanxin;

public class Num45_jump {

    //    使用最少的跳跃次数到达数组的最后一个位置。
    //    假设你总是可以到达数组的最后一个位置。
    public int jump(int[] nums) {
        //每次在可跳范围内选择可以使得跳的更远的位置。
        if (nums.length == 1) return 0;
        int coverEnd = 0;
        int maxDistance = 0;
        int step = 0;
        //在0位置算起跳一次，因此 i < nums.length - 1
        //遍历过程即统计从0位置起跳的最大覆盖范围
        for (int i = 0; i < nums.length - 1; i++) {
            //统计覆盖范围内的最大跳跃距离，如果i遍历到最大范围边界，紧接着更新步数和最大边界
            maxDistance = Math.max(maxDistance,i + nums[i]);
            //如果i走到覆盖范围边界，无论如何都要再跳一步了
            //如果i 始终走在覆盖范围内，不用添加步数
            if (i == coverEnd){
                step++;
                //更新最大覆盖范围的边界
                coverEnd = maxDistance;
            }
        }
        return step;
    }


}
