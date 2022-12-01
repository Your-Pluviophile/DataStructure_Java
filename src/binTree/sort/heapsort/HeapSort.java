package binTree.sort.heapsort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {

        int[] nums = {23,32,12,45,98,50,8888,12};
        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        System.out.println("====");
        System.out.println(Arrays.toString(nums));
    }

    public static void heapSort(int[] nums){
        //1.堆化
        for(int i = (nums.length - 2)/2; i >= 0 ; i--) {
            siftDown(nums,i,nums.length);
        }
        //2.与最后一个元素交换 并下沉
        for(int i = nums.length - 1;i > 0;i--){
            swap(nums,0,i);
            siftDown(nums,0,i);
        }

    }
    public static void siftDown(int[] arr, int k, int length){
        while(2 * k + 1 < length){
            int j = 2 * k + 1;;
            if(j + 1 < length && arr[j] < arr[j + 1]){
                j = j + 1;
            }
            if(arr[k] >= arr[j]){
                break;
            }else{
                swap(arr,k,j);
                k = j;
            }
        }
    }

    private static void swap(int[] arr, int k, int j) {
        int temp = arr[k];
        arr[k] = arr[j];
        arr[j] = temp;
    }

}
