package part4_leetcode.str;

import java.util.Scanner;

public class Num221213_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //输出字符串中最长的数字串
        //怎么判定是否是最长数字串？ 统计连续出现的次数
        //将最长字符串保存到新的字符串 ? 记录下标和长度？ 截取长度
        int maxCount = Integer.MIN_VALUE;
        int count = 0;
        int endIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                    endIndex = i;
                }
            }else{
                count = 0;
            }
        }

        System.out.println(str.substring(endIndex - maxCount + 1,endIndex + 1));
    }
}
