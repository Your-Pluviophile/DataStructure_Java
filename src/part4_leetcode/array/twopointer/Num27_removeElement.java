package part4_leetcode.array.twopointer;

public class Num27_removeElement {
    public int removeElement_4(int[] nums, int val) {
        int j = nums.length - 1;//指向数组最后一个元素
        for (int i = 0; i <= j; i++) {
            if (nums[i] == val){
                //i-- 是为了一直使i指针维持在原位
                //j-- 是为了缩短数组的长度
                swap(nums,i--,j--);
            }
        }
        return j + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;

    }

    public int removeElement_3(int[] nums, int val) {
        int ans = 0;
        for (int x : nums) {
            //如果相同的时候，则跳过该数字
            if (x != val){
                nums[ans++] = x;
            }
        }
        return ans;
    }

    public int removeElement_2(int[] nums, int val) {
        int slow_p = 0;

        for (int fast_p = 0; fast_p < nums.length; fast_p++) {
            if (nums[fast_p] != val) {
                nums[slow_p] = nums[fast_p];
                slow_p++;
            }
        }

        return slow_p;
    }
    public int removeElement_1(int[] nums, int val) {

        int size = nums.length;
        for (int i = 0; i < size ; i++) {
            if (nums[i] == val){
                for (int j = i + 1; j < size; j++) {
                    //把所有元素都往前覆盖一位
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }
}
