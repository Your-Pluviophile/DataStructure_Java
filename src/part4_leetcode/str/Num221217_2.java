package part4_leetcode.str;

import java.util.Scanner;

public class Num221217_2 {
    public static void main(String[] args) {
        System.out.println(new Num221217_2().StrToInt("+2"));
    }

    public int StrToInt(String str) {
        //任意字符 空格/正负需要单独处理

        if(str.length() == 0) return 0;
        int len = str.length();
        int startindex =0;
        while(startindex < len && str.charAt(startindex) == ' ') startindex++;//直到找到第一个非空格字符

        char[] ch = str.toCharArray();
        int flag = 1;
        long sum = 0;

        if(startindex < len && ch[startindex] == '-'){
            flag = -1;
            ch[0] = '0';
        }else if(startindex < len && ch[startindex] == '+'){
            ch[0] = '0';
        }

        for (int i = startindex; i < ch.length; i++) {
            if(ch[i] > '9' || ch[i] < '0'){
                return 0;
            }else{
                sum = sum * 10 + (ch[i] - '0');
            }


        }

        if(flag == -1 && sum * (-1) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if(flag == 1 && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return (int)sum * flag;

    }
}
