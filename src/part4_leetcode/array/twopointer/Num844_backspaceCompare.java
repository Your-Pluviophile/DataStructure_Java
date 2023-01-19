package part4_leetcode.array.twopointer;

public class Num844_backspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        return process(s).equals(process(t));
    }
    public String process(String str){
        char[] chars = str.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != '#'){
                chars[slow++] = chars[fast];
            }else {
                if (slow > 0){
                    slow--;
                }
            }
        }
        return new String(chars,0,slow);
    }
}
