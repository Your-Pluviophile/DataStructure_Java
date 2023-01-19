package part4_leetcode.array.twopointer;

public class Offer58_reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverse(sb, 0, n - 1);
        reverse(sb, n, s.length() - 1);
        reverse(sb, 0, s.length() - 1);
        return sb.toString();

    }

    void reverse(StringBuilder s, int start, int end) {
        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start++, s.charAt(end));
            s.setCharAt(end--, temp);
        }
    }
}
