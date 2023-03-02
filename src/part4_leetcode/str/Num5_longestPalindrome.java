package part4_leetcode.str;

/**
 * @author mumu
 * @since 2023-03-02
 */
public class Num5_longestPalindrome {
        public String longestPalindrome(String str) {
            // 构造辅助字符数组
            char[] charArr = str.toCharArray();
            char[] res = new char[str.length() * 2 + 1];
            int index = 0;
            for (int i = 0; i != res.length; i++) {
                res[i] = (i & 1) == 0 ? '#' : charArr[index++];
            }
            // 求辅助字符串中的最长回文半径
            int[] pArr = new int[res.length]; // 记录每个字符搜索能达到最长回文半径
            int maxLength = 0;   // 记录搜索过程中最长回文子串长度（去掉辅助字符影响）
            int maxCharIndex = 0; // 记录搜索过程中最长回文子串中心点（保留辅助字符影响）
            int c = -1;   // 初始中心
            int r = -1;  // 初始右边界
            for(int i=0; i<res.length; i++){
                pArr[i] = i < r ? Math.min(pArr[2*c-i], r-i) : 1;
                int startIndex = i+pArr[i];
                while(i+pArr[i] < res.length && i-pArr[i] > -1){
                    if(res[i+pArr[i]] == res[i-pArr[i]]){
                        pArr[i]++;
                    }else{
                        break;
                    }
                }
                if(i+pArr[i]-1 > r){  // 更新最右边界和中心
                    r = i+pArr[i]-1;
                    c = i;
                }
                if(pArr[i]-1 > maxLength){   // 更新
                    maxLength = pArr[i]-1;
                    maxCharIndex = i;
                }
            }
            char[] result = new char[maxLength];
            // 得到最长回文子串
            int start = maxCharIndex-pArr[maxCharIndex]+1; // 获得初始元素下标
            for(int i=0;i<result.length;i++){ // 去除辅助字符
                result[i] = res[++start];
                start++;
            }
            return String.valueOf(result);

        }

}
