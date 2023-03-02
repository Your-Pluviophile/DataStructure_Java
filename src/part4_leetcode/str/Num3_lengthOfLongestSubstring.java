package part4_leetcode.str;

import java.util.HashMap;

/**

 *
 * @author mumu
 * @since 2023-02-18
 */
public class Num3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        //定义一个哈希表用于记录字符上一次出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        //right一直向右边扩展，如果当前字符重复，就把left移动到当前字符第一次出现的下一个位置
        int res = 0;
        for(int right = 0;right < s.length(); right++){
            //如果 在Map中存在key，则返回key所对应的的value。
            //如果 在Map中不存在key，则返回默认值
            int index = map.getOrDefault(s.charAt(right), -1);
            left = Math.max(left,index + 1);
            res = Math.max(res,right -left + 1);
            map.put(s.charAt(right), right);
        }
        return res;
    }
}
