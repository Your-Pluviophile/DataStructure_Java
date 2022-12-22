package part4_leetcode.backtracing;

import java.util.Scanner;

public class Day221222_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m  = sc.nextInt();
        System.out.println(process(m,n));

    }

    private static int process(int m, int n) {
        if((m == 1 && n >=1) || (m >=1 && n == 1)){
            return m + n ;
        }
        return process(m-1,n) + process(m,n - 1);
    }
}
