package part4_leetcode.tanxin;

import java.util.Arrays;

public class Num455_findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        //s 饼干尺寸
        //g 孩子胃口
        //使尽可能多的s > g
        //排序 小孩子优先拿小饼干
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0,j = 0; i < s.length && j < g.length; i++) {
            if (s[i] >= g[j]){
                count++;
                j++;
            }
        }
        return count;
    }

}
