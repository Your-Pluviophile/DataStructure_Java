package part4_leetcode.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num93_restoreIpAddresses {
    List<String> res = new ArrayList<>();
    Deque<String> path = new ArrayDeque<>(4);
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12) return res;
        back_tracing(s,0,4);
        return res;
    }

    private void back_tracing(String s, int startIndex,int reside) {
        //终止条件
        if(startIndex == s.length()){
            //当遍历到最后一个字符且剩余段数为0时，将此时的path添加到结果中
            if(reside==0){
                res.add(String.join(".", path));
            }
            return;
        }
        //每段最多3位
        for (int i = startIndex; i < startIndex + 3; i++) {
            if (i > s.length()) break;
            //字符串剩余长度和分段所需长度
            if(s.length()-i > reside*3)
                continue;
            if (isValid(s,startIndex,i)){
                String curS = s.substring(startIndex, i+1);
                path.addLast(curS);
                back_tracing(s,i + 1,reside -1);
                path.removeLast();
            }

        }

    }

    private boolean isValid(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return false;
        }
        if (s.charAt(startIndex) == '0' && startIndex != endIndex) {
            return false;
        }
        int num = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }

            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
