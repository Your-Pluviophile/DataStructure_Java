package part4_leetcode.array.binarySearch;

public class Num69_mySqrt {
    public int mySqrt(int x) {

        if (x == 0) return 0;
        if (x == 1) return 1;

        int l = 0;
        int r = x;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (mid < x / mid){
                l = mid + 1;
            }else if (mid > x / mid){
                r = mid - 1;
            }else{
                return mid;
            }
        }
        return r;
    }
}
