package part4_leetcode.array;

import java.util.Scanner;

public class Day221219_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;

        int countDown = 0;
        int countUp = 0;

        int[] f = new int[1000];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < 1000; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        while(temp >= 0 && !isFibonacci(temp,f)){
            countDown++;
            temp--;
        }
        temp = n;
        while(!isFibonacci(temp,f)){
            countUp++;
            temp++;
        }
        System.out.println(Math.min(countDown,countUp));

    }

    private static boolean isFibonacci(int n,int[] f) {
        for (int i = 0; i < 1000; i++) {
            if(n == f[i]){
                return true;
            }
        }
        return false;
    }
}
