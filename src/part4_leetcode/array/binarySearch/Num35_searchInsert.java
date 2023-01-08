package part4_leetcode.array.binarySearch;

public class Num35_searchInsert {
    public int searchInsert(int[] nums, int target) {
        //1 二分查找该元素
        //2 返回将被插入的位置

        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length - 1;

        int l = 0;
        int r = nums.length - 1;

        while (r >= l) {
            int mid = l + ((r - l) >> 1);
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;

    }
}
