package part4_leetcode.tanxin;

public class Num738_monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        //给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
        //局部最优：遇到strNum[i - 1] > strNum[i]的情况，让strNum[i - 1]--，
        // 然后strNum[i]给为9，可以保证这两位变成最大单调递增整数
        // 3 2 8 7
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i++) {
            if(ch[i] > ch[i + 1]){
                ch[i]--;
                start = i + 1;//代表需要从第几位开始9
            }
        }

        for (int i = start; i < s.length(); i++) {
            ch[i] = '9';
        }
        return Integer.parseInt(String.valueOf(ch));
    }
}
