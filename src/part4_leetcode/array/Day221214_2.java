package part4_leetcode.array;

import java.util.Scanner;

public class Day221214_2 {
    public static void main(String[] args) {
        //100 ->  2
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        boolean negative = false;
        if (M < 0) negative = true;
        StringBuilder sb = new StringBuilder();
        M = Math.abs(M);

        //进制转换居然这么简单
        while(M > N){
            sb.insert(0,chars[M % N]);
            //下一位
            M /= N ;
        }

        System.out.println((negative ? "-" : "") + sb.toString());


    }
}
