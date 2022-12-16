package part4_leetcode.array;

import java.util.Scanner;

public class Day221216_2 {
    public static void main(String[] args) {
        //本题毫无疑问是一道贪心题
        //求连续字数组最大和
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum,sum);
            if(sum < 0) sum = 0;

        }

        System.out.println(maxSum);
    }
}
