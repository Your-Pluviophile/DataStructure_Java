package part4_leetcode.tanxin;

import java.util.Scanner;

public class Day230102_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while(scanner.hasNextInt()){
            int arg = scanner.nextInt();
            count++;
            if (count > 10){
                break;
            }
            if(arg == 0){
                continue;
            }
            System.out.println(method(arg));
        }
    }

    private static int method(int arg) {
        if (arg == 1) return 0;
        int ans = 0;
        int temp = 0;
        while(arg > 0){
            if (arg == 2){
                ans++;
                break;
            }else if (arg < 2){
                break;
            }
            temp = arg / 3;
            ans += temp;
            arg = arg % 3 + temp;
        }
        return ans;
    }
}
