package part4_leetcode.array.twopointer;

public class Num151_reverseWords {
    public String reverseWords(String s) {
        //取空格
        StringBuilder sb = removeSpace(s);
        //反转所有
        reverse(sb, 0, sb.length() - 1);
        //反转每个单词
        reverseEach(sb);
        return sb.toString();
    }


    private StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;

        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start++);
            //保证中间只有一个空格
            //如果c不是空格，直接添加
            //如果c是空格，如果sb末尾没有，也可以添加
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
        }
        return sb;
    }
    void reverse(StringBuilder s, int start, int end) {
        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start++, s.charAt(end));
            s.setCharAt(end--, temp);
        }
    }
    private void reverseEach(StringBuilder sb) {
        int n = sb.length() - 1;
        int start = 0;
        int end = start + 1;
        while (start <= n) {
            //end定位到单词末尾
            while (end <= n && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end);
            start = end + 1;
            end = start + 1;
        }
    }
}
