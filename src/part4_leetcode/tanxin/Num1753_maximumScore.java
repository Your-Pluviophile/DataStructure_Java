package part4_leetcode.tanxin;

import java.util.Arrays;

public class Num1753_maximumScore {
    public int maximumScore(int a, int b, int c) {
        //每次都取较大和次大的
        int count = 0;
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        while (arr[0] != 0 || arr[1] != 0){
            count++;
            arr[1]--;
            arr[2]--;
            Arrays.sort(arr);
        }
        return count;
    }
}
