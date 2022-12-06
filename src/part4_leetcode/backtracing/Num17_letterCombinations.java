package part4_leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

public class Num17_letterCombinations {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        String[] numStrings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracing(digits,numStrings,0);
        return res;
    }

    private void backtracing(String digits, String[] numStrings, int num) {
        //终止条件
        if(num == digits.length()){
            res.add(sb.toString());
            return;
        }
        String nums = numStrings[digits.charAt(num) - '0'];
        for (int i = 0; i < nums.length(); i++) {
            sb.append(nums.charAt(i));
            backtracing(digits,numStrings,num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
