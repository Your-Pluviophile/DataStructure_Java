package part2_arith.sort.quicksort;

import java.util.Random;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mumu
 * @since 2023-02-16
 */
public class Num912_sortArray {
    public int[] sortArray_heapSort(int[] nums) {
        //1.从最后一个非叶子结点开始堆化
        for (int i = (nums.length - 1 - 1) >> 1; i >= 0  ; i--) {
            heapify(nums,i,nums.length);
        }
        // 2.不断交换堆顶元素和数组的最后一个位置，将最大值移到数组末尾
        for (int i = nums.length - 1; i > 0; i--) {
            // 交换
            swap(nums,0,i);
            // 堆化
            heapify(nums,0,i);
        }
        return nums;
    }

    private void heapify(int[] nums, int k, int length) {
        //如果还存在子树
        while(2 * k + 1 < length){
            //保存左右子树的最大值
            int j = 2 * k + 1;
            if(j + 1 < length && nums[j] < nums[j + 1]){
                j = j + 1;
            }

            if(nums[k] >= nums[j]){
                return;
            }else{
                swap(nums,k,j);
                k = j;
            }
        }
    }

    public int[] sortArray_quickSort(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        quickSort(nums,l,r);
        return nums;
    }
    public void quickSort(int[] nums,int l,int r){
        if(l > r) return;
        int div = partition(nums,l,r);
        quickSort(nums,l,div - 1);
        quickSort(nums,div + 1,r);
    }
    public int partition(int[] nums,int l,int r){
        int randomIndex = new Random().nextInt(r - l + 1) + l;
        swap(nums,l,randomIndex);
        int v = nums[l];//坑
        int i = l;
        int j = r;
        while (i < j) {
            // 先从后向前扫描碰到第一个 < v的元素停止
            while (i < j && nums[j] >= v) {
                j --;
            }
            // 此时j指向第一个小于v的元素，填坑,填坑之后j对应的元素空出来了
            nums[i] = nums[j];
            // i继续从前向后扫描，碰到第一个 > v的元素停止
            while (i < j && nums[i] <= v) {
                i ++;
            }
            // i指向第一个 > v的元素，填坑，填坑之后i对应的位置空出来
            nums[j] = nums[i];
        }
        // 此时i和j重合，填充分区点
        nums[j] = v;
        return j;
    }
    public void swap(int[] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
