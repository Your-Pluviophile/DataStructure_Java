package part4_leetcode.array.twopointer;

public class Num344_reverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while(left < right){
            swap(s,left++,right--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
