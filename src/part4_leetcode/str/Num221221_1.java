package part4_leetcode.str;

import java.util.Arrays;
import java.util.Scanner;

public class Num221221_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n ; i++) {
            strs[i] = sc.next();
        }


        boolean islenSort = isLenSort(strs);
        boolean isdicSort = isDicSort(strs);

        if (islenSort && isdicSort){
            System.out.println("both");
        }else if(islenSort){
            System.out.println("lengths");
        } else if (isdicSort) {
            System.out.println("lexicographically");
        }else{
            System.out.println("none");
        }


    }
    public static boolean isDicSort(String[] str) {
        for (int i = 0; i < str.length - 1; i++) {
            if(str[i].compareTo(str[i + 1]) > 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isLenSort(String[] str) {
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i].length() > str[i + 1].length()) {
                return false;
            }
        }
        return true;
    }
}
