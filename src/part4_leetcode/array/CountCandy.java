package part4_leetcode.array;

import java.util.Scanner;

public class CountCandy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();//A - B;
        int num2 = sc.nextInt();//B - C;
        int num3 = sc.nextInt();//A + B;  num1 + num3 = A - B + A + B = 2 * A
        int num4 = sc.nextInt();//B + C
        //输出ABC
        int A,B1,B2,C;
        A = (num1 + num3 ) >> 1;
        B1 = (num2 + num4 ) >> 1;
        B2 = (num3 - num1 ) >> 1;
        C = (num4 - num2 ) >> 1 ;
        if (B1 != B2) {
            System.out.println("No");

        } else {
            System.out.println(A + " " + B1 + " " + C);
        }

    }
}
