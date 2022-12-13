package part4_leetcode.array;

import java.util.HashMap;

public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution (int[] numbers) {
        // 摩尔投票法
        // 遇到相同的数 票数+1 反之-1
        // 当票数为0，更换数字
        // 由于出现次数 最多的数 > 其他数的总和,抵消之后剩下的肯定是出现最多的数
        int res = numbers[0];
        int count = 1;
        for (int i = 1; i < numbers.length; i++) {
            if(res == numbers[i]){
                count++;
            } else if (--count == 0) {
                count = 1;
                res = numbers[i];
            }

        }

        return res;
    }
}
