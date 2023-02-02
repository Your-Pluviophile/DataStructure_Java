package part4_leetcode.nowcoder;

import java.util.Scanner;

import static part4_leetcode.backtracing.Day221222_2.process;

public class Day230202_1 {
    /*
    NowCoder开了一家早餐店，这家店的客人都有个奇怪的癖好：他们只要来这家店吃过一次早餐，就会每天都过来；
    并且，所有人在这家店吃了两天早餐后，接下来每天都会带一位新朋友一起来品尝。
    于是，这家店的客人从最初一个人发展成浩浩荡荡成百上千人：1、1、2、3、5……
    现在，NowCoder想请你帮忙统计一下，某一段时间范围那他总共卖出多少份早餐（假设每位客人只吃一份早餐）。
     */

    static long[] fibs = new long[81];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            process();
            long res = 0;
            for (int i = from; i <= to; i++) {
                res += fibs[i];
            }
            System.out.println(res);
        }


    }

    private static void process() {
        fibs[0] = 1;
        fibs[1] = 1;
        fibs[2] = 2;
        for (int i = 3; i < fibs.length; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
    }


}
