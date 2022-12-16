package part4_leetcode.array;

import java.util.Scanner;

public class Day221217_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int[][] map = new int[W][H];

        int count = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                map[i][j] = 1;
            }
        }

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if(map[i][j] == 1){//左上角肯定可以
                    count++;
                    //如果该位置为1，则将上下左右距离为2的点标记为0
                    if(i - 2 >= 0) map[i-2][j]=0;
                    if(i + 2 < W) map[i+2][j]=0;
                    if(j + 2 < H) map[i][j+2]=0;
                    if(j - 2 >= 0) map[i][j-2]=0;
                }
            }
        }
        System.out.println(count);


    }
}
