package part4_leetcode.array.binarySearch;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mumu
 * @since 2023-02-16
 */
public class Num81_search {
    public boolean search(int[] nums, int target) {
        //在上一题的基础上增加了重复，但代码应该是一样的
        int n = nums.length;
        if (n == 0) return false;
        if (n == 1) return nums[0] == target ? true : false;

        int left = 0, right = n - 1;
        while (left <= right) {
            // 处理左右两边数字相同的情况，要保证左右两边的数字不一样，才能通过中间点的值来判断哪部分是排序好的
            // 比如[1, 0, 1, 1, 1]，这个case仅通过中间点就无法判断哪部分是排序好的
            while (left <= right && nums[left] == nums[right] && nums[left] != target) {
                left++;
                right--;
            }
            if (left > right) {
                return false;
            }
            if (nums[left] == target || nums[right] == target) {
                return true;
            }
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return true;
            if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] && target > nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

}
