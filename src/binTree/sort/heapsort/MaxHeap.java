package binTree.sort.heapsort;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MaxHeap {
    //底层是一个动态数组
    private List<Integer> arr;
    //数组大小
    private  int size;

    public MaxHeap() {
        this(10);
    }
    public MaxHeap(int capacity){
        this.arr = new ArrayList<>(capacity);
    }
    public int parent(int k){
       return (k - 1) >> 1;
    }
    public int leftChild(int k){
        return k << 1 + 1;
    }
    public int rightChild(int k){
        return k << 1 + 2;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    //堆中添加元素
    public void add(int val){
        this.arr.add(val);
        size++;
        //从最后一个元素开始
        siftUp(size - 1);
    }
    //查看堆顶元素
    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException("heap is empty!cannot peek!");
        }
        return arr.get(0);
    }
    //移除堆顶元素并返回
    public int extractMax(){
        if (isEmpty()) {
            throw new NoSuchElementException("heap is empty!cannot extract!");
        }
        int maxVal = arr.get(0);
        //将最后一个元素与堆顶元素交换
        arr.set(0,arr.get(size - 1));
        size--;
        siftDown(0);
        return maxVal;
    }

    private void siftUp(int k) {
        while(k >= 0 && arr.get(k) > arr.get(parent(k))){
            swap(k,parent(k));
            k = parent(k);
        }
    }

    private void swap(int k, int parent) {
        int temp = arr.get(k);
        arr.set(k,arr.get(parent));
        arr.set(parent,temp);

    }

    //创建最大堆
    public MaxHeap(int[] nums){
        this.arr = new ArrayList<>(nums.length);
        for (int num : nums) {
            arr.add(num);
            size++;
        }
        //从最后一个非叶子结点开始做siftDown操作
        for(int i = parent(size - 1);i >= 0 ;i--){
            siftDown(i);
        }
    }

    private void siftDown(int k) {
        //判断是否存在子树
        while(leftChild(k) < size){
            //左右子树最大值j
            int j = arr.get(leftChild(k));
            if(j + 1 < size && arr.get(j) < arr.get(j + 1)){
                j = j + 1;
            }

            if(arr.get(k) > arr.get(j)){
                break;
            }else{
                swap(k,j);
                k = j;
            }


        }
    }

}
