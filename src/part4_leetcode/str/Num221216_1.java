package part4_leetcode.str;

import java.util.Scanner;

public class Num221216_1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        //怎么插入？

        int count = 0;
        for (int i = 0; i <= str1.length(); i++) {
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i,str2);
            if (isPalind(sb.toString())){
                count++;
            }
        }

        System.out.println(count);
    }
    static  boolean isPalind(String s){
        char[] ch =s.toCharArray();

        for (int i = 0,j = ch.length - 1; i < j; i++,j--) {
            if (ch[i] != ch[j]){
                return false;
            }
        }
        return true;
    }
}
