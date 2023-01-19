package part4_leetcode.array.twopointer;

public class Offer05_replaceSpace {
    public String replaceSpace(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        //1.统计,一个空格 扩容两个
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("  ");
            }
        }
        //若是没有空格直接返回
        if(sb.length() == 0){
            return s;
        }
        //2.扩容
        int tail_p1 = s.length() - 1;//指向原数组末尾
        s += sb.toString();
        int tail_p2 = s.length() - 1;//指向新数组末尾

        //3.拷贝
        char[] chars = s.toCharArray();
        while(tail_p1 >= 0){
            if (chars[tail_p1] == ' '){
                chars[tail_p2--] = '0';
                chars[tail_p2--] = '2';
                chars[tail_p2] = '%';
            }else {
                chars[tail_p2] = chars[tail_p1];
            }
            tail_p1--;
            tail_p2--;
        }
        return new String(chars);
    }
}
