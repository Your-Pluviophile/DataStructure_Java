package part4_leetcode.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num131_partiton {
    List<List<String>> res = new ArrayList<>();
    Deque<String> path = new ArrayDeque<>();
    public List<List<String>> partition(String s) {
        back_tracing(s,0);
        return res;
    }

    private void back_tracing(String s, int startIndex) {
        //如果要截取的位置已经大于字符串长度，终止
        if (startIndex >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i < s.length();i++){
            //如果当前要截取的字符串是回文
            if(isPalindrome(s,startIndex,i)){
                //截取
                String str = s.substring(startIndex,i + 1);
                path.add(str);
            }else{
                //否则直接跳过
                continue;
            }
            //不重复
            back_tracing(s,i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
