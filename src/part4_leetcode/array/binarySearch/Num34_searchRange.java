package part4_leetcode.array.binarySearch;

public class Num34_searchRange {
    public int[] searchRange(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        int start = 0;
        int end = 0;

        int mid = binarySearch(nums, target, l, r);
        if (mid == -1) return new int[]{-1, -1};
        //找到一个相等
        start = end = mid;

        while (start >= 1 && nums[start - 1] == target) {
            start--;
        }
        while (end <= nums.length - 2 && nums[end + 1] == target) {
            end++;
        }
        return new int[]{start, end};
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
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
        return -1;
    }
}
