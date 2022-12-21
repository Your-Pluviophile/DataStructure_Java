package part4_leetcode.array;

import java.util.Scanner;

public class Day221222_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int res = Math.max(A,B);;
        while(res <= A * B){

            if(res % A == 0 && res % B == 0){
                System.out.println(res);
                break;
            }
            res++;
        }

    }
}
