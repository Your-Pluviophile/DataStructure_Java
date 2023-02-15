package part4_leetcode.array.binarySearch;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mumu
 * @since 2023-02-15
 */
public class Num33_search {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        if(n == 1) return nums[0] == target ? 0:-1;

        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left +((right - left) >> 1);
            if(nums[mid] == target) return mid;
            //如果nums[mid] < nums[right],说明右半部分是有序的
            if(nums[mid] < nums[right]){
                //如果target在右半边，
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                    //如果target不在右半边
                }else{
                    right = mid - 1;
                }
            }else{
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
