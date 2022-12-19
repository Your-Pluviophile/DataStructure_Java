package part4_leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Day221219_2 {
    public boolean chkParenthesis(String A, int n) {
        if(n % 2 != 0) return false;
        // 这个题目描述的真是莫名其妙
        Deque<Character> stack = new ArrayDeque<>();//(())

        for (char c : A.toCharArray()) {
            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
