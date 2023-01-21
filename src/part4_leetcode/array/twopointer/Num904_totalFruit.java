package part4_leetcode.array.twopointer;

public class Num904_totalFruit {
    public int totalFruit(int[] fruits) {
        if (fruits.length < 3) return fruits.length;
        //求只包含两种元素的最长连续子序列
        int max_len = Integer.MIN_VALUE;
        int left = 0;
        int right = 1;
        //使用first和second 保存两种元素
        int first = fruits[left];
        int second = fruits[right];
        while (right < fruits.length) {
            //如果fruits[right]是其中的，一直更新右边界，并记录长度
            if (fruits[right] == first || fruits[right] == second) {
                max_len = Math.max(max_len, right - left + 1);
                right++;
            } else {
                //如果fruits[right]不是其中的,就更新新的数为基准，产生新的second
                //将left直接移动到right前面一格（肯定与right不同），产生新的first
                left = right - 1;
                first = fruits[left];
                second = fruits[right];
                //找出first第一次出现的位置
                while (left > 0 && first == fruits[left - 1]) {
                    left--;
                }
                max_len = Math.max(max_len, right - left + 1);
            }
        }
        return max_len;
    }
}
