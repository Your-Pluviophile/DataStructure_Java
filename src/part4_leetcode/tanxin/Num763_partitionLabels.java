package part4_leetcode.tanxin;

import java.util.ArrayList;
import java.util.List;

public class Num763_partitionLabels {
    public List<Integer> partitionLabels(String s) {
        //在遍历的过程中相当于是要找每一个字母的边界，如果找到之前遍历过的所有字母的最远边界，
        // 说明这个边界就是分割点了。此时前面出现过所有字母，最远也就到这个边界了。

//        统计每一个字符最后出现的位置
//        从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
        List<Integer> res = new ArrayList<>();
        //统计每个字符出现的最远边界
        int[] edge = new int[26];
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            edge[ch[i] - 'a'] = i;
        }
        int index = 0;
        int last = -1;
        for (int i = 0; i < ch.length; i++) {
            index = Math.max(index,edge[ch[i] - 'a']);
            if (i == index){
                res.add(i - last);
                last = i;
            }
        }
        return res;
    }
}
