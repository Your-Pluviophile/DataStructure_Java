package part4_leetcode.array.binarySearch;

public class Num367_isPerfectSquar {
    public boolean isPerfectSquare(int num) {
        if (num == 0) return true;
        if (num == 1) return true;

        int l = 1;
        int r = num ;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if ((long) mid * mid < num ){
                l = mid + 1;
            }else if ((long) mid * mid > num ){
                r = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
