package part4_leetcode.bit;

import java.util.Scanner;

public class Day221224_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String binnary_num = Integer.toBinaryString(num);
        String[] strings = binnary_num.split("0");
        int res = 0;
        for (String string : strings) {
            res = Math.max(res,string.length());
        }
        System.out.println(res);

    }
}
//      a
//   b     d
//           c
//          f  g
//         e
