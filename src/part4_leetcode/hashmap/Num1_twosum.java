package part4_leetcode.hashmap;

import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mumu
 * @since 2023-02-18
 */
public class Num1_twosum {
    public int[] twoSum(int[] nums, int target) {
        //map存放的就是我们访问过的元素
        //k: 保存当前值 ，v ： 保存当前下标
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
