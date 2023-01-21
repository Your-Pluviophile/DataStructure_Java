package part4_leetcode.array.twopointer;

public class Num76_minWindow {
    public String minWindow(String s, String t) {
        //涵盖 t 所有字符的最小子串
        if (s.length() < t.length()) return "";
        char[] char_s = s.toCharArray();
        char[] char_t = t.toCharArray();

        int[] hash = new int[128];
        for (char c : char_t) {
            hash[c]--;//统计t有多少字符
        }
        int left = 0;
        int count = 0;
        String res = "";
        for (int right = 0; right < char_s.length; right++) {
            hash[char_s[right]]++;//用s中的字符去填坑
            //此时，没有在t出现的字符的hash 必然 > 1
            //已填满的坑 再出现，必然 > 1
            //如果还有坑没填满，再出现，此时的状态必然 <= 0
            if (hash[char_s[right]] <= 0) count++;//坑没填满，字符出现的次数+1；
            //当count == t的长度后，说明此时窗口内已经包含了t，此时移动左边界缩小窗口
            //只有当左指针指向的字符是冗余的情况下，才能保证去掉该字符后，窗口中仍然包含t
            while (count == t.length() && hash[char_s[left]] > 0) {
                hash[char_s[left]]--;
                left++;
            }
            //更新res
            if (count == char_t.length) {
                if (res.equals("") || res.length() > right - left + 1) {
                    res = s.substring(left, right + 1);
                }
            }
        }
        return res;
    }
}
